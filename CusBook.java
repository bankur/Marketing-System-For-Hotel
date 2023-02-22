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
import java.awt.Button;
import javax.swing.DefaultComboBoxModel;


public class CusBook extends JFrame {
	JComboBox CoStatus;
	private JTable table;
	JFrame frame;
	public CusBook() {
		setResizable(false);
	

		setSize(416, 667);
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
		tabbedPane.setBounds(0, 0, 402, 630);
		getContentPane().add(tabbedPane);
		
		JPanel west = new JPanel();
		west.setForeground(Color.BLACK);
		west.setFont(new Font("Tahoma", Font.BOLD, 10));
		tabbedPane.addTab("Booking", null, west, null);
		west.setPreferredSize(new Dimension(400, 199));
		west.setBackground(new Color(255, 30, 35));
		west.setLayout(null);
				
		JLabel titlelbl1 = new JLabel("Customer Booking");
		titlelbl1.setBounds(87, 10, 300, 35);
		titlelbl1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		titlelbl1.setForeground(Color.white);
		west.add(titlelbl1);
						
		JSeparator s1 = new JSeparator();
		s1.setBounds(0, 50, 400, 10);
		west.add(s1);
								
										
		JLabel guesttlbl = new JLabel("Guest Name : ");
		guesttlbl.setBounds(20, 120, 150, 30);
		guesttlbl.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		guesttlbl.setForeground(Color.white);
		west.add(guesttlbl);
										
			JTextField guesttxt = new JTextField();
			guesttxt.setBounds(150, 120, 200, 30);
			guesttxt.setFont(new Font("Times New Roman", Font.BOLD, 16));
			west.add(guesttxt);
												
		JLabel roomid = new JLabel("Room No    : ");
		roomid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		roomid.setBounds(20, 170, 150, 30);
		roomid.setFont(new Font("Times New Roman", Font.BOLD, 16));
		roomid.setForeground(Color.white);
		west.add(roomid);
														
			JTextField roomidtxt = new JTextField();
			roomidtxt.setBounds(150, 170, 200, 30);
			roomidtxt.setFont(new Font("Times  New Roman", Font.PLAIN, 16));
			//roomidtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
			west.add(roomidtxt);
																
		JLabel checkinlbl = new JLabel("Check-In     : ");
		checkinlbl.setBounds(20, 220, 150, 30);
		checkinlbl.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		checkinlbl.setForeground(Color.white);
		west.add(checkinlbl);
																		
		JDateChooser c1 = new JDateChooser();
		c1.setBounds(150, 220, 200, 30);
		c1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		c1.setDateFormatString("yyyy-MM-dd");
		west.add(c1);
																				
		JLabel checkoutlbl = new JLabel("Check-Out  : ");
		checkoutlbl.setBounds(20, 270, 150, 30);
		checkoutlbl.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		checkoutlbl.setForeground(Color.white);
		west.add(checkoutlbl);
																						
		JDateChooser c2 = new JDateChooser();
		c2.setBounds(150, 270, 200, 30);
		c2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		c2.setDateFormatString("yyyy-MM-dd");
		west.add(c2);
																								
		JLabel BokStat = new JLabel("Booking Status : ");
		BokStat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BokStat.setBounds(20, 320, 150, 30);
		//BokStat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		//BokStat.setForeground(Color.white);
		west.add(BokStat);
		CoStatus = new JComboBox(status);
		CoStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CoStatus.setToolTipText("");
		CoStatus.setModel(new DefaultComboBoxModel(new String[] {"Booked"}));
		CoStatus.setBounds(150, 320, 200, 30);
		//CoStatus.setFont(new Font("Times New Roman", Font.BOLD, 18));
		//CoStatus.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		west.add(CoStatus);
																										
																										
		JButton insertbtn = new JButton("Confirm");
		insertbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		insertbtn.setBounds(70, 397, 100, 40);
		insertbtn.setFocusable(false);
		insertbtn.setBackground(new Color(84, 181, 218));
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
																														
																														JSeparator s22 = new JSeparator();
																														s22.setBounds(0, 535, 640, 5);
																														west.add(s22);
																														
																																JLabel lbllink1 = new JLabel("www.Garyhotel.com");
																																lbllink1.setBounds(103, 545, 263, 35);
																																lbllink1.setFont(new Font("Times New Roman", Font.ITALIC, 24));
																																lbllink1.setForeground(Color.black);
																																west.add(lbllink1);
																																
																																Button button = new Button("Back");
																																button.setForeground(Color.WHITE);
																																button.setBackground(new Color(0, 0, 0));
																																button.setFont(new Font("Tahoma", Font.PLAIN, 18));
																																button.addActionListener(new ActionListener() {
																																	public void actionPerformed(ActionEvent e) {
																																		Dashboardcustomer reg = new Dashboardcustomer();
																																		reg.setVisible(true);
																																		frame.dispose();
																																	}
																																});
																																button.setBounds(250, 397, 100, 40);
																																west.add(button);
																																
																														
																																
																																
																																
																																JPanel panel_1 = new JPanel();
																																panel_1.setBounds(392, 610, -389, -586);
																																getContentPane().add(panel_1);
		setVisible(true);
	}
	private JPanel contentPane;

{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public static void main(String[] args) {
		new CusBook();
	}
}
