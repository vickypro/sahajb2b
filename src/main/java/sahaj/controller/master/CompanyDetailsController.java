package sahaj.controller.master;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sahaj.model.master.CompanyDetails;
import sahaj.model.master.Item;
import sahaj.service.master.CompanyDetailsService;
import sahaj.service.master.ItemService;
import sahaj.serviceimpl.master.CompanyDetailsServiceImpl;

@Controller
public class CompanyDetailsController {

	@RequestMapping(value = "/getCompanyDetailsList", method = RequestMethod.GET)
	public @ResponseBody List getCompanyDetailsList (ModelMap model) {
		System.out.println("------------------CompanyDetailsController---------------------------");
		CompanyDetailsServiceImpl companyDetailsServiceimpl = new CompanyDetailsServiceImpl();
		 List<CompanyDetails>companyDetailsList = companyDetailsServiceimpl.getCompanyDetailsList();
		return companyDetailsList;
	}
	
	@RequestMapping(value = "/saveCompanyProfile", method = RequestMethod.POST)
	public @ResponseBody CompanyDetails saveCompanyProfile (@RequestBody CompanyDetails companyDetails) {
		System.out.println("IN ITEM controller==========="+companyDetails.toString());
		CompanyDetailsServiceImpl companyDetailsServiceimpl = new CompanyDetailsServiceImpl();
		companyDetailsServiceimpl.saveCompanyProfile(companyDetails);
		return companyDetails;
	}
	
	@RequestMapping(value = "/getCompanyDetails", method = RequestMethod.POST)
	public @ResponseBody CompanyDetails getCompanyDetails (@RequestBody int companyId) {
		System.out.println("IN getItemDetails controller===========");
		CompanyDetailsServiceImpl companyDetailsServiceimpl = new CompanyDetailsServiceImpl();
		CompanyDetails companyDetails = companyDetailsServiceimpl.getCompanyDetails(companyId);
		return companyDetails;
	}

	
	@RequestMapping(value = "/updateCompanyProfile", method = RequestMethod.POST)
	public @ResponseBody CompanyDetails updateCompanyProfile (@RequestBody CompanyDetails companyDetails) {
		System.out.println("IN ITEM controller==========="+companyDetails.toString());
		CompanyDetailsServiceImpl companyDetailsServiceimpl = new CompanyDetailsServiceImpl();
		companyDetailsServiceimpl.updateCompanyProfile(companyDetails);
		return companyDetails;
	}
	
	@RequestMapping(value = "/deleteCompanyProfile", method = RequestMethod.POST)
	public @ResponseBody int deleteCompanyProfile (@RequestBody  int companyId) {
		System.out.println("IN ITEM controller===========");
		CompanyDetailsServiceImpl companyDetailsServiceimpl = new CompanyDetailsServiceImpl();
		int result = companyDetailsServiceimpl.deleteCompanyProfile(companyId);
		return result;
	}
	
	
}
