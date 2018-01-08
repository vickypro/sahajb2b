package sahaj.model.master;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "company_profile_master")
public class CompanyDetails {

	@Field("company_id")
	private int companyId;
	@Field("company_name")
	private String companyName;
	@Field("delete_status")
	private int deleteStatus;
	@Field("pincode")
	private String pincode;
	@Field("address")
	private String address;
	@Field("city")
	private String city;
	@Field("district_id")
	private int districtId;
	@Field("state_id")
	private int stateId;
	@Field("contact_number1")
	private String contactNumber1;
	@Field("contact_number2")
	private String contactNumber2;
	@Field("email_id")
	private String emailId;
	List<CompanyBankDetails>bankDetailsList =  new ArrayList<CompanyBankDetails>() ;
	
	public List<CompanyBankDetails> getBankDetailsList() {
		return bankDetailsList;
	}

	public void setBankDetailsList(List<CompanyBankDetails> bankDetailsList) {
		this.bankDetailsList = bankDetailsList;
	}


	
	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getContactNumber1() {
		return contactNumber1;
	}

	public void setContactNumber1(String contactNumber1) {
		this.contactNumber1 = contactNumber1;
	}

	public String getContactNumber2() {
		return contactNumber2;
	}

	public void setContactNumber2(String contactNumber2) {
		this.contactNumber2 = contactNumber2;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(int activeStatus) {
		this.deleteStatus = activeStatus;
	}

}
