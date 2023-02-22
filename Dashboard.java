package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Provider.Service;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dashboard extends JFrame {


	public Dashboard() {

		new JFrame();
		setTitle("Dashboard");
		setSize(1144, 733);

		// inserting image
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(-385, 31, 1600, 610);
		lblImage.setIcon(new ImageIcon("C:\\Users\\Ridhwaan\\Downloads\\AssignmentJava-main\\img\\wp11009778.jpg"));
		getContentPane();

		// declare and initialise variables
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 178, 102));
		panel_1.setBounds(-20, 0, 1700, 50);
		getContentPane();
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 178, 102));
		panel_2.setBounds(-116, 651, 1700, 50);
		getContentPane();
		panel_2.setLayout(null);

		JButton btnbook5 = new JButton("Booking");
		btnbook5.setBounds(10, 90, 95, 40);
		btnbook5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnbook5.setBackground(new Color(255, 178, 102));
		btnbook5.setForeground(Color.BLACK);
		btnbook5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btnbook5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				AdminBook ab= new AdminBook();
				ab.setVisible(true);
			}
		});

		JButton btnroom = new JButton("Room");
		btnroom.setBounds(10, 185, 95, 40);
		btnroom.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnroom.setBackground(new Color(255, 178, 102));
		btnroom.setForeground(Color.BLACK);
		btnroom.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btnroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				new RoomAdd().setVisible(true);
			}
		});



		JButton btnlogout = new JButton("Log Out");
		btnlogout.setBounds(10, 280 , 95, 40);
		btnlogout.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnlogout.setBackground(new Color(255, 178, 102));
		btnlogout.setForeground(Color.BLACK);
		btnlogout.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				dispose();
				new WelcomePage().setVisible(true);
			}
		});

		//btnser.setFocusable(false);
		btnbook5.setFocusable(false);
		
		btnroom.setFocusable(false);
		btnlogout.setFocusable(false);
		getContentPane().add(btnbook5);
		getContentPane().add(btnroom);
	
		getContentPane().add(btnlogout);
		getContentPane().add(panel_1);
		
				JLabel lbl1 = new JLabel("Hotel Admin Booking And Management System");
				lbl1.setBounds(236, 10, 700, 45);
				panel_1.add(lbl1);
				lbl1.setFont(new Font("Constantia", Font.BOLD, 30));
		getContentPane().add(panel_2);
		getContentPane().add(lblImage);

		getContentPane().setLayout(null);
		setResizable(false);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Dashboard();
	}

}