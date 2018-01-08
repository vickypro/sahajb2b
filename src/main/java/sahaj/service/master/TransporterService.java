package sahaj.service.master;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.session.SessionDestroyedEvent;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import sahaj.database.DatabaseConnection;
import sahaj.model.master.District;
import sahaj.model.master.Transporter;

public class TransporterService {

	MongoClient mongoClient = DatabaseConnection.getDatabaseConnection();
	List<Transporter> transporter;
	public void saveTransporterService(Transporter transporter) {

		DB db = mongoClient.getDB("solar");
		DBCollection col = db.getCollection("transporter_master");
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("party_code", transporter.getPartyCode());
		docBuilder.append("contact_person",transporter.getContactPerson());
		docBuilder.append("party_name",transporter.getPartyName());
		docBuilder.append("mobile_number",transporter.getMobileNumber());
		docBuilder.append("email_id",transporter.getEmailId());
		docBuilder.append("address",transporter.getAddress());
		docBuilder.append("state_id",transporter.getStateId());
		docBuilder.append("city_id",transporter.getCityId());
		docBuilder.add("active_status",transporter.isActiveStatus());
		
		
		
		  
		col.insert(docBuilder.get());
	 
	}
	public Transporter getTransporterDetails(int  partyCode) {
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		Query query = new Query();
		 
		query.addCriteria(Criteria.where("party_code").is(partyCode));
		Transporter tr = mongoTemplate.findOne(query, Transporter.class);
		
		
		return tr;
	}
	public List<Transporter> getTransporterList() {

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		 transporter = mongoTemplate.findAll(Transporter.class,"transporter_master");
	 System.out.println("hii");
		return transporter;

	}
public Transporter NewTransporter() {
		
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		List<Transporter> TransporterList = mongoTemplate.findAll(Transporter.class,"transporter_master");
		Transporter transporter=new Transporter();
		for(Transporter agency:TransporterList)
		{
			int NewTransporter=agency.getPartyCode()+1;
			transporter.setPartyCode(NewTransporter);
		}
		 
		return transporter;	

}

public void updateTransporter(Transporter transporter) {
	 
	SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
	MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
	DB db = mongoClient.getDB("solar");
	DBCollection dbCollection = db.getCollection("transporter_master");
	BasicDBObject newDocument = new BasicDBObject();
	newDocument.put("contact_person",transporter.getContactPerson());
	newDocument.put("party_name",transporter.getPartyName());
	newDocument.put("mobile_number",transporter.getMobileNumber());
	newDocument.put("email_id",transporter.getEmailId());
	newDocument.put("state_id",transporter.getStateId());
	newDocument.put("city_id",transporter.getCityId());
	newDocument.put("address",transporter.getAddress());
	newDocument.put("active_status",transporter.isActiveStatus());
	newDocument.put("party_code",transporter.getPartyCode());
	
	dbCollection.update(
			new BasicDBObject().append("party_code",transporter.getPartyCode()),
			newDocument);
			 }

public void deleteTransporter(int partyCode) {
	
	
	SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
	MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
	Query query = new Query();
	query.addCriteria(Criteria.where("party_code").is(partyCode));
	mongoTemplate.remove(query, Transporter.class);
}





	
	
	
	

public  void sendMail() throws AddressException, MessagingException {
	
	for(Transporter emailid:transporter)
	{
		 

	System.out.println("mail");
	String rep=emailid.getEmailId();
	 sendEmail(rep, "Email", "Welcome to Email Integration", "amar.s.shinde@gmail.com", "amar.s.shinde@gmail.com", "amar7559");
	
	}
}
public static void sendEmail(String to, String subject, String msg,
      String from, String userName, String password) throws AddressException, MessagingException {
   Properties properties = new Properties();
   properties.put("mail.smtp.auth", "true");
   properties.put("mail.smtp.starttls.enable", "true");
   properties.put("mail.smtp.host", "smtp.gmail.com");
   properties.put("mail.smtp.port", "587");
   Session session = Session.getInstance(properties, new Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
         return new PasswordAuthentication(userName, password);
       }
   
   });

 
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(from));
      message.setRecipients(Message.RecipientType.BCC,
         InternetAddress.parse(to));
      message.setSubject(subject);
      message.setText(msg);
      Transport.send(message);
      System.out.println("Message send successfully....");
   } 


	/*for(Transporter emailid:transporter)
	{
	System.out.println("email id:"+emailid.getEmailId());
	String from="shindeamar459@gmail.com";
	String username="shindeamar459@gmail.com";
	String password="amar4029";
	String hostname="mail.gsmtp.host";
	String Subject="Email Integration";
	String textmsg="hii";
	//String mailTo="amar.s.shinde@gmail.com";
	String mailTo=emailid.getEmailId();
	SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
	MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
	ArrayList<Transporter> listOfEmails = (ArrayList<Transporter>) mongoTemplate.findAll(Transporter.class,"transporter_master");
	
	
	 Properties properties = new Properties();
     properties.put("mail.smtp.auth", "true");
     properties.put("mail.smtp.starttls.enable", "true");
     properties.put("mail.smtp.host", "smtp.gmail.com");
     properties.put("mail.smtp.port", "587");
     Session session = Session.getInstance(properties, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
           return new PasswordAuthentication(username, password);
         }
     });
     
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.addRecipient(Message.RecipientType.BCC, new InternetAddress(mailTo));
         message.setSubject(Subject);
         message.setText(textmsg);
         Transport.send(message);
         System.out.println("Message send successfully....");
      
}}*/
}






