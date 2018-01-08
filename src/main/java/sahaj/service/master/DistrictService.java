package sahaj.service.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

import sahaj.database.DatabaseConnection;
import sahaj.model.master.District;
import sahaj.model.master.State;

/**
 * @author Amit
 *
 */
public class DistrictService {

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
}
