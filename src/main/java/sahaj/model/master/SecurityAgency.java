package sahaj.model.master;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="SecurityAgency")
public class SecurityAgency {
	
 
	
	@Field("security_agencycode")
	int securityAgencyCode;
	
	@Field("security_agencyname")
	String securityAgencyName;
	
	@Field("contact_person")
	String contactPerson;
	
	@Field("mobile_number")
	String mobileNumber;
	
	@Field("email_id")
	String emailId;
	
	@Field("pin_code")
	String pinCode;
	
	@Field("address")
	String address;
	
	@Field("station")
	String station;
	
	@Field("active_status")
	boolean activeStatus;
	
	@Field("delete_status")
	String deleteStatus;
	
	@Field("state_id")
	int stateId;
	
	@Field("district_id")
	int districtId;
	
	 
	public int getSecurityAgencyCode() {
		return securityAgencyCode;
	}
	public void setSecurityAgencyCode(int securityAgencyCode) {
		this.securityAgencyCode = securityAgencyCode;
	}
	public String getSecurityAgencyName() {
		return securityAgencyName;
	}
	public void setSecurityAgencyName(String securityAgencyName) {
		this.securityAgencyName = securityAgencyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	 
	 
	 
	 
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobilNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	 
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}

	 
	
 
	public boolean isActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	} 
	
	
	 
	 
	
	
	

}
