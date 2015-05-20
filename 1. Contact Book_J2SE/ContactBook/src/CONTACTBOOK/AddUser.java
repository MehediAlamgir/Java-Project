package CONTACTBOOK;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;

public class AddUser extends JFrame implements ActionListener {

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
	private JButton save;
	private JButton browse;
	private String s;
	private String sex = "";
	private String dob = "";
	private String filename = "";
	private int cnt = 0 ;
	public AddUser()
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
		image.setBounds(380 , 15 , 205 , 220);
		image.setBackground(Color.gray);
		
		browse  = new JButton("import");
		browse.setBounds(430, 240, 100, 30);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(100, 15, 250, 30);
		lastNameField = new JTextField();
		lastNameField.setBounds(100, 55, 250, 30);
		nickNameField = new JTextField();
		nickNameField.setBounds(100, 95, 250, 30);
		contactField = new JTextField();
		contactField.setBounds(100, 135, 250, 30);
		bloodGroupField = new JTextField();
		bloodGroupField.setBounds(100, 175, 250, 30);
		emailField = new JTextField();
		emailField.setBounds(100, 215, 250, 30);
		
		genderChoice = new Choice();
		genderChoice.add("Male");
		genderChoice.add("Female");
		genderChoice.setBounds(100, 265, 250, 45);
		
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
		
		save = new JButton("Save");
		save.setBounds(110, 370, 210, 30);
		
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
		con.add(save);
		con.add(image);
		con.add(browse);
		save.addActionListener(this);
		browse.addActionListener(this);
		
		frame = new JFrame("User SignUp Form");
		frame.add(con);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 440);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		sex = genderChoice.getSelectedItem();
		dob = dayChoice.getSelectedItem() + " / " + monthChoice.getSelectedItem() +" / " + yearChoice.getSelectedItem();
		
		if (obj == save)
		{	
			
			if (firstNameField.getText().equals("") || lastNameField.getText().equals("") || nickNameField.getText().equals("") || filename.equals("") || contactField.getText().equals("") || emailField.getText().equals("") || sex.equals("") || dob.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Sorry , please fillup all of your information!");
			}
			else
			{	
				MyDatabase.userInfo(LoginPage.USER_NAME , firstNameField.getText(), lastNameField.getText(), nickNameField.getText(), filename.toString(), contactField.getText(), emailField.getText(), bloodGroupField.getText(), sex, dob);
			}
			
		}
		
		if (obj == browse)
		{
			try
			{
//		        JFileChooser chooser = new JFileChooser();
//		        chooser.showOpenDialog(image);
//		        File f = chooser.getSelectedFile();
//		        filename = f.getAbsolutePath();
//		        JOptionPane.showMessageDialog(null, filename); 
				
				JFileChooser fileChooser = new JFileChooser(".");
			    FileFilter filter1 = new ExtensionFileFilter("JPG  , JPEG , PNG", new String[] { "JPG", "JPEG" , "PNG" });
			    fileChooser.setFileFilter(filter1);
			    int status = fileChooser.showOpenDialog(null);
			    if (status == JFileChooser.APPROVE_OPTION) 
			    {
			      File selectedFile = fileChooser.getSelectedFile();
			      filename = selectedFile.getAbsolutePath();
			      JOptionPane.showMessageDialog(null, filename);
			      //JOptionPane.showMessageDialog(null, "Image Selected");
			    }
			    else if (status == JFileChooser.CANCEL_OPTION) 
			    {
			    	//System.out.println(JFileChooser.CANCEL_OPTION);
			    	JOptionPane.showMessageDialog(null, "Canceled!");
			    } 	
					  
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		new AddUser();
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
