/*
 * gavin mcpaul
 * manager class
 * 
 * 
 * 
 */
package classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Manager {

	private JFrame frame;

		//VARIABLES FOR DATABSE CONNECTION
		private String url = "jdbc:mysql://localhost:3306/";
		private String dbName = "fast_food?autoReconnect=true&useSSL=false";
		private String driver = "com.mysql.jdbc.Driver";
		private String userName = "root";
		private String passwordDB = "password";
		private Statement statement = null;   
	    private ResultSet resultSet = null;
	    
	    //SOME VARIABLES FOR THE JPANELS ARE ANNOUNCED OUTSIDE THE METHOD SO OTHERS CAN USE 
		private JPanel panelMenu,panelChoose,panel_Order;
	
		private JPasswordField enterPassword;

		//private JPasswordField enterPassword;
		


	    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager window = new Manager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Manager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel panelMenu = new JPanel();
		frame.getContentPane().add(panelMenu, "name_10475017053377");
		panelMenu.setLayout(null);
		panelMenu.setVisible(true);
		
		final JPanel panelChoose = new JPanel();
		frame.getContentPane().add(panelChoose, "name_10477123123916");
		panelChoose.setLayout(null);
		panelChoose.setVisible(false);
		
		final JPanel panel_Order = new JPanel();
		frame.getContentPane().add(panel_Order, "name_10478840946849");
		panel_Order.setLayout(null);
		panel_Order.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Mr Chippy");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(12, 13, 408, 51);
		panelMenu.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(27, 92, 56, 16);
		panelMenu.add(lblEmail);
		
	    JTextField enterEmail = new JTextField();
		enterEmail.setBounds(116, 89, 116, 22);
		panelMenu.add(enterEmail);
		enterEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(27, 144, 68, 16);
		panelMenu.add(lblPassword);
		
		enterPassword = new JPasswordField();
		enterPassword.setBounds(116, 141, 116, 22);
		panelMenu.add(enterPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(135, 189, 97, 25);
		panelMenu.add(btnLogin);
		
		
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelChoose.setVisible(true);

				try 
				{		
					 // CODE THAT WILL DISPLAY JTEXTBOX IF THE PASSWORDS OR EMAIL ARE NOT ENTERED CORRECTLY 
					 String email = enterEmail.getText();
			         String Password = enterPassword.getText();
				
					 // IF NO DATA ENTERERD TO JTEXTFIELD WILL POP UP ERROR
					 if(e.getSource() == btnLogin && email.equals("") || Password.equals(""))
					 {

						 JOptionPane.showMessageDialog(null, "Cannot be left blank, TRY AGAIN","TRY AGAIN", JOptionPane.ERROR_MESSAGE);
					 }
		         
		             // IF EMAIL DOES NOT CONTAIN @ OR .com WILL POP UP BOX INVALID EMIAL ADDRESS
					 else if(e.getSource() == btnLogin && !email.contains(".com") || !email.contains("@"))
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
			        		
			        		 JOptionPane.showMessageDialog(null, "Correct Credentials","Have a nice day", JOptionPane.INFORMATION_MESSAGE);

			        		 	panelMenu.setVisible(false);
			        			panelChoose.setVisible(true);

			        	 }
			        	 
			        	 else
			        	 {
			        		 JOptionPane.showMessageDialog(null, "Incorrect Password or Email, logIn","Please Try again", JOptionPane.ERROR_MESSAGE);

			        	 }
			        	 
			        	 ps.close();
			        	 rs.close();
			        	 conn.close();
			        }
				}catch(Exception ee) 
				{
					System.out.println(ee);

				}
				
			}
			
		});

		
		
		
		JButton add = new JButton("Add Item");
		add.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		
		add.setBounds(154, 80, 115, 33);
		panelChoose.add(add);
		
		JButton remove = new JButton("Remove Item");
		remove.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
			
		});
		
		remove.setBounds(154, 137, 115, 33);
		panelChoose.add(remove);
		
		JButton update = new JButton("Update Item ");
		update.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
			
		});
		update.setBounds(154, 194, 115, 33);
		panelChoose.add(update);
		
		JLabel lblPleaseSelectAn = new JLabel("Please Select An Option");
		lblPleaseSelectAn.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseSelectAn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPleaseSelectAn.setBounds(55, 13, 331, 51);
		panelChoose.add(lblPleaseSelectAn);
		
		
	}
}

	      


