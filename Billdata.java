package ConLib;

public class Billdata {
	int bookingid;
	int uid;
	int room;
	String date;
	public Billdata() {
		this.bookingid = 0;
		this.uid = 0;
		this.room = 0;
		this.date = "";
	}
	public Billdata(int bookingid, int Uid, int room, String date) {
		this.bookingid = bookingid;
		this.uid = Uid;
		this.room = room;
		this.date = date;
	}
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
