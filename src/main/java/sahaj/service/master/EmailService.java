package sahaj.service.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.mongodb.MongoClient;

import sahaj.model.Mongodb.Mongodb;
import sahaj.model.master.Email;

public class EmailService {
	@Autowired 
	Mongodb mongo=new Mongodb();
	private MongoOperations mongoOperations;
	
	
	MongoClient mongoClient = new MongoClient(mongo.getHost(),27017);
	
	
	
	public void sendMail(Email mail) {
		
	}


}
