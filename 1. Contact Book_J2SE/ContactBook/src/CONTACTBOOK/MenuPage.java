package CONTACTBOOK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPage extends JFrame implements ActionListener {

	private JButton addUser;
	private JButton viewUser;
	private JButton deleteUser;
	private JButton updateUser;
	private JButton programmer;
	private Container con;
	
	public MenuPage()
	{
		con = this.getContentPane();
		con.setBackground(Color.WHITE);
		
		addUser = new JButton("Add New Friend");
		addUser.setBounds(145, 100, 180, 30);
		viewUser = new JButton("Show Friend's Info.");
		viewUser.setBounds(145, 140, 180, 30);
		deleteUser = new JButton("Delete Friend's Info.");
		deleteUser.setBounds(145, 180, 180, 30);
		updateUser = new JButton("Update Friend's Info.");
		updateUser.setBounds(145, 220, 180, 30);
		
		
		con.add(addUser);
		con.add(viewUser);
		con.add(deleteUser);
		con.add(updateUser);
		con.setLayout(null);
		
		addUser.addActionListener(this);
		viewUser.addActionListener(this);
		deleteUser.addActionListener(this);
		updateUser.addActionListener(this);
		
		
		JFrame frame = new JFrame("Option Page");
		frame.add(con);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(500 , 450);
		frame.setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent ae) 
	{
		
		Object s = ae.getSource();
		if (s == addUser)
		{
			new AddUser();
		}
		
		if (s == viewUser)
		{
			 new ViewUser();
		}
		
		if (s == deleteUser)
		{
			new DeleteUser();
		}
		
		if (s == updateUser)
		{
			new UpdateUser();
		}
	}

	public static void main(String[] args) {
		new MenuPage();
	}
}
