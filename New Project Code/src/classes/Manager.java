package classes;
import javax.swing.*;
import javax.swing.border.LineBorder;

import javafx.geometry.Point3D;

import java.awt.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;


public class Manager extends JFrame  {
	
		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel p1, p2, p3;
	private JLabel password, email, title;
	private JTextField enterEmail;
	private JPasswordField enterPassword; 
	private JButton logIn;
	
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
		
	
	
		ListenerClass listener = new ListenerClass(); 
	
		enterEmail.addFocusListener(listener);
		enterPassword.addFocusListener(listener);
	
		logIn.addActionListener(listener);
	
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
		
		public void actionPerformed(ActionEvent e)
		{
			try {
				
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fast_food?autoReconnect=true&useSSL=false");  
				//here sonoo is database name, root is username and password
				Statement stmt=con.createStatement(); 
				

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
	         
	         
	     	String pass = enterPassword.getText();
        	String email1 = enterEmail.getText();
        	
        	String sql = "Select Email, Password from manager where Email='" + enterEmail.getText() + "' and Password='" + enterPassword.getText() + "'";
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				email = rs.getString("Email");
				Password = rs.getString("Password");
				
				if(email.equals(email1) && Password.equals(pass))
				{
	        		JOptionPane.showMessageDialog(null, "Correct password, logIn","Signed In", JOptionPane.ERROR_MESSAGE);

				}
				
				else
				{
	        		 JOptionPane.showMessageDialog(null, "Incorrect Password or Email, logIn","Please Try again", JOptionPane.ERROR_MESSAGE);

				}
			}
	         
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
	         con.close();  
			}catch(Exception e1)
			{ 
				System.out.println(e1);
			}  	
		  }

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}  
	         
		 }


		
		
	}

