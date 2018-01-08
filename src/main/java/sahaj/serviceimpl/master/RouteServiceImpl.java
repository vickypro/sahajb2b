package sahaj.serviceimpl.master;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

import sahaj.database.DatabaseConnection;
import sahaj.model.master.Customer;
import sahaj.model.master.District;
import sahaj.model.master.Magazine;
import sahaj.model.master.MagazineCapacity;
import sahaj.model.master.Route;
import sahaj.model.master.RouteMapping;
import sahaj.model.master.Van;

public class RouteServiceImpl {

	@Autowired
	private MongoOperations mongoOperations;

	MongoClient mongoClient = DatabaseConnection.getDatabaseConnection();

	public List<Route> getRouteList() {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		List<Route> routeList = mongoTemplate.findAll(Route.class, "route_master");
		return routeList;
	}
	
	public District getDistrictId() {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.addCriteria(Criteria.where("district_name").is("Nagpur"));

		District district = mongoTemplate.findOne(query, District.class);

		return district;
	}

	public List<Magazine> getMagazineListForCustomer(int customerId) {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.addCriteria(Criteria.where("customer_id").is(customerId));

		List<Magazine> magazineList = mongoTemplate.find(query, Magazine.class);
		return magazineList;

	}

	public int getNextRouteId() {
		int returnValue = 0;
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "route_id"));
		Route route = mongoTemplate.findOne(query, Route.class);
		if (route == null) {
			returnValue = 1;
		} else {
			returnValue = route.getRouteId() + 1;
		}
		return returnValue;
	}

	public int getNextRouteMappingId() {
		int returnValue = 0;
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "route_mapping_id"));
		RouteMapping routeMapping = mongoTemplate.findOne(query, RouteMapping.class);
		if (routeMapping == null) {
			returnValue = 1;
		} else {
			returnValue =  routeMapping.getRouteMappingId() + 1;
		}
		return returnValue;
	}

	public void saveRoute(Route route) {

		DB db = mongoClient.getDB("solar");
		DBCollection collection1 = db.getCollection("route_master");
		DBCollection collection2 = db.getCollection("route_mapping");

		List<DBObject> documents1 = new ArrayList<>();
		List<DBObject> documents2 = new ArrayList<>();

		DBObject document1 = new BasicDBObject();
		route.setRouteId(getNextRouteId());

		document1.put("route_id", route.getRouteId());
		document1.put("customer_id", route.getCustomerId());
		document1.put("magazine_id", route.getMagazineId());
		document1.put("active_status", route.isActiveStatus());
		document1.put("delete_status", 0);

		documents1.add(document1);

		int routeMappingId = getNextRouteMappingId();

		for (int i = 0; i < route.getRouteMappingList().size(); i++) {
			DBObject document2 = new BasicDBObject();
			RouteMapping routeMapping = route.getRouteMappingList().get(i);
			document2.put("routemapping_id", routeMappingId);
			document2.put("state_id", routeMapping.getStateId());
			document2.put("district_id", routeMapping.getDistrictId());
			document2.put("reached_days", routeMapping.getReachedDays());
			document2.put("route_id", route.getRouteId());

			documents2.add(document2);
			routeMappingId++;
		}
		System.out.println("documents----------" + documents1);
		System.out.println();
		System.out.println("documents----------" + documents2);

		collection1.insert(documents1);
		// System.out.println("collection1.insert(documents1)----"+collection1.insert(documents1));
		collection2.insert(documents2);

	}
	
	public Route getRouteDetails(int routeId) {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.addCriteria(Criteria.where("route_id").is(routeId));
		Route route = mongoTemplate.findOne(query, Route.class);

		Query query1 = new Query();
		query1.addCriteria(Criteria.where("route_id").is(routeId));
		List<RouteMapping> routeMappingList = mongoTemplate.find(query, RouteMapping.class);
		route.setRouteMappingList(routeMappingList);
		System.out.println("route----------"+route.toString());
		return route;
	}
	
	public void updateRoute(Route route) {

		DB db = mongoClient.getDB("solar");
		DBCollection collection1 = db.getCollection("route_master");
		DBCollection collection2 = db.getCollection("route_mapping");
		
		List<DBObject> documents2 = new ArrayList<>();
		
		BasicDBObject searchQuery1 = new BasicDBObject("route_id", route.getRouteId());
		
		BasicDBObject document1 = new BasicDBObject();
		document1.put("customer_id", route.getCustomerId());
		document1.put("magazine_id", route.getMagazineId());
		document1.put("active_status", route.isActiveStatus());
		document1.put("delete_status", 0);

		BasicDBObject setQuery1 = new BasicDBObject();
		setQuery1.append("$set", document1);
		WriteResult writeResult1 = collection1.update(searchQuery1, setQuery1);
		
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria.where("route_id").is(route.getRouteId()));	
		mongoTemplate.remove(query, RouteMapping.class);
		
		int routeMappingId = getNextRouteMappingId();

		for (int i = 0; i < route.getRouteMappingList().size(); i++) {
			DBObject document2 = new BasicDBObject();
			RouteMapping routeMapping = route.getRouteMappingList().get(i);
			document2.put("routemapping_id", routeMappingId);
			document2.put("state_id", routeMapping.getStateId());
			document2.put("district_id", routeMapping.getDistrictId());
			document2.put("reached_days", routeMapping.getReachedDays());
			document2.put("route_id", route.getRouteId());

			documents2.add(document2);
			routeMappingId++;
		}
		collection2.insert(documents2);

	}
}
