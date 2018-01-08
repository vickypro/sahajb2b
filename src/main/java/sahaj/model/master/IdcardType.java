package sahaj.model.master;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "idcardtype_master")
public class IdcardType {

	@Field("idcardtype_id")
	int idcardtype_id;

	@Field("idcardtype")
	String idcardtype;

	@Field("description")
	String description;

	@Field("delete_status")
	int delete_status;

	public int getIdcardtype_id() {
		return idcardtype_id;
	}

	public void setIdcardtype_id(int idcardtype_id) {
		this.idcardtype_id = idcardtype_id;
	}

	public String getIdcardtype() {
		return idcardtype;
	}

	public void setIdcardtype(String idcardtype) {
		this.idcardtype = idcardtype;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDelete_status() {
		return delete_status;
	}

	public void setDelete_status(int delete_status) {
		this.delete_status = delete_status;
	}

}
