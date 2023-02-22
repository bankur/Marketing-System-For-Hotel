package ConLib;

public class libBookRequest {

	String Checkin_date;
	String Checkout_date;
	String preffered_room;
	int Uid;

	public libBookRequest() {

		Checkin_date = "";
		Checkout_date = "";
		this.preffered_room = "";
		Uid = 0;

	}

	public libBookRequest(String checkin_date, String checkout_date, String preffered_room, int uid) {

		Checkin_date = checkin_date;
		Checkout_date = checkout_date;
		this.preffered_room = preffered_room;
		Uid = uid;

	}

	public String getCheckin_date() {
		return Checkin_date;
	}

	public void setCheckin_date(String checkin_date) {
		Checkin_date = checkin_date;
	}

	public String getCheckout_date() {
		return Checkout_date;
	}

	public void setCheckout_date(String checkout_date) {
		Checkout_date = checkout_date;
	}

	public String getPreffered_room() {
		return preffered_room;
	}

	public void setPreffered_room(String preffered_room) {
		this.preffered_room = preffered_room;
	}

	public int getUid() {
		return Uid;
	}

	public void setUid(int uid) {
		Uid = uid;
	}

}
