package sahaj.service.master;

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
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

import sahaj.database.DatabaseConnection;
import sahaj.model.master.Item;
import sahaj.model.master.ItemSaleRate;
import sahaj.model.master.State;

public class ItemService {

	@Autowired
	private MongoOperations mongoOperations;

	MongoClient mongoClient = DatabaseConnection.getDatabaseConnection();
	
	
	public void saveItem(Item item) {

		DB db = mongoClient.getDB("solar");
		DBCollection col = db.getCollection("item_master");
		System.out.println("In service============"+item.toString());
		
		item.setItemId(getNextItemId());
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("item_id", item.getItemId());
		docBuilder.append("company_id",item.getCompanyId() );
		docBuilder.append("brand_id", item.getBrandId());
		docBuilder.append("item_code", item.getItemCode());
		docBuilder.append("item_name", item.getItemName());
		docBuilder.append("short_name",item.getShortName() );
		docBuilder.append("item_category_id",item.getItemCategoryId() );
		docBuilder.append("uom_id",item.getUomId() );
		docBuilder.append("kg_per_uom", item.getKgPerUom());
		docBuilder.append("sector_id", item.getSectorId());
		docBuilder.append("quantity_per_box", item.getQuantityPerBox());
		docBuilder.append("display_order", item.getDisplayOrder());
		docBuilder.append("daily_stock", item.getDailyStock());
		docBuilder.append("equivalent_item_id", item.getEquivalentItemId());
		docBuilder.append("group_name",item.getGroupName());
		docBuilder.append("packing_quantity", item.getPackingQuantity());
		docBuilder.append("daily_stock_main_group",item.getDailyStockMainGroup());
		docBuilder.append("token_no_prefix",item.getTokenNoPrefix());
		docBuilder.append("show_to_subdealer", item.getShowToSubdealer());
		docBuilder.append("accept_target", item.getAcceptTarget());
		docBuilder.append("restrict_sale_qty", item.getRestrictSaleQty());
		docBuilder.append("sale_quantity", item.getSaleQuantity());
		docBuilder.append("active", item.getActiveStatus());
		docBuilder.append("delete_status",0);

		WriteResult result = col.insert(docBuilder.get());

		int itemSaleRateId = getNextItemSaleRateId();
		DBCollection col1 = db.getCollection("item_salerate_master");
		for(int i=0; i<item.getSaleRateList().size();i++)
		{
			ItemSaleRate itemSaleRate = item.getSaleRateList().get(i) ;
			itemSaleRate.setItemId(item.getItemId());
			System.out.println("itemSaleRateId*********"+itemSaleRateId);
			itemSaleRateId++;
			itemSaleRate.setItemSaleRateId(itemSaleRateId);
			BasicDBObjectBuilder docBuilderList = BasicDBObjectBuilder.start();
			docBuilderList.append("state_idComma", itemSaleRate.getStateIDComma());
			docBuilderList.append("state_id", itemSaleRate.getStateId());
			docBuilderList.append("sale_rate_with", itemSaleRate.getSaleRateWith());
			docBuilderList.append("rate", itemSaleRate.getRate());
			docBuilderList.append("item_id", itemSaleRate.getItemId());
			docBuilderList.append("item_salerate_id", itemSaleRate.getItemSaleRateId());
			WriteResult resultList = col1.insert(docBuilderList.get());
		}
		
		
	}
	
	public int getNextItemSaleRateId() {
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "item_salerate_id"));

		ItemSaleRate itemSaleRate = mongoTemplate.findOne(query, ItemSaleRate.class);
		return itemSaleRate.getItemSaleRateId();
	}
	
	public int getNextItemId() {
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "item_id"));

		Item item = mongoTemplate.findOne(query, Item.class);
		return item.getItemId()+1;
	}
	
	public List<Item> getItemNameList() {
		System.out.println("In service============");
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		
		Query query = new Query();
		query.addCriteria(Criteria.where("delete_status").is(0));

		List<Item> itemNameList = mongoTemplate.find(query,Item.class);
		return itemNameList;

	}
	
	public List<Item> getItemList() {
		
		
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		
		Query query = new Query();
		query.addCriteria(Criteria.where("delete_status").is(0));

		List<Item> itemList = mongoTemplate.find(query,Item.class);
		return itemList;

	}
	
	public Item getItemDetails(int itemId) {
		System.out.println("In getItemDetails============"+itemId);
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);

		Query query = new Query();
		query.addCriteria(Criteria.where("item_id").is(itemId));
		Item item = mongoTemplate.findOne(query, Item.class);
		
		    Query query1 = new Query();
	        query1.addCriteria(Criteria.where("item_id").is(itemId));
	        System.out.println("query1-------"+query1);
	        List<ItemSaleRate> itemSaleRateList =  mongoTemplate.find(query1, ItemSaleRate.class);
	 
		item.setSaleRateList(itemSaleRateList);
		System.out.println("itemSaleRateList----------"+itemSaleRateList.size());
		return item;
	}
	
	public void updateItem(Item item) {

	  SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
	   MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		         DB db = mongoClient.getDB("solar");
		         
				 DBCollection dbCollection = db.getCollection("item_master");
				 BasicDBObject searchQuery = new BasicDBObject("item_id", item.getItemId());
				 
		         BasicDBObject newDocument = new BasicDBObject();
				 newDocument.append("item_id", item.getItemId());
				 newDocument.append("company_id",item.getCompanyId() );
				 newDocument.append("brand_id", item.getBrandId());
				 newDocument.append("item_code", item.getItemCode());
				 newDocument.append("item_name", item.getItemName());
				 newDocument.append("short_name",item.getShortName() );
				 newDocument.append("item_category_id",item.getItemCategoryId() );
				 newDocument.append("uom_id",item.getUomId() );
				 newDocument.append("kg_per_uom", item.getKgPerUom());
				 newDocument.append("sector_id", item.getSectorId());
				 newDocument.append("quantity_per_box", item.getQuantityPerBox());
				 newDocument.append("display_order", item.getDisplayOrder());
				 newDocument.append("daily_stock", item.getDailyStock());
				 newDocument.append("equivalent_item_id", item.getEquivalentItemId());
				 newDocument.append("group_name",item.getGroupName());
				 newDocument.append("packing_quantity", item.getPackingQuantity());
				 newDocument.append("daily_stock_main_group",item.getDailyStockMainGroup());
				 newDocument.append("token_no_prefix",item.getTokenNoPrefix());
				 newDocument.append("show_to_subdealer", item.getShowToSubdealer());
				 newDocument.append("accept_target", item.getAcceptTarget());
				 newDocument.append("restrict_sale_qty", item.getRestrictSaleQty());
				 newDocument.append("sale_quantity", item.getSaleQuantity());
				 newDocument.append("active", item.getActiveStatus());
				 
				 BasicDBObject setQuery = new BasicDBObject();
				 setQuery.append("$set", newDocument);
				 dbCollection.update(searchQuery, setQuery);
		      
		  	   Query searchQuery2 = new Query(Criteria.where("item_id").is( item.getItemId()));
		  	   WriteResult result = mongoTemplate.remove(searchQuery2, ItemSaleRate.class);
		  	   System.out.println("Result-----------"+result);
				 
		  	    int itemSaleRateId = getNextItemSaleRateId();
				DBCollection col1 = db.getCollection("item_salerate_master");
				for(int i=0; i<item.getSaleRateList().size();i++)
				{
					ItemSaleRate itemSaleRate = item.getSaleRateList().get(i) ;
					itemSaleRate.setItemId(item.getItemId());
					System.out.println("itemSaleRateId*********"+itemSaleRateId);
					itemSaleRateId++;
					itemSaleRate.setItemSaleRateId(itemSaleRateId);
					BasicDBObjectBuilder docBuilderList = BasicDBObjectBuilder.start();
					docBuilderList.append("state_idComma", itemSaleRate.getStateIDComma());
					docBuilderList.append("sale_rate_with", itemSaleRate.getSaleRateWith());
					docBuilderList.append("rate", itemSaleRate.getRate());
					docBuilderList.append("item_id", itemSaleRate.getItemId());
					docBuilderList.append("item_salerate_id", itemSaleRate.getItemSaleRateId());
					WriteResult resultList = col1.insert(docBuilderList.get());
					System.out.println("resultList*********"+resultList.getN());
				}
				
	}
	
	public int  deleteItem(int itemId) {
//		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
//		MongoOperations mongoOperation = new MongoOperations(simpleMongoDbFactory);
	
//		Query searchQuery = new Query(Criteria.where("company").is("DCV"));
//	    mongoOperation.remove(searchQuery, Item.class);

//	   SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
//	   MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
//	   Query searchQuery = new Query(Criteria.where("delete_status").is(1));
//	   WriteResult result = mongoTemplate.remove(searchQuery, Item.class);
//	   System.out.println("Result-----------"+result);
   // mongoOperation.remove(searchQuery, Item.class);
			         DB db = mongoClient.getDB("solar");
					 DBCollection dbCollection = db.getCollection("item_master");
					 BasicDBObject searchQuery = new BasicDBObject("item_id",itemId );
					 
					 BasicDBObject newDocument = new BasicDBObject();
					 newDocument.append("delete_status", 1);
					 //System.out.println("NEWDOCUMENT===================="+newDocument);
					 BasicDBObject setQuery = new BasicDBObject();
					 setQuery.append("$set", newDocument);
					 WriteResult result = dbCollection.update(searchQuery, setQuery);
					 //System.out.println("Result-----------"+result.getN());
				 return result.getN();
		}
	
		
}
