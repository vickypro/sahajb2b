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
import sahaj.model.master.CompanyBankDetails;
import sahaj.model.master.CompanyDetails;
import sahaj.model.master.Item;
import sahaj.model.master.ItemSaleRate;

public class CompanyDetailsServiceImpl {

	@Autowired
	private MongoOperations mongoOperations;

	MongoClient mongoClient = DatabaseConnection.getDatabaseConnection();
	
	public List<CompanyDetails> getCompanyDetailsList() {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		
		Query query = new Query();
		query.addCriteria(Criteria.where("delete_status").is(0));

		List<CompanyDetails> companyDetailsList = mongoTemplate.find(query,CompanyDetails.class,"company_profile_master");
		System.out.println("companyDetailsList--------------------------------------"+companyDetailsList.size());
		return companyDetailsList;

	}
	
	public void saveCompanyProfile(CompanyDetails companyDetails) {

		DB db = mongoClient.getDB("solar");
		DBCollection col = db.getCollection("company_profile_master");
		System.out.println("In service============"+companyDetails.toString());
		
		companyDetails.setCompanyId(getNextCompanyProfileId());
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("company_id", companyDetails.getCompanyId());
		docBuilder.append("company_name",companyDetails.getCompanyName());
		docBuilder.append("delete_status", companyDetails.getDeleteStatus());
		docBuilder.append("pincode", companyDetails.getPincode());
		docBuilder.append("address", companyDetails.getAddress());
		docBuilder.append("city",companyDetails.getCity());
		docBuilder.append("district_id",companyDetails.getDistrictId());
		docBuilder.append("state_id",companyDetails.getStateId());
		docBuilder.append("contact_number1", companyDetails.getContactNumber1());
		docBuilder.append("contact_number2", companyDetails.getContactNumber2());
		docBuilder.append("email_id", companyDetails.getEmailId());
		

		WriteResult result = col.insert(docBuilder.get());

		int companyBankDetailsId = getNextCompanyBankId();
		DBCollection col1 = db.getCollection("company_bank_details");
		for(int i=0; i<companyDetails.getBankDetailsList().size();i++)
		{
			CompanyBankDetails companyBankDetails = companyDetails.getBankDetailsList().get(i) ;
			companyBankDetails.setCompanyId(companyDetails.getCompanyId());
			System.out.println("companyBankDetailsId*********"+companyBankDetailsId);
			companyBankDetails.setCompanyBankDetailsId(companyBankDetailsId);
			BasicDBObjectBuilder docBuilderList = BasicDBObjectBuilder.start();
			docBuilderList.append("company_bank_details_id", companyBankDetails.getCompanyBankDetailsId());
			docBuilderList.append("bank_id", companyBankDetails.getBankId());
			docBuilderList.append("bank_branch_name", companyBankDetails.getBankBranchName());
			docBuilderList.append("account_number", companyBankDetails.getAccountNumber());
			docBuilderList.append("ifsc_code", companyBankDetails.getIfscCode());
			docBuilderList.append("delete_status", companyBankDetails.getDeleteStatus());
			docBuilderList.append("company_id", companyBankDetails.getCompanyId());
			WriteResult resultList = col1.insert(docBuilderList.get());
			companyBankDetailsId++;
		}
	}
		
		public int getNextCompanyProfileId() {
			SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
			MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

			Query query = new Query();
			query.limit(1);
			query.with(new Sort(Sort.Direction.DESC, "company_id"));

			CompanyDetails companyDetails = mongoTemplate.findOne(query, CompanyDetails.class);
			return companyDetails.getCompanyId()+1;
		}
		
		public int getNextCompanyBankId() {
			
			int i=0;
			SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
			MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

			Query query = new Query();
			query.limit(1);
			query.with(new Sort(Sort.Direction.DESC, "company_bank_details_id"));

			CompanyBankDetails companyBankDetails = mongoTemplate.findOne(query, CompanyBankDetails.class);
	
			if(companyBankDetails == null) 
			{
				i=1;
			}
			else {
			i = companyBankDetails.getCompanyBankDetailsId()+1;
			}
			return i;
		}
		
		public CompanyDetails getCompanyDetails(int companyId) {
			System.out.println("In getCompanyDetails============"+companyId);
			SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
			MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

			Query query = new Query();
			query.addCriteria(Criteria.where("company_id").is(companyId));
			CompanyDetails companyDetails = mongoTemplate.findOne(query, CompanyDetails.class);
			
		   Query query1 = new Query();
		    query1.addCriteria(Criteria.where("company_id").is(companyId));
		    System.out.println("query1-------"+query1);
		     List<CompanyBankDetails> bankDetailsList =  mongoTemplate.find(query1, CompanyBankDetails.class);
		 
		     companyDetails.setBankDetailsList(bankDetailsList);
			System.out.println("bankDetailsList----------"+bankDetailsList.size());
			return companyDetails;
		}
		
		public void updateCompanyProfile(CompanyDetails companyDetails) {

			SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
			   MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
				         DB db = mongoClient.getDB("solar");
				      
						 DBCollection dbCollection = db.getCollection("company_profile_master");
						 BasicDBObject searchQuery = new BasicDBObject("company_id", companyDetails.getCompanyId());
						 
				         BasicDBObject newDocument = new BasicDBObject();
				         newDocument.append("company_id", companyDetails.getCompanyId());
				         newDocument.append("company_name",companyDetails.getCompanyName());
				         newDocument.append("delete_status", companyDetails.getDeleteStatus());
				         newDocument.append("pincode", companyDetails.getPincode());
				         newDocument.append("address", companyDetails.getAddress());
				         newDocument.append("city",companyDetails.getCity());
				         newDocument.append("district_id",companyDetails.getDistrictId());
				         newDocument.append("state_id",companyDetails.getStateId());
				         newDocument.append("contact_number1", companyDetails.getContactNumber1());
				         newDocument.append("contact_number2", companyDetails.getContactNumber2());
				         newDocument.append("email_id", companyDetails.getEmailId());
						 
						 BasicDBObject setQuery = new BasicDBObject();
						 setQuery.append("$set", newDocument);
						 dbCollection.update(searchQuery, setQuery);
				      
				  	   Query searchQuery2 = new Query(Criteria.where("company_id").is(companyDetails.getCompanyId()));
				  	   WriteResult result = mongoTemplate.remove(searchQuery2, CompanyBankDetails.class);
				  	   System.out.println("Result-----------"+result);
				  	   
				  	   int companyBankDetailsId = getNextCompanyBankId();
						DBCollection col1 = db.getCollection("company_bank_details");
						for(int i=0; i<companyDetails.getBankDetailsList().size();i++)
						{
							CompanyBankDetails companyBankDetails = companyDetails.getBankDetailsList().get(i) ;
							companyBankDetails.setCompanyId(companyDetails.getCompanyId());
							System.out.println("companyBankDetailsId*********"+companyBankDetailsId);
							companyBankDetails.setCompanyBankDetailsId(companyBankDetailsId);
							BasicDBObjectBuilder docBuilderList = BasicDBObjectBuilder.start();
							docBuilderList.append("company_bank_details_id", companyBankDetails.getCompanyBankDetailsId());
							docBuilderList.append("bank_id", companyBankDetails.getBankId());
							docBuilderList.append("bank_branch_name", companyBankDetails.getBankBranchName());
							docBuilderList.append("account_number", companyBankDetails.getAccountNumber());
							docBuilderList.append("ifsc_code", companyBankDetails.getIfscCode());
							docBuilderList.append("delete_status", companyBankDetails.getDeleteStatus());
							docBuilderList.append("company_id", companyBankDetails.getCompanyId());
							WriteResult resultList = col1.insert(docBuilderList.get());
							companyBankDetailsId++;
						}			
		}
		
		public int  deleteCompanyProfile(int companyId) {
			
			 DB db = mongoClient.getDB("solar");
			 DBCollection dbCollection = db.getCollection("company_profile_master");
			 BasicDBObject searchQuery = new BasicDBObject("company_id",companyId );
			 
			 BasicDBObject newDocument = new BasicDBObject();
			 newDocument.append("delete_status", 1);
			 BasicDBObject setQuery = new BasicDBObject();
			 setQuery.append("$set", newDocument);
			 WriteResult result = dbCollection.update(searchQuery, setQuery);
		 return result.getN();
	}
		
			
		
	}

