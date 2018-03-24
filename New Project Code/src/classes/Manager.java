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
import java.sql.SQLException;
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
import javax.swing.JLayeredPane;

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
		private JTextField sec;

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
		frame.setBounds(100, 100, 802, 508);
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
		add_code.setFont(new Font("Open Sans", Font.PLAIN, 20));
		add_code.setBounds(27, 153, 141, 28);
		panel_Add.add(add_code);
		
		JLabel add_name = new JLabel("Name:");
		add_name.setFont(new Font("Open Sans", Font.PLAIN, 20));
		add_name.setBounds(27, 211, 94, 28);
		panel_Add.add(add_name);
		
		JLabel add_price = new JLabel("Price:");
		add_price.setFont(new Font("Open Sans", Font.PLAIN, 20));
		add_price.setBounds(27, 263, 79, 35);
		panel_Add.add(add_price);
		
		JLabel add_descrip = new JLabel("Description:");
		add_descrip.setFont(new Font("Open Sans", Font.PLAIN, 20));
		add_descrip.setBounds(447, 13, 146, 35);
		panel_Add.add(add_descrip);
		
		JLabel add_section = new JLabel("Section:");
		add_section.setFont(new Font("Open Sans", Font.PLAIN, 20));
		add_section.setBounds(27, 311, 94, 35);
		panel_Add.add(add_section);
		
		JLabel add_alergy = new JLabel("Alergy:");
		add_alergy.setFont(new Font("Open Sans", Font.PLAIN, 20));
		add_alergy.setBounds(448, 208, 94, 35);
		panel_Add.add(add_alergy);
		
		add_codeIn = new JTextField();
		add_codeIn.setBounds(175, 153, 165, 35);
		panel_Add.add(add_codeIn);
		add_codeIn.setColumns(10);
		
		add_nameIn = new JTextField();
		add_nameIn.setBounds(175, 211, 165, 35);
		panel_Add.add(add_nameIn);
		add_nameIn.setColumns(10);
		
		add_priceIn = new JTextField();
		add_priceIn.setBounds(175, 266, 165, 35);
		panel_Add.add(add_priceIn);
		add_priceIn.setColumns(10);
		
		add_descripIn = new JTextField();
		add_descripIn.setBounds(448, 46, 284, 136);
		panel_Add.add(add_descripIn);
		add_descripIn.setColumns(10);
		
		add_alergyIn = new JTextField();
		add_alergyIn.setBounds(448, 244, 284, 136);
		panel_Add.add(add_alergyIn);
		add_alergyIn.setColumns(10);
		
		JComboBox add_sectionIn = new JComboBox();
		add_sectionIn.setModel(new DefaultComboBoxModel(new String[] {"", "Drink", "Main", "Side", "Dessert"}));
		add_sectionIn.setBounds(175, 314, 165, 35);
		panel_Add.add(add_sectionIn);
		
		//AL
		//
		JButton add_OK = new JButton("OK");
		add_OK.setFont(new Font("Open Sans", Font.BOLD, 20));
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
		
		add_OK.setBounds(223, 405, 129, 43);
		panel_Add.add(add_OK);
		
		JLabel lblPleaseEnterProduct = new JLabel("Please Enter Product Details");
		lblPleaseEnterProduct.setForeground(new Color(255, 0, 0));
		lblPleaseEnterProduct.setFont(new Font("Open Sans", Font.BOLD, 25));
		lblPleaseEnterProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterProduct.setBounds(12, 13, 402, 82);
		panel_Add.add(lblPleaseEnterProduct);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Open Sans", Font.BOLD, 20));
		btnCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panel_Add.setVisible(false);
				panelChoose.setVisible(true);
			}
		});
		btnCancel.setBounds(363, 405, 129, 43);
		panel_Add.add(btnCancel);
		
		
		panel_Add.setVisible(false);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//PANEL MENU CODE
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lblNewLabel = new JLabel("The Chippy");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 50));
		lblNewLabel.setBounds(190, 71, 413, 69);
		panelMenu.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Open Sans", Font.PLAIN, 20));
		lblEmail.setBackground(UIManager.getColor("Button.background"));
		lblEmail.setBounds(164, 276, 126, 35);
		panelMenu.add(lblEmail);
		
	    JTextField enterEmail = new JTextField();
	    enterEmail.setFont(new Font("Open Sans", Font.PLAIN, 20));
		enterEmail.setBounds(338, 195, 172, 35);
		panelMenu.add(enterEmail);
		enterEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Open Sans", Font.PLAIN, 20));
		lblPassword.setBounds(164, 195, 141, 35);
		panelMenu.add(lblPassword);
		
		enterPassword = new JPasswordField();
		enterPassword.setBounds(338, 267, 172, 35);
		panelMenu.add(enterPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Open Sans", Font.BOLD, 20));
		btnLogin.setBounds(338, 337, 172, 51);
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
		add.setFont(new Font("Open Sans", Font.PLAIN, 20));
		add.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panelChoose.setVisible(false);
				panel_Add.setVisible(true);

			}
		});
		//
		
		add.setBounds(170, 141, 166, 60);
		panelChoose.add(add);
		
		JButton remove = new JButton("Remove Item");
		remove.setFont(new Font("Open Sans", Font.PLAIN, 20));
		remove.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panelChoose.setVisible(false);
				panel_remove.setVisible(true);

				
			}
			
		});
		
		remove.setBounds(170, 274, 166, 60);
		panelChoose.add(remove);
		
		JButton update = new JButton("Update Item ");
		update.setFont(new Font("Open Sans", Font.PLAIN, 20));
		update.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				panelChoose.setVisible(false);
				panel_update.setVisible(true);

			}
			
		});
		update.setBounds(415, 141, 166, 60);
		panelChoose.add(update);
		
		JLabel lblPleaseSelectAn = new JLabel("Please Select An Option");
		lblPleaseSelectAn.setForeground(new Color(255, 0, 0));
		lblPleaseSelectAn.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseSelectAn.setFont(new Font("Open Sans", Font.BOLD, 30));
		lblPleaseSelectAn.setBounds(75, 27, 640, 51);
		panelChoose.add(lblPleaseSelectAn);
		
		//CODE TO CREATE NEW USER 
		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.setFont(new Font("Open Sans", Font.PLAIN, 20));
		btnCreateUser.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panelChoose.setVisible(false);
				panel_user.setVisible(true);

			}
		});
		btnCreateUser.setBounds(415, 274, 166, 60);
		panelChoose.add(btnCreateUser);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setFont(new Font("Open Sans", Font.BOLD, 20));
		btnSignOut.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panelChoose.setVisible(false);
				panelMenu.setVisible(true);
			}
		});
		btnSignOut.setBounds(12, 370, 187, 60);
		panelChoose.add(btnSignOut);
		
		JButton btnViewProducts = new JButton("View Products");
		btnViewProducts.setFont(new Font("Open Sans", Font.BOLD, 20));
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
		btnViewProducts.setBounds(585, 370, 187, 60);
		panelChoose.add(btnViewProducts);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//PANEL REMOVE PANEL
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel remove_code = new JLabel("Product Code:");
		remove_code.setFont(new Font("Open Sans", Font.PLAIN, 20));
		remove_code.setBounds(175, 167, 140, 30);
		panel_remove.add(remove_code);
		
		JLabel remove_name = new JLabel("Name:");
		remove_name.setFont(new Font("Open Sans", Font.PLAIN, 20));
		remove_name.setBounds(175, 237, 104, 30);
		panel_remove.add(remove_name);
		
		remove_codeIn = new JTextField();
		remove_codeIn.setBounds(346, 170, 140, 30);
		panel_remove.add(remove_codeIn);
		remove_codeIn.setColumns(10);
		
		remove_nameIn = new JTextField();
		remove_nameIn.setBounds(346, 240, 140, 30);
		panel_remove.add(remove_nameIn);
		remove_nameIn.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(30, 86, 174, -60);
		panel_remove.add(lblNewLabel_1);
		
		JLabel lblEnterDetailsTo = new JLabel("Enter Details to remove a Product");
		lblEnterDetailsTo.setForeground(new Color(255, 0, 0));
		lblEnterDetailsTo.setFont(new Font("Open Sans", Font.BOLD, 30));
		lblEnterDetailsTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterDetailsTo.setBounds(62, 26, 626, 92);
		panel_remove.add(lblEnterDetailsTo);
		
		JButton remove_OK = new JButton("OK");
		remove_OK.setFont(new Font("Open Sans", Font.BOLD, 20));
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
			       	
			        if(e.getSource()== remove_OK && code2.equals("") || name2.equals(""))
			        {
						 JOptionPane.showMessageDialog(null, "Cannot be left blank, TRY AGAIN","TRY AGAIN", JOptionPane.ERROR_MESSAGE);

			        }
			        
			        else if(code2 != null)
			        {
			        	
			        	String code3 = new String(code2);
			        	
			        	String query1 ="DELETE FROM Product WHERE Product_Code = ? AND Name = ?";
			        	
			        	PreparedStatement ps = conn.prepareStatement(query1);
			        	ps.setString(1, code2);
			        	ps.setString(2, name2);
			     
			        	//ResultSet rs;
			        	ps.execute();
			        	
			        	try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM product where Product_Code = ? AND Name=?"))
			        			{
			        				stmt.setString(1, code3);
			        				stmt.setString(2, name2);

			        			   ResultSet rs =stmt.executeQuery();
			        				
			        				if(rs.next())
			        				{
			        				
			    			        	  JOptionPane.showMessageDialog(null, "Product was not deleted","Please Try again", JOptionPane.ERROR_MESSAGE);
			    			        	  //JOptionPane.showMessageDialog(null, "Product Deleted from Menu","Product Deleted", JOptionPane.INFORMATION_MESSAGE);
				     			          //  panel_remove.setVisible(false);
				     			          //  panelChoose.setVisible(true);
			        				}
			        				
			        				else
			        				{
			    			        	  //JOptionPane.showMessageDialog(null, "Product was not deleted","Please Try again", JOptionPane.ERROR_MESSAGE);

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
		remove_OK.setBounds(327, 301, 110, 37);
		panel_remove.add(remove_OK);
		
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.setFont(new Font("Open Sans", Font.BOLD, 20));
		btnCancel_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panel_remove.setVisible(false);
				panelChoose.setVisible(true);
			}
		});
		btnCancel_1.setBounds(327, 363, 110, 37);
		panel_remove.add(btnCancel_1);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//PANEL_UPDATE CODE
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		JLabel lblEnterInformationTo = new JLabel("Enter Information to Update Product");
		lblEnterInformationTo.setForeground(new Color(255, 0, 0));
		lblEnterInformationTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterInformationTo.setFont(new Font("Open Sans", Font.BOLD, 25));
		lblEnterInformationTo.setBounds(158, 13, 489, 36);
		panel_update.add(lblEnterInformationTo);
		
		JLabel update_code = new JLabel("Product Code:");
		update_code.setFont(new Font("Open Sans", Font.PLAIN, 20));
		update_code.setBounds(175, 72, 145, 16);
		panel_update.add(update_code);
		
		JLabel update_name = new JLabel("Name:");
		update_name.setFont(new Font("Open Sans", Font.PLAIN, 20));
		update_name.setBounds(175, 118, 98, 16);
		panel_update.add(update_name);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Open Sans", Font.PLAIN, 20));
		lblPrice.setBounds(175, 168, 78, 16);
		panel_update.add(lblPrice);
		
		JLabel lblSection = new JLabel("Section:");
		lblSection.setFont(new Font("Open Sans", Font.PLAIN, 20));
		lblSection.setBounds(175, 214, 98, 16);
		panel_update.add(lblSection);
		
		JLabel update_descrip = new JLabel("Description:");
		update_descrip.setFont(new Font("Open Sans", Font.PLAIN, 20));
		update_descrip.setBounds(521, 62, 116, 26);
		panel_update.add(update_descrip);
		
		update_codeIn = new JTextField();
		update_codeIn.setBounds(332, 70, 137, 26);
		panel_update.add(update_codeIn);
		update_codeIn.setColumns(10);
		
		update_nameIn = new JTextField();
		update_nameIn.setBounds(332, 115, 137, 29);
		panel_update.add(update_nameIn);
		update_nameIn.setColumns(10);
		
		update_priceIn = new JTextField();
		update_priceIn.setBounds(332, 166, 137, 26);
		panel_update.add(update_priceIn);
		update_priceIn.setColumns(10);
		
		update_descripIn = new JTextField();
		update_descripIn.setBounds(521, 99, 229, 112);
		panel_update.add(update_descripIn);
		update_descripIn.setColumns(10);
		
		JLabel lblAlergy = new JLabel("Alergy:");
		lblAlergy.setFont(new Font("Open Sans", Font.PLAIN, 20));
		lblAlergy.setBounds(521, 224, 91, 26);
		panel_update.add(lblAlergy);
		
		update_alergyIn = new JTextField();
		update_alergyIn.setBounds(522, 252, 229, 112);
		panel_update.add(update_alergyIn);
		update_alergyIn.setColumns(10);
		
		JButton update_OK = new JButton("Update");
		update_OK.setFont(new Font("Open Sans", Font.BOLD, 20));
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
					 String section3 = sec.getText();
					 String alergy3 = update_alergyIn.getText();
					 
				     //String text = (String)update_sectionIn.getSelectedItem();

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
			        	ps.setString(5, section3);
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
		update_OK.setBounds(507, 395, 116, 36);
		panel_update.add(update_OK);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setFont(new Font("Open Sans", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panel_update.setVisible(false);
				panelChoose.setVisible(true);
			}
		});
		btnNewButton.setBounds(635, 395, 116, 36);
		panel_update.add(btnNewButton);
		
		JLabel lblMain = new JLabel("Main:");
		lblMain.setFont(new Font("Open Sans", Font.PLAIN, 20));
		lblMain.setBounds(12, 72, 68, 21);
		panel_update.add(lblMain);
		
		JComboBox update_main = new JComboBox();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(url+dbName,userName,passwordDB);
	        statement=conn.createStatement(); 
			String s = "Select Name from product WHERE Section = 'Main';";
			ResultSet rs = statement.executeQuery(s);
			
			while(rs.next())
			{
				update_main.addItem(rs.getString(1));
			}
		}
			catch (Exception e3)
			{
				System.out.print(e3);
				
			}
		
		update_main.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
			        Connection conn = DriverManager.getConnection(url+dbName,userName,passwordDB);
			        statement=conn.createStatement(); 
			        
			        String s = "Select * from fast_food.product WHERE Section = 'Main' and Name = ?";
			        PreparedStatement pst = conn.prepareStatement(s);
			        pst.setString(1, (String)update_main.getSelectedItem());
			        java.sql.ResultSet rs=pst.executeQuery();
			        	
			        
			        	while(rs.next()) 
			        	{
			        		update_codeIn.setText(rs.getString("Product_Code"));
			        		update_nameIn.setText(rs.getString("Name"));
			        		update_priceIn.setText(rs.getString("Price"));
			        		update_descripIn.setText(rs.getString("Description"));
			        		update_alergyIn.setText(rs.getString("Alergy"));
			        		sec.setText(rs.getString("Section"));
			        	}
			        	
			        	pst.close();
						} catch (SQLException | ClassNotFoundException e1) 
			    	{
							
							System.out.print(e1);
						}
						
			        
			}
		});
		update_main.setFont(new Font("Open Sans", Font.PLAIN, 20));
		update_main.setBounds(12, 99, 137, 26);
		panel_update.add(update_main);
		
		
       	        
		
		JLabel lblNewLabel_2 = new JLabel("Side:");
		lblNewLabel_2.setFont(new Font("Open Sans", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(12, 147, 56, 16);
		panel_update.add(lblNewLabel_2);
		
		JComboBox update_side = new JComboBox();
		
		update_side.setFont(new Font("Open Sans", Font.PLAIN, 20));
		update_side.setBounds(12, 168, 137, 26);
		panel_update.add(update_side);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(url+dbName,userName,passwordDB);
	        statement=conn.createStatement(); 
			String s = "Select Name from product WHERE Section = 'Side';";
			ResultSet rs = statement.executeQuery(s);
			
			while(rs.next())
			{
				update_side.addItem(rs.getString(1));
			}
		}
			catch (Exception e3)
			{
				System.out.print(e3);
				
			}
		
		update_side.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
			        Connection conn = DriverManager.getConnection(url+dbName,userName,passwordDB);
			        statement=conn.createStatement(); 
			        
			        String s = "Select * from fast_food.product WHERE Section = 'Side' and Name = ?";
			        PreparedStatement pst = conn.prepareStatement(s);
			        pst.setString(1, (String)update_side.getSelectedItem());
			        java.sql.ResultSet rs=pst.executeQuery();
			        	
			        
			        	while(rs.next()) 
			        	{
			        		update_codeIn.setText(rs.getString("Product_Code"));
			        		update_nameIn.setText(rs.getString("Name"));
			        		update_priceIn.setText(rs.getString("Price"));
			        		update_descripIn.setText(rs.getString("Description"));
			        		update_alergyIn.setText(rs.getString("Alergy"));
			        		sec.setText(rs.getString("Section"));
			        	}
			        	
			        	pst.close();
						} catch (SQLException | ClassNotFoundException e1) 
			    	{
							
							System.out.print(e1);
						}
						
			        
			
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Dessert:");
		lblNewLabel_3.setFont(new Font("Open Sans", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(12, 209, 91, 26);
		panel_update.add(lblNewLabel_3);
		
		JComboBox update_dessert = new JComboBox();
		
		update_dessert.setFont(new Font("Open Sans", Font.PLAIN, 20));
		update_dessert.setBounds(12, 241, 137, 26);
		panel_update.add(update_dessert);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(url+dbName,userName,passwordDB);
	        statement=conn.createStatement(); 
			String s = "Select Name from product WHERE Section = 'Dessert';";
			ResultSet rs = statement.executeQuery(s);
			
			while(rs.next())
			{
				update_dessert.addItem(rs.getString(1));
			}
		}
			catch (Exception e3)
			{
				System.out.print(e3);
				
			}
		
		update_dessert.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
			        Connection conn = DriverManager.getConnection(url+dbName,userName,passwordDB);
			        statement=conn.createStatement(); 
			        
			        String s = "Select * from fast_food.product WHERE Section = 'Dessert' and Name = ?";
			        PreparedStatement pst = conn.prepareStatement(s);
			        pst.setString(1, (String)update_dessert.getSelectedItem());
			        java.sql.ResultSet rs=pst.executeQuery();
			        	
			        
			        	while(rs.next()) 
			        	{
			        		update_codeIn.setText(rs.getString("Product_Code"));
			        		update_nameIn.setText(rs.getString("Name"));
			        		update_priceIn.setText(rs.getString("Price"));
			        		update_descripIn.setText(rs.getString("Description"));
			        		update_alergyIn.setText(rs.getString("Alergy"));
			        		sec.setText(rs.getString("Section"));
			        	}
			        	
			        	pst.close();
						} catch (SQLException | ClassNotFoundException e1) 
			    	{
							
							System.out.print(e1);
						}
						
			}
		});
		
		JLabel lblDrink = new JLabel("Drink:");
		lblDrink.setFont(new Font("Open Sans", Font.PLAIN, 20));
		lblDrink.setBounds(12, 280, 68, 16);
		panel_update.add(lblDrink);
		
		JComboBox update_drink = new JComboBox();
		
		update_drink.setFont(new Font("Open Sans", Font.PLAIN, 20));
		update_drink.setBounds(12, 305, 137, 26);
		panel_update.add(update_drink);
		
		sec = new JTextField();
		sec.setBounds(332, 214, 137, 22);
		panel_update.add(sec);
		sec.setColumns(10);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(url+dbName,userName,passwordDB);
	        statement=conn.createStatement(); 
			String s = "Select Name from product WHERE Section = 'Drink';";
			ResultSet rs = statement.executeQuery(s);
			
			while(rs.next())
			{
				update_drink.addItem(rs.getString(1));
			}
			
		    }
			catch (Exception e3)
			{
				System.out.print(e3);
				
			}
		
		update_drink.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
			        Connection conn = DriverManager.getConnection(url+dbName,userName,passwordDB);
			        statement=conn.createStatement(); 
			        
			        String s = "Select * from fast_food.product WHERE Section = 'Drink' and Name = ?";
			        PreparedStatement pst = conn.prepareStatement(s);
			        pst.setString(1, (String)update_drink.getSelectedItem());
			        java.sql.ResultSet rs=pst.executeQuery();
			        	
			        
			        	while(rs.next()) 
			        	{
			        		update_codeIn.setText(rs.getString("Product_Code"));
			        		update_nameIn.setText(rs.getString("Name"));
			        		update_priceIn.setText(rs.getString("Price"));
			        		update_descripIn.setText(rs.getString("Description"));
			        		update_alergyIn.setText(rs.getString("Alergy"));
			        		sec.setText(rs.getString("Section"));
			        	}
			        	
			        	pst.close();
						} catch (SQLException | ClassNotFoundException e1) 
			    	{
							
							System.out.print(e1);
						}
						
				
			}
		});
		
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		//PANEL ADD USER
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		JLabel user_email = new JLabel("Email:");
		user_email.setFont(new Font("Open Sans", Font.PLAIN, 20));
		user_email.setBounds(174, 169, 105, 26);
		panel_user.add(user_email);
		
		JLabel user_pass = new JLabel("Password:");
		user_pass.setFont(new Font("Open Sans", Font.PLAIN, 20));
		user_pass.setBounds(174, 244, 105, 28);
		panel_user.add(user_pass);
		
		user_emailIn = new JTextField();
		user_emailIn.setBounds(317, 168, 159, 35);
		panel_user.add(user_emailIn);
		user_emailIn.setColumns(10);
		user_emailIn.setText(null);
		
		user_passwordIn = new JPasswordField();
		user_passwordIn.setBounds(317, 244, 159, 35);
		panel_user.add(user_passwordIn);
		user_passwordIn.setText(null);

		JButton user_OK = new JButton("Create User");
		user_OK.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				 try {

					 // CODE THAT WILL DISPLAY JTEXTBOX IF THE PASSWORDS OR EMAIL ARE NOT ENTERED CORRECTLY 
					 String email = user_emailIn.getText();
			         String password = user_passwordIn.getText();
				
					 // IF NO DATA ENTERERD TO JTEXTFIELD WILL POP UP ERROR
					 if(e.getSource() == user_OK && email == "" || password == "")
					 {

						 JOptionPane.showMessageDialog(null, "Cannot be left blank, TRY AGAIN","TRY AGAIN", JOptionPane.ERROR_MESSAGE);
					 }
		         
		             // IF EMAIL DOES NOT CONTAIN @ OR .com WILL POP UP BOX INVALID EMIAL ADDRESS
					 else if(e.getSource() == user_OK && !email.contains(".com") || !email.contains("@"))
					 {
						 JOptionPane.showMessageDialog(null, "invalid email, TRY AGAIN","TRY AGAIN", JOptionPane.ERROR_MESSAGE);
					 }
					 
					// try {
					 else {
					//CODE TO VERFIY THE EMAIL ADDRESS AND PASSWORD FROM THE DATABASE 
					Class.forName("com.mysql.jdbc.Driver");
			        Connection conn = DriverManager.getConnection(url+dbName,userName,passwordDB);
			        statement=conn.createStatement(); 
			        
			        String emailAd = user_emailIn.getText();
			        char[] passwd = user_passwordIn.getPassword();
			        String password1 = new String(passwd);
			        
			        
			       // if(passwd != null && emailAd != null)
			      //  {
			        	//String pass = new String(passwd);
			        	String query5 ="INSERT INTO manager values(?,?)";
			        	
			        	PreparedStatement ps = conn.prepareStatement(query5);
			        	ps.setString(1, user_emailIn.getText());
			        	ps.setString(2, user_passwordIn.getText());
			        	
			        	
			        	ps.execute();
  			            JOptionPane.showMessageDialog(null, "User was Registered as Admin","User Added", JOptionPane.INFORMATION_MESSAGE);
				
			        		/*
			        //	try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM manager where Email = ? and Password = ?"))
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
			        	 */
			        	 ps.close();
			        	 conn.close();
			        	// rs.close();
			     // 
					 }
				}catch(Exception ee) 
				{

					System.out.println(ee);

				}
				
			}
		});
		user_OK.setFont(new Font("Open Sans", Font.BOLD, 20));
		user_OK.setBounds(317, 335, 159, 42);
		panel_user.add(user_OK);
		
		JLabel lblInsertNewUser = new JLabel("Insert New User Details");
		lblInsertNewUser.setForeground(new Color(255, 0, 0));
		lblInsertNewUser.setFont(new Font("Open Sans", Font.BOLD, 30));
		lblInsertNewUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertNewUser.setBounds(185, 53, 415, 42);
		panel_user.add(lblInsertNewUser);
		
		JButton btnCancel_2 = new JButton("Cancel");
		btnCancel_2.setFont(new Font("Open Sans", Font.BOLD, 20));
		btnCancel_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panel_update.setVisible(false);
				panelChoose.setVisible(true);
			}
		});
		btnCancel_2.setBounds(317, 390, 159, 42);
		panel_user.add(btnCancel_2);
		
		JButton btnViewUsers = new JButton("View Users");
		btnViewUsers.setFont(new Font("Open Sans", Font.BOLD, 20));
		btnViewUsers.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panel_user.setVisible(true);
				View_Users view = new View_Users();
				view.main(null);
			}
		});
		btnViewUsers.setBounds(613, 390, 159, 42);
		panel_user.add(btnViewUsers);
		
	
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


		
	}
}

	      


