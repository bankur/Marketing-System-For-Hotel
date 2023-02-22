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

public class Dashboardcustomer extends JFrame {

	public Dashboardcustomer() {

		new JFrame();
		setTitle("Dashboard");
		setSize(1183, 734);

		// inserting image
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(-352, -27, 1521, 673);
		lblImage.setIcon(new ImageIcon("C:\\Users\\Ridhwaan\\Downloads\\AssignmentJava-main\\img\\the-ravenala-attitude-hotel-2.jpg"));
		getContentPane();

		// declare and initialise variables
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(-20, 0, 1700, 60);
		getContentPane();
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 643, 1169, 50);
		getContentPane();
		panel_2.setLayout(null);

		JButton btnbook = new JButton("Booking");
		btnbook.setBounds(495, 590, 159, 50);
		btnbook.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnbook.setBackground(new Color(0, 128, 192));
		btnbook.setForeground(Color.BLACK);
		btnbook.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btnbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				CusBook cs =new CusBook();
				 cs.setVisible(true);
				
				
			}
		});

		JButton btnlogout = new JButton("Log Out");
		btnlogout.setBounds(83, 590, 159, 50);
		btnlogout.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnlogout.setBackground(new Color(0, 128, 192));
		btnlogout.setForeground(Color.BLACK);
		btnlogout.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				
				 dispose();
				 new WelcomePage().setVisible(true);
			}
		});

		JLabel lbl1 = new JLabel("Hotel Customer Booking And Management System Cu");
		lbl1.setBounds(200, 15, 902, 45);
		lbl1.setFont(new Font("Harrington", Font.BOLD, 30));

		btnbook.setFocusable(false);
		btnlogout.setFocusable(false);

		// add variables to JFrame
		getContentPane().add(lbl1);
		getContentPane().add(btnbook);
		getContentPane().add(btnlogout);
		getContentPane().add(panel_1);
		getContentPane().add(panel_2);
		getContentPane().add(lblImage);

		getContentPane().setLayout(null);
		setResizable(false);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Dashboardcustomer();
	}

}