package sahaj.service.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

import sahaj.database.DatabaseConnection;
import sahaj.model.master.CustomerCategory;
import sahaj.model.master.Sector;


public class SectorService {
	
	@Autowired
	private MongoOperations mongoOperations;

	MongoClient mongoClient = DatabaseConnection.getDatabaseConnection();
	
	public List<Sector> getSectorList() {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		List<Sector> sectorList = mongoTemplate.findAll(Sector.class,
				"sector_master");
		return sectorList;

	}
	
	public int getNextSectorId() {
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "sector_id"));

		Sector sector = mongoTemplate.findOne(query, Sector.class);
		return sector.getSectorId() + 1;
	}
	
	public void saveSector(Sector sector) {

		DB db = mongoClient.getDB("solar");
		DBCollection col = db.getCollection("sector_master");

		sector.setSectorId(getNextSectorId());

		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("sector_id", sector.getSectorId());
		docBuilder.append("sector_name", sector.getSectorName());
		docBuilder.append("description", sector.getDescription());
		docBuilder.append("active_status", 0);
		docBuilder.append("delete_status", 0);

		WriteResult result = col.insert(docBuilder.get());
	}
	
	public Sector getSectorDetails(int sectorId) {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.addCriteria(Criteria.where("sector_id").is(sectorId));

		Sector sector = mongoTemplate.findOne(query, Sector.class);
//		System.out.println("getCustomerCategoryName-----" + customerCategory.getCustomerCategoryName());
//		System.out.println("getDescription-----" + customerCategory.getDescription());

		return sector;
	}
	
	public void updateSector(Sector  sector) {

		DB db = mongoClient.getDB("solar");
		DBCollection dbCollection = db.getCollection("sector_master");
		BasicDBObject searchQuery = new BasicDBObject("sector_id", sector.getSectorId());
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("sector_name", sector.getSectorName());
		newDocument.append("description", sector.getDescription());
//		newDocument.append("active_status", 0);
		BasicDBObject setQuery = new BasicDBObject();
		setQuery.append("$set", newDocument);
		WriteResult writeResult = dbCollection.update(searchQuery, setQuery);

		System.out.println("newDocument----------" + newDocument);
		System.out.println("writeResult----------" + writeResult);

	}
	
	public int deleteSector(int sectorId) {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		DB db = mongoClient.getDB("solar");
		DBCollection dbCollection = db.getCollection("sector_master");
		BasicDBObject searchQuery = new BasicDBObject("sector_id", sectorId);
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("delete_status",1);
		BasicDBObject setQuery = new BasicDBObject();
		setQuery.append("$set", newDocument);
		WriteResult writeResult = dbCollection.update(searchQuery, setQuery);

		return writeResult.getN();
	}
}
