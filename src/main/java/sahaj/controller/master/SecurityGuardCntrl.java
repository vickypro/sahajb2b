package sahaj.controller.master;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
import sahaj.model.master.SecurityGuard;
 
import sahaj.service.master.SecurityGuardService;
@Controller
public class SecurityGuardCntrl {
	
	
	@RequestMapping(value = "/saveguard", method = RequestMethod.POST)
	public @ResponseBody SecurityGuard save (@RequestBody SecurityGuard SecurityGuard) {
		 
		SecurityGuardService SecurityGuardService=new SecurityGuardService();
		SecurityGuardService.saveSecurityguard(SecurityGuard);
		return SecurityGuard;
	}
	
	
	
	@RequestMapping(value = "/getSecurityList", method = RequestMethod.GET)
	public @ResponseBody List getSecurityAgencyList () {
		SecurityGuardService SecurityGuardService=new SecurityGuardService();
		List<SecurityGuard> SecurityAgency = SecurityGuardService.getSecurityGuardList();
		return SecurityAgency;
	}
	

	@RequestMapping(value = "/deleteGuard", method = RequestMethod.POST)
	public @ResponseBody List<SecurityGuard> deleteGuard (@RequestBody int securityGuardCode) {
		
		SecurityGuardService SecurityGuardService=new SecurityGuardService();
		SecurityGuardService.deleteGuard(securityGuardCode);
		List<SecurityGuard> SecurityGuard =SecurityGuardService.getSecurityGuardList();
		return SecurityGuard;
	}
	
	@RequestMapping(value = "/newGuards", method = RequestMethod.POST)
	public @ResponseBody SecurityGuard newGuard () {
		SecurityGuardService SecurityGuardService=new SecurityGuardService();
		SecurityGuard SecurityGuard=SecurityGuardService.Newguard();
		SecurityGuardService.getAgencyList();
		return SecurityGuard;
	}
	
	@RequestMapping(value = "/getAgencyList", method = RequestMethod.GET)
	public @ResponseBody Map getAgencyList () {
		SecurityGuardService SecurityGuardService=new SecurityGuardService();
		SecurityGuardService.getcardList();
		Map<String, String> Agencylist=SecurityGuardService.getAgencyList();
		return Agencylist;
	}
	
	@RequestMapping(value = "/getCardType", method = RequestMethod.GET)
	public @ResponseBody Map getCardList () {
		SecurityGuardService SecurityGuardService=new SecurityGuardService();
		Map<String, String> Agencylist=SecurityGuardService.getcardList();
		return Agencylist;
	}
	
	@RequestMapping(value = "/getGuarddetails", method = RequestMethod.POST)
	public @ResponseBody SecurityGuard  getAgencyDetails (@RequestBody int securityGuardCode) {
		SecurityGuardService SecurityGuardService=new SecurityGuardService();
		SecurityGuard SecurityGuard =SecurityGuardService.getAgencyDetails(securityGuardCode);
		 return SecurityGuard;
	}
	

	@RequestMapping(value = "/updateGuard", method = RequestMethod.POST)
	public @ResponseBody SecurityGuard SecurityGuard (@RequestBody SecurityGuard SecurityGuard) {
		SecurityGuardService SecurityGuardService=new SecurityGuardService();
		SecurityGuardService.updateGuard(SecurityGuard);
		return SecurityGuard;
	}
	
	
	
	
}
