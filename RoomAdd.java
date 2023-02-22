package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import ConLib.JDBC;
import ConLib.libRoom;
import javax.swing.DefaultComboBoxModel;


public class RoomAdd extends JFrame {
	JComboBox CoStatus, CoRoomType, CoRoomType1;
	JButton btnSearch;

	public RoomAdd() {

		setSize(1250, 650);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setLayout(null);
		north.setPreferredSize(new Dimension(1, 80));
		north.setBackground(new Color(106, 101, 101));
		getContentPane().add(north, BorderLayout.NORTH);

		JPanel Center = new JPanel();
		Center.setLayout(null);
		Center.setPreferredSize(new Dimension(180, 180));
		Center.setBackground(new Color(200, 100, 100));

		getContentPane().add(Center, BorderLayout.CENTER);

		JLabel titlelbl = new JLabel("Gary Hotel");
		titlelbl.setFont(new Font("Times New Roman", Font.BOLD, 25));
		titlelbl.setForeground(Color.white);
		titlelbl.setBounds(520, 20, 200, 35);
		north.add(titlelbl);

		JPanel west = new JPanel();
		west.setLayout(null);
		west.setPreferredSize(new Dimension(400, 80));
		west.setBackground(new Color(21, 159, 133));
		getContentPane().add(west, BorderLayout.WEST);

		JLabel titlelbl1 = new JLabel("Add Room");
		titlelbl1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		titlelbl1.setForeground(Color.white);
		titlelbl1.setBounds(110, 20, 200, 35);
		west.add(titlelbl1);

		JSeparator s1 = new JSeparator();
		s1.setBounds(5, 50, 380, 10);
		west.add(s1);

		JLabel roomid = new JLabel("Room No");
		roomid.setBounds(20, 120, 150, 30);
		roomid.setFont(new Font("Times New Roman", Font.BOLD, 18));
		roomid.setForeground(Color.white);
		west.add(roomid);

		JTextField roomidtxt = new JTextField();
		roomidtxt.setBounds(150, 120, 200, 30);
		roomidtxt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		roomidtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		west.add(roomidtxt);

		JLabel roomtypelbl = new JLabel("Room Type");
		roomtypelbl.setBounds(20, 170, 150, 30);
		roomtypelbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		roomtypelbl.setForeground(Color.white);
		west.add(roomtypelbl);

		Object[] type = { "Single", "Double", "Twin" };

		CoRoomType1 = new JComboBox(type);
		CoRoomType1.setBounds(150, 170, 200, 30);
		CoRoomType1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CoRoomType1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		west.add(CoRoomType1);

		JLabel BokStat = new JLabel("Room Status");
		BokStat.setBounds(20, 270, 150, 30);
		BokStat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		BokStat.setForeground(Color.white);
		west.add(BokStat);
		

		Object[] status = { "Available", "Booked" };
		CoStatus = new JComboBox(status);
		CoStatus.setBounds(150, 270, 200, 30);
		CoStatus.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CoStatus.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		west.add(CoStatus);


		JTextField roomfacilitiestxt = new JTextField();
		roomfacilitiestxt.setBounds(150, 220, 200, 30);
		roomfacilitiestxt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		roomfacilitiestxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		west.add(roomfacilitiestxt);

		JLabel roomfcilitieslbl = new JLabel("Room Facilities");
		roomfcilitieslbl.setBounds(20, 220, 150, 30);
		roomfcilitieslbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		roomfcilitieslbl.setForeground(Color.white);
		west.add(roomfcilitieslbl);

		JLabel lblPrice = new JLabel("Room Price");
		lblPrice.setBounds(20, 320, 150, 30);
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPrice.setForeground(Color.white);
		west.add(lblPrice);

		JTextField txtPrice = new JTextField();
		txtPrice.setBounds(150, 320, 200, 30);
		txtPrice.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtPrice.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		west.add(txtPrice);

		JButton insertbtn = new JButton("Add");
		insertbtn.setBounds(20, 400, 100, 30);
		insertbtn.setFocusable(false);
		insertbtn.setBackground(new Color(106, 101, 101));
		insertbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		insertbtn.setForeground(Color.white);
		west.add(insertbtn);
		insertbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				int romNo = Integer.parseInt(roomidtxt.getText());	
				String romType = CoRoomType1.getSelectedItem().toString();
				String stat = CoStatus.getSelectedItem().toString();
				String facilities = roomfacilitiestxt.getText();
				String price = txtPrice.getText();
				
				JDBC jdbc = new JDBC();
				libRoom lib = new libRoom(romNo, price, stat, romType, facilities);
				boolean result = jdbc.saveroom(lib);
			}
		});

		JButton updatebtn = new JButton("Update");
		updatebtn.setBounds(140, 400, 100, 30);
		updatebtn.setFocusable(false);
		updatebtn.setBackground(new Color(106, 101, 101));
		updatebtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		updatebtn.setForeground(Color.white);
		west.add(updatebtn);
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				int romno = Integer.parseInt(roomidtxt.getText());
				String Stat = CoStatus.getSelectedItem().toString();
				String price = txtPrice.getText();
				String type = CoRoomType.getSelectedItem().toString();
				String facilities = roomfacilitiestxt.getText();
				
				JDBC jdbc = new JDBC();
				libRoom lib = new libRoom(romno, price, Stat, type, facilities);
				boolean result = jdbc.updateroom(lib);
				
			}
		});

		JButton clearbtn = new JButton("Delete");
		clearbtn.setBounds(260, 400, 100, 30);
		clearbtn.setFocusable(false);
		clearbtn.setBackground(new Color(106, 101, 101)); 
		clearbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		clearbtn.setForeground(Color.white);
		west.add(clearbtn);
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {		
				int romno = Integer.parseInt(roomidtxt.getText());
				JDBC jdbc = new JDBC();
				libRoom lib = new libRoom();
				lib.setRoomNo(romno);
				boolean result = jdbc.deleteroom(lib);
			}

		});

		Object[] romType = { "Single", "Double", "Twin" };
		CoRoomType = new JComboBox(romType);
		CoRoomType.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double", "Twin"}));
		CoRoomType.setFont(new Font("Verdana", Font.BOLD, 12));
		CoRoomType.setBounds(20, 20, 100, 23);
		CoRoomType.setBackground(new Color(255, 255, 255));

		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSearch.setBounds(190, 20, 100, 23);
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.setFocusable(false);

		JLabel mes = new JLabel("All the rooms are displayed");
		mes.setBounds(340, 470, 250, 23);
		mes.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mes.setForeground(Color.black);
		mes.setVisible(false);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Room No");
		model.addColumn("Room Type");
		model.addColumn("Room Price");
		model.addColumn("Room Status");
		model.addColumn("Room Facilities");
		
		JTable tableRoom = new JTable(model);

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				model.setRowCount(0);
				JDBC jdbc = new JDBC();
				String ty = CoRoomType.getSelectedItem().toString();
				libRoom ro = new libRoom();
				ro.setRoomType(ty);
				ArrayList search = jdbc.roomdata(ro);
				if (search.size() > 0) {
					for (int i = 0; i < search.size(); i++) {
						ro = (libRoom) search.get(i);
						Object[] tmp = { ro.getRoomNo(), ro.getRoomType(), ro.getRoomPrice(), ro.getRoomStatus(),ro.getFacilities() };
						model.addRow(tmp);
						 
					}
				}
			}
		});
		
		
		JScrollPane sroll = new JScrollPane(tableRoom);
		sroll.setBounds(20, 50, 800, 400);
		Center.add(sroll);

		Center.add(CoRoomType);
		Center.add(mes);
		Center.add(btnSearch);
		setVisible(true);
	}

	public static void main(String[] args) {
		new RoomAdd();
	}
}
