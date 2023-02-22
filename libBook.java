package ConLib;

public class libBook {

	String Checkin_date;
	String Checkout_date;
	String Booking_status;
	int Uid;
	String guestName;
	int roomNo;

	public libBook() {

		Checkin_date = "";
		Checkout_date = "";
		Booking_status = "";
		Uid = 0;
		guestName = "";
		roomNo = 0;
	}

	public libBook(String checkin_date, String checkout_date, String booking_status, int uid, String GuestName,
			int RoomNo) {

		Checkin_date = checkin_date;
		Checkout_date = checkout_date;

		Booking_status = booking_status;
		Uid = uid;
		guestName = GuestName;
		roomNo = RoomNo;
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

	public String getBooking_status() {
		return Booking_status;
	}

	public void setBooking_status(String booking_status) {
		Booking_status = booking_status;
	}

	public int getUid() {
		return Uid;
	}

	public void setUid(int uid) {
		Uid = uid;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

}
