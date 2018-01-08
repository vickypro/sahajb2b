package sahaj.model.master;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "magazine_master")
public class Magazine {

	@Field("magazine_id")
	private int magazineId;
	@Field("magazine_code")
	private int magazineCode;
	@Field("magazine_name")
	private String magazineName;
	@Field("description")
	private String description;
	@Field("document_key")
	private String documentKey;
	@Field("license_number")
	private String licenseNumber;
	@Field("license_expirydate")
	private Date licenseExpiryDate;
	@Field("address")
	private String address;
	@Field("city")
	private String city;
	@Field("state_id")
	private int stateId;
	@Field("district_id")
	private int districtId;
	@Field("customer_id")
	private int customerId;

	public int getMagazineId() {
		return magazineId;
	}

	public void setMagazineId(int magazineId) {
		this.magazineId = magazineId;
	}

	public int getMagazineCode() {
		return magazineCode;
	}

	public void setMagazineCode(int magazineCode) {
		this.magazineCode = magazineCode;
	}

	public String getMagazineName() {
		return magazineName;
	}

	public void setMagazineName(String magazineName) {
		this.magazineName = magazineName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDocumentKey() {
		return documentKey;
	}

	public void setDocumentKey(String documentKey) {
		this.documentKey = documentKey;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Date getLicenseExpiryDate() {
		return licenseExpiryDate;
	}

	public void setLicenseExpiryDate(Date licenseExpiryDate) {
		this.licenseExpiryDate = licenseExpiryDate;
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Magazine [magazineId=" + magazineId + ", magazineCode=" + magazineCode + ", magazineName="
				+ magazineName + ", description=" + description + ", documentKey=" + documentKey + ", licenseNumber="
				+ licenseNumber + ", licenseExpiryDate=" + licenseExpiryDate + ", address=" + address + ", city=" + city
				+ ", stateId=" + stateId + ", districtId=" + districtId + ", customerId=" + customerId + "]";
	}

}
