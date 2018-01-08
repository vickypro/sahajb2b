package sahaj.serviceimpl.master;

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
import sahaj.model.master.Bank;
import sahaj.model.master.District;
import sahaj.model.master.State;

/**
 * @author Amit
 *
 */
public class DistrictServiceImpl {

	@Autowired
	private MongoOperations mongoOperations;
	
	MongoClient mongoClient = DatabaseConnection.getDatabaseConnection();
	
	public List<District> getDistrictList() {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		List<District> districtList = mongoTemplate.findAll(District.class,
				"district_master");
		return districtList;

	}
	
	public int getNextDistrictId() {
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "district_id"));

		District district = mongoTemplate.findOne(query, District.class);
		return district.getDistrictId() + 1;
	}
	
	public int saveDistrict(District district) {

		DB db = mongoClient.getDB("solar");
		DBCollection col = db.getCollection("district_master");

		district.setDistrictId(getNextDistrictId());

		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("district_id", district.getDistrictId());
		docBuilder.append("district_name", district.getDistrictName());
		docBuilder.append("email_id", district.getEmailId());
		docBuilder.append("description", district.getDescription());
		docBuilder.append("state_id", district.getStateId());
		docBuilder.append("delete_status", "0");

		WriteResult result = col.insert(docBuilder.get());
		return result.getN();
	}
	
	public District getDistrictDetails(int districtId) {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.addCriteria(Criteria.where("district_id").is(districtId));

		District district = mongoTemplate.findOne(query, District.class);

		return district;
	}
	
	public int updateDistrict(District district) {

		DB db = mongoClient.getDB("solar");
		DBCollection dbCollection = db.getCollection("district_master");
		BasicDBObject searchQuery = new BasicDBObject("district_id", district.getDistrictId());
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("district_name", district.getDistrictName());
		newDocument.append("email_id", district.getEmailId());
		newDocument.append("description", district.getDescription());
		newDocument.append("state_id", district.getStateId());
		BasicDBObject setQuery = new BasicDBObject();
		setQuery.append("$set", newDocument);
		WriteResult writeResult = dbCollection.update(searchQuery, setQuery);	
		return writeResult.getN();

	}
	
}
