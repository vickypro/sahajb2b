package sahaj.model.master;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="SecurityGuard")
public class SecurityGuard {
	
	@Field("security_guard_code")
	int securityGuardCode;
	
	@Field("security_guard_name")
	String securityGuardName;
	
	@Field("security_agency")
	String securityAgency;
	
	@Field("mobile_no")
	String mobileNo;
	
	@Field("guard_age")
	int guardAge;
	
	
	@Field("address")
	String address;
	
	@Field("card_type")	
	String cardType;
	
	@Field("card_no")
	String cardNo;
	
	@Field("active_status")
	boolean activeStatus;
	
	 
	public String getSecurityAgency() {
		return securityAgency;
	}
	public void setSecurityAgency(String securityAgency) {
		this.securityAgency = securityAgency;
	}
	
	public boolean isActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	
	public int getSecurityGuardCode() {
		return securityGuardCode;
	}
	public void setSecurityGuardCode(int securityGuardCode) {
		this.securityGuardCode = securityGuardCode;
	}
	 
	 
	public String getSecurityGuardName() {
		return securityGuardName;
	}
	public void setSecurityGuardName(String securityGuardName) {
		this.securityGuardName = securityGuardName;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getGuardAge() {
		return guardAge;
	}
	public void setGuardAge(int guardAge) {
		this.guardAge = guardAge;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

}
