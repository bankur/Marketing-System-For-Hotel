package ConLib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import GUI.CustomerReg;

public class JDBC extends Connector {

	JButton btn;

/*	public boolean save(CorpLib inse) {
		// registration for Corp-customer
		boolean result = false;
		Connection conn;
		String sql = "insert into registration(Customerid,Fullname, Dob, gender ,address, email, MobileNum, customerType,CompanyName ) values(?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstat;
		try {
			System.out.println(inse.getId());
			// sending data from textfield to sql
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, inse.getId());
			pstat.setString(2, inse.getName());
			pstat.setString(3, inse.getDob());
			pstat.setString(4, inse.getGender());
			pstat.setString(5, inse.getAddress());
			pstat.setString(6, inse.getEmail());
			pstat.setInt(7, inse.getPhone());
			pstat.setString(8, inse.getCusType());
			pstat.setString(9, inse.getCompany());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "Welcome to Hotel Luton!!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(btn, "please try again!!");
			System.out.println("Error :" + ex.getMessage());
		}
		return result;

	}*/

	public LoginLibs logindata(LoginLibs user) {
		// customer login data inserted
		String sql = "insert into user (name , password, CustomerId) values(?,?,?)";
		try {

			Connection conn = connect();
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getPassword());
			pstat.setInt(3, user.getId());
			pstat.executeUpdate();

		}

		catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return user;
	}

/*	public LoginLibs logindatastaf(LoginLibs user) {
		// staff login data inserted
		String sql = "insert into user (name , password, StafId, UserType) values(?,?,?,?)";
		try {

			Connection conn = connect();
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getPassword());
			pstat.setInt(3, user.getId());
			pstat.setString(4, user.gettype());
			pstat.executeUpdate();

		}

		catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return user;
	}*/

	public boolean saveCust(CustomerLib inse) {
		//registration for customer
		boolean result = false;
		Connection conn;
		String sql = "insert into registration(Customerid, Fullname, Dob, gender ,address, email, MobileNum ) values(?,?,?,?,?,?,?)";
		PreparedStatement pstat;
		try {
			// sending data from textfield to sql
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, inse.getId());
			pstat.setString(2, inse.getName());
			pstat.setString(3, inse.getDob());
			pstat.setString(4, inse.getGender());
			pstat.setString(5, inse.getAddress());
			pstat.setString(6, inse.getEmail());
			pstat.setInt(7, inse.getPhone());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "Welcome to Hotel Luton!!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(btn, "please try again!!");
			System.out.println("Error :" + ex.getMessage());
		}
		return result;

	}

	public boolean RequestBook(libBookRequest inse) {
		// declare and initialize
		//customer requests booking
		boolean result = false;
		Connection conn;
		String sql = "insert into booking (Checkin_date,Checkout_date,roomPreference, Uid)values(?,?,?,?)";
		PreparedStatement pstat;
		try {
			// sending data from textfield to sql
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, inse.getCheckin_date());
			pstat.setString(2, inse.getCheckout_date());
			pstat.setString(3, inse.getPreffered_room());
			pstat.setInt(4, inse.getUid());

			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "Your Booking was a Sucess!!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(btn, "please try again!!");
			System.out.println("Error :" + ex.getMessage());
		}
		return result;

	}

	public libBookRequest bookupdaterequest(libBookRequest inse) {
		Connection conn;
		//customer updates booking
		try {

			String query1 = "update booking set  Checkin_date =?, Checkout_date=?,roomPreference=? where Booking_ID =? ";
			conn = connect();
			PreparedStatement pst = conn.prepareStatement(query1);
			pst.setString(1, inse.getCheckin_date());
			pst.setString(2, inse.getCheckout_date());
			pst.setString(3, inse.getPreffered_room());
			pst.setInt(4, inse.getUid());

			pst.execute();
			JOptionPane.showMessageDialog(null, "Update Successfull");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return inse;

	}

	public boolean saveBook(libBook inse) {
		// declare and initialize
		boolean result = false;
		Connection conn;
		//staff confirms booking
		
		
		PreparedStatement pstat;
		try {
			String sql = "insert  booking  (Checkin_date, Checkout_date,Booking_status,guestName,roomId ) values (?,?,?,?,?)";
			// sending data from textfield to sql
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, inse.getCheckin_date());
			pstat.setString(2, inse.getCheckout_date());
			pstat.setString(3, inse.getBooking_status());
			pstat.setString(4, inse.getGuestName());
			pstat.setInt(5, inse.getRoomNo());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, " Booking was a Sucess!!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(btn, "please try again!!");
			System.out.println("Error :" + ex.getMessage());
		}
		return result;

	}

	public LoginLibs loginCust(LoginLibs user) {
		//getting login credentials of customer
		String sql = "Select * from user  where name = ? and password =?";
		try {

			Connection conn = connect();
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getPassword());
			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				user.setId(rs.getInt("CustomerID"));
				// user.setFullName(rs.getString("FullName"));
				// user.setAddress(rs.getString("Address"));
				// user.setEmail(rs.getString("Email"));
				// user.setPhoneNo(rs.getInt("PhoneNo"));
			}
		}

		catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return user;
	}

	public LoginLibs billCust(LoginLibs user) {
		//receipt given to customer
		String sql = "Select * from registration inner join user on \r\n"
				+ "user.CustomerId = registration.Customerid where UserId = ?";
		try {

			Connection conn = connect();
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, user.getId());

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				user.setId(rs.getInt("UserId"));
				// user.setFullName(rs.getString("FullName"));
				// user.setAddress(rs.getString("Address"));
				// user.setEmail(rs.getString("Email"));
				// user.setPhoneNo(rs.getInt("PhoneNo"));

			}

		}

		catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return user;
	}

	public ArrayList Bookdata(BookDataLib bok1) {
		//booking data for table
		String query = "select * from booking  join user on booking.Uid = user.name join registration on user.CustomerId = registration.CustomerId where roomPreference != ' ' ";
		Connection conn;
		PreparedStatement pstat;

		ArrayList search = new ArrayList();
		try {
			conn = connect();
			pstat = conn.prepareStatement(query);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				BookDataLib bok = new BookDataLib(rs.getString("Fullname"),rs.getString("Checkin_date"), rs.getString("Checkout_date"),
						rs.getString("Booking_status"), rs.getString("roomPreference"), rs.getInt("Uid"),
						(rs.getInt("Booking_ID")), rs.getInt("roomId"));

				search.add(bok);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return search;
	}

	public ArrayList Bookdatacust(BookDataLib bok1) {
		//booking data for table
		String query = "select * from booking ";
		Connection conn;
		PreparedStatement pstat;

		ArrayList search = new ArrayList();
		try {
			conn = connect();
			pstat = conn.prepareStatement(query);
			
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				BookDataLib bok = new BookDataLib(rs.getString("guestName"),rs.getString("Checkin_date"), rs.getString("Checkout_date"),
						rs.getString("Booking_status"), rs.getString("roomPreference"), rs.getInt("Uid"),
						(rs.getInt("Booking_ID")), rs.getInt("roomId"));

				search.add(bok);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return search;
	}
	
	public ArrayList roomdata(libRoom rom1) {
		//getting room data which have room status as "available"
		String query = "select * from room  where  roomType = ? and roomStatus =\"Available\";";
		Connection conn;
		PreparedStatement pstat;

		ArrayList search = new ArrayList();
		try {
			conn = connect();
			pstat = conn.prepareStatement(query);
			pstat.setString(1, rom1.getRoomType());
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				libRoom rom = new libRoom(rs.getInt("roomId"), rs.getString("roomPrice"), rs.getString("roomStatus"),
						rs.getString("roomType"), rs.getString("roomFacilities"));

				search.add(rom);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return search;
	}

	public boolean saveroom(libRoom lib) {
		//staff inserting data of new rooms in sql
		String sql = "insert into room(roomId,roomType,roomPrice,roomFacilities,roomStatus) values(?,?,?,?,?) ";
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, lib.getRoomNo());
			pstat.setString(2, lib.getRoomType());
			pstat.setString(3, lib.getRoomPrice());
			pstat.setString(4, lib.getFacilities());
			pstat.setString(5, lib.getRoomStatus());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			JOptionPane.showMessageDialog(btn, "Room added successfully");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return result;

	}

	public boolean updateroom(libRoom lib) {
		//updating the specification of the rooms by staff in sql
		String sql = "update room set roomType =?, roomPrice = ?, roomFacilities = ?, roomStatus =?  where roomId = ?";
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, lib.getRoomType());
			pstat.setString(2, lib.getRoomPrice());
			pstat.setString(3, lib.getFacilities());
			pstat.setString(4, lib.getRoomStatus());
			pstat.setInt(5, lib.getRoomNo());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			JOptionPane.showMessageDialog(btn, "Room modified successfully");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return result;

	}

	public boolean deleteroom(libRoom lib) {
		//deleting a room in sql 
		String sql = "delete from room  where roomId = ?";
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, lib.getRoomNo());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			JOptionPane.showMessageDialog(btn, "Room deleted successfully");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return result;

	}

	public boolean invoicestaf(BillLib lib) {
		//inserting data in the invoice table
		String sql = "insert into invoice (Status,InvoiceDate,VatCharge,  Total, DetailId, bookingid) values(?,?,?,?,?,?) ";
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, lib.getStatus());
			pstat.setString(2, lib.getDate());
			pstat.setString(3, lib.getVat());
			pstat.setString(4, lib.getTotal());
			pstat.setInt(5, lib.getDetailid());
			pstat.setInt(6, lib.getBookID());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "Bill Generated");
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;

	}

	public boolean detailstaf(Billdata lib) {
		//inserting data in the InvoiceDetail table
		String sql = "insert into invoicedetail(detailID, uid1, room1, date1) values(?,?,?,?) ";
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, lib.getBookingid());
			pstat.setInt(2, lib.getUid());
			pstat.setInt(3, lib.getRoom());
			pstat.setString(4, lib.getDate());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;

	}

	

	public ArrayList billtable(Billdata lib) {
		//fetching data of booking, menu and service 
		String query = " select * from booking  ";
		Connection conn;
		PreparedStatement pstat;

		ArrayList search = new ArrayList();
		try {
			conn = connect();
			pstat = conn.prepareStatement(query);

			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				Billdata bill = new Billdata(rs.getInt("Booking_ID"), rs.getInt("Uid"),rs.getInt("roomId"),
						rs.getString("Date"));

				search.add(bill);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return search;
	}

	
}




	

