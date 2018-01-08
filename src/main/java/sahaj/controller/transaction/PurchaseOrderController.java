package sahaj.controller.transaction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
import java.util.ArrayList;
 
import java.util.List;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.io.*;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.bouncycastle.tsp.TimeStampToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;*/
 
 
import com.mongodb.MongoClient;

import sahaj.model.PurchaseOrder.PurchaseOrder;
import sahaj.model.PurchaseOrder.Table;
import sahaj.model.PurchaseOrder.TableContent;
import sahaj.model.PurchaseOrder.TableContent2;
import sahaj.service.PurchaseOrder.PurchaseOrderService1;
import sahaj.service.PurchaseOrder.PurchaseOrderService2;

 


@Controller
public class PurchaseOrderController {

	boolean valid;
	List<Table> table=new ArrayList<Table>();
	List<Table> table2=new ArrayList<Table>();
	
	List<TableContent> exp_table=new ArrayList<TableContent>();
	List<TableContent> exp_tablestg2=new ArrayList<TableContent>();
	
	List<TableContent2> exp_table2=new ArrayList<TableContent2>();
	
	Table tab=new Table();
	Table tab2=new Table();
	
	TableContent exptable=new TableContent();
	TableContent2 exptable2=new TableContent2();
	PurchaseOrderService1 pdf;
	private static String UPLOAD_FOLDER = "E://";
	private MongoClient mongoClient;

	
	@RequestMapping(value = "/savepocontract", method = RequestMethod.POST)
	public @ResponseBody PurchaseOrder savePoContract (@RequestBody PurchaseOrder PoContract) {
		PurchaseOrderService1 FileUpload_service=new PurchaseOrderService1();
		FileUpload_service.SavepoContract(PoContract,table,exp_table,exp_table2);
		//customerCategoryService.saveCustomerCategory(customerCategory);
		return PoContract;

	}
	
	@RequestMapping(value = "/valid", method = RequestMethod.GET)
	public @ResponseBody boolean valid () {
		
		 
		return valid ;

	}
	
	
	@RequestMapping(value = "/getpolist", method = RequestMethod.GET)
	public @ResponseBody List getpolist () {
		 
		PurchaseOrderService1 FileUpload_service=new PurchaseOrderService1();
		 List<PurchaseOrder> pocontract = FileUpload_service.getPoList();
		return pocontract;
	}
	
	 
	
	
	@RequestMapping(value = "/getpocontract", method = RequestMethod.GET)
	public @ResponseBody List getpocontract () {
		PurchaseOrderService1 FileUpload_service=new PurchaseOrderService1();
		 List<PurchaseOrder> pocontract = FileUpload_service.CreatePo();
		return pocontract;
	}
	
	@RequestMapping(value = "/getfiledata", method = RequestMethod.GET)
	public  @ResponseBody List getfiledata () {
		
		Table t1=new Table();
		List<Table> getfile=table;
		
		return getfile;
	}
	
	@RequestMapping(value = "/gettabledata", method = RequestMethod.GET)
	public @ResponseBody List gettabledata () {
	
		if(exp_tablestg2.retainAll(exp_table))
		{
		List<TableContent> gettable1=exp_table;
		return gettable1;
		}
		else
		{
			List<TableContent> gettable1=exp_table;
			return gettable1;
		}
	}
	
	/*@RequestMapping(value = "/gettable2data", method = RequestMethod.GET)
	public @ResponseBody List gettable2data () {
		
		List<TableContent2> gettable2=exp_table2;
		return gettable2;
	
	}*/
	
	@RequestMapping(value = "/cleardata", method = RequestMethod.GET)
	public void cleardata () {
		table.clear();
		table2.clear();
		exp_table.clear();
		exp_table2.clear();
		exp_tablestg2.clear();
	
	}
	
	@RequestMapping("/upload")
	public ModelAndView showUpload() {
		return new ModelAndView("upload");
	}

	 
	
	@PostMapping("/upload")
	public ModelAndView fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws  SignatureException     {
			
		if (file.isEmpty()) {
			return new ModelAndView("File");
		}
	 
		try {
			
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
			System.out.println(path);
			Files.write(path, bytes);
		//	E:\Eco New AED.pdf
			
			//PdfReader reader = new PdfReader("E:\\Eco New AED.pdf");
		//	 AcroFields fields = reader.getAcroFields();
		//	 ArrayList<String> names = fields.getSignatureNames();
			 
			 /*for (String name : names) {
					System.out.println("===== " + name + " =====");
					
				 
				}*/
			 
			 PdfReader reader = new PdfReader(UPLOAD_FOLDER + file.getOriginalFilename());
			 AcroFields form  = reader.getAcroFields();
			 List<String> signatureNames = form.getSignatureNames();
			 
			 KeyStore kall = PdfPKCS7.loadCacertsKeyStore();
			 for(String s:signatureNames)
			 {
				 try {
				 System.out.println("s"+s);
				 PdfPKCS7 pk = form.verifySignature(s);
				 Certificate pkc[] = pk.getCertificates();
				  Calendar cal = pk.getSignDate();
				 System.out.println("Subject:"
                         + PdfPKCS7.getSubjectFields(pk.getSigningCertificate()));
				 System.out.println("Document modified: " + !pk.verify());
				 System.out.println("data:"+PdfPKCS7.getIssuerFields(pk.getSigningCertificate()));
				 X509Certificate cert = (X509Certificate) pk.getSigningCertificate();
				 SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
				 System.out.println("Signed on: " + date_format.format(pk.getSignDate().getTime()));
				 System.out.println("Issuer: " + cert.getIssuerDN());
				 System.out.println("Subject: " + cert.getSubjectDN());
				 System.out.println("Valid from: " + date_format.format(cert.getNotBefore()));
					System.out.println("Valid to: " + date_format.format(cert.getNotAfter()));
					System.out.println("public key:"+cert.getPublicKey());
					 
					FileInputStream fis = new FileInputStream("C:\\Users\\BSC-Server\\Desktop\\2014.cer");
					 CertificateFactory cf = CertificateFactory.getInstance("X.509");
					 Collection c = cf.generateCertificates(fis);
					 Iterator i = c.iterator();
					 while (i.hasNext()) {
					    Certificate cert1 = (Certificate)i.next();
					    System.out.println(cert1);
					 }
					
					
					try {
						cert.checkValidity(cal.getTime());
						System.out
								.println("The certificate was valid at the time of signing.");
						valid=false;
					} catch (CertificateExpiredException e) {
						System.out
								.println("The certificate was expired at the time of signing.");
						valid=true;
					} catch (CertificateNotYetValidException e) {
						valid=false;
						System.out.println("The certificate wasn't valid yet at the time of signing.");
					}
					try {
						cert.checkValidity();
						valid=false;
						System.out.println("The certificate is still valid.");
					} catch (CertificateExpiredException e) {
						valid=true;
						System.out.println("The certificate has expired.");
					} catch (CertificateNotYetValidException e) {
						System.out.println("The certificate isn't valid yet.");
						valid=true;
					}
					 
				 }
				 catch(Exception  e)
				 {
					 valid=true;
				 }
					
			 }
			
			
			String location=path.toString();
			
			 try (PDDocument document = PDDocument.load(new File(location))) {
				  document.getClass();

		            if (!document.isEncrypted()) {
		        		 
		                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
		                stripper.setSortByPosition(true);
		                PDFTextStripper tStripper = new PDFTextStripper();
		                String pdfFileInText = tStripper.getText(document);
		               
		                PurchaseOrderService1 FileUpload_service=new PurchaseOrderService1();
		                PurchaseOrderService2 FileUpload_service2=new PurchaseOrderService2();
		          
		                
		                FileUpload_service.Pdfdata(pdfFileInText,tab,table);
		                FileUpload_service2.Pdfdata(pdfFileInText, tab2, table2);
		///////////////////////////////////////tables 1//////////////////////////////////////////////////                
		                FileUpload_service.ProductMain(pdfFileInText,exp_table);
		                FileUpload_service2.ProductMain(pdfFileInText, exp_tablestg2);
		               
		                
		             
		            }

		        }

		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ModelAndView("File");
	}

	 

}
