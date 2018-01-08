package sahaj.controller.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sahaj.model.master.CustomerCategory;
import sahaj.service.master.CustomerCategoryService;
import sahaj.serviceimpl.master.CustomerCategoryServiceImpl;
import sahaj.serviceimpl.master.CustomerServiceImpl;

@Controller
public class CustomerCategoryController {

//	@Autowired
//	CustomerCategoryService customerCategoryService;
	
	@RequestMapping(value = "/getCustomerCategoryList", method = RequestMethod.GET)
	public @ResponseBody List getCustomerCategoryList (ModelMap model) {
		CustomerCategoryServiceImpl customerCategoryService = new CustomerCategoryServiceImpl();
		 List<CustomerCategory> getCustomerCategoryList = customerCategoryService.getCustomerCategoryList();
		return getCustomerCategoryList;
	}
	
	@RequestMapping(value = "/PostCustomerCategory", method = RequestMethod.POST)
	public @ResponseBody CustomerCategory saveCustomerCategory (@RequestBody CustomerCategory customerCategory) {
		CustomerCategoryServiceImpl customerCategoryService = new CustomerCategoryServiceImpl();
		customerCategoryService.saveCustomerCategory(customerCategory);
		return customerCategory;
	}
	
	@RequestMapping(value = "/getCustomerCategoryDetails", method = RequestMethod.POST)
	public @ResponseBody CustomerCategory getCustomerCategoryDetails (@RequestBody int customerCategoryId) {
		CustomerCategoryServiceImpl customerCategoryService = new CustomerCategoryServiceImpl();
		CustomerCategory customerCategory = customerCategoryService.getCustomerCategoryDetails(customerCategoryId);
		return customerCategory;
	}
	
	@RequestMapping(value = "/updateCustomerCategory", method = RequestMethod.POST)
	public @ResponseBody CustomerCategory updateCustomerCategory (@RequestBody CustomerCategory customerCategory) {
		CustomerCategoryServiceImpl customerCategoryService = new CustomerCategoryServiceImpl();
		customerCategoryService.updateCustomerCategory(customerCategory);
		return customerCategory;
	}
	
	@RequestMapping(value = "/deleteCustomerCategory", method = RequestMethod.POST)
	public @ResponseBody CustomerCategory deleteCustomerCategory (@RequestBody CustomerCategory customerCategory) {
		CustomerCategoryServiceImpl customerCategoryService = new CustomerCategoryServiceImpl();
		customerCategoryService.deleteCustomerCategory(customerCategory);
		return customerCategory;
	}
	
	
	
	
}
