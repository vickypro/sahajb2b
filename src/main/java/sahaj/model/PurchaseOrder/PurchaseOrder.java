package sahaj.model.PurchaseOrder;

public class PurchaseOrder {

	String PoDate;
	String PoNo;
	String PoTime;
	String PoValid;
	String indent_no;
	String valid_date;
	
	public String getIndent_no() {
		return indent_no;
	}
	public void setIndent_no(String indent_no) {
		this.indent_no = indent_no;
	}
	public String getValid_date() {
		return valid_date;
	}
	public void setValid_date(String valid_date) {
		this.valid_date = valid_date;
	}
	
	public String getPoDate() {
		return PoDate;
	}
	public void setPoDate(String poDate) {
		PoDate = poDate;
	}
	public String getPoNo() {
		return PoNo;
	}
	public void setPoNo(String poNo) {
		PoNo = poNo;
	}
	public String getPoTime() {
		return PoTime;
	}
	public void setPoTime(String poTime) {
		PoTime = poTime;
	}
	public String getPoValid() {
		return PoValid;
	}
	public void setPoValid(String poValid) {
		PoValid = poValid;
	}
	
	
}
