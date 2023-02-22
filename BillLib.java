package ConLib;

public class BillLib {
	int bookID;
	int detailid;
	String item;
	String  quantity;
	String rate;
	String date;
	String status;
	String vat;
	String total;
	public BillLib() {
		
		this.bookID = 0;
		this.detailid = 0;
		this.item = "";
		this.quantity = "";
		this.rate = "";
		this.date = "";
		this.status = "";
		this.vat = "";
		this.total = "";
	}
	public BillLib(int bookID,int detailID, String item, String quantity, String rate, String date, String status, String vat,
			String total) {
		
		this.bookID = bookID;
		this.detailid = detailID;
		this.item = item;
		this.quantity = quantity;
		this.rate = rate;
		this.date = date;
		this.status = status;
		this.vat = vat;
		this.total = total;
		
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	public int getDetailid() {
		return detailid;
	}
	public void setDetailid(int detailid) {
		this.detailid = detailid;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVat() {
		return vat;
	}
	public void setVat(String vat) {
		this.vat = vat;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
}
