package sahaj.model.master;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "item_salerate_master")
public class ItemSaleRate {
	@Field("item_id")
	private int itemId;
	@Field("item_salerate_id")
	private int itemSaleRateId;
	private String stateId[];
	@Field("sale_rate_with")
	private String saleRateWith;
	@Field("rate")
	private Double rate;
	@Field("state_idComma")
	private String stateIDComma;
	
	public String[] getStateId() {
		return stateId;
	}
	public void setStateId(String[] stateId) {
		this.stateId = stateId;
	}
	public String getSaleRateWith() {
		return saleRateWith;
	}
	public void setSaleRateWith(String saleRateWith) {
		this.saleRateWith = saleRateWith;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public String getStateIDComma() {
		return stateIDComma;
	}
	public void setStateIDComma(String stateIDComma) {
		this.stateIDComma = stateIDComma;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getItemSaleRateId() {
		return itemSaleRateId;
	}
	public void setItemSaleRateId(int itemSaleRateId) {
		this.itemSaleRateId = itemSaleRateId;
	}
	
}
