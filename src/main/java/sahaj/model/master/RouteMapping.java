package sahaj.model.master;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "route_mapping")
public class RouteMapping {

	@Field("routemapping_id")
	private int routeMappingId;
	@Field("state_id")
	private int stateId;
	@Field("district_id")
	private int districtId;
	@Field("reached_days")
	private int reachedDays;

	public int getRouteMappingId() {
		return routeMappingId;
	}

	public void setRouteMappingId(int routeMappingId) {
		this.routeMappingId = routeMappingId;
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

	public int getReachedDays() {
		return reachedDays;
	}

	public void setReachedDays(int reachedDays) {
		this.reachedDays = reachedDays;
	}

}
