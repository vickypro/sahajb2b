package sahaj.controller.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sahaj.model.master.Customer;
import sahaj.model.master.District;
import sahaj.service.master.CustomerService;
import sahaj.serviceimpl.master.CustomerServiceImpl;

@Controller
public class CustomerController {

//	@Autowired
//	CustomerService customerService;
	
	@RequestMapping(value = "/getCustomerList", method = RequestMethod.GET)
	public @ResponseBody List getCustomerList(ModelMap model) {
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		List<Customer> customerList = customerService.getCustomerList();
		return customerList;
	}

	@RequestMapping(value = "/getDistrictListForState", method = RequestMethod.POST)
	public @ResponseBody List getDistrictList(@RequestBody int stateId) {
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		List<District> districtList = customerService.getDistrictList(stateId);
		return districtList;
	}

	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public @ResponseBody Customer saveCustomer(@RequestBody Customer customer) {
		
		try {
			CustomerServiceImpl customerService = new CustomerServiceImpl();
			customerService.saveCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	@RequestMapping(value = "/getCustomerDetails", method = RequestMethod.POST)
	public @ResponseBody Customer getCustomerDetails (@RequestBody int customerId) {
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		Customer customer = customerService.getCustomerDetails(customerId);
		return customer;
	}
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public @ResponseBody Customer updateCustomer (@RequestBody Customer customer) {
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		customerService.updateCustomer(customer);
		return customer;
	}
}
