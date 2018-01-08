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
import sahaj.model.master.Item;
import sahaj.model.master.ItemSaleRate;
import sahaj.model.master.Sector;
import sahaj.model.master.State;

/**
 * @author Ankita
 *
 */
public class StateServiceImpl {

	@Autowired
	private MongoOperations mongoOperations;
	
	MongoClient mongoClient = DatabaseConnection.getDatabaseConnection();
	
	public List<State> getStateList() {
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		
		Query query = new Query();
		query.addCriteria(Criteria.where("delete_status").is(0));

    	List<State> stateList = mongoTemplate.find(query, State.class);
		return stateList;

	}
	
	public void saveState(State state) {

		DB db = mongoClient.getDB("solar");
		DBCollection col = db.getCollection("state_master");
		System.out.println("In service============"+state.toString());
		
		state.setStateId(getNextStateId());
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("state_id", state.getStateId());
		docBuilder.append("state_name",state.getStateName());
		docBuilder.append("state_code", state.getStateCode());
		docBuilder.append("description", state.getDescription());
		docBuilder.append("cc_office_address1", state.getCcOfficeAddress1());
		docBuilder.append("ccOfficeAddress2", state.getCcOfficeAddress2());
		docBuilder.append("cc_emailid", state.getCcEmailId());
		docBuilder.append("active_status", "true");
		docBuilder.append("delete_status",0);

		WriteResult result = col.insert(docBuilder.get());

	}
	
	public int getNextStateId() {
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "state_id"));

		State state = mongoTemplate.findOne(query, State.class);
	
		return state.getStateId()+1;
	}
	
	public State getStateDetails(int stateId) {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.addCriteria(Criteria.where("state_id").is(stateId));

		State state = mongoTemplate.findOne(query, State.class);
//		System.out.println("getCustomerCategoryName-----" + customerCategory.getCustomerCategoryName());
//		System.out.println("getDescription-----" + customerCategory.getDescription());

		return state;
	}
	
	public int updateState(State state) {

		DB db = mongoClient.getDB("solar");
		DBCollection dbCollection = db.getCollection("state_master");
		BasicDBObject searchQuery = new BasicDBObject("state_id", state.getStateId());
		BasicDBObject newDocument = new BasicDBObject();
		
		newDocument.append("state_name",state.getStateName());
		newDocument.append("state_code", state.getStateCode());
		newDocument.append("description", state.getDescription());
		newDocument.append("cc_office_address1", state.getCcOfficeAddress1());
		newDocument.append("ccOfficeAddress2", state.getCcOfficeAddress2());
		newDocument.append("cc_emailid", state.getCcEmailId());
		newDocument.append("active_status", "true");
		
		BasicDBObject setQuery = new BasicDBObject();
		setQuery.append("$set", newDocument);
		WriteResult writeResult = dbCollection.update(searchQuery, setQuery);

		System.out.println("newDocument----------" + newDocument);
		System.out.println("writeResult----------" + writeResult);
		return writeResult.getN();
	}
	
	public int deleteState(int stateId) {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		DB db = mongoClient.getDB("solar");
		DBCollection dbCollection = db.getCollection("state_master");
		BasicDBObject searchQuery = new BasicDBObject("state_id", stateId);
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("delete_status",1);
		BasicDBObject setQuery = new BasicDBObject();
		setQuery.append("$set", newDocument);
		WriteResult writeResult = dbCollection.update(searchQuery, setQuery);
		return writeResult.getN();
	}
	
}
