package CONTACTBOOK;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class ViewUser extends JFrame implements ActionListener
{
	private JFrame frame;
	private Container con;
	private JTextField nick;
	private JLabel messageLabel;
	private JButton search;
	
	public ViewUser() 
	{
		con = this.getContentPane();
		con.setBackground(Color.WHITE);
		
		messageLabel = new JLabel("Enter Your NickName");
		messageLabel.setBounds(130, 100, 400, 40);
		nick = new JTextField();
		nick.setBounds(90, 135, 210, 25);
		search = new JButton("Search");
		search.setBounds(145, 180, 100, 25);
		
		con.add(messageLabel);
		con.add(nick);
		con.add(search);
		con.setLayout(null);
		
		search.addActionListener(this);
		
		frame = new JFrame("View User Form");
		frame.add(con);
		frame.setSize(400 , 400);
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}


	public void actionPerformed(ActionEvent ae) 
	{
		Object obj = ae.getSource();
		String name = nick.getText();
		
		if (obj == search)
		{
			
			if (name.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "You Must Provide your NickName");
			}
			else
			{
				if (MyDatabase.nickNameCheck(name) == true)
				{
						MyDatabase ob = new MyDatabase();
						ob.showInfo(name);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid NickName");
				}
			}
		}

		
	}
	
	public static void main(String[] args) {
		new ViewUser();
	}
}