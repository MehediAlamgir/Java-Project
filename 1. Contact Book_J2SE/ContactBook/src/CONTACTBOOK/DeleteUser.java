package CONTACTBOOK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DeleteUser extends JFrame implements ActionListener
{
	private JFrame frame;
	private Container con;
	private JTextField nick;
	private JLabel messageLabel;
	private JButton search;
	
	public DeleteUser() 
	{
		con = this.getContentPane();
		con.setBackground(Color.WHITE);
		
		messageLabel = new JLabel("Enter Your NickName");
		messageLabel.setBounds(130, 100, 400, 40);
		nick = new JTextField();
		nick.setBounds(90, 135, 210, 25);
		search = new JButton("Delete");
		search.setBounds(145, 180, 100, 25);
		
		con.add(messageLabel);
		con.add(nick);
		con.add(search);
		con.setLayout(null);
		
		search.addActionListener(this);
		
		frame = new JFrame("Delete User form");
		frame.add(con);
		frame.setSize(400 , 400);
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}


	public void actionPerformed(ActionEvent ae) 
	{
		Object s = ae.getSource();
		
		if (s == search)
		{
			if (nick.getText().equals(""))
			{
				JOptionPane.showMessageDialog(nick, "You Must provide your NickName");
			}
			else
			{
				MyDatabase.deleteUser(nick.getText());
			}
		}
		
	}
	
	public static void main(String[] args) {
		new DeleteUser();
	}
}
