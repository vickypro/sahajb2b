package sahaj.service.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

import sahaj.database.DatabaseConnection;
import sahaj.model.master.Uom;

public class UomService {
	
	@Autowired
	private MongoOperations mongoOperations;

	MongoClient mongoClient = DatabaseConnection.getDatabaseConnection();
	
	public List<Uom> getUomList() {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		List<Uom> uomList = mongoTemplate.findAll(Uom.class,
				"uom_master");
		return uomList;

	}

}
