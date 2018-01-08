package sahaj.model.master;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="state_master")
public class State {

	@Field("state_id")
	private int stateId;
	@Field("state_name")
	private String  stateName;
	@Field("description")
	private String description;
	@Field("state_code")
	private String stateCode;
	@Field("cc_emailid")
	private String ccEmailId;
	@Field("cc_office_address1")
	private String ccOfficeAddress1;
	@Field("ccOfficeAddress2")
	private String ccOfficeAddress2;
	@Field("active_status")
	private String activeStatus;
	@Field("delete_status")
	private int deleteStatus;
	
	
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getCcEmailId() {
		return ccEmailId;
	}
	public void setCcEmailId(String ccEmailId) {
		this.ccEmailId = ccEmailId;
	}
	public String getCcOfficeAddress1() {
		return ccOfficeAddress1;
	}
	public void setCcOfficeAddress1(String ccOfficeAddress1) {
		this.ccOfficeAddress1 = ccOfficeAddress1;
	}
	public String getCcOfficeAddress2() {
		return ccOfficeAddress2;
	}
	public void setCcOfficeAddress2(String ccOfficeAddress2) {
		this.ccOfficeAddress2 = ccOfficeAddress2;
	}

	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	
}
