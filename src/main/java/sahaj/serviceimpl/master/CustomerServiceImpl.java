package sahaj.serviceimpl.master;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

import sahaj.database.DatabaseConnection;
import sahaj.model.master.Customer;
import sahaj.model.master.CustomerCategory;
import sahaj.model.master.District;
import sahaj.model.master.Magazine;
import sahaj.model.master.MagazineCapacity;
import sahaj.service.master.CustomerService;

/**
 * @author Amit
 *
 */
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private MongoOperations mongoOperations;

	MongoClient mongoClient = DatabaseConnection.getDatabaseConnection();

	public List<Customer> getCustomerList() {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		List<Customer> customerList = mongoTemplate.findAll(Customer.class, "customer_master");
		return customerList;

	}

	public List<District> getDistrictList(int stateId) {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.addCriteria(Criteria.where("state_id").is(stateId));

		List<District> districtList = mongoTemplate.find(query, District.class);
		return districtList;

	}

	public int getNextCustomerId() {
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "customer_id"));
		Customer customer = mongoTemplate.findOne(query, Customer.class);
		return customer.getCustomerId() + 1;
	}

	public int getNextMagazineId() {
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "magazine_id"));

		Magazine magazine = mongoTemplate.findOne(query, Magazine.class);
		return magazine.getMagazineId() + 1;
	}

	public int getNextMagazineCapacityId() {
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "magazine_capacity_id"));

		MagazineCapacity magazineCapacity = mongoTemplate.findOne(query, MagazineCapacity.class);
		return magazineCapacity.getMagazineCapacityId() + 1;
	}

	public void saveCustomer(Customer customer) {
		
//		System.out.println("date-------"+customer.getMaxMonthTargetDate());
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		String string = simpleDateFormat.format(customer.getMaxMonthTargetDate());
//		
//		Date date = simpleDateFormat.parse(string);
//		
//		System.out.println("convert---------"+date);
		
		
		DB db = mongoClient.getDB("solar");
		DBCollection collection1 = db.getCollection("customer_master");
		DBCollection collection2 = db.getCollection("magazine_master");
		DBCollection collection3 = db.getCollection("magazine_capacity_master");

		List<DBObject> documents1 = new ArrayList<>();
		List<DBObject> documents2 = new ArrayList<>();
		List<DBObject> documents3 = new ArrayList<>();

		DBObject document1 = new BasicDBObject();
		System.out.println("getNextCustomerId--------" + getNextCustomerId());
		customer.setCustomerId(getNextCustomerId());

		document1.put("customer_id", customer.getCustomerId());
		document1.put("customer_code", customer.getCustomerCode());
		document1.put("customer_name", customer.getCustomerName());
		document1.put("mobile_number", customer.getMobileNumber());
		document1.put("email_id", customer.getEmailId());
		document1.put("address", customer.getAddress());
		document1.put("city", customer.getCity());
		document1.put("state_id", customer.getStateId());
		document1.put("district_id", customer.getDistrictId());

		document1.put("customer_category_id", customer.getCustomerCategoryId());
		document1.put("associate_name", customer.getAssociateName());
		document1.put("inout_state", customer.getInOutState());

//		document1.put("dispatch_mode", Arrays.toString(customer.getDispatchMode()));
		document1.put("dispatch_mode", customer.getDispatchMode());
		document1.put("gst_number", customer.getGstNumber());
		document1.put("tokenno_prefix", customer.getTokenNoPrefix());
		document1.put("bank_id", customer.getBankId());
		document1.put("branch_name", customer.getBranchName());
		document1.put("account_number", customer.getAccountNumber());
		document1.put("ifsc_code", customer.getIfscCode());
		document1.put("has_subdealer", customer.getHasSubdealer());
		document1.put("showto_subdealer", customer.getShowToSubdealer());
		document1.put("accept_daily_stock", customer.getAcceptDailyStock());
		document1.put("club_po", customer.getClubPo());

		document1.put("goods_receipt", customer.getGoodsReceipt());
		document1.put("phone_report_check", customer.getPhoneReportCheck());
		document1.put("active_status", customer.getActiveStatus());
		document1.put("priority_loading_request", customer.getPriorityLoadingRequest());
		document1.put("dailystock_checkdays", customer.getDailyStockCheckDays());
		document1.put("phonereport_checkdays", customer.getPhoneReportCheckDays());
		document1.put("maxcontract_days", customer.getMaxContractDays());
		document1.put("maxmonth_targetdate", new Date());

		document1.put("owner_firstname", customer.getOwnerFirstName());
		document1.put("owner_lastname", customer.getOwnerLastName());
		document1.put("owner_emailid", customer.getOwnerEmailId());
		document1.put("owner_mobilenumber", customer.getOwnerMobileNumber());
		document1.put("owner_dateofbirth", new Date());
		document1.put("owner_pannumber", customer.getOwnerPanNumber());
		document1.put("owner_aadhaarnumber", customer.getOwnerAadhaarNumber());

		document1.put("manager_firstname", customer.getManagerFirstName());
		document1.put("manager_lastname", customer.getManagerLastName());
		document1.put("manager_emailid", customer.getManagerEmailId());
		document1.put("manager_mobilenumber", customer.getManagerMobileNumber());
		document1.put("manager_dateofbirth", new Date());
		document1.put("manager_pannumber", customer.getManagerPanNumber());
		document1.put("manager_adhaarnumber", customer.getManagerAdhaarNumber());
		documents1.add(document1);

		int magazineId = getNextMagazineId();
		int magazineCapacityId = getNextMagazineCapacityId();
		System.out.println("magazineId-----------" + magazineId);

		for (int i = 0; i < customer.getMagazineList().size(); i++) {
			DBObject document2 = new BasicDBObject();
			Magazine magazine = customer.getMagazineList().get(i);
			document2.put("magazine_id", magazineId);
			document2.put("magazine_code", magazine.getMagazineCode());
			document2.put("magazine_name", magazine.getMagazineName());
			document2.put("description", magazine.getDescription());
			document2.put("document_key", magazine.getDocumentKey());
			document2.put("license_number", magazine.getLicenseNumber());
			document2.put("license_expirydate", new Date());
			document2.put("address", magazine.getAddress());
			document2.put("city", magazine.getCity());
			document2.put("state_id", magazine.getStateId());
			document2.put("district_id", magazine.getDistrictId());
			document2.put("customer_id", customer.getCustomerId());
			documents2.add(document2);

			for (int j = 0; j < customer.getMagazineCapacityList().size(); j++) {
				DBObject document3 = new BasicDBObject();
				MagazineCapacity magazineCapacity = customer.getMagazineCapacityList().get(j);
				if (magazine.getMagazineId() == magazineCapacity.getMagazineId()) {
					document3.put("magazine_capacity_id", magazineCapacityId);
					document3.put("item_category_id", magazineCapacity.getItemCategoryId());
					document3.put("capacity", magazineCapacity.getCapacity());
					document3.put("uom_id", magazineCapacity.getUomId());
					document3.put("rotation_capacity", magazineCapacity.getRotationCapacity());
					document3.put("magazine_id", magazineId);
					document3.put("customer_id", customer.getCustomerId());
					documents3.add(document3);
					magazineCapacityId++;
				}
			}

			magazineId++;
		}
		System.out.println("documents----------" + documents1);
		System.out.println();
		System.out.println("documents----------" + documents2);
		System.out.println();
		System.out.println("documents----------" + documents3);
		System.out.println();
		
		collection1.insert(documents1);
//		System.out.println("collection1.insert(documents1)----"+collection1.insert(documents1));
		collection2.insert(documents2);
		collection3.insert(documents3);
		

	}

	public Customer getCustomerDetails(int customerId) {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.addCriteria(Criteria.where("customer_id").is(customerId));
		Customer customer = mongoTemplate.findOne(query, Customer.class);

		Query query1 = new Query();
		query1.addCriteria(Criteria.where("customer_id").is(customerId));
		List<Magazine> magazineList = mongoTemplate.find(query, Magazine.class);
		customer.setMagazineList(magazineList);

		Query query2 = new Query();
		query2.addCriteria(Criteria.where("customer_id").is(customerId));
		List<MagazineCapacity> magazineCapacityList = mongoTemplate.find(query, MagazineCapacity.class);
		customer.setMagazineCapacityList(magazineCapacityList);
		
		return customer;
	}

	public void updateCustomer(Customer customer) {

		DB db = mongoClient.getDB("solar");
		DBCollection collection1 = db.getCollection("customer_master");
		DBCollection collection2 = db.getCollection("magazine_master");
		DBCollection collection3 = db.getCollection("magazine_capacity_master");

		BasicDBObject searchQuery1 = new BasicDBObject("customer_id", customer.getCustomerId());
		
		BasicDBObject document1 = new BasicDBObject();
		document1.append("customer_code", customer.getCustomerCode());
		document1.append("customer_name", customer.getCustomerName());
		document1.append("mobile_number", customer.getMobileNumber());
		document1.append("email_id", customer.getEmailId());
		document1.append("address", customer.getAddress());
		document1.append("city", customer.getCity());
		document1.append("state_id", customer.getStateId());
		document1.append("district_id", customer.getDistrictId());

		document1.append("customer_category_id", customer.getCustomerCategoryId());
		document1.append("associate_name", customer.getAssociateName());
		document1.append("inout_state", customer.getInOutState());

		document1.append("dispatch_mode", customer.getDispatchMode());
		document1.append("gst_number", customer.getGstNumber());
		document1.append("tokenno_prefix", customer.getTokenNoPrefix());
		document1.append("bank_id", customer.getBankId());
		document1.append("branch_name", customer.getBranchName());
		document1.append("account_number", customer.getAccountNumber());
		document1.append("ifsc_code", customer.getIfscCode());
		document1.append("has_subdealer", customer.getHasSubdealer());
		document1.append("showto_subdealer", customer.getShowToSubdealer());
		document1.append("accept_daily_stock", customer.getAcceptDailyStock());
		document1.append("club_po", customer.getClubPo());

		document1.append("goods_receipt", customer.getGoodsReceipt());
		document1.append("phone_report_check", customer.getPhoneReportCheck());
		document1.append("priority_loading_request", customer.getPriorityLoadingRequest());
		document1.append("dailystock_checkdays", customer.getDailyStockCheckDays());
		document1.append("phonereport_checkdays", customer.getPhoneReportCheckDays());
		document1.append("maxcontract_days", customer.getMaxContractDays());
		document1.append("maxmonth_targetdate", new Date());

		document1.append("owner_firstname", customer.getOwnerFirstName());
		document1.append("owner_lastname", customer.getOwnerLastName());
		document1.append("owner_emailid", customer.getOwnerEmailId());
		document1.append("owner_mobilenumber", customer.getOwnerMobileNumber());
		document1.append("owner_dateofbirth", new Date());
		document1.append("owner_pannumber", customer.getOwnerPanNumber());
		document1.append("owner_aadhaarnumber", customer.getOwnerAadhaarNumber());

		document1.append("manager_firstname", customer.getManagerFirstName());
		document1.append("manager_lastname", customer.getManagerLastName());
		document1.append("manager_emailid", customer.getManagerEmailId());
		document1.append("manager_mobilenumber", customer.getManagerMobileNumber());
		document1.append("manager_dateofbirth", new Date());
		document1.append("manager_pannumber", customer.getManagerPanNumber());
		document1.append("manager_adhaarnumber", customer.getManagerAdhaarNumber());

		BasicDBObject setQuery1 = new BasicDBObject();
		setQuery1.append("$set", document1);
		WriteResult writeResult1 = collection1.update(searchQuery1, setQuery1);
		
		for (int i = 0; i < customer.getMagazineList().size(); i++) {
			BasicDBObject document2 = new BasicDBObject();
			Magazine magazine = customer.getMagazineList().get(i);
			BasicDBObject searchQuery2 = new BasicDBObject("magazine_id", magazine.getMagazineId());

			document2.append("magazine_code", magazine.getMagazineCode());
			document2.append("magazine_name", magazine.getMagazineName());
			document2.append("description", magazine.getDescription());
			document2.append("document_key", magazine.getDocumentKey());
			document2.append("license_number", magazine.getLicenseNumber());
			document2.append("license_expirydate", new Date());
			document2.append("address", magazine.getAddress());
			document2.append("city", magazine.getCity());
			document2.append("state_id", magazine.getStateId());
			document2.append("district_id", magazine.getDistrictId());
			document2.append("customer_id", customer.getCustomerId());

			BasicDBObject setQuery2 = new BasicDBObject();
			setQuery2.append("$set", document2);
			WriteResult writeResult2 = collection2.update(searchQuery2, setQuery2);
		}

		for (int j = 0; j < customer.getMagazineCapacityList().size(); j++) {
			BasicDBObject document3 = new BasicDBObject();
			MagazineCapacity magazineCapacity = customer.getMagazineCapacityList().get(j);
			BasicDBObject searchQuery3 = new BasicDBObject("magazine_capacity_id", magazineCapacity.getMagazineCapacityId());
			
			document3.put("item_category_id", magazineCapacity.getItemCategoryId());
			document3.put("capacity", magazineCapacity.getCapacity());
			document3.put("uom_id", magazineCapacity.getUomId());
			document3.put("rotation_capacity", magazineCapacity.getRotationCapacity());
			
			BasicDBObject setQuery3 = new BasicDBObject();
			setQuery3.append("$set", document3);
			WriteResult writeResult3 = collection3.update(searchQuery3, setQuery3);
		}
		

	}

}
