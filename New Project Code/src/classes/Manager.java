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
		private JTextField add_codeIn;
		private JTextField add_nameIn;
		private JTextField add_priceIn;
		private JTextField add_sectionIn;
		private JTextField add_descripIn;
		private JTextField add_alergyIn;		

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
		
		//JRAME CREATION AND JPANEL CODE
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
		
		final JPanel panel_Add = new JPanel();
		frame.getContentPane().add(panel_Add, "name_10478840946849");
		panel_Add.setLayout(null);
		panel_Add.setVisible(false);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//PANEL ADD CODE
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


		JLabel add_code = new JLabel("Product Code:");
		add_code.setBounds(12, 46, 94, 16);
		panel_Add.add(add_code);
		
		JLabel add_name = new JLabel("Name:");
		add_name.setBounds(12, 75, 56, 16);
		panel_Add.add(add_name);
		
		JLabel add_price = new JLabel("Price:");
		add_price.setBounds(12, 104, 56, 16);
		panel_Add.add(add_price);
		
		JLabel add_descrip = new JLabel("Description:");
		add_descrip.setBounds(238, 46, 94, 16);
		panel_Add.add(add_descrip);
		
		JLabel add_section = new JLabel("Section");
		add_section.setBounds(12, 133, 56, 16);
		panel_Add.add(add_section);
		
		JLabel add_alergy = new JLabel("Alergy:");
		add_alergy.setBounds(238, 133, 56, 16);
		panel_Add.add(add_alergy);
		
		add_codeIn = new JTextField();
		add_codeIn.setBounds(110, 43, 116, 22);
		panel_Add.add(add_codeIn);
		add_codeIn.setColumns(10);
		
		add_nameIn = new JTextField();
		add_nameIn.setBounds(110, 72, 116, 22);
		panel_Add.add(add_nameIn);
		add_nameIn.setColumns(10);
		
		add_priceIn = new JTextField();
		add_priceIn.setBounds(110, 101, 116, 22);
		panel_Add.add(add_priceIn);
		add_priceIn.setColumns(10);
		
		add_sectionIn = new JTextField();
		add_sectionIn.setBounds(110, 130, 116, 22);
		panel_Add.add(add_sectionIn);
		add_sectionIn.setColumns(10);
		
		add_descripIn = new JTextField();
		add_descripIn.setBounds(238, 63, 170, 62);
		panel_Add.add(add_descripIn);
		add_descripIn.setColumns(10);
		
		add_alergyIn = new JTextField();
		add_alergyIn.setBounds(238, 150, 170, 62);
		panel_Add.add(add_alergyIn);
		add_alergyIn.setColumns(10);
		
		//AL
		//
		JButton add_OK = new JButton("OK");
		add_OK.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{		
					 String code1 = add_codeIn.getText();
					 String name1 = add_nameIn.getText();
					 String price1 = add_priceIn.getText();
					 String descrip1 = add_descripIn.getText();
					 String section1 = add_sectionIn.getText();
					 String alergy1 = add_alergyIn.getText();
						
					//CODE TO VERFIY THE EMAIL ADDRESS AND PASSWORD FROM THE DATABASE 
					Class.forName("com.mysql.jdbc.Driver");
			        Connection conn = DriverManager.getConnection(url+dbName,userName,passwordDB);
			        statement=conn.createStatement(); 
			       	        
			        if(code1 != null)
			        {
			        	
			        	String code = new String(code1);
			        	String query1 ="INSERT INTO Product values (?,?,?,?,?,?)";
			        	
			        	PreparedStatement ps = conn.prepareStatement(query1);
			        	ps.setString(1, code1);
			        	ps.setString(2, name1);
			        	ps.setString(3, price1);
			        	ps.setString(4, descrip1);
			        	ps.setString(5, section1);
			        	ps.setString(6, alergy1);

			        	//ResultSet rs;
			        	ps.execute();
			        	
			        	 
			        	// if(ps.next())
			        	// {  
			           //      JOptionPane.showMessageDialog(null, "New Product Was Added to Menu","Product Added", JOptionPane.INFORMATION_MESSAGE);

			        	// }
			        	 
			        	 //else
			        	// {
			        	//	 JOptionPane.showMessageDialog(null, "Incorrect Password or Email, logIn","Please Try again", JOptionPane.ERROR_MESSAGE);

			        	// }
			        	 
			        	 //ps.close();
			        	// rs.close();
			        	 conn.close();
			        }
				}catch(Exception ee) 
				{
					System.out.println(ee);

				}
				
			}
		});
		//
		
		add_OK.setBounds(272, 225, 97, 25);
		panel_Add.add(add_OK);
		
		JLabel lblPleaseEnterProduct = new JLabel("Please Enter Product Detilas");
		lblPleaseEnterProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPleaseEnterProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterProduct.setBounds(50, 13, 319, 16);
		panel_Add.add(lblPleaseEnterProduct);
		panel_Add.setVisible(false);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//PANEL MENU CODE
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
		
		//AL
		// 
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//panelChoose.setVisible(true);

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
			//
		});

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//PANEL CHOOSE CODE
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//
		// AL
		JButton add = new JButton("Add Item");
		add.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panelChoose.setVisible(false);
				panel_Add.setVisible(true);

			}
		});
		//
		
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
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
	}
}

	      


