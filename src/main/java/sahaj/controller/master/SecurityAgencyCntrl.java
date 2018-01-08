package sahaj.controller.master;

 

import java.util.List;

import org.springframework.stereotype.Controller;
 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
import sahaj.model.master.SecurityAgency;
 
import sahaj.service.master.SecurityAgencyService;
 
 
 
@Controller
public class SecurityAgencyCntrl {
	
	
	@RequestMapping(value = "/saveagency", method = RequestMethod.POST)
	public @ResponseBody SecurityAgency save (@RequestBody SecurityAgency SecurityAgency) {
		SecurityAgencyService SecurityAgencyService=new SecurityAgencyService();
		SecurityAgencyService.saveSecurityAgency(SecurityAgency);
		return SecurityAgency;
	}
	
	@RequestMapping(value = "/getagency", method = RequestMethod.GET)
	public @ResponseBody List getSecurityAgencyList () {
		SecurityAgencyService SecurityAgencyService=new SecurityAgencyService();
		List<SecurityAgency> SecurityAgency = SecurityAgencyService.getSecurityAgency();
		return SecurityAgency;
	}
	 
	
	@RequestMapping(value = "/deleteAgency", method = RequestMethod.POST)
	public @ResponseBody List<SecurityAgency> deleteAgency (@RequestBody int securityagencyCode) {
		
		SecurityAgencyService SecurityAgencyService=new SecurityAgencyService();
		SecurityAgencyService.deleteAgency(securityagencyCode);
		List<SecurityAgency> SecurityAgency =  SecurityAgencyService.getSecurityAgency();
		return SecurityAgency;
	}
	
	
	@RequestMapping(value = "/getAgencydetails", method = RequestMethod.POST)
	public @ResponseBody SecurityAgency  getAgencyDetails (@RequestBody int securityagencyCode) {
		System.out.println("datatatat:"+securityagencyCode);
		SecurityAgencyService SecurityAgencyService=new SecurityAgencyService();
		SecurityAgency SecurityAgency =SecurityAgencyService.getAgencyDetails(securityagencyCode);
		 return SecurityAgency;
	}
	
	
	@RequestMapping(value = "/updateAgency", method = RequestMethod.POST)
	public @ResponseBody SecurityAgency updateAgency (@RequestBody SecurityAgency SecurityAgency) {
		SecurityAgencyService SecurityAgencyService=new SecurityAgencyService();
		SecurityAgencyService.updateAgency(SecurityAgency);
		return SecurityAgency;
	}
	
	@RequestMapping(value = "/newAgency", method = RequestMethod.POST)
	public @ResponseBody SecurityAgency newAgency () {
		SecurityAgencyService SecurityAgencyService=new SecurityAgencyService();
		 
		SecurityAgency SecurityAgency=SecurityAgencyService.NewAgency();
		return SecurityAgency;
	}
	
	
	 

}
