package classes;
import javax.swing.*;
import javax.swing.border.LineBorder;

import javafx.geometry.Point3D;

import java.awt.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;


public class Manager extends JFrame  {
	
	//VARIABLES FOR GUI
	private static final long serialVersionUID = 1L;
	private JPanel p1, p2, p3;
	private JLabel password, email, title, select;
	private JTextField enterEmail;
	private JPasswordField enterPassword; 
	private JButton logIn;
	
	private JPanel p4;
	private JButton add, delete, update;
	
	private JPanel p5;
	private JTextField enterID, enterName, enterPrice, enterDescription, enterSection;
	private JLabel id, name, price, description, section;
	private JButton confirm;
	
	//VARIABLES FOR DATABSE CONNECTION
	private String url = "jdbc:mysql://localhost:3306/";
	private String dbName = "fast_food?autoReconnect=true&useSSL=false";
	private String driver = "com.mysql.jdbc.Driver";
	private String userName = "root";
	private String passwordDB = "password";
	private Statement statement = null;   
    private ResultSet resultSet = null;
    
    //CODE TO GENERATE THE GUI
	public Manager()
	{
		p1 = new JPanel();
		p1.setLayout(new GridLayout(3,1));
		p1.add(email = new JLabel("Email:"));
		p1.add(enterEmail = new JTextField(15));
		
		p1.add(password = new JLabel("Password:"));
		p1.add(enterPassword = new JPasswordField(15));
		
		//p1.add(logIn = new JButton("Log In"));
		//logIn.setHorizontalAlignment(JButton.CENTER);
		//logIn.setVerticalTextPosition(JButton.BOTTOM);
		
		p1.setBackground(Color.WHITE);
		p1.setBorder(new LineBorder(Color.BLACK, 1));
		
		add(p1, BorderLayout.WEST);
		
		p2= new JPanel();
		p2.add(logIn = new JButton("Log In"));
		logIn.setHorizontalAlignment(JButton.CENTER);
		p2.setBorder(new LineBorder(Color.BLACK, 1));
		p2.setBackground(Color.WHITE);

		add(p2, BorderLayout.SOUTH);

		
		p3 = new JPanel();
		p3.setLayout(new GridLayout(1,1));
		
		p3.add(title = new JLabel("The Chippy"));
		p3.setBackground(Color.WHITE);
		title.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
		title.setHorizontalAlignment(JLabel.CENTER);
		//title.setVerticalTextPosition(JLabel.TOP);
		
		add(p3,  BorderLayout.NORTH);
		
		p4 = new JPanel();
	    p4.setLayout(new GridLayout(4,0));
	    
		p4.add(select = new JLabel("Please Select"));
		select.setHorizontalAlignment(JLabel.CENTER);
		
	    p4.add(add = new JButton("Add New Item"));
		p4.add(delete = new JButton("Remove Item"));
		p4.add(update = new JButton("Edit Item"));
		p4.setBorder(new LineBorder(Color.BLACK, 1));
		p4.setBackground(Color.WHITE);
		
	
		add(p4, BorderLayout.CENTER);
			
		p4.setVisible(false);
		
		p5 = new JPanel();
		p5.setLayout(new GridLayout(2,6));
		
		p5.add(enterID = new JTextField());
		p5.add(id = new JLabel("Product Code:"));
		p5.add(enterName = new JTextField());
		p5.add(name = new JLabel("Name:"));
		p5.add(enterPrice = new JTextField());
		p5.add(price = new JLabel("Price:"));
		p5.add(enterDescription = new JTextField());
		p5.add(description = new JLabel("Description:"));
		p5.add(enterSection = new JTextField());
		p5.add(section = new JLabel("Section:"));
		p5.add(confirm = new JButton("Conform"));
		
		p5.setBorder(new LineBorder(Color.BLACK, 1));
		p5.setBackground(Color.WHITE);
		
	
		add(p5, BorderLayout.CENTER);
			
		p5.setVisible(false);
		
		
		ListenerClass listener = new ListenerClass(); 
	
		enterEmail.addFocusListener(listener);
		enterPassword.addFocusListener(listener);
		logIn.addActionListener(listener);
		
		add.addActionListener(listener);
		delete.addActionListener(listener);
		update.addActionListener(listener);

		
	
	}
	
	
	
	public static void main(String[] args)
	{
		Manager frame = new Manager();

		frame.setTitle("CHANGE MENU");
		
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	


	
	class ListenerClass implements FocusListener, ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{		
				 // CODE THAT WILL DISPLAY JTEXTBOX IF THE PASSWORDS OR EMAIL ARE NOT ENTERED CORRECTLY 
				 String email = enterEmail.getText();
		         String Password = enterPassword.getText();
			
				 // IF NO DATA ENTERERD TO JTEXTFIELD WILL POP UP ERROR
				 if(e.getSource() == logIn && email.equals("") || password.equals(""))
				 {

					 JOptionPane.showMessageDialog(null, "Cannot be left blank, TRY AGAIN","TRY AGAIN", JOptionPane.ERROR_MESSAGE);
				 }
	         
	             // IF EMAIL DOES NOT CONTAIN @ OR .com WILL POP UP BOX INVALID EMIAL ADDRESS
				 else if(e.getSource() == logIn && !email.contains(".com") || !email.contains("@"))
				 {
					 JOptionPane.showMessageDialog(null, "invalid email, TRY AGAIN","TRY AGAIN", JOptionPane.ERROR_MESSAGE);
				 }
					
				//CODE TO VERFIY THE EMAIL ADDRESS AND PASSWORD FROM THE DATABASE 
				Class.forName("com.mysql.jdbc.Driver");
		        Connection conn = DriverManager.getConnection(url+dbName,userName,passwordDB);
		        statement=conn.createStatement(); 
		        
		        String emailAd = enterEmail.getText();
		        char[] passwd = enterPassword.getPassword();
		        String password1 = new String(passwd);
		        
		        
		        if(passwd != null)
		        {
		        	String pass = new String(passwd);
		        	String query1 ="SELECT Email,Password FROM manager where Email=? and Password=?";
		        	
		        	PreparedStatement ps = conn.prepareStatement(query1);
		        	ps.setString(1, emailAd);
		        	ps.setString(2, password1);
		        	
		        	ResultSet rs;
		        	 rs = ps.executeQuery();
		        	 
		        	 if(rs.next())
		        	 {  
		        		    p1.setVisible(false);
		        		    p2.setVisible(false);
		        		    p3.setVisible(false);
		        		    p5.setVisible(false);

		        		    p4.setVisible(true);
 
		        	 }
		        	 
		        	 else
		        	 {
		        		 JOptionPane.showMessageDialog(null, "Incorrect Password or Email, logIn","Please Try again", JOptionPane.ERROR_MESSAGE);

		        	 }
		        	 
		        	 ps.close();
		        	 rs.close();
		        	 conn.close();
		        }
		        
		        String add1 = add.getText();
		        String delete1 = delete.getText();
		        String update1 = update.getText();
		        
		        if(e.getSource() == add)
		        {
		        	p5.setVisible(true);
		        }
		        
			}catch(Exception ee) 
			{
				System.out.println(ee);

			}
			
		}  
		
		
		@Override
		public void focusGained(FocusEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

	         
		 }	
		
	}

	
	
		/*
		public void actionPerformed(ActionEvent e)
		{
			try {
				
				 Class.forName("com.mysql.jdbc.Driver");
		         Connection conn = DriverManager.getConnection(url+dbName,userName,passwordDB);
		         statement=conn.createStatement(); 
		 		//resultSet =statement.executeQuery("select * from product");  

 
		         String email = enterEmail.getText();
		         String Password = enterPassword.getText();
			
				 // IF NO DATA ENTERERD TO JTEXTFIELD WILL POP UP ERROR
				 if(e.getSource() == logIn && email.equals("") || password.equals(""))
				 {

					 JOptionPane.showMessageDialog(null, "Cannot be left blank, TRY AGAIN","TRY AGAIN", JOptionPane.ERROR_MESSAGE);
				 }
	         
	          // IF EMAIL DOES NOT CONTAIN @ OR .com WILL POP UP BOX INVALID EMIAL ADDRESS
				 else if(e.getSource() == logIn && !email.contains(".com") || !email.contains("@"))
				 {
					 JOptionPane.showMessageDialog(null, "invalid email, TRY AGAIN","TRY AGAIN", JOptionPane.ERROR_MESSAGE);
				 }
				 
				 String sql = "select Email, Password from manager where Email = ? AND Password = ?";
				 PreparedStatement ps = conn.prepareStatement(sql);
				 ps.setString(1,  email);
				 ps.setString(2, Password);
				 ps.executeQuery();
				 resultSet = ps.executeQuery();
				 
				 while(resultSet.next()) {
					 
				 
				 String checkUser = resultSet.getString(1);
				 String checkPassword = resultSet.getString(2);
				 
				 if((checkUser.equals(email)) && (checkPassword.equals(Password)))
			        {
		        		JOptionPane.showMessageDialog(null, "Correct password, logIn","Signed In", JOptionPane.ERROR_MESSAGE);
			        }
			        else
			        {
		        		 JOptionPane.showMessageDialog(null, "Incorrect Password or Email, logIn","Please Try again", JOptionPane.ERROR_MESSAGE);
			        }
				 }
			        conn.close();
				 
				 
	         /*
	         
				String pass = enterPassword.getText();
	     		String email1 = enterEmail.getText();
        	
	     		String sql = "select Email,Password from manager where Email = '"+enterEmail+"'and Password = '"+enterPassword+"'";
	     		resultSet = statement.executeQuery(sql);
	     		//statement=conn.prepareStatement(sql);
	     		//ResultSet rs=statement.executeQuery(sql);
			//int count =0;
			while(resultSet.next()) {
				

				//String pass = enterPassword.getText();
	     		//String email1 = enterEmail.getText();
				//email = rs.getString("Email");
				//Password = rs.getString("Password");
				 
				if(email.equals(email1) && Password.equals(pass))
				{
	        		JOptionPane.showMessageDialog(null, "Correct password, logIn","Signed In", JOptionPane.ERROR_MESSAGE);

				}
				
				else
				{
	        		 JOptionPane.showMessageDialog(null, "Incorrect Password or Email, logIn","Please Try again", JOptionPane.ERROR_MESSAGE);

				}
			}
			*/
		/*
			  conn.close();  
			}catch(Exception e1)
			{ 
				System.out.println(e1);
			}  	
		  }
	        */
			/*
			 if(pass.equals(rs.getString("password")))
			 {
	        		JOptionPane.showMessageDialog(null, "Correct password, logIn","Signed In", JOptionPane.ERROR_MESSAGE);

			 }
			 
			 else
			 {
        		 JOptionPane.showMessageDialog(null, "Incorrect Password or Email, logIn","Please Try again", JOptionPane.ERROR_MESSAGE);

			 }
			 
			 */
			
			/* 
	         if(e.getSource()== logIn && enterEmail != null && enterPassword != null) 
	         {
	        	 String pass = enterPassword.getText();
	        	 String email1 = enterEmail.getText();
	        	 String sql = "Select Email, Password from manager where Email='" + enterEmail.getText() + "' and Password='" + enterPassword.getText() + "'";
				 stmt=con.prepareStatement(sql);
				  ResultSet rs=stmt.executeQuery(sql);
	        	ResultSet rs=stmt.executeQuery(sql);
				
	        	if(rs.next()) 
	        	{ 
	        		JOptionPane.showMessageDialog(null, "Correct password, logIn","Signed In", JOptionPane.ERROR_MESSAGE);
	        	}
	        	 
	        	else 
	        	{
	        		 JOptionPane.showMessageDialog(null, "Incorrect Password or Email, logIn","Please Try again", JOptionPane.ERROR_MESSAGE);
	            }
	        	
	          }
	         */
	      


