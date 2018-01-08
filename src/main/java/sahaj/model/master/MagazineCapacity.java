package sahaj.model.master;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "magazine_capacity_master")
public class MagazineCapacity {

	@Field("magazine_capacity_id")
	private int magazineCapacityId;
	@Field("item_category_id")
	private int itemCategoryId;
	@Field("capacity")
	private double capacity;
	@Field("uom_id")
	private int uomId;
	@Field("rotation_capacity")
	private double rotationCapacity;
	@Field("magazine_id")
	private int magazineId;

	public int getMagazineCapacityId() {
		return magazineCapacityId;
	}

	public void setMagazineCapacityId(int magazineCapacityId) {
		this.magazineCapacityId = magazineCapacityId;
	}

	public int getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(int itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public int getUomId() {
		return uomId;
	}

	public void setUomId(int uomId) {
		this.uomId = uomId;
	}

	public double getRotationCapacity() {
		return rotationCapacity;
	}

	public void setRotationCapacity(double rotationCapacity) {
		this.rotationCapacity = rotationCapacity;
	}

	public int getMagazineId() {
		return magazineId;
	}

	public void setMagazineId(int magazineId) {
		this.magazineId = magazineId;
	}

}
