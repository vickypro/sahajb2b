package sahaj.service.master;

import java.util.List;
import com.mongodb.MongoClient;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
 
import com.mongodb.WriteResult;

import sahaj.model.Mongodb.Mongodb;
import sahaj.model.master.Transporter;
//import sahaj.model.master.Van;
import sahaj.model.master.Van;

public class VanService {
	@Autowired 
	Mongodb mongo=new Mongodb();
	private MongoOperations mongoOperations;
	
	
	MongoClient mongoClient = new MongoClient(mongo.getHost(),27017);

	
	
	public void saveVan(Van van) {
		

		DB db = mongoClient.getDB("solar");
		DBCollection col = db.getCollection("van_master");

		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		
		docBuilder.append("van_id", van.getVanId());
		docBuilder.append("van_no", van.getVanNo());
		docBuilder.append("description", van.getDescripton());
		docBuilder.append("van_capacity", van.getVanCapacity());
		docBuilder.append("transpoter_name",van.getTranspoterName());
		docBuilder.append("state_id",van.getStateId());
		
		docBuilder.append("insurance_validity_date", van.getInsuranceValidityDate());
		docBuilder.append("driver_lic_no", van.getDriverLicNo());
		docBuilder.append("dockey",van.getDockey());
		docBuilder.append("transporter_id",van.getTransporterId());
	
		
		docBuilder.append("driver_lic_validity_date", van.getDriverlicValiditydate());
		docBuilder.append("fitness_certificate_date",van.getFitnessCertificatedate());
		WriteResult result = col.insert(docBuilder.get());
	}

	public List<Van>getVanList() {

		MongoClient mongoClient = new MongoClient(mongo.getHost(),27017);
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		List<Van> VanList = mongoTemplate.findAll(Van.class, "van_master");
		 System.out.println("welcome");
		
		return VanList;

}
	

	public void deleteVan(String vanId) {

 
		MongoClient mongoClient = new MongoClient(mongo.getHost(),27017);
		 
 
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		Query query = new Query();
		 
		query.addCriteria(Criteria.where("van_id").is(vanId));
		mongoTemplate.remove(query, Van.class);
		 
  

 
	}

	public Van  getVanDetails(String  vanId) {
		MongoClient mongoClient = new MongoClient(mongo.getHost(),27017);
	 
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria.where("van_id").is(vanId));
		System.out.println(query);

		Van van = mongoTemplate.findOne(query, Van.class);
		System.out.println("details");
 
		return van;
	}
	public void updateVan(Van van) {
			 
			SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
			MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		
			DB db = mongoClient.getDB("solar");
			DBCollection dbCollection = db.getCollection("van_master");
			BasicDBObject newDocument = new BasicDBObject();
			 
			newDocument.put("van_id",van.getVanId());
			newDocument.put("van_no",van.getVanNo());
			newDocument.put("description",van.getDescripton());
			newDocument.put("van_capacity",van.getVanCapacity());
			newDocument.put("transpoter_name",van.getTranspoterName());
			newDocument.put("transporter_id",van.getTransporterId());
			newDocument.put("state_id",van.getStateId());
			newDocument.put("insurance_validity_date",van.getInsuranceValidityDate());
			newDocument.put("driver_lic_no",van.getDriverLicNo());
			newDocument.put("dockey",van.getDockey());
			newDocument.put("driver_lic_validity_date",van.getDriverlicValiditydate());
			newDocument.put("fitness_certificate_date",van.getFitnessCertificatedate());
			
			dbCollection.update(
					new BasicDBObject().append("vanId",van.getVanId()),
					newDocument);
					 }
		 

public void addNewVan(Van van) {
		

		DB db = mongoClient.getDB("solar");
		DBCollection col = db.getCollection("van_master");

	}
}