package sahaj.database;

import com.mongodb.MongoClient;

/**
 * @author Amit
 *
 */
public class DatabaseConnection {

	public static MongoClient getDatabaseConnection() {
		MongoClient mongoClient = new MongoClient("192.168.1.107", 27017);
		return mongoClient;
	}
}
