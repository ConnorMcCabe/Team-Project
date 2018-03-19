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
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;

import org.jcp.xml.dsig.internal.dom.DOMUtils;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Manager extends JFrame {

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
		private JTextField add_descripIn;
		private JTextField add_alergyIn;		
		private JTextField remove_codeIn;
		private JTextField remove_nameIn;
		private JTextField update_codeIn;
		private JTextField update_nameIn;
		private JTextField update_priceIn;
		private JTextField update_descripIn;
		private JTextField update_alergyIn;
		private JTextField user_emailIn;
		private JPasswordField user_passwordIn;

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
		
		//JRAME CREATION AND ALL SEPERATE JPANEL CODE
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		frame = new JFrame();
		frame.setBounds(100, 100, 477, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel panelMenu = new JPanel();
		panelMenu.setBackground(UIManager.getColor("Button.background"));
		panelMenu.setForeground(Color.BLACK);
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
		
		JPanel panel_remove = new JPanel();
		frame.getContentPane().add(panel_remove, "name_44676578512252");
		panel_remove.setLayout(null);
		panel_remove.setVisible(false);
		
		JPanel panel_update = new JPanel();
		frame.getContentPane().add(panel_update, "name_21178903507949");
		panel_update.setLayout(null);
		panel_update.setVisible(false);

		JPanel panel_user = new JPanel();
		frame.getContentPane().add(panel_user, "name_1167324204295");
		panel_user.setLayout(null);
		panel_user.setVisible(false);


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
		
		JLabel add_section = new JLabel("Section:");
		add_section.setBounds(12, 136, 56, 16);
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
		
		add_descripIn = new JTextField();
		add_descripIn.setBounds(238, 63, 170, 62);
		panel_Add.add(add_descripIn);
		add_descripIn.setColumns(10);
		
		add_alergyIn = new JTextField();
		add_alergyIn.setBounds(238, 150, 170, 62);
		panel_Add.add(add_alergyIn);
		add_alergyIn.setColumns(10);
		
		JComboBox add_sectionIn = new JComboBox();
		add_sectionIn.setModel(new DefaultComboBoxModel(new String[] {"", "Drink", "Main", "Side", "Dessert"}));
		add_sectionIn.setBounds(110, 133, 116, 22);
		panel_Add.add(add_sectionIn);
		
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
					// String section1 = add_sectionIn.getText();
					 String alergy1 = add_alergyIn.getText();
						
					//CODE TO VERFIY THE EMAIL ADDRESS AND PASSWORD FROM THE DATABASE 
					Class.forName("com.mysql.jdbc.Driver");
			        Connection conn = DriverManager.getConnection(url+dbName,userName,passwordDB);
			        statement=conn.createStatement(); 
			       
			        
			        String text = (String)add_sectionIn.getSelectedItem();
			       	        
			        if(code1 != null)
			        {
			        	
			        	String code = new String(code1);
			        	String query1 ="INSERT INTO Product values (?,?,?,?,?,?)";
			        	
			        	PreparedStatement ps = conn.prepareStatement(query1);
			        	ps.setString(1, code1);
			        	ps.setString(2, name1);
			        	ps.setString(3, price1);
			        	ps.setString(4, descrip1);
			        	ps.setString(5, text);
			        	ps.setString(6, alergy1);

			        	//ResultSet rs;
			        	ps.execute();
			        
				
			        	
			        	try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM product where Product_Code = ?"))
			        			{
			        				stmt.setString(1, code1);
			        				ResultSet rs =stmt.executeQuery();
			        				
			        				if(rs.next())
			        				{
			     			           JOptionPane.showMessageDialog(null, "New Product Was Added to Menu","Product Added", JOptionPane.INFORMATION_MESSAGE);
			     			           panel_Add.setVisible(false);
			     			           panelChoose.setVisible(true);
			     			           
			        				}
			        				
			        				else
			        				{
			    			        	 JOptionPane.showMessageDialog(null, "Incorrect Password or Email, logIn","Please Try again", JOptionPane.ERROR_MESSAGE);

			        				}
			        			}

			        	
			        	 conn.close();
			        }
				}catch(Exception ee) 
				{
					 JOptionPane.showMessageDialog(null, "Cannot be left blank, TRY AGAIN","TRY AGAIN", JOptionPane.ERROR_MESSAGE);

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
		lblPleaseEnterProduct.setBounds(65, 13, 319, 16);
		panel_Add.add(lblPleaseEnterProduct);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panel_Add.setVisible(false);
				panelChoose.setVisible(true);
			}
		});
		btnCancel.setBounds(272, 263, 97, 25);
		panel_Add.add(btnCancel);
		
		
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
		lblEmail.setBounds(129, 92, 56, 16);
		panelMenu.add(lblEmail);
		
	    JTextField enterEmail = new JTextField();
		enterEmail.setBounds(212, 89, 116, 22);
		panelMenu.add(enterEmail);
		enterEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(129, 127, 68, 16);
		panelMenu.add(lblPassword);
		
		enterPassword = new JPasswordField();
		enterPassword.setBounds(212, 124, 116, 22);
		panelMenu.add(enterPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(167, 189, 97, 25);
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
		
		add.setBounds(75, 91, 115, 33);
		panelChoose.add(add);
		
		JButton remove = new JButton("Remove Item");
		remove.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panelChoose.setVisible(false);
				panel_remove.setVisible(true);

				
			}
			
		});
		
		remove.setBounds(75, 164, 115, 33);
		panelChoose.add(remove);
		
		JButton update = new JButton("Update Item ");
		update.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				panelChoose.setVisible(false);
				panel_update.setVisible(true);

			}
			
		});
		update.setBounds(254, 91, 115, 33);
		panelChoose.add(update);
		
		JLabel lblPleaseSelectAn = new JLabel("Please Select An Option");
		lblPleaseSelectAn.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseSelectAn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPleaseSelectAn.setBounds(55, 13, 331, 51);
		panelChoose.add(lblPleaseSelectAn);
		
		//CODE TO CREATE NEW USER 
		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panelChoose.setVisible(false);
				panel_user.setVisible(true);

			}
		});
		btnCreateUser.setBounds(253, 164, 116, 33);
		panelChoose.add(btnCreateUser);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panelChoose.setVisible(false);
				panelMenu.setVisible(true);
			}
		});
		btnSignOut.setBounds(12, 248, 100, 29);
		panelChoose.add(btnSignOut);
		
		JButton btnViewProducts = new JButton("View Products");
		btnViewProducts.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnViewProducts.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panelChoose.setVisible(true);
				View_Products products = new View_Products();
				products.main(null);
				//panelChoose.setVisible(true);

				//getClass().panelChoose.setVisible(false);
				//products.setVisible(true);
				//panelChoose.setVisible(false);
				//panel_view.setVisible(true);
			}
		});
		btnViewProducts.setBounds(309, 250, 138, 29);
		panelChoose.add(btnViewProducts);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//PANEL REMOVE PANEL
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel remove_code = new JLabel("Product Code:");
		remove_code.setBounds(100, 86, 87, 16);
		panel_remove.add(remove_code);
		
		JLabel remove_name = new JLabel("Name:");
		remove_name.setBounds(100, 132, 56, 16);
		panel_remove.add(remove_name);
		
		remove_codeIn = new JTextField();
		remove_codeIn.setBounds(199, 83, 116, 22);
		panel_remove.add(remove_codeIn);
		remove_codeIn.setColumns(10);
		
		remove_nameIn = new JTextField();
		remove_nameIn.setBounds(199, 129, 116, 22);
		panel_remove.add(remove_nameIn);
		remove_nameIn.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(30, 86, 174, -60);
		panel_remove.add(lblNewLabel_1);
		
		JLabel lblEnterDetailsTo = new JLabel("Enter Details to remove a Product");
		lblEnterDetailsTo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterDetailsTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterDetailsTo.setBounds(82, 27, 279, 27);
		panel_remove.add(lblEnterDetailsTo);
		
		JButton remove_OK = new JButton("OK");
		remove_OK.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{		
					 String code2 = remove_codeIn.getText();
					 String name2 = remove_nameIn.getText();
						
					//CODE TO VERFIY THE EMAIL ADDRESS AND PASSWORD FROM THE DATABASE 
					Class.forName("com.mysql.jdbc.Driver");
			        Connection conn = DriverManager.getConnection(url+dbName,userName,passwordDB);
			        statement=conn.createStatement(); 
			       	
			        if(e.getSource()== remove_OK && remove_codeIn.equals("") || remove_nameIn.equals(""))
			        {
						 JOptionPane.showMessageDialog(null, "Cannot be left blank, TRY AGAIN","TRY AGAIN", JOptionPane.ERROR_MESSAGE);

			        }
			        
			        if(code2 != null)
			        {
			        	
			        	String code3 = new String(code2);
			        	
			        	String query1 ="DELETE FROM Product WHERE Product_Code = ? AND Name = ?";
			        	
			        	PreparedStatement ps = conn.prepareStatement(query1);
			        	ps.setString(1, code2);
			        	ps.setString(2, name2);
			     
			        	//ResultSet rs;
			        	ps.execute();
			        	
			        	try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM product where Product_Code = ?"))
			        			{
			        				stmt.setString(1, code3);
			        				ResultSet rs =stmt.executeQuery();
			        				
			        				if(rs.next())
			        				{
			        				
			    			        	  JOptionPane.showMessageDialog(null, "Product was not deleted","Please Try again", JOptionPane.ERROR_MESSAGE);

			        				}
			        				
			        				else
			        				{
			    			        	    JOptionPane.showMessageDialog(null, "Product Deleted from Menu","Product Deleted", JOptionPane.INFORMATION_MESSAGE);
				     			            panel_remove.setVisible(false);
				     			            panelChoose.setVisible(true);

			        				}
			        			}

			        	
			        	 conn.close();
			        }
				}catch(Exception ee) 
				{

					System.out.println(ee);

				}
				
				
			}
		});
		remove_OK.setBounds(156, 185, 97, 25);
		panel_remove.add(remove_OK);
		
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panel_remove.setVisible(false);
				panelChoose.setVisible(true);
			}
		});
		btnCancel_1.setBounds(156, 226, 97, 25);
		panel_remove.add(btnCancel_1);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//PANEL_UPDATE CODE
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		JLabel lblEnterInformationTo = new JLabel("Enter Information to Update Product");
		lblEnterInformationTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterInformationTo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterInformationTo.setBounds(86, 13, 321, 26);
		panel_update.add(lblEnterInformationTo);
		
		JLabel update_code = new JLabel("Product Code:");
		update_code.setBounds(12, 60, 91, 16);
		panel_update.add(update_code);
		
		JLabel update_name = new JLabel("Name:");
		update_name.setBounds(12, 89, 56, 16);
		panel_update.add(update_name);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(12, 118, 56, 16);
		panel_update.add(lblPrice);
		
		JLabel lblSection = new JLabel("Section:");
		lblSection.setBounds(12, 147, 56, 16);
		panel_update.add(lblSection);
		
		JLabel update_descrip = new JLabel("Description:");
		update_descrip.setBounds(235, 60, 78, 16);
		panel_update.add(update_descrip);
		
		update_codeIn = new JTextField();
		update_codeIn.setBounds(96, 57, 116, 22);
		panel_update.add(update_codeIn);
		update_codeIn.setColumns(10);
		
		update_nameIn = new JTextField();
		update_nameIn.setBounds(96, 86, 116, 22);
		panel_update.add(update_nameIn);
		update_nameIn.setColumns(10);
		
		update_priceIn = new JTextField();
		update_priceIn.setBounds(96, 115, 116, 22);
		panel_update.add(update_priceIn);
		update_priceIn.setColumns(10);
		
		update_descripIn = new JTextField();
		update_descripIn.setBounds(235, 77, 154, 60);
		panel_update.add(update_descripIn);
		update_descripIn.setColumns(10);
		
		JLabel lblAlergy = new JLabel("Alergy:");
		lblAlergy.setBounds(234, 147, 56, 16);
		panel_update.add(lblAlergy);
		
		update_alergyIn = new JTextField();
		update_alergyIn.setBounds(235, 164, 154, 60);
		panel_update.add(update_alergyIn);
		update_alergyIn.setColumns(10);
		
		JComboBox update_sectionIn = new JComboBox();
		update_sectionIn.setModel(new DefaultComboBoxModel(new String[] {"", "Drink", "Main", "Side", "Dessert"}));
		update_sectionIn.setBounds(96, 144, 116, 22);
		panel_update.add(update_sectionIn);
		
		JButton update_OK = new JButton("Update");
		update_OK.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{

				try 
				{		
					 String code3 = update_codeIn.getText();
					 String name3 = update_nameIn.getText();
					 String price3 = update_priceIn.getText();
					 String descrip3 = update_descripIn.getText();
					 //String section3 = update_sectionIn.getText();
					 String alergy3 = update_alergyIn.getText();
					 
				     String text = (String)update_sectionIn.getSelectedItem();

					//CODE TO VERFIY THE EMAIL ADDRESS AND PASSWORD FROM THE DATABASE 
					Class.forName("com.mysql.jdbc.Driver");
			        Connection conn = DriverManager.getConnection(url+dbName,userName,passwordDB);
			        statement=conn.createStatement(); 
			       	        
			        if(code3 != null)
			        {
			        	
			        	String code = new String(code3);
			        	String query1 ="UPDATE Product SET Product_Code=?, Name=?, Price=?, Description=?, Section=?, Alergy=? WHERE Product_Code= ?";
			        	
			        	PreparedStatement ps = conn.prepareStatement(query1);
			        	ps.setString(1, code3);
			        	ps.setString(2, name3);
			        	ps.setString(3, price3);
			        	ps.setString(4, descrip3);
			        	ps.setString(5, text);
			        	ps.setString(6, alergy3);
			        	ps.setString(7, code3);


			        	//ResultSet rs;
			        	ps.execute();
			        	try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM product where Product_Code = ?"))
			        			{
			        				stmt.setString(1, code3);
			        				ResultSet rs =stmt.executeQuery();
			        				
			        				if(rs.next())
			        				{
			     			           JOptionPane.showMessageDialog(null, "Product was Updated","Product Updated", JOptionPane.INFORMATION_MESSAGE);
			     			           panel_update.setVisible(false);
			     			           panelChoose.setVisible(true);
			     			           
			        				}
			        				
			        				else
			        				{
				     			           JOptionPane.showMessageDialog(null, "Product Not Updated","Product Not Updated", JOptionPane.ERROR_MESSAGE);

			        				}
			        			}

			        	
			        	 conn.close();
			        }
				}catch(Exception ee) 
				{
					 JOptionPane.showMessageDialog(null, "Cannot be left blank, TRY AGAIN","TRY AGAIN", JOptionPane.ERROR_MESSAGE);

					System.out.println(ee);

				}
				
			}
		});
		update_OK.setBounds(265, 231, 97, 25);
		panel_update.add(update_OK);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panel_update.setVisible(false);
				panelChoose.setVisible(true);
			}
		});
		btnNewButton.setBounds(265, 269, 97, 25);
		panel_update.add(btnNewButton);
		
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		//PANEL ADD USER
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		JLabel user_email = new JLabel("Email:");
		user_email.setBounds(106, 100, 56, 16);
		panel_user.add(user_email);
		
		JLabel user_pass = new JLabel("Password:");
		user_pass.setBounds(106, 139, 67, 16);
		panel_user.add(user_pass);
		
		user_emailIn = new JTextField();
		user_emailIn.setBounds(197, 97, 116, 22);
		panel_user.add(user_emailIn);
		user_emailIn.setColumns(10);
		
		user_passwordIn = new JPasswordField();
		user_passwordIn.setBounds(197, 136, 116, 22);
		panel_user.add(user_passwordIn);
		
		JButton user_OK = new JButton("Create User");
		user_OK.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{		
					 // CODE THAT WILL DISPLAY JTEXTBOX IF THE PASSWORDS OR EMAIL ARE NOT ENTERED CORRECTLY 
					 String email = user_emailIn.getText();
			         String password = user_passwordIn.getText();
				
					 // IF NO DATA ENTERERD TO JTEXTFIELD WILL POP UP ERROR
					 if(e.getSource() == btnLogin && email.equals("") || password.equals(""))
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
			        
			        //String emailAd = enterEmail.getText();
			        char[] passwd = user_passwordIn.getPassword();
			        String password1 = new String(passwd);
			        
			        
			        if(email != null)
			        {
			        	//String pass = new String(passwd);
			        	String query1 ="INSERT INTO manager(Email, Password) values(?,?)";
			        	
			        	PreparedStatement ps = conn.prepareStatement(query1);
			        	ps.setString(1, email);
			        	ps.setString(2, password1);
			        	
			        	ps.execute();


			        	try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM manager where Email = ? and Password = ?"))
			        			{
			        				stmt.setString(1, email);
			        				stmt.setString(2, password1);

			        				ResultSet rs =stmt.executeQuery();
			        				
			        				if(rs.next())
			        				{
			     			           JOptionPane.showMessageDialog(null, "User was Registered as Admin","User Added", JOptionPane.INFORMATION_MESSAGE);
			     			           panel_user.setVisible(false);
			     			           panelChoose.setVisible(true);
			     			           
			        				}
			        				
			        				else
			        				{
			    			        	 JOptionPane.showMessageDialog(null, "User was not created","Please Try again", JOptionPane.ERROR_MESSAGE);

			        				}
			        			}
			        	 
			        	 ps.close();
			        	 conn.close();
			        }
				}catch(Exception ee) 
				{

					System.out.println(ee);

				}
				
			}
		});
		user_OK.setFont(new Font("Tahoma", Font.BOLD, 13));
		user_OK.setBounds(157, 180, 116, 25);
		panel_user.add(user_OK);
		
		JLabel lblInsertNewUser = new JLabel("Insert New User Details");
		lblInsertNewUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInsertNewUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertNewUser.setBounds(88, 35, 261, 16);
		panel_user.add(lblInsertNewUser);
		
		JButton btnCancel_2 = new JButton("Cancel");
		btnCancel_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panel_update.setVisible(false);
				panelChoose.setVisible(true);
			}
		});
		btnCancel_2.setBounds(165, 218, 97, 25);
		panel_user.add(btnCancel_2);
		
		JButton btnViewUsers = new JButton("View Users");
		btnViewUsers.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panel_user.setVisible(true);
				View_Users view = new View_Users();
				view.main(null);
			}
		});
		btnViewUsers.setBounds(319, 256, 97, 25);
		panel_user.add(btnViewUsers);
		
	
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


		
	}
}

	      


