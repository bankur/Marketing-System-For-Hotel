package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import ConLib.JDBC;
import ConLib.LoginLibs;

public class Login {
	JFrame frame;
	protected Dashboard Dashboard;

	public Login() {
		//Initialize and declare
		frame = new JFrame();
		frame.setSize(900, 550);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(1, 60));
		north.setLayout(null);
		north.setBackground(new Color(204, 204, 255));
		frame.getContentPane().add(north, BorderLayout.NORTH);

		JLabel lbltitle = new JLabel("GARY HOTEL");
		lbltitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbltitle.setForeground(Color.WHITE);
		lbltitle.setBounds(380, 15, 200, 30);
		north.add(lbltitle);

		JPanel west = new JPanel();
		west.setBounds(0, 1, 400, 501);
		west.setPreferredSize(new Dimension(400, 10));
		west.setLayout(null);
		west.setBackground(new Color(32, 32, 32));
		frame.getContentPane().add(west, BorderLayout.WEST);

		JLabel lbltitle2 = new JLabel("Login");
		lbltitle2.setFont(new Font("Bauhaus 93", Font.PLAIN, 25));
		lbltitle2.setForeground(Color.WHITE);
		lbltitle2.setBounds(175, 10, 150, 30);
		west.add(lbltitle2);

		JSeparator s1 = new JSeparator();
		s1.setBounds(0, 40, 500, 5);
		west.add(s1);

		JSeparator s2 = new JSeparator();
		s2.setBounds(0, 420, 500, 5);
		west.add(s2);

		JLabel lblUserName = new JLabel("Username");
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setBounds(50, 130, 100, 30);
		west.add(lblUserName);

		JTextField txtUserName = new JTextField("");
		txtUserName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtUserName.setBounds(150, 130, 200, 30);
		west.add(txtUserName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(50, 190, 100, 30);
		west.add(lblPassword);

		JPasswordField txtPassword = new JPasswordField("");
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPassword.setBounds(150, 190, 200, 30);
		west.add(txtPassword);
		
		JButton logintbtn = new JButton("Login");
		logintbtn.setBounds(30, 280, 100, 30);
		logintbtn.setFocusable(false);
		logintbtn.setBackground(new Color(106, 101, 101));
		logintbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		logintbtn.setForeground(Color.white);
		logintbtn.setFocusable(false);
		west.add(logintbtn);
		logintbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				// creating new variable to store textfield text
				
				String uname = txtUserName.getText();
				String pass = txtPassword.getText();
				//  staff registration opens if condition fulfilled
				if (uname.equals("admin") && pass.equals("zxcvbnm")) {
					JOptionPane.showMessageDialog(logintbtn, "admin login");
					Dashboard  = new Dashboard();
					
				
					

				} else {

				
					// if combobox item customer or corp-customer
					System.out.println("Not admin");
					LoginLibs user = new LoginLibs();
						//login for customer
						user.setUsername(uname);
						user.setPassword(pass);
						Global.loginCred = user;
						user = new JDBC().loginCust(user);
						if (user.getId() > 0) {
							Global.loginCred = user;
							JOptionPane.showMessageDialog(null, "Login Successful");
							new Dashboardcustomer().setVisible(true);
							frame.dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Wrong Password or Username");
						}
					
				}
			}
		});

		JButton clearbtn = new JButton("Clear");
		clearbtn.setBounds(150, 280, 100, 30);
		clearbtn.setFocusable(false);
		clearbtn.setBackground(new Color(106, 101, 101));
		clearbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		clearbtn.setForeground(Color.white);
		clearbtn.setFocusable(false);
		west.add(clearbtn);
		//clears the textfield if there is values
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				txtUserName.setText(null);
				txtPassword.setText(null);

			}
		});

		JLabel lbllink = new JLabel("www.Garyshotel.com");
		lbllink.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbllink.setForeground(Color.WHITE);
		lbllink.setBounds(130, 425, 200, 20);
		west.add(lbllink);

		JPanel CENTER = new JPanel();
		CENTER.setPreferredSize(new Dimension(400, 10));
		CENTER.setLayout(null);
		CENTER.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(CENTER, BorderLayout.CENTER);

//		set image
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(-263, -44, 548, 359);
		lblImage.setIcon(new ImageIcon("C:\\Users\\Ridhwaan\\OneDrive\\Pictures\\Slideshow\\HD-wallpaper-maldives-resort-ocean-resorts-pier-lights-sky.jpg"));
		frame.getContentPane();
		CENTER.add(lblImage);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ridhwaan\\Downloads\\AssignmentJava-main\\img\\HD-wallpaper-maldives-resort-ocean-resorts-pier-lights-sky.jpg"));
		lblNewLabel.setBounds(-159, 0, 658, 453);
		CENTER.add(lblNewLabel);

		JButton backbtn = new JButton("Back");
		backbtn.setBounds(270, 280, 100, 30);
		backbtn.setFocusable(false);
		backbtn.setBackground(new Color(106, 101, 101));
		backbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		backbtn.setForeground(Color.white);
		backbtn.setFocusable(false);
		west.add(backbtn);
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				//open new class welcome page
				WelcomePage reg = new WelcomePage();
				reg.setVisible(true);
				frame.dispose();

			}

		});

		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Login();
	}

}