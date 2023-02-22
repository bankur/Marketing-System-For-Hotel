package ConLib;

public class libRoom {
	int RoomNo;
	String RoomPrice;
	String RoomStatus;
	String RoomType;
	String facilities;
	public libRoom() {
		
		RoomNo = 0;
		RoomPrice = "";
		RoomStatus = "";
		RoomType = "";
		this.facilities = "";
	}
	public libRoom(int roomNo, String roomPrice, String roomStatus, String roomType, String facilities) {
		
		RoomNo = roomNo;
		RoomPrice = roomPrice;
		RoomStatus = roomStatus;
		RoomType = roomType;
		this.facilities = facilities;
	}
	public int getRoomNo() {
		return RoomNo;
	}
	public void setRoomNo(int roomNo) {
		RoomNo = roomNo;
	}
	public String getRoomPrice() {
		return RoomPrice;
	}
	public void setRoomPrice(String roomPrice) {
		RoomPrice = roomPrice;
	}
	public String getRoomStatus() {
		return RoomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		RoomStatus = roomStatus;
	}
	public String getRoomType() {
		return RoomType;
	}
	public void setRoomType(String roomType) {
		RoomType = roomType;
	}
	public String getFacilities() {
		return facilities;
	}
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	
	
}
