package sahaj.serviceimpl.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

import sahaj.database.DatabaseConnection;
import sahaj.model.master.CustomerCategory;
import sahaj.service.master.CustomerCategoryService;

/**
 * @author Amit
 *
 */
public class CustomerCategoryServiceImpl implements CustomerCategoryService {

	@Autowired
	private MongoOperations mongoOperations;

	MongoClient mongoClient = DatabaseConnection.getDatabaseConnection();

	public List<CustomerCategory> getCustomerCategoryList() {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		List<CustomerCategory> customerCategoryList = mongoTemplate.findAll(CustomerCategory.class,
				"customer_category");
		return customerCategoryList;

	}

	public int getNextCustomerCategoryId() {
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "customer_category_id"));

		CustomerCategory customerCategory = mongoTemplate.findOne(query, CustomerCategory.class);
		return customerCategory.getCustomerCategoryId() + 1;
	}

	public void saveCustomerCategory(CustomerCategory customerCategory) {

		DB db = mongoClient.getDB("solar");
		DBCollection col = db.getCollection("customer_category");

		customerCategory.setCustomerCategoryId(getNextCustomerCategoryId());

		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("customer_category_id", customerCategory.getCustomerCategoryId());
		docBuilder.append("customer_category_name", customerCategory.getCustomerCategoryName());
		docBuilder.append("description", customerCategory.getDescription());
		docBuilder.append("active_status", "0");

		WriteResult result = col.insert(docBuilder.get());
		int n = result.getN();
	}

	public CustomerCategory getCustomerCategoryDetails(int customerCategoryId) {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.addCriteria(Criteria.where("customer_category_id").is(customerCategoryId));

		CustomerCategory customerCategory = mongoTemplate.findOne(query, CustomerCategory.class);
		System.out.println("getCustomerCategoryName-----" + customerCategory.getCustomerCategoryName());
		System.out.println("getDescription-----" + customerCategory.getDescription());

		return customerCategory;
	}

	public void updateCustomerCategory(CustomerCategory customerCategory) {

		/*
		 * SimpleMongoDbFactory simpleMongoDbFactory = new
		 * SimpleMongoDbFactory(mongoClient, "solar"); MongoTemplate mongoTemplate = new
		 * MongoTemplate(simpleMongoDbFactory);
		 * 
		 * WriteResult a = mongoTemplate.updateFirst( new
		 * Query(Criteria.where("_id").is(customerCategory.getCustomerCategoryId())),
		 * Update.update("customer_category_name",
		 * customerCategory.getCustomerCategoryName()), CustomerCategory.class);
		 */

//		DB db = mongoClient.getDB("solar");
//		DBCollection dbCollection = db.getCollection("customer_category");
//		BasicDBObject newDocument = new BasicDBObject();
//		newDocument.put("customer_category_name", customerCategory.getCustomerCategoryName());
//		newDocument.put("description", customerCategory.getDescription());
//		newDocument.put("active_status", 0);
//		WriteResult writeResult = dbCollection.update(
//				new BasicDBObject().append("customer_category_id", customerCategory.getCustomerCategoryId()),
//				newDocument);

		DB db = mongoClient.getDB("solar");
		DBCollection dbCollection = db.getCollection("customer_category");
		BasicDBObject searchQuery = new BasicDBObject("customer_category_id", customerCategory.getCustomerCategoryId());
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("customer_category_name", customerCategory.getCustomerCategoryName());
		newDocument.append("description", customerCategory.getDescription());
//		newDocument.append("active_status", 0);
		BasicDBObject setQuery = new BasicDBObject();
		setQuery.append("$set", newDocument);
		WriteResult writeResult = dbCollection.update(searchQuery, setQuery);

		System.out.println("newDocument----------" + newDocument);
		System.out.println("writeResult----------" + writeResult);

	}

	public void deleteCustomerCategory(CustomerCategory customerCategory) {

		DB db = mongoClient.getDB("solar");
		DBCollection dbCollection = db.getCollection("customer_category");
		BasicDBObject searchQuery = new BasicDBObject("customer_category_id", customerCategory.getCustomerCategoryId());
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("active_status", 1);
		BasicDBObject setQuery = new BasicDBObject();
		setQuery.append("$set", newDocument);
		WriteResult writeResult = dbCollection.update(searchQuery, setQuery);
		System.out.println("writeResult----------" + writeResult);
	}

}
