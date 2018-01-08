package sahaj.model.master;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "company_bank_details")
public class CompanyBankDetails {
	
	@Field("company_bank_details_id")
	private int companyBankDetailsId;
	@Field("bank_id")
	private int bankId;
	@Field("bank_branch_name")
	private String bankBranchName;
	@Field("account_number")
	private int accountNumber;
	@Field("ifsc_code")
	private String ifscCode;
	@Field("delete_status")
	private int deleteStatus;
	@Field("company_id")
	private int companyId;
	
	
	public int getCompanyBankDetailsId() {
		return companyBankDetailsId;
	}
	public void setCompanyBankDetailsId(int companyBankDetailsId) {
		this.companyBankDetailsId = companyBankDetailsId;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankBranchName() {
		return bankBranchName;
	}
	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public int getDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(int activeStatus) {
		this.deleteStatus = activeStatus;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

}
