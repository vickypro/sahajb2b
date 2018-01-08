package sahaj.model.master;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Amit
 *
 */
@Document(collection = "transportertype_master")
public class TransporterType {

	@Field("transportertype_id")
	private int transporterTypeId;
	@Field("transportertype")
	private String transporterTypeName;
	@Field("description")
	private String description;
	@Field("delete_status")
	private int deleteStatus;

	public int getTransporterTypeId() {
		return transporterTypeId;
	}

	public void setTransporterTypeId(int transporterTypeId) {
		this.transporterTypeId = transporterTypeId;
	}

	public String getTransporterTypeName() {
		return transporterTypeName;
	}

	public void setTransporterTypeName(String transporterTypeName) {
		this.transporterTypeName = transporterTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(int deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

}
