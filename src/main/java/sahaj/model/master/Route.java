package sahaj.model.master;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "route_master")
public class Route {

	@Field("route_id")
	private int routeId;
	@Field("customer_id")
	private int customerId;
	@Field("magazine_id")
	private int magazineId;
	@Field("active_status")
	private boolean activeStatus;
	@Field("delete_status")
	private int deleteStatus;

	private List<RouteMapping> routeMappingList = new ArrayList<RouteMapping>();

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getMagazineId() {
		return magazineId;
	}

	public void setMagazineId(int magazineId) {
		this.magazineId = magazineId;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public int getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(int deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public List<RouteMapping> getRouteMappingList() {
		return routeMappingList;
	}

	public void setRouteMappingList(List<RouteMapping> routeMappingList) {
		this.routeMappingList = routeMappingList;
	}

}
