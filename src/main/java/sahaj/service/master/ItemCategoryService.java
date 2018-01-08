package sahaj.service.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

import sahaj.database.DatabaseConnection;
import sahaj.model.master.ItemCategory;
import sahaj.model.master.Sector;

public class ItemCategoryService {

	@Autowired
	private MongoOperations mongoOperations;

	MongoClient mongoClient = DatabaseConnection.getDatabaseConnection();

	public List<ItemCategory> getItemCategoryList() {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		List<ItemCategory> itemcategoryList = mongoTemplate.findAll(ItemCategory.class, "item_category_master");
		return itemcategoryList;

	}
}
