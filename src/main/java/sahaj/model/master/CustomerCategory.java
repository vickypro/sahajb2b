package sahaj.model.master;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "customer_category")
public class CustomerCategory {

	@Field("customer_category_id")
	private int customerCategoryId;
	@Field("customer_category_name")
	private String customerCategoryName;
	@Field("description")
	private String description;
	@Field("active_status")
	private int activeStatus;

	public int getCustomerCategoryId() {
		return customerCategoryId;
	}

	public void setCustomerCategoryId(int customerCategoryId) {
		this.customerCategoryId = customerCategoryId;
	}

	public String getCustomerCategoryName() {
		return customerCategoryName;
	}

	public void setCustomerCategoryName(String customerCategoryName) {
		this.customerCategoryName = customerCategoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Override
	public String toString() {
		return "CustomerCategory [customerCategoryId=" + customerCategoryId + ", customerCategoryName="
				+ customerCategoryName + ", description=" + description + ", activeStatus=" + activeStatus + "]";
	}

}
