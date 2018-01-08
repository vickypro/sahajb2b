package sahaj.model.master;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "customer_master")
public class Customer {

	@Field("customer_id")
	private int customerId;
	@Field("customer_code")
	private int customerCode;
	@Field("customer_name")
	private String customerName;
	@Field("mobile_number")
	private long mobileNumber;
	@Field("email_id")
	private String emailId;
	@Field("address")
	private String address;
	@Field("city")
	private String city;
	@Field("state_id")
	private int stateId;
	@Field("district_id")
	private int districtId;
	@Field("customer_category_id")
	private int customerCategoryId;
	@Field("associate_name")
	private String associateName;
	@Field("inout_state")
	private String inOutState;
	@Field("dispatch_mode")
	private String[] dispatchMode;
	@Field("gst_number")
	private String gstNumber;
	@Field("tokenno_prefix")
	private String tokenNoPrefix;
	@Field("bank_id")
	private int bankId;
	@Field("branch_name")
	private String branchName;
	@Field("account_number")
	private long accountNumber;
	@Field("ifsc_code")
	private String ifscCode;
	@Field("has_subdealer")
	private String hasSubdealer;
	@Field("showto_subdealer")
	private String showToSubdealer;
	@Field("accept_daily_stock")
	private String acceptDailyStock;
	@Field("club_po")
	private String clubPo;
	@Field("goods_receipt")
	private String goodsReceipt;
	@Field("phone_report_check")
	private String phoneReportCheck;
	@Field("active_status")
	private String activeStatus;
	@Field("priority_loading_request")
	private String priorityLoadingRequest;
	@Field("dailystock_checkdays")
	private int dailyStockCheckDays;
	@Field("phonereport_checkdays")
	private int phoneReportCheckDays;
	@Field("maxcontract_days")
	private int maxContractDays;
	@Field("maxmonth_targetdate")
	private Date maxMonthTargetDate;

	@Field("owner_firstname")
	private String ownerFirstName;
	@Field("owner_lastname")
	private String ownerLastName;
	@Field("owner_emailid")
	private String ownerEmailId;
	@Field("owner_mobilenumber")
	private long ownerMobileNumber;
	@Field("owner_dateofbirth")
	private Date ownerDateOfBirth;
	@Field("owner_pannumber")
	private String ownerPanNumber;
	@Field("owner_aadhaarnumber")
	private String ownerAadhaarNumber;

	@Field("manager_firstname")
	private String managerFirstName;
	@Field("manager_lastname")
	private String managerLastName;
	@Field("manager_emailid")
	private String managerEmailId;
	@Field("manager_mobilenumber")
	private long managerMobileNumber;
	@Field("manager_dateofbirth")
	private Date managerDateOfBirth;
	@Field("manager_pannumber")
	private String managerPanNumber;
	@Field("manager_adhaarnumber")
	private String managerAdhaarNumber;

	List<Magazine> magazineList = new ArrayList<Magazine>();
	List<MagazineCapacity> magazineCapacityList = new ArrayList<MagazineCapacity>();

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public int getCustomerCategoryId() {
		return customerCategoryId;
	}

	public void setCustomerCategoryId(int customerCategoryId) {
		this.customerCategoryId = customerCategoryId;
	}

	public String getAssociateName() {
		return associateName;
	}

	public void setAssociateName(String associateName) {
		this.associateName = associateName;
	}

	public String getInOutState() {
		return inOutState;
	}

	public void setInOutState(String inOutState) {
		this.inOutState = inOutState;
	}

	public String[] getDispatchMode() {
		return dispatchMode;
	}

	public void setDispatchMode(String[] dispatchMode) {
		this.dispatchMode = dispatchMode;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getTokenNoPrefix() {
		return tokenNoPrefix;
	}

	public void setTokenNoPrefix(String tokenNoPrefix) {
		this.tokenNoPrefix = tokenNoPrefix;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getHasSubdealer() {
		return hasSubdealer;
	}

	public void setHasSubdealer(String hasSubdealer) {
		this.hasSubdealer = hasSubdealer;
	}

	public String getShowToSubdealer() {
		return showToSubdealer;
	}

	public void setShowToSubdealer(String showToSubdealer) {
		this.showToSubdealer = showToSubdealer;
	}

	public String getAcceptDailyStock() {
		return acceptDailyStock;
	}

	public void setAcceptDailyStock(String acceptDailyStock) {
		this.acceptDailyStock = acceptDailyStock;
	}

	public String getClubPo() {
		return clubPo;
	}

	public void setClubPo(String clubPo) {
		this.clubPo = clubPo;
	}

	public String getGoodsReceipt() {
		return goodsReceipt;
	}

	public void setGoodsReceipt(String goodsReceipt) {
		this.goodsReceipt = goodsReceipt;
	}

	public String getPhoneReportCheck() {
		return phoneReportCheck;
	}

	public void setPhoneReportCheck(String phoneReportCheck) {
		this.phoneReportCheck = phoneReportCheck;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getPriorityLoadingRequest() {
		return priorityLoadingRequest;
	}

	public void setPriorityLoadingRequest(String priorityLoadingRequest) {
		this.priorityLoadingRequest = priorityLoadingRequest;
	}

	public int getDailyStockCheckDays() {
		return dailyStockCheckDays;
	}

	public void setDailyStockCheckDays(int dailyStockCheckDays) {
		this.dailyStockCheckDays = dailyStockCheckDays;
	}

	public int getPhoneReportCheckDays() {
		return phoneReportCheckDays;
	}

	public void setPhoneReportCheckDays(int phoneReportCheckDays) {
		this.phoneReportCheckDays = phoneReportCheckDays;
	}

	public int getMaxContractDays() {
		return maxContractDays;
	}

	public void setMaxContractDays(int maxContractDays) {
		this.maxContractDays = maxContractDays;
	}

	public Date getMaxMonthTargetDate() {
		return maxMonthTargetDate;
	}

	public void setMaxMonthTargetDate(Date maxMonthTargetDate) {
		this.maxMonthTargetDate = maxMonthTargetDate;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	public String getOwnerEmailId() {
		return ownerEmailId;
	}

	public void setOwnerEmailId(String ownerEmailId) {
		this.ownerEmailId = ownerEmailId;
	}

	public long getOwnerMobileNumber() {
		return ownerMobileNumber;
	}

	public void setOwnerMobileNumber(long ownerMobileNumber) {
		this.ownerMobileNumber = ownerMobileNumber;
	}

	public Date getOwnerDateOfBirth() {
		return ownerDateOfBirth;
	}

	public void setOwnerDateOfBirth(Date ownerDateOfBirth) {
		this.ownerDateOfBirth = ownerDateOfBirth;
	}

	public String getOwnerPanNumber() {
		return ownerPanNumber;
	}

	public void setOwnerPanNumber(String ownerPanNumber) {
		this.ownerPanNumber = ownerPanNumber;
	}

	public String getOwnerAadhaarNumber() {
		return ownerAadhaarNumber;
	}

	public void setOwnerAadhaarNumber(String ownerAadhaarNumber) {
		this.ownerAadhaarNumber = ownerAadhaarNumber;
	}

	public String getManagerFirstName() {
		return managerFirstName;
	}

	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}

	public String getManagerLastName() {
		return managerLastName;
	}

	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
	}

	public String getManagerEmailId() {
		return managerEmailId;
	}

	public void setManagerEmailId(String managerEmailId) {
		this.managerEmailId = managerEmailId;
	}

	public long getManagerMobileNumber() {
		return managerMobileNumber;
	}

	public void setManagerMobileNumber(long managerMobileNumber) {
		this.managerMobileNumber = managerMobileNumber;
	}

	public Date getManagerDateOfBirth() {
		return managerDateOfBirth;
	}

	public void setManagerDateOfBirth(Date managerDateOfBirth) {
		this.managerDateOfBirth = managerDateOfBirth;
	}

	public String getManagerPanNumber() {
		return managerPanNumber;
	}

	public void setManagerPanNumber(String managerPanNumber) {
		this.managerPanNumber = managerPanNumber;
	}

	public String getManagerAdhaarNumber() {
		return managerAdhaarNumber;
	}

	public void setManagerAdhaarNumber(String managerAdhaarNumber) {
		this.managerAdhaarNumber = managerAdhaarNumber;
	}

	public List<Magazine> getMagazineList() {
		return magazineList;
	}

	public void setMagazineList(List<Magazine> magazineList) {
		this.magazineList = magazineList;
	}

	public List<MagazineCapacity> getMagazineCapacityList() {
		return magazineCapacityList;
	}

	public void setMagazineCapacityList(List<MagazineCapacity> magazineCapacityList) {
		this.magazineCapacityList = magazineCapacityList;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerCode=" + customerCode + ", customerName="
				+ customerName + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", address=" + address
				+ ", city=" + city + ", stateId=" + stateId + ", districtId=" + districtId + ", customerCategoryId="
				+ customerCategoryId + ", associateName=" + associateName + ", inOutState=" + inOutState
				+ ", dispatchMode=" + dispatchMode + ", gstNumber=" + gstNumber + ", tokenNoPrefix=" + tokenNoPrefix
				+ ", bankId=" + bankId + ", branchName=" + branchName + ", accountNumber=" + accountNumber
				+ ", ifscCode=" + ifscCode + ", hasSubdealer=" + hasSubdealer + ", showToSubdealer=" + showToSubdealer
				+ ", acceptDailyStock=" + acceptDailyStock + ", clubPo=" + clubPo + ", goodsReceipt=" + goodsReceipt
				+ ", phoneReportCheck=" + phoneReportCheck + ", activeStatus=" + activeStatus
				+ ", priorityLoadingRequest=" + priorityLoadingRequest + ", dailyStockCheckDays=" + dailyStockCheckDays
				+ ", phoneReportCheckDays=" + phoneReportCheckDays + ", maxContractDays=" + maxContractDays
				+ ", maxMonthTargetDate=" + maxMonthTargetDate + ", ownerFirstName=" + ownerFirstName
				+ ", ownerLastName=" + ownerLastName + ", ownerEmailId=" + ownerEmailId + ", ownerMobileNumber="
				+ ownerMobileNumber + ", ownerDateOfBirth=" + ownerDateOfBirth + ", ownerPanNumber=" + ownerPanNumber
				+ ", ownerAadhaarNumber=" + ownerAadhaarNumber + ", managerFirstName=" + managerFirstName
				+ ", managerLastName=" + managerLastName + ", managerEmailId=" + managerEmailId
				+ ", managerMobileNumber=" + managerMobileNumber + ", managerDateOfBirth=" + managerDateOfBirth
				+ ", managerPanNumber=" + managerPanNumber + ", managerAdhaarNumber=" + managerAdhaarNumber
				+ ", magazineList=" + magazineList + ", magazineCapacityList=" + magazineCapacityList + "]";
	}

	private String tempString;

	public String getTempString() {
		return tempString;
	}

	public void setTempString(String tempString) {
		this.tempString = tempString;
	}
	
}
