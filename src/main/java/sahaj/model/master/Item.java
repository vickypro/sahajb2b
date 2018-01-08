package sahaj.model.master;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "item_master")
public class Item {
	@Field("item_id")
	private int itemId;
	@Field("company_id")
	private int companyId;
	@Field("brand_id")
	private int brandId;
	@Field("item_code")
	private int itemCode;
	@Field("item_name")
	private String itemName;
	@Field("short_name")
	private String shortName;
	@Field("item_category_id")
	private int itemCategoryId;
	@Field("uom_id")
	private int uomId;
	@Field("kg_per_uom")
	private double kgPerUom;
	@Field("sector_id")
	private int sectorId;
	@Field("quantity_per_box")
	private double quantityPerBox;
	@Field("display_order")
	private int displayOrder;
	@Field("daily_stock")
	private String dailyStock;
	@Field("equivalent_item_id")
	private int[] equivalentItemId;	
	@Field("group_name")
	private String groupName;
	@Field("packing_quantity")
	private String packingQuantity;
   @Field("daily_stock_main_group")
	private String dailyStockMainGroup;
	@Field("token_no_prefix")
	private String tokenNoPrefix;
	@Field("show_to_subdealer")
	private String showToSubdealer;
	@Field("accept_target")
	private String acceptTarget;
	@Field("restrict_sale_qty")
	private String restrictSaleQty;
	@Field("sale_quantity")
	private int saleQuantity;
	@Field("delete_status")
	private int deleteStatus;
	
	
	List<ItemSaleRate>saleRateList =  new ArrayList<ItemSaleRate>() ;
	
	
	public List<ItemSaleRate> getSaleRateList() {
		return saleRateList;
	}

	public void setSaleRateList(List<ItemSaleRate> saleRateList) {
		this.saleRateList = saleRateList;
	}

	public String getPackingQuantity() {
		return packingQuantity;
	}

	public void setPackingQuantity(String packingQuantity) {
		this.packingQuantity = packingQuantity;
	}

	
	
	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Field("active")
	private String activeStatus;
	

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public int getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(int itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public int getUomId() {
		return uomId;
	}

	public void setUomId(int uomId) {
		this.uomId = uomId;
	}

	public double getKgPerUom() {
		return kgPerUom;
	}

	public void setKgPerUom(double kgPerUom) {
		this.kgPerUom = kgPerUom;
	}

	public int getSectorId() {
		return sectorId;
	}

	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}

	public double getQuantityPerBox() {
		return quantityPerBox;
	}

	public void setQuantityPerBox(double quantityPerBox) {
		this.quantityPerBox = quantityPerBox;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getDailyStock() {
		return dailyStock;
	}

	public void setDailyStock(String dailyStock) {
		this.dailyStock = dailyStock;
	}

	public int[] getEquivalentItemId() {
		return equivalentItemId;
	}

	public void setEquivalentItemId(int[] equivalentItemId) {
		this.equivalentItemId = equivalentItemId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDailyStockMainGroup() {
		return dailyStockMainGroup;
	}

	public void setDailyStockMainGroup(String dailyStockMainGroup) {
		this.dailyStockMainGroup = dailyStockMainGroup;
	}

	public String getTokenNoPrefix() {
		return tokenNoPrefix;
	}

	public void setTokenNoPrefix(String tokenNoPrefix) {
		this.tokenNoPrefix = tokenNoPrefix;
	}

	public String getShowToSubdealer() {
		return showToSubdealer;
	}

	public void setShowToSubdealer(String showToSubdealer) {
		this.showToSubdealer = showToSubdealer;
	}

	public String getAcceptTarget() {
		return acceptTarget;
	}

	public void setAcceptTarget(String acceptTarget) {
		this.acceptTarget = acceptTarget;
	}

	public String getRestrictSaleQty() {
		return restrictSaleQty;
	}

	public void setRestrictSaleQty(String restrictSaleQty) {
		this.restrictSaleQty = restrictSaleQty;
	}

	public double getSaleQuantity() {
		return saleQuantity;
	}

	public void setSaleQuantity(int saleQuantity) {
		this.saleQuantity = saleQuantity;
	}
	
	public int getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(int deleteStatus) {
		this.deleteStatus = deleteStatus;
	}


	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", companyId=" + companyId + ", brandId=" + brandId + ", itemCode=" + itemCode
				+ ", itemName=" + itemName + ", shortName=" + shortName + ", itemCategoryId=" + itemCategoryId
				+ ", uomId=" + uomId + ", kgPerUom=" + kgPerUom + ", sectorId=" + sectorId + ", quantityPerBox="
				+ quantityPerBox + ", displayOrder=" + displayOrder + ", dailyStock=" + dailyStock
				+ ", equivalentItemId=" + equivalentItemId + ", groupName=" + groupName + ", packingQuantity="
				+ packingQuantity + ", dailyStockMainGroup=" + dailyStockMainGroup + ", tokenNoPrefix=" + tokenNoPrefix
				+ ", showToSubdealer=" + showToSubdealer + ", acceptTarget=" + acceptTarget + ", restrictSaleQty="
				+ restrictSaleQty + ", saleQuantity=" + saleQuantity + ", saleRateList=" + saleRateList
				+ ", activeStatus=" + activeStatus + "]";
	}


}
