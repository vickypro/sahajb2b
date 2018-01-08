package sahaj.service.PurchaseOrder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import sahaj.model.Mongodb.Mongodb;
import sahaj.model.PurchaseOrder.PurchaseOrder;
import sahaj.model.PurchaseOrder.Table;
import sahaj.model.PurchaseOrder.TableContent;
import sahaj.model.PurchaseOrder.TableContent2;

public class PurchaseOrderService2 {

	
	Mongodb mongo=new Mongodb();
	MongoClient mongoClient = new MongoClient(mongo.getHost(), 27017);
	
	
	public List<PurchaseOrder> getPoList() {

		MongoClient mongoClient = new MongoClient(mongo.getHost(),27017);
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		List<PurchaseOrder> PoContract = mongoTemplate.findAll(PurchaseOrder.class, "PoContract");
		return PoContract;
}
	
	
	
	public List<PurchaseOrder> CreatePo()  
	{
		List<PurchaseOrder> Pocontract =new ArrayList<PurchaseOrder>() ;
		PurchaseOrder po=new PurchaseOrder();
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss a");
	     Calendar calobj = Calendar.getInstance();
	      String time=df.format(calobj.getTime());
	       String[] DateTime = time.split(" ",2);
	       String Date=DateTime[0];
	       String Time=DateTime[1];
	    
	       po.setPoDate(Date);
	       po.setPoTime(Time);
	       calobj.add(Calendar.MONTH,1);
	       String valid= + (calobj.get(Calendar.DATE) + 1)
	    		   +"/"+calobj.get(Calendar.MONTH)+1
	    		   +"/"+calobj.get(Calendar.YEAR);
	    //  String pono="1";
	       MongoClient mongoClient = new MongoClient(mongo.getHost(),27017);
			SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "solar");
			MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
			List<PurchaseOrder> PoContract1 = mongoTemplate.findAll(PurchaseOrder.class, "PoContract");
			for(PurchaseOrder p:PoContract1)
			{
				int po1=Integer.parseInt(p.getPoNo());
				int temp=po1+1;
				String poget=Integer.toString(temp);
				po.setPoNo(poget);
			}
	      
	    
	      po.setPoValid(valid);
	      Pocontract.add(po);
	    return Pocontract;

	}
	
	 

	public void SavepoContract(PurchaseOrder poContract, List<Table> table, List<TableContent> exp_table,List<TableContent2> exp_table2)
	{
		/////////////////////////////////Normal Data of PDF/////////////////////////////////////////////
		DB db = mongoClient.getDB("solar");
		DBCollection collection = db.getCollection("PoContract");
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("PoDate",poContract.getPoDate());
		docBuilder.append("PoNo", poContract.getPoNo());
		docBuilder.append("PoTime", poContract.getPoTime());
		docBuilder.append("PoValidDate", poContract.getPoValid());
		for(Table tab:table)
		{
			docBuilder.append("indent_no",tab.getIndent_no());
			docBuilder.append("Date",tab.getDate());
			docBuilder.append("address",tab.getAddress());
			docBuilder.append("license_no",tab.getLicense_no());
			docBuilder.append("valid_date",tab.getValid_date());
		}
		collection.insert(docBuilder.get());
		////////////////////////////////////////Table1////////////////////////////////////////////////////
		for(TableContent tab:exp_table)
		{
			DB db1 = mongoClient.getDB("solar");
			DBCollection colproduct = db1.getCollection("ProductMain");
			BasicDBObjectBuilder docBuilderproduct = BasicDBObjectBuilder.start();
		docBuilderproduct.append("sr_no",tab.getSr_no());
		docBuilderproduct.append("Explosive_name",tab.getExplosive_name());
		docBuilderproduct.append("classes",tab.getClasses());
		docBuilderproduct.append("Division",tab.getDivision());
		docBuilderproduct.append("Quality",tab.getQuality());
		docBuilderproduct.append("Unit",tab.getUnit());
		docBuilderproduct.append("PoNo", poContract.getPoNo());
		colproduct.insert(docBuilderproduct.get());
		}
		
		for(TableContent2 tab:exp_table2)
		{
			
			DB db1 = mongoClient.getDB("solar");
			DBCollection colproduct = db1.getCollection("ProductSubCategory");
			BasicDBObjectBuilder docBuilderproduct = BasicDBObjectBuilder.start();
		docBuilderproduct.append("sr_no",tab.getSr_no());
		docBuilderproduct.append("Explosive_name",tab.getExplosive_name());
		docBuilderproduct.append("classes",tab.getClasses());
		docBuilderproduct.append("Division",tab.getDivision());
		docBuilderproduct.append("Quality",tab.getQuality());
		docBuilderproduct.append("Unit",tab.getUnit());
		docBuilderproduct.append("PoNo", poContract.getPoNo());
		colproduct.insert(docBuilderproduct.get());
		}
		
		
	}


	public void Pdfdata(String pdfFileInText,Table tab,List<Table> table)
	{
		 
		 /////////////////////Indent/////////////////////////////////////////////////////////////////              
        String intendarr[] = pdfFileInText.split("No. :");
        String intend = intendarr[intendarr.length-1];
        String line[]=intend.split("\\r?\\n");
        String intend_no=line[0];
    
        tab.setIndent_no(intend_no);
////////////////////////////Dates//////////////////////////////////////////////////////
        String datearr[] = pdfFileInText.split("Date :");
        String date = datearr[datearr.length-1];
        String dates[]=date.split("\\r?\\n");
        String datess=dates[0];
      
        tab.setDate(datess);
//////////////////////////////////////Address//////////////////////////////////////////////////
        String addressarr[] = pdfFileInText.split("Magazine  :");
        String address = addressarr[addressarr.length-1];
        String adds[]=address.split("\\r?\\n");
        String addres=adds[0];
      
        tab.setAddress(addres);
////////////////////////////////////valid date///////////////////////////////////////////////////
        String validarr[] = pdfFileInText.split("is valid till");
        String validat = validarr[validarr.length-1];
        String validdate[]=validat.split("\\r?\\n");
        String validdates=validdate[0];
   
        tab.setValid_date(validdates);
///////////////////////////////////////license////////////////////////////////////////////                
        String licarr[] = pdfFileInText.split("number");
        String licens = licarr[licarr.length-1];
        String lices[]=licens.split("\\r?\\n");
        String license=lices[0];
        String licencearr[] = license.split("\\s+");
        tab.setLicense_no(licencearr[1]);
        
 //////////////////////////////////////receive explosive///////////////////////////////////////////////////////       
        String receive_exp[]= pdfFileInText.split("explosives on");
        String rec= receive_exp[receive_exp.length-1];
        String received[]=rec.split("\\r?\\n");
        String receives=received[0];
        String receive[]=receives.split("\\s+");
        tab.setReceive(receive[1]);
        
        table.add(tab);
	}
	
	public void ProductMain(String pdfFileInText,List<TableContent> exp_table)
	{
		
	    String target=pdfFileInText;
        int start= target.indexOf("Unit");
        int end=target.indexOf("I/We");
        String tableline=target.substring(start, end);
        System.out.println("data:"+tableline);
        String tablesplit[]=tableline.split("Unit");
        String tabletemp=tablesplit[tablesplit.length-1];
        String lines[] = tabletemp.split("\\r?\\n");
        List<String> list = new ArrayList<String>();
        for(String s:lines)
        {
        	if(s != null && s.length() > 0) {
                list.add(s);
        									}
        }
        
        list.remove(list.size()-1);
        
        	String[] newline=list.toArray(new String[list.size()]);
        	for(String s:newline)
        	{
        	TableContent exptable1=new TableContent();
        		String splt[]=s.split(" ");
        		exptable1.setSr_no(splt[0]);
                int tablestart=s.indexOf(splt[0]);
                int tableend=s.indexOf(")");
                String name=s.substring(tablestart, tableend)+")";
                String[] are=name.split("",2);
                exptable1.setExplosive_name(are[1]);
                exptable1.setClasses(splt[splt.length-4]);
        		exptable1.setDivision(splt[splt.length-3]);
                exptable1.setQuality(splt[splt.length-2]);
	            exptable1.setUnit(splt[splt.length-1]);
        		exp_table.add(exptable1);
        	}	
	}
	
	public void ProductMainCategory(String pdfFileInText,List<TableContent2> exp_table2)
	{
		
		  String target2=pdfFileInText;
    	  String liness[] = target2.split("Unit");
    	  String temp2=liness[2];
    	  int start2= temp2.indexOf("1");
          int end2=temp2.indexOf("The");
          String tableline2=temp2.substring(start2, end2);
          String linesnew[] = tableline2.split("\\r?\\n");
          List<String> list1 = new ArrayList<String>();
          for(String s:linesnew)
            {
            	if(s != null && s.length() > 0) {
                    list1.add(s);
            									}
            }
          list1.remove(list1.size()-1);
          String[] newlinenew=list1.toArray(new String[list1.size()]);
        	for(String str:newlinenew)
            	{
            		TableContent2 exptable2=new TableContent2();
            		String splttable2[]=str.split(" ");
            		exptable2.setSr_no(splttable2[0]);
           			String nametable2=str.replaceAll(splttable2[0], "")
            				.replaceAll(splttable2[splttable2.length-4], "")
            				.replaceAll(splttable2[splttable2.length-3], "")
            				.replaceAll(splttable2[splttable2.length-2], "")
            				.replaceAll(splttable2[splttable2.length-1], "");
            		exptable2.setExplosive_name(nametable2);
            		exptable2.setClasses(splttable2[splttable2.length-4]);
            		exptable2.setDivision(splttable2[splttable2.length-3]);
            		exptable2.setQuality(splttable2[splttable2.length-2]);
            		exptable2.setUnit(splttable2[splttable2.length-1]);
               		exp_table2.add(exptable2);
	        	}
     
	}
	
	

	
}
