package CONTACTBOOK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpPage extends JFrame implements ActionListener {

	private JLabel firstName;
	private JLabel lastName;
	private JLabel userName;
	private JLabel password;
	private JLabel contact;
	private JLabel email;
	private JLabel bloodGroup;
	private JLabel gender;
	private JLabel dateOfBirth;
	private Choice dayChoice;
	private Choice monthChoice;
	private Choice yearChoice;
	private Choice genderChoice;
	
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField userNameField;
	private JTextField contactField;
	private JTextField bloodGroupField;
	private JTextField emailField;
	private JPasswordField passwordField;
	private Container con;
	private JFrame frame;
	private JButton save;
	private String s;
	private String sex = "";
	private String dob = "";
	//private int cnt = 0 ;
	public SignUpPage()
	{
		init();
	}
	
	private void init()
	{
		con = this.getContentPane();
		con.setBackground(Color.WHITE);
		
		firstName = new JLabel("FirstName: ");
		firstName.setBounds(2, 10, 300, 30);
		lastName = new JLabel("LastName: ");
		lastName.setBounds(2, 55, 300, 30);
		userName = new JLabel("UserName: ");
		userName.setBounds(2, 97, 300, 30);
		password = new JLabel("Password: ");
		password.setBounds(2, 140, 300, 30);	
		contact = new JLabel("Contact No. ");
		contact.setBounds(2, 180, 300, 30);
		bloodGroup = new JLabel("Blood Group: ");
		bloodGroup.setBounds(2, 220, 300, 30);
		email = new JLabel("E-mail Address: ");
		email.setBounds(2, 260, 300, 30);
		gender = new JLabel("Gender: ");
		gender.setBounds(2, 300, 300, 30);
		dateOfBirth = new JLabel("Date Of Birth: ");
		dateOfBirth.setBounds(2, 345, 300, 30);
		
		
		
		firstNameField = new JTextField();
		firstNameField.setBounds(100, 15, 250, 30);
		lastNameField = new JTextField();
		lastNameField.setBounds(100, 55, 250, 30);
		userNameField = new JTextField();
		userNameField.setBounds(100, 95, 250, 30);
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 135, 250, 30);
		contactField = new JTextField();
		contactField.setBounds(100, 175, 250, 30);
		bloodGroupField = new JTextField();
		bloodGroupField.setBounds(100, 215, 250, 30);
		emailField = new JTextField();
		emailField.setBounds(100, 255, 250, 30);
		
		genderChoice = new Choice();
		genderChoice.add("Male");
		genderChoice.add("Female");
		genderChoice.setBounds(100, 306, 250, 45);
		
		dayChoice = new Choice();
		monthChoice = new Choice();
		yearChoice = new Choice();
		
		for(int i = 1 ; i <32 ; i++)
		{
			s = Integer.toString(i);
			dayChoice.add(s);
		}
		dayChoice.setBounds(100, 348, 70, 45);
		
		monthChoice.add("Jan");
		monthChoice.add("Feb");
		monthChoice.add("Mar");
		monthChoice.add("Apr");
		monthChoice.add("May");
		monthChoice.add("Jun");
		monthChoice.add("Jul");
		monthChoice.add("Aug");
		monthChoice.add("Sep");
		monthChoice.add("Oct");
		monthChoice.add("Nov");
		monthChoice.add("Dec");
		
		monthChoice.setBounds(180, 348, 70, 45);
		
		for(int i = 1971 ; i <2031 ; i++)
		{
			s = Integer.toString(i);
			yearChoice.add(s);
		}
		yearChoice.setBounds(270, 348, 80, 45);
		
		save = new JButton("Save");
		save.setBounds(110, 400, 210, 30);

			
		con.setLayout(null);
		con.add(firstName);
		con.add(firstNameField);	
		con.add(lastName);
		con.add(lastNameField);
		con.add(userName);
		con.add(userNameField);
		con.add(password);
		con.add(passwordField);
		con.add(contact);
		con.add(contactField);
		con.add(bloodGroup);
		con.add(bloodGroupField);		
		con.add(email);
		con.add(emailField);
		
		con.add(genderChoice);
		con.add(gender);
		con.add(dayChoice);
		con.add(monthChoice);
		con.add(yearChoice);
		con.add(dateOfBirth);
		con.add(save);
		
		save.addActionListener(this);
		
		frame = new JFrame("SignUp Form");
		frame.add(con);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLocationRelativeTo(null);
		frame.setSize(400, 480);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		sex = genderChoice.getSelectedItem();
		dob = dayChoice.getSelectedItem() + " / " + monthChoice.getSelectedItem() +" / " + yearChoice.getSelectedItem();
		if (obj == save)
		{
	
			if (firstNameField.getText().equals("") || lastNameField.getText().equals("") || userNameField.getText().equals("") || passwordField.getText().equals("") || contactField.getText().equals("") || emailField.getText().equals("") || sex.equals("") || dob.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Sorry , please fillup all of your information!");
			}
			else
			{	
				MyDatabase.signupInfo(firstNameField.getText(), lastNameField.getText(), userNameField.getText(), passwordField.getText(), contactField.getText(), emailField.getText(), bloodGroupField.getText(), sex, dob);
			}
			
		}
		
		
	}
	
	

	
//	public static void main(String[] args) {
//		new SignUpPage();
//	}
	

}
