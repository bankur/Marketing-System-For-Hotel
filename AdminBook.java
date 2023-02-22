package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import com.toedter.calendar.JDateChooser;

import ConLib.BookDataLib;
import ConLib.JDBC;
import ConLib.libBook;
import ConLib.libRoom;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;


public class AdminBook extends JFrame {
	JComboBox CoStatus;
	private JTable table;

	public AdminBook() {
		setResizable(false);
	

		setSize(548, 667);
		setTitle("Booking Details");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		Object[] status = { "Pending", "Booked" };

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Checkin date");
		model.addColumn("Checkout date");
		model.addColumn("Booking Status");
		model.addColumn("Name");
		model.addColumn("Room No");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 537, 630);
		getContentPane().add(tabbedPane);
		
				JPanel west = new JPanel();
				tabbedPane.addTab("Booking", null, west, null);
				west.setPreferredSize(new Dimension(400, 199));
				west.setBackground(new Color(0, 149, 149));
						west.setLayout(null);
				
						JLabel titlelbl1 = new JLabel(" Booking Details For Admin");
						titlelbl1.setBounds(100, 10, 338, 35);
						titlelbl1.setFont(new Font("Bauhaus 93", Font.PLAIN, 27));
						titlelbl1.setForeground(Color.WHITE);
						west.add(titlelbl1);
						
								JSeparator s1 = new JSeparator();
								s1.setBounds(0, 50, 522, 10);
								west.add(s1);
								
										
										JLabel guesttlbl = new JLabel("Guest Name : ");
										guesttlbl.setForeground(Color.WHITE);
										guesttlbl.setFont(new Font("Tahoma", Font.BOLD, 22));
										guesttlbl.setBounds(40, 120, 165, 30);
										//lblPref.setFont(new Font("Times New Roman", Font.BOLD, 18));
										//lblPref.setForeground(Color.white);
										west.add(guesttlbl);
										
												JTextField guesttxt = new JTextField();
												guesttxt.setBounds(188, 120, 200, 30);
												guesttxt.setFont(new Font("Times New Roman", Font.BOLD, 16));
												west.add(guesttxt);
												
														JLabel roomid = new JLabel("Room No : ");
														roomid.setFont(new Font("Tahoma", Font.BOLD, 22));
														roomid.setForeground(Color.WHITE);
														roomid.setBounds(55, 160, 150, 30);
														//roomid.setFont(new Font("Times New Roman", Font.BOLD, 18));
														//roomid.setForeground(Color.white);
														west.add(roomid);
														
																JTextField roomidtxt = new JTextField();
																roomidtxt.setBounds(188, 160, 200, 30);
																roomidtxt.setFont(new Font("Dialog", Font.PLAIN, 16));
																//roomidtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
																west.add(roomidtxt);
																
																		JLabel checkinlbl = new JLabel("Check-In : ");
																		checkinlbl.setFont(new Font("Tahoma", Font.BOLD, 22));
																		checkinlbl.setForeground(Color.WHITE);
																		checkinlbl.setBounds(55, 220, 150, 30);
																		//checkinlbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
																		//checkinlbl.setForeground(Color.white);
																		west.add(checkinlbl);
																		
																				JDateChooser c1 = new JDateChooser();
																				c1.setBounds(188, 220, 200, 30);
																				c1.setFont(new Font("Times New Roman", Font.BOLD, 14));
																				c1.setDateFormatString("yyyy-MM-dd");
																				west.add(c1);
																				
																						JLabel checkoutlbl = new JLabel("Check-Out : ");
																						checkoutlbl.setForeground(Color.WHITE);
																						checkoutlbl.setFont(new Font("Tahoma", Font.BOLD, 22));
																						checkoutlbl.setBounds(55, 270, 150, 30);
																						//checkoutlbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
																						//checkoutlbl.setForeground(Color.white);
																						west.add(checkoutlbl);
																						
																								JDateChooser c2 = new JDateChooser();
																								c2.setBounds(188, 270, 200, 30);
																								c2.setFont(new Font("Times New Roman", Font.BOLD, 14));
																								c2.setDateFormatString("yyyy-MM-dd");
																								west.add(c2);
																								
																										JLabel BokStat = new JLabel("Booking Status : ");
																										BokStat.setFont(new Font("Tahoma", Font.BOLD, 22));
																										BokStat.setForeground(Color.WHITE);
																										BokStat.setBounds(0, 320, 205, 30);
																										//BokStat.setFont(new Font("Times New Roman", Font.BOLD, 18));
																										//BokStat.setForeground(Color.white);
																										west.add(BokStat);
																										CoStatus = new JComboBox(status);
																										CoStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
																										CoStatus.setBounds(188, 320, 200, 30);
																										//CoStatus.setFont(new Font("Times New Roman", Font.BOLD, 18));
																										//CoStatus.setBorder(BorderFactory.createLineBorder(Color.white, 1));
																										west.add(CoStatus);
																										
																										
																												JButton insertbtn = new JButton("Confirm");
																												insertbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
																												insertbtn.setBounds(221, 400, 100, 40);
																												insertbtn.setFocusable(false);
																												insertbtn.setBackground(new Color(196, 195, 135));
																												//insertbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
																												insertbtn.setForeground(Color.BLACK);
																												west.add(insertbtn);
																												insertbtn.addActionListener(new ActionListener() {
																													public void actionPerformed(ActionEvent ex) {
																														String checkin = ((JTextField) c1.getDateEditor().getUiComponent()).getText();

																														try {
																															Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(checkin);
																														} catch (ParseException e1) {

																														}
																														String checkout = ((JTextField) c2.getDateEditor().getUiComponent()).getText();

																														try {
																															Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(checkout);
																														} catch (ParseException e1) {

																														}
																														int bookId ;
																														String Gname = guesttxt.getText();
																														String Status = CoStatus.getSelectedItem().toString();
																														int roomNo = Integer.parseInt(roomidtxt.getText());

																														JDBC jdbc = new JDBC();
																														libBook lib = new libBook(checkin, checkout, Status, roomNo, Gname, roomNo);
																														boolean result = jdbc.saveBook(lib);

																													}
																												});
																												
																												JButton updatebtn = new JButton("Update");
																												updatebtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
																												updatebtn.setBounds(55, 400, 100, 40);
																												updatebtn.setFocusable(false);
																												updatebtn.setBackground(new Color(196, 195, 135));
																												//updatebtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
																												updatebtn.setForeground(Color.BLACK);
																												west.add(updatebtn);
																												updatebtn.addActionListener(new ActionListener() {
																													public void actionPerformed(ActionEvent ex) {
																														String checkin = ((JTextField) c1.getDateEditor().getUiComponent()).getText();

																														try {
																															Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(checkin);
																														} catch (ParseException e1) {

																														}
																														String checkout = ((JTextField) c2.getDateEditor().getUiComponent()).getText();

																														try {
																															Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(checkout);
																														} catch (ParseException e1) {

																														}
																														int bookId ;
																														String Gname = guesttxt.getText();
																														String Status = CoStatus.getSelectedItem().toString();

																														int roomNo = Integer.parseInt(roomidtxt.getText());

																														JDBC jdbc = new JDBC();
																														libBook lib = new libBook(checkin, checkout, Status, roomNo, Gname, roomNo);
																														boolean result = jdbc.saveBook(lib);

																													}
																												});
																												
																														JButton clearbtn = new JButton("Delete");
																														clearbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
																														clearbtn.setBounds(397, 400, 100, 40);
																														clearbtn.setFocusable(false);
																														clearbtn.setBackground(new Color(106, 101, 101));
																														//clearbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
																														clearbtn.setForeground(Color.WHITE);
																														west.add(clearbtn);
																														clearbtn.addActionListener(new ActionListener() {
																															public void actionPerformed(ActionEvent ex) {
																																int bookId ;
																																JDBC jdbc = new JDBC();
																																libBook lib = new libBook();
																																
																																//booleanlib.setUid(bookId) result = jdbc.DeleteBookstaf(lib);
																															}

																														});
																														
																														JSeparator s22 = new JSeparator();
																														s22.setBounds(0, 510, 640, 5);
																														west.add(s22);
																														
																																JLabel lbllink1 = new JLabel("www.Garyhotel.com");
																																lbllink1.setBounds(169, 522, 200, 20);
																																lbllink1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
																																lbllink1.setForeground(Color.black);
																																west.add(lbllink1);
																																
																																JLabel lblNewLabel_1 = new JLabel("New label");
																																lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ridhwaan\\Downloads\\AssignmentJava-main\\img\\the-ravenala-attitude-hotel-2.jpg"));
																																lblNewLabel_1.setBounds(-114, 0, 646, 603);
																																west.add(lblNewLabel_1);
																																
																										
																																
																																JPanel panel = new JPanel();
																																panel.setBackground(new Color(0, 0, 64));
																																tabbedPane.addTab("View", null, panel, null);
																																tabbedPane.setBackgroundAt(1, new Color(255, 255, 255));
																																panel.setLayout(null);
																																
																																JLabel lblNewLabel = new JLabel("Booking Table");
																																lblNewLabel.setForeground(new Color(255, 255, 255));
																																lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
																																lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
																																lblNewLabel.setBounds(113, 10, 226, 34);
																																panel.add(lblNewLabel);
																																JButton btn = new JButton("VIEW LOGS");
																																btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
																																panel.add(btn);
																																btn.setBounds(10, 41, 138, 21);
																																
																																JScrollPane scrollPane = new JScrollPane();
																																scrollPane.setBounds(10, 72, 512, 521);
																																panel.add(scrollPane);
																																
																																table_1 = new JTable();
																																scrollPane.setViewportView(table_1);
																																btn.addActionListener(new ActionListener() {
																																	public void actionPerformed(ActionEvent e) {
																																		
																																		try {
																																			Class.forName("com.mysql.cj.jdbc.Driver");
																																		try {
																																			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","root","PFH#23kgrw9");
																																		Statement st=con.createStatement();
																																		String query ="Select * from booking";
																																		ResultSet rs = st.executeQuery(query);
																																		ResultSetMetaData rsmd =rs.getMetaData();
																																		DefaultTableModel model = (DefaultTableModel)table_1.getModel();
																																		
																																		int cols = rsmd.getColumnCount();
																																		String [] colname = new String [cols];
																																		for (int i=0;i<cols;i++) {
																																			colname[i]=rsmd.getColumnName(i+1);
																																			model.setColumnIdentifiers(colname);
																																			int bokid;
																																			String Checkin ,checkout,boksat,gname,roomid;
																																			while(rs.next()) {
																																				bokid =rs.getInt(1);
																																				gname=rs.getString(2);
																																				Checkin=rs.getString(3);
																																				checkout=rs.getString(4);
																																				boksat=rs.getString(5);
																																				roomid=rs.getString(6);
																																			
																																				Object []row2= {bokid ,gname,Checkin ,checkout,boksat,roomid};
																																			model.addRow(row2);
																																							}
																																		
																																		}
																																		st.close();
																																		con.close();
																																		} catch (SQLException e1) {
																																			// TODO Auto-generated catch block
																																			e1.printStackTrace();
																																		}
																																		} catch (ClassNotFoundException e1) {
																																			// TODO Auto-generated catch block
																																			e1.printStackTrace();
																																		}
																																	}
																																});
																																
																														
																																
																																
																																
																																JPanel panel_1 = new JPanel();
																																panel_1.setBounds(392, 610, -389, -586);
																																getContentPane().add(panel_1);
		setVisible(true);
	}
	private JPanel contentPane;
	private JTable table_1;

{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public static void main(String[] args) {
		AdminBook ad =new AdminBook();
		ad.setVisible(true);
	}
}
