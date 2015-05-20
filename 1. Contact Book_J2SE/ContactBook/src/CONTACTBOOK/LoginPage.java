package CONTACTBOOK;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener {
	
	private Container con ;
	private JLabel userNameLabel;
	private JLabel userPasswordLabel;
	private JLabel imageLabel;
	private JTextField userNameField;
	private JPasswordField userPasswordField;
	private JButton loginButton;
	private JButton signupButton;
	private JFrame frame; 
	public static String USER_NAME;
	
	private LoginPage() {
		
		con = this.getContentPane();
		con.setBackground(Color.WHITE);
		
		imageLabel = new JLabel();
		imageLabel.setBounds(15, 60, 245, 260);
		imageLabel.setIcon(new ImageIcon("Images\\login1.jpg"));
		
		userNameLabel = new JLabel("UserName: ");
		userNameLabel.setBounds(260,170,700,30);
		
		userNameField = new JTextField();
		userNameField.setBounds(350, 172, 215, 30);
		
		userPasswordLabel = new JLabel("Password: ");
		userPasswordLabel.setBounds(260, 213, 700, 30);
		
		userPasswordField = new JPasswordField();
		userPasswordField.setBounds(350, 212, 215, 30);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(350, 258, 100 , 30);
		loginButton.setIcon(new ImageIcon("Images\\login2.PNG"));
		loginButton.setBackground(Color.WHITE);
		loginButton.addActionListener(this);
		
		signupButton = new JButton("SignUp");
		signupButton.setBounds(460, 258, 100 , 30);
		signupButton.setBackground(Color.WHITE);
		signupButton.addActionListener(this);
		con.add(userNameLabel);
		con.add(userNameField);
		con.add(userPasswordLabel);
		con.add(userPasswordField);
		con.add(loginButton);
		con.add(signupButton);
		con.add(imageLabel);
		
		frame = new JFrame("ACCOUNT LOGIN");
		frame.add(con);
		frame.setSize(600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
			
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
		
		String user = userNameField.getText();
		String pass = userPasswordField.getText();
		
		if (ae.getSource() == loginButton)
		{
			if (user.isEmpty() || pass.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please enter your username and password");
			}
			else
			{
				if (MyDatabase.serachUser(user, pass) == true)
				{
					JOptionPane.showMessageDialog(null, "Sucessfully Login!");
					USER_NAME = user;
					new MenuPage();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid UserName or Password!");
				}
			}
			
		}
		
		if (ae.getSource() == signupButton)
		{
			new SignUpPage();
		}
	}
	
	public static void main(String[] args) {
		new LoginPage();
	}
}
