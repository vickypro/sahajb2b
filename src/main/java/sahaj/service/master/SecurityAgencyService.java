package sahaj.service.master;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import sahaj.controller.master.SecurityAgencyCntrl;
import sahaj.database.DatabaseConnection;
import sahaj.model.master.CustomerCategory;
import sahaj.model.master.SecurityAgency;
import sahaj.model.master.Van;
 

public class SecurityAgencyService {
	
	MongoClient mongoClient = DatabaseConnection.getDatabaseConnection();
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	public void saveSecurityAgency(SecurityAgency SecurityAgency) {
		
		DB db = mongoClient.getDB("solar");
		DBCollection col = db.getCollection("SecurityAgency");
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("security_agencycode", SecurityAgency.getSecurityAgencyCode());
		docBuilder.append("security_agencyname", SecurityAgency.getSecurityAgencyName());
		docBuilder.append("address", SecurityAgency.getAddress());
		docBuilder.append("email_id",SecurityAgency.getEmailId());
		docBuilder.append("mobile_number",SecurityAgency.getMobileNumber());
		docBuilder.append("state_id",SecurityAgency.getStateId());
		docBuilder.append("district_id",SecurityAgency.getDistrictId());
		docBuilder.append("station",SecurityAgency.getStation());
		docBuilder.append("active_status",SecurityAgency.isActiveStatus());
		docBuilder.append("created_on",timeStamp);
		col.insert(docBuilder.get());
	 
	}
	
	public List<SecurityAgency> getSecurityAgency() {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		List<SecurityAgency> SecurityAgency = mongoTemplate.findAll(SecurityAgency.class,"SecurityAgency");
		return SecurityAgency;

	}
	
	public void deleteAgency(int securityagencyCode) {
		
	
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria.where("security_agencycode").is(securityagencyCode));
		mongoTemplate.remove(query, SecurityAgency.class);
	}
	
	
	public SecurityAgency getAgencyDetails(int  securityagencyCode) {
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria.where("security_agencycode").is(securityagencyCode));
		SecurityAgency SecurityAgency = mongoTemplate.findOne(query, SecurityAgency.class);
		return SecurityAgency;
	}
	
	public void updateAgency(SecurityAgency SecurityAgency) {
		 
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		DB db = mongoClient.getDB("solar");
		DBCollection dbCollection = db.getCollection("SecurityAgency");
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("security_agencycode",SecurityAgency.getSecurityAgencyCode());
		newDocument.put("security_agencyname",SecurityAgency.getSecurityAgencyName());
		newDocument.put("address",SecurityAgency.getAddress());
		newDocument.put("email_id",SecurityAgency.getEmailId());
		newDocument.put("mobile_number",SecurityAgency.getMobileNumber());
		newDocument.put("state_id",SecurityAgency.getStateId());
		newDocument.put("district_id",SecurityAgency.getDistrictId());
		newDocument.put("station",SecurityAgency.getStation());
		newDocument.put("active_status",SecurityAgency.isActiveStatus());
		newDocument.put("updated_on",timeStamp);
		dbCollection.update(
				new BasicDBObject().append("security_agencycode",SecurityAgency.getSecurityAgencyCode()),
				newDocument);
	 }
	 

	
	public SecurityAgency  NewAgency() {
		
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		List<SecurityAgency> SecurityAgencylist = mongoTemplate.findAll(SecurityAgency.class,"SecurityAgency");
		SecurityAgency SecurityAgency=new SecurityAgency();
		for(SecurityAgency agency:SecurityAgencylist)
		{
			System.out.println("data:"+agency.getSecurityAgencyCode());
			int NewAgency=agency.getSecurityAgencyCode()+1;
			SecurityAgency.setSecurityAgencyCode(NewAgency);
		}
		 
		return SecurityAgency;
	}

	 
}
