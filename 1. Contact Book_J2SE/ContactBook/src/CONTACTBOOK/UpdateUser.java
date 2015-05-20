package CONTACTBOOK;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;

public class UpdateUser extends JFrame implements ActionListener {

	private JLabel firstName;
	private JLabel lastName;
	private JLabel nickName;
	private JLabel contact;
	private JLabel email;
	private JLabel bloodGroup;
	private JLabel gender;
	private JLabel dateOfBirth;
	private JPanel image;
	private Choice dayChoice;
	private Choice monthChoice;
	private Choice yearChoice;
	private Choice genderChoice;
	
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField nickNameField;
	private JTextField contactField;
	private JTextField bloodGroupField;
	private JTextField emailField;
	private Container con;
	private JFrame frame;
	
	private String s;
	private String sex = "";
	private String dob = "";
	private String filename = "";
	private int cnt = 0 ;
	
	private JButton firstNameUpdate;
	private JButton lastNameUpdate;
	private JButton contactUpdate;
	private JButton emailUpdate;
	private JButton bloodUpdate;
	private JButton genderUpdate;
	private JButton dobUpdate;
	private JButton browse;
	public UpdateUser()
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
		nickName = new JLabel("NickName: ");
		nickName.setBounds(2, 97, 300, 30);
		contact = new JLabel("Contact No. ");
		contact.setBounds(2, 140, 300, 30);
		bloodGroup = new JLabel("Blood Group: ");
		bloodGroup.setBounds(2, 180, 300, 30);
		email = new JLabel("E-mail Address: ");
		email.setBounds(2, 220, 300, 30);
		gender = new JLabel("Gender: ");
		gender.setBounds(2, 260, 300, 30);	
		dateOfBirth = new JLabel("Date Of Birth: ");
		dateOfBirth.setBounds(2, 305, 300, 30);
		
		image = new JPanel(new BorderLayout());
		image.setBounds(480 , 15 , 205 , 220);
		image.setBackground(Color.gray);
		
		browse  = new JButton("Update");
		browse.setBounds(530, 240, 100, 30);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(100, 15, 250, 30);
		firstNameUpdate = new JButton("Update");
		firstNameUpdate.setBounds(360, 15, 100, 30);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(100, 55, 250, 30);
		lastNameUpdate = new JButton("Update");
		lastNameUpdate.setBounds(360, 55, 100, 30);
		
		nickNameField = new JTextField();
		nickNameField.setBounds(100, 95, 250, 30);
		
		contactField = new JTextField();
		contactField.setBounds(100, 135, 250, 30);
		contactUpdate = new JButton("Update");
		contactUpdate.setBounds(360, 135, 100, 30);
		
		bloodGroupField = new JTextField();
		bloodGroupField.setBounds(100, 175, 250, 30);
		bloodUpdate = new JButton("Update");
		bloodUpdate.setBounds(360, 175, 100, 30);
		
		emailField = new JTextField();
		emailField.setBounds(100, 215, 250, 30);
		emailUpdate = new JButton("Update");
		emailUpdate.setBounds(360, 215, 100, 30);
		
		genderChoice = new Choice();
		genderChoice.add("Male");
		genderChoice.add("Female");
		genderChoice.setBounds(100, 265, 250, 45);
		genderUpdate = new JButton("Update");
		genderUpdate.setBounds(360, 261, 100, 30);
		
		dayChoice = new Choice();
		monthChoice = new Choice();
		yearChoice = new Choice();
		
		for(int i = 1 ; i <32 ; i++)
		{
			s = Integer.toString(i);
			dayChoice.add(s);
		}
		dayChoice.setBounds(100, 306, 70, 45);
		
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
		
		monthChoice.setBounds(180, 306, 70, 45);
		
		for(int i = 1971 ; i <2031 ; i++)
		{
			s = Integer.toString(i);
			yearChoice.add(s);
		}
		yearChoice.setBounds(270, 306, 80, 45);
		
		dobUpdate = new JButton("Update");
		dobUpdate.setBounds(360, 300, 100, 30);
		
		con.setLayout(null);
		con.add(firstName);
		con.add(firstNameField);	
		con.add(lastName);
		con.add(lastNameField);
		con.add(nickName);
		con.add(nickNameField);
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
		con.add(dobUpdate);
		con.add(image);
		con.add(browse);
		con.add(firstNameUpdate);
		con.add(lastNameUpdate);
		con.add(contactUpdate);
		con.add(emailUpdate);
		con.add(genderUpdate);
		con.add(dobUpdate);
		con.add(bloodUpdate);
		
		dobUpdate.addActionListener(this);
		browse.addActionListener(this);
		firstNameUpdate.addActionListener(this);
		lastNameUpdate.addActionListener(this);
		contactUpdate.addActionListener(this);
		emailUpdate.addActionListener(this);
		bloodUpdate.addActionListener(this);
		genderUpdate.addActionListener(this);
		
		frame = new JFrame("User Update Form");
		frame.add(con);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 440);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new UpdateUser();
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		sex = genderChoice.getSelectedItem();
		dob = dayChoice.getSelectedItem() + " / " + monthChoice.getSelectedItem() +" / " + yearChoice.getSelectedItem();
		
		if (obj == dobUpdate )
		{	
			String name = nickNameField.getText();
			
			if (name.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "You Must Provide your NickName");
			}
			else
			{
				if (MyDatabase.nickNameCheck(name) == true)
				{
						MyDatabase.updateDateOfBirth(name , dob);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid NickName");
				}
			}
		}
		
		if (obj == firstNameUpdate )
		{	
			String name = nickNameField.getText();
			String fname = firstNameField.getText();
			
			if (name.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "You Must Provide your NickName");
			}
			else
			{
				if (MyDatabase.nickNameCheck(name) == true)
				{
						MyDatabase.updateFirstName(name , fname);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid NickName");
				}
			}
		}
		
		if (obj == lastNameUpdate )
		{	
			String name = nickNameField.getText();
			String lname = lastNameField.getText();
			
			if (name.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "You Must Provide your NickName");
			}
			else
			{
				if (MyDatabase.nickNameCheck(name) == true)
				{
						MyDatabase.updateLastName(name , lname);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid NickName");
				}
			}
		}
		
		if (obj == contactUpdate )
		{	
			String name = nickNameField.getText();
			String con = contactField.getText();
			
			if (name.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "You Must Provide your NickName");
			}
			else
			{
				if (MyDatabase.nickNameCheck(name) == true)
				{
						MyDatabase.updateContact(name , con);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid NickName");
				}
			}
		}
		
		if (obj == emailUpdate )
		{	
			String name = nickNameField.getText();
			String eml = emailField.getText();
			
			if (name.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "You Must Provide your NickName");
			}
			else
			{
				if (MyDatabase.nickNameCheck(name) == true)
				{
						MyDatabase.updateEmail(name , eml);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid NickName");
				}
			}
		}
		
		if (obj == bloodUpdate)
		{
			String name = nickNameField.getText();
			String bg = bloodGroupField.getText();
			
			if (name.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "You Must Provide your NickName");
			}
			else
			{
				if (MyDatabase.nickNameCheck(name) == true)
				{
						MyDatabase.updateBlood(name , bg);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid NickName");
				}
			}
		}
		
		if (obj == genderUpdate )
		{	
			String name = nickNameField.getText();
			
			if (name.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "You Must Provide your NickName");
			}
			else
			{
				if (MyDatabase.nickNameCheck(name) == true)
				{
						MyDatabase.updateGender(name , sex);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid NickName");
				}
			}
		}
		
		if (obj == browse)
		{
			
			String name = nickNameField.getText();
			
			if (name.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "You Must Provide your NickName");
			}
			else
			{
				if (MyDatabase.nickNameCheck(name) == true)
				{
					try
					{
//				        JFileChooser chooser = new JFileChooser();
//				        chooser.showOpenDialog(image);
//				        File f = chooser.getSelectedFile();
//				        filename = f.getAbsolutePath();
//				        JOptionPane.showMessageDialog(null, filename); 
						
						JFileChooser fileChooser = new JFileChooser(".");
					    FileFilter filter1 = new ExtensionFileFilter("JPG  , JPEG , PNG", new String[] { "JPG", "JPEG" , "PNG" });
					    fileChooser.setFileFilter(filter1);
					    int status = fileChooser.showOpenDialog(null);
					    if (status == JFileChooser.APPROVE_OPTION) 
					    {
					      File selectedFile = fileChooser.getSelectedFile();
					      filename = selectedFile.getAbsolutePath();
					      JOptionPane.showMessageDialog(null, "Image Selected");
					    }
					    else if (status == JFileChooser.CANCEL_OPTION) 
					    {
					    	//System.out.println(JFileChooser.CANCEL_OPTION);
					    	JOptionPane.showMessageDialog(null, "Canceled!");
					    } 
					    
					    MyDatabase.updateImage(name , filename);
							  
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}
						
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid NickName");
				}
			}
			
		}
		
		
	}
	
	
	
	class ExtensionFileFilter extends FileFilter {
		  String description;

		  String extensions[];

		  public ExtensionFileFilter(String description, String extension) {
		    this(description, new String[] { extension });
		  }

		  public ExtensionFileFilter(String description, String extensions[]) {
		    if (description == null) {
		      this.description = extensions[0];
		    } else {
		      this.description = description;
		    }
		    this.extensions = (String[]) extensions.clone();
		    toLower(this.extensions);
		  }

		  private void toLower(String array[]) {
		    for (int i = 0, n = array.length; i < n; i++) {
		      array[i] = array[i].toLowerCase();
		    }
		  }

		  public String getDescription() {
		    return description;
		  }

		  public boolean accept(File file) {
		    if (file.isDirectory()) {
		      return true;
		    } else {
		      String path = file.getAbsolutePath().toLowerCase();
		      for (int i = 0, n = extensions.length; i < n; i++) {
		        String extension = extensions[i];
		        if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
		          return true;
		        }
		      }
		    }
		    return false;
		  }
		}
			
}
