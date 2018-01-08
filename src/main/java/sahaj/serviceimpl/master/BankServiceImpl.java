/**
 * 
 */
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
import sahaj.service.master.BankService;

/**
 * @author Amit
 *
 */
public class BankServiceImpl implements BankService{

	@Autowired
	private MongoOperations mongoOperations;

	MongoClient mongoClient = DatabaseConnection.getDatabaseConnection();

	public List<Bank> getBankList() {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		List<Bank> bankList = mongoTemplate.findAll(Bank.class, "bank_master");
		return bankList;

	}
	
	public int getNextBankId() {
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "bank_id"));

		Bank bank = mongoTemplate.findOne(query, Bank.class);
		return bank.getBankId() + 1;
	}
	
	public int saveBank(Bank bank) {

		DB db = mongoClient.getDB("solar");
		DBCollection col = db.getCollection("bank_master");

		bank.setBankId(getNextBankId());

		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("bank_id", bank.getBankId());
		docBuilder.append("bank_name", bank.getBankName());
		docBuilder.append("description", bank.getDescription());
		docBuilder.append("delete_status", "0");

		WriteResult result = col.insert(docBuilder.get());
		return result.getN();
	}
	
	public Bank getBankDetails(int bankId) {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.addCriteria(Criteria.where("bank_id").is(bankId));

		Bank bank = mongoTemplate.findOne(query, Bank.class);

		return bank;
	}
	
	public int updateBank(Bank bank) {

		DB db = mongoClient.getDB("solar");
		DBCollection dbCollection = db.getCollection("bank_master");
		BasicDBObject searchQuery = new BasicDBObject("bank_id", bank.getBankId());
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("bank_name", bank.getBankName());
		newDocument.append("description", bank.getDescription());
		BasicDBObject setQuery = new BasicDBObject();
		setQuery.append("$set", newDocument);
		WriteResult writeResult = dbCollection.update(searchQuery, setQuery);	
		return writeResult.getN();

	}
}
