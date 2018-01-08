package sahaj.model.master;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="van_master")
	public class Van {
	@Field("van_no")
	    String vanNo;
	@Field("insurance_validity_date")
	String insuranceValidityDate;
	
	@Field("driver_lic_validity_date")
	String driverlicValiditydate;
	
	@Field("van_capacity")
	String vanCapacity;
	@Field("fitness_certificate_date")
	String fitnessCertificatedate;
	@Field("description")
	String descripton;
	@Field("dockey")
	String dockey;
	
	@Field("van_id")
	String vanId;
	@Field("trasnporter_id")
	int transporterId;
	
	public String getVanId() {
		return vanId;
	}
	public void setVanId(String vanId) {
		this.vanId = vanId;
	}
	@Field("transpoter_name")
	String transpoterName;
	@Field("driver_lic_no")
	String driverLicNo;
	
	@Field("state_id")
	String stateId;
	
	public int getTransporterId() {
		return transporterId;
	}
	public void setTransporterId(int transporterId) {
		this.transporterId = transporterId;
	}
	public String getDriverLicNo() {
		return driverLicNo; 
	}
	public void setDriverLicNo(String driverLicNo) {
		this.driverLicNo = driverLicNo;
	}
	public String getTranspoterName() {
		return transpoterName;
	}
	public void setTranspoterName(String transpoterName) {
		this.transpoterName = transpoterName;
	}
	
	
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	public String getDescripton() {
		return descripton;
	}
	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}
	public String getDockey() {
		return dockey;
	}
	public void setDockey(String dockey) {
		this.dockey = dockey;
	}
	 
	 
	public String getVanNo() {
		return vanNo;
	}
	public void setVanNo(String vanNo) {
		this.vanNo = vanNo;
	}
	public String getInsuranceValidityDate() {
		return insuranceValidityDate;
	}
	public void setInsuranceValidityDate(String insuranceValidityDate) {
		this.insuranceValidityDate = insuranceValidityDate;
	}


	public String getDriverlicValiditydate() {
		return driverlicValiditydate;
	}
	public void setDriverlicValiditydate(String driverlicValiditydate) {
		this.driverlicValiditydate = driverlicValiditydate;
	}
	public String getVanCapacity() {
		return vanCapacity;
	}
	public void setVanCapacity(String vanCapacity) {
		this.vanCapacity = vanCapacity;
	}
	public String getFitnessCertificatedate() {
		return fitnessCertificatedate;
	}
	public void setFitnessCertificatedate(String fitnessCertificatedate) {
		this.fitnessCertificatedate = fitnessCertificatedate;
	}
	
	}


