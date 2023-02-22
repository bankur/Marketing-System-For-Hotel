package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomePage extends JFrame implements ActionListener {
	JLabel lbltitle, lblcontact, lblcontact1;
	JButton btnsignup, btnsignin;

	public WelcomePage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Welcome Page");
		setSize(1600, 740); 
		setLocationRelativeTo(null);
		
		getContentPane().setBackground(new Color(255, 178, 102));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		getContentPane().setLayout(null);

		//inserting Image
		JLabel lblImage = new JLabel(""); 
		lblImage.setBounds(1, 90, 1700, 560);
		lblImage.setIcon(new ImageIcon("welcomeimg.jpg"));
		getContentPane();
		
		//declare and initialising
		lbltitle = new JLabel("Welcome To Gary Hotel");
		lbltitle.setForeground(Color.BLACK);
		lbltitle.setBounds(277, 30, 702, 73); 
		lbltitle.setFont(new Font("Lucida Calligraphy", Font.BOLD, 44));

		lblcontact = new JLabel("Contact us :");
		lblcontact.setForeground(Color.BLACK);
		lblcontact.setBounds(70, 617, 248, 43);
		lblcontact.setFont(new Font("Times New Roman", Font.BOLD, 25));

		lblcontact1 = new JLabel("garyhotel69@gmail.com | 9887654321, 01-7654321");
		lblcontact1.setForeground(Color.BLACK);
		lblcontact1.setBounds(25, 660, 560, 43);
		lblcontact1.setFont(new Font("Times New Roman", Font.BOLD, 24));

		btnsignup = new JButton("Sign up");
		btnsignup.setBounds(1106, 30, 124, 50);
		btnsignup.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnsignup.setBackground(new Color(255,255,255));
		btnsignup.setForeground(Color.BLACK);
		btnsignup.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		btnsignup.addActionListener(this);
		
		btnsignin = new JButton("Sign in");
		btnsignin.setBounds(1250, 30, 124, 50);
		btnsignin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnsignin.setBackground(new Color(255,255,255));
		btnsignin.setForeground(Color.BLACK);
		btnsignin.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		btnsignin.addActionListener(this);
		
		btnsignup.setFocusable(false);
		btnsignin.setFocusable(false);
		getContentPane().setLayout(null);

		//add variables to JFrame
		getContentPane().add(lblImage);
		getContentPane().add(lbltitle);
		getContentPane().add(lblcontact);
		getContentPane().add(lblcontact1);
		getContentPane().add(btnsignup);
		getContentPane().add(btnsignin);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ridhwaan\\Downloads\\AssignmentJava-main\\img\\f64ba3ed274adee99ae41abe76652075.jpg"));
		lblNewLabel.setBounds(0, 0, 1540, 703);
		getContentPane().add(lblNewLabel);

		setVisible(true);
		setResizable(false);

	}

	public static void main(String[] args) {
		new WelcomePage();

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnsignup) {

			CustomerReg reg =new CustomerReg();
			reg.frame2.setVisible(true);
			this.dispose();
		}
		if (e.getSource() == btnsignin) {
			
			Login log =new Login();
			log.frame.setVisible(true);
			this.dispose();
			
		}

	}
}
