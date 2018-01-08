package sahaj.service.master;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import sahaj.database.DatabaseConnection;
import sahaj.model.master.IdcardType;
import sahaj.model.master.SecurityAgency;
import sahaj.model.master.SecurityGuard;

public class SecurityGuardService {
	
	
	
MongoClient mongoClient = DatabaseConnection.getDatabaseConnection();
String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	public void saveSecurityguard(SecurityGuard SecurityGuard) {
		DB db = mongoClient.getDB("solar");
		DBCollection col = db.getCollection("SecurityGuard");
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("security_guard_code", SecurityGuard.getSecurityGuardCode());
		docBuilder.append("security_guard_name", SecurityGuard.getSecurityGuardName());
		docBuilder.append("address", SecurityGuard.getAddress());
		docBuilder.append("security_agency", SecurityGuard.getSecurityAgency());
		docBuilder.append("mobile_no",SecurityGuard.getMobileNo());
		docBuilder.append("guard_age",SecurityGuard.getGuardAge());
		docBuilder.append("card_type",SecurityGuard.getCardType());
		docBuilder.append("card_no",SecurityGuard.getCardNo());
		docBuilder.append("active_status",SecurityGuard.isActiveStatus());
		docBuilder.append("created_on",timeStamp);
		col.insert(docBuilder.get());
	 
	}
	
	public List<SecurityGuard> getSecurityGuardList() {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		List<SecurityGuard> SecurityGuard = mongoTemplate.findAll(SecurityGuard.class,"SecurityGuard");
		return SecurityGuard;

	}
	
	public void deleteGuard(int securityGuardCode) {
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria.where("security_guard_code").is(securityGuardCode));
		mongoTemplate.remove(query, SecurityGuard.class);
	}
	
	
		public SecurityGuard Newguard() {
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		List<SecurityGuard> SecurityAgencylist = mongoTemplate.findAll(SecurityGuard.class,"SecurityGuard");
		SecurityGuard SecurityGuard=new SecurityGuard();
		for(SecurityGuard SecurityGuard1:SecurityAgencylist)
		{
			int NewGuard=SecurityGuard1.getSecurityGuardCode()+1;
			SecurityGuard.setSecurityGuardCode(NewGuard);
		}
		return SecurityGuard;
	}
		
		
		public  Map<String, String>  getAgencyList() {
			SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
			MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
			Map<String, String> Agencylist = new HashMap<String, String>();
		    List<SecurityAgency> SecurityAgency = mongoTemplate.findAll(SecurityAgency.class,"SecurityAgency");
			for(SecurityAgency Agency:SecurityAgency)
			{
			Agencylist.put(Agency.getSecurityAgencyName(),Agency.getSecurityAgencyName());
			}
			return Agencylist;
		}
		
		public  Map<String, String>  getcardList() {
			SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
			MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
			Map<String, String> cardlist = new HashMap<String, String>();
			 List<IdcardType> IdCardType = mongoTemplate.findAll(IdcardType.class,"idcardtype_master");
			 for(IdcardType IdCardTypes:IdCardType)
				{
				cardlist.put(IdCardTypes.getIdcardtype(),IdCardTypes.getIdcardtype());
				}
			 return cardlist;
			
		}
		
		public SecurityGuard getAgencyDetails(int securityGuardCode) {
			SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
			MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
			Query query = new Query();
			query.addCriteria(Criteria.where("security_guard_code").is(securityGuardCode));
			SecurityGuard SecurityGuard = mongoTemplate.findOne(query, SecurityGuard.class);
			return SecurityGuard;
		}
		
		public void updateGuard(SecurityGuard SecurityGuard) {
			 
			SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
			MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
			DB db = mongoClient.getDB("solar");
			DBCollection dbCollection = db.getCollection("SecurityGuard");
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("security_guard_code", SecurityGuard.getSecurityGuardCode());
			newDocument.put("security_guard_name", SecurityGuard.getSecurityGuardName());
			newDocument.put("address", SecurityGuard.getAddress());
			newDocument.put("security_agency", SecurityGuard.getSecurityAgency());
			newDocument.put("mobile_no",SecurityGuard.getMobileNo());
			newDocument.put("guard_age",SecurityGuard.getGuardAge());
			newDocument.put("card_type",SecurityGuard.getCardType());
			newDocument.put("card_no",SecurityGuard.getCardNo());
			newDocument.put("active_status",SecurityGuard.isActiveStatus());
			newDocument.put("updated_on",timeStamp);
			dbCollection.update(
					new BasicDBObject().append("security_guard_code", SecurityGuard.getSecurityGuardCode()),
					newDocument);
		 }
		 
		
	

}
