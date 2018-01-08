package sahaj.serviceimpl.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

import sahaj.database.DatabaseConnection;
import sahaj.model.master.TransporterType;

@Service("transporterTypeService")
@Transactional
@Component
public class TransporterTypeServiceImpl {

	@Autowired
	private MongoOperations mongoOperations;

	MongoClient mongoClient = DatabaseConnection.getDatabaseConnection();
	
	public List<TransporterType> getTransporterTypeList() {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		List<TransporterType> transporterTypeList = mongoTemplate.findAll(TransporterType.class, "transportertype_master");
		return transporterTypeList;
	}
	
	public int getNextTransporterTypeId() {
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "transportertype_id"));

		TransporterType transporterType = mongoTemplate.findOne(query, TransporterType.class);
		return transporterType.getTransporterTypeId() + 1;
	}
	
	public int saveTransporterType(TransporterType transporterType) {

		DB db = mongoClient.getDB("solar");
		DBCollection col = db.getCollection("transportertype_master");

		transporterType.setTransporterTypeId(getNextTransporterTypeId());

		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("transportertype_id", transporterType.getTransporterTypeId());
		docBuilder.append("transportertype", transporterType.getTransporterTypeName());
		docBuilder.append("description", transporterType.getDescription());
		docBuilder.append("delete_status", "0");

		WriteResult result = col.insert(docBuilder.get());
		return result.getN();
	}
	
	public TransporterType getTransporterTypeDetails(int transporterTypeId) {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.addCriteria(Criteria.where("transportertype_id").is(transporterTypeId));

		TransporterType transporterType = mongoTemplate.findOne(query, TransporterType.class);

		return transporterType;
	}
	
	public int updateTransporterType(TransporterType transporterType) {

		DB db = mongoClient.getDB("solar");
		DBCollection dbCollection = db.getCollection("transportertype_master");
		BasicDBObject searchQuery = new BasicDBObject("transportertype_id", transporterType.getTransporterTypeId());
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("transportertype", transporterType.getTransporterTypeName());
		newDocument.append("description", transporterType.getDescription());
		BasicDBObject setQuery = new BasicDBObject();
		setQuery.append("$set", newDocument);
		WriteResult writeResult = dbCollection.update(searchQuery, setQuery);	
		return writeResult.getN();

	}
}
