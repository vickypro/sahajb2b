/**
 * 
 */
package sahaj.service.master;

import java.util.List;

import sahaj.model.master.CustomerCategory;

/**
 * @author Amit
 *
 */
public interface CustomerCategoryService {

	public List<CustomerCategory> getCustomerCategoryList();

	public void saveCustomerCategory(CustomerCategory customerCategory);

	public CustomerCategory getCustomerCategoryDetails(int customerCategoryId);

	public void updateCustomerCategory(CustomerCategory customerCategory);

	public void deleteCustomerCategory(CustomerCategory customerCategory);
}
