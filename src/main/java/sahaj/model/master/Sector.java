package sahaj.model.master;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection = "sector_master")
public class Sector {

		@Field("sector_id")
		private int sectorId;
		@Field("sector_name")
		private String sectorName;
		@Field("description")
		private String description;
		@Field("active_status")
		private int activeStatus;
		
		public int getSectorId() {
			return sectorId;
		}
		public void setSectorId(int sectorId) {
			this.sectorId = sectorId;
		}
		public String getSectorName() {
			return sectorName;
		}
		public void setSectoName(String sectorName) {
			this.sectorName = sectorName;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public void setSectorName(String sectorName) {
			this.sectorName = sectorName;
		}
		public int getActiveStatus() {
			return activeStatus;
		}
		public void setActiveStatus(int activeStatus) {
			this.activeStatus = activeStatus;
		}
		
	


}
