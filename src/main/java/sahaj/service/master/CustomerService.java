package sahaj.service.master;

import java.util.List;

import sahaj.model.master.Customer;
import sahaj.model.master.District;

/**
 * @author Amit
 *
 */
public interface CustomerService {

	public List<Customer> getCustomerList();
	
	public List<District> getDistrictList(int stateId);
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomerDetails(int customerId);
	
	public void updateCustomer(Customer customer);
}
