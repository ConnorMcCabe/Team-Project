package Resturaunt;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class GUI {

	private JFrame frmMenu;

	/**
	 * Launch the application.
	 */
	public static void Menu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setTitle("MENU");
		frmMenu.setBounds(100, 100, 1100, 600);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.getContentPane().setLayout(null);
		
		JLabel ImageLabel = new JLabel("");
		ImageLabel.setBounds(311, 42, 432, 364);
		frmMenu.getContentPane().add(ImageLabel);
		
		JTextArea PriceBox = new JTextArea();
		PriceBox.setText("");
		PriceBox.setEditable(false);
		PriceBox.setBounds(402, 484, 341, 20);
		frmMenu.getContentPane().add(PriceBox);
		
		JTextArea DescriptionBox = new JTextArea();
		DescriptionBox.setText("");
		DescriptionBox.setEditable(false);
		DescriptionBox.setBounds(402, 424, 341, 20);
		frmMenu.getContentPane().add(DescriptionBox);
		
		JTextArea AllergenBox = new JTextArea();
		AllergenBox.setText("");
		AllergenBox.setEditable(false);
		AllergenBox.setBounds(402, 452, 341, 20);
		frmMenu.getContentPane().add(AllergenBox);
		
		JTable OrderSummary = new JTable();
		String columns[] = new String[] {"Product", "Price", "Quanity"};
		DefaultTableModel dtm = new DefaultTableModel(columns, 0);
		OrderSummary.setModel(dtm);
		
		OrderSummary.setBounds(780, 46, 294, 426);
		frmMenu.getContentPane().add(OrderSummary);
		
		JLabel lblNewLabel = new JLabel("Main's");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 42, 92, 34);
		frmMenu.getContentPane().add(lblNewLabel);
		
		JComboBox<String> MainCB = new JComboBox<String>();
		MainCB.setModel(new DefaultComboBoxModel<>(new String[] {"Select Main"}));
		MainCB.setBounds(10, 87, 223, 27);
		try
		{
			java.sql.ResultSet rs;
			java.sql.Statement st;
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food","root","pass");
			st = conn.createStatement();
			String s = "Select Name from fast_food.product WHERE Section = 'Main';";
			rs = st.executeQuery(s);
			while(rs.next())
			{
				MainCB.addItem(rs.getString(1));
			}
		}
			catch (Exception x2)
			{
				System.out.print(x2);
				JOptionPane.showMessageDialog(null, "Error");
			}
		MainCB.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent arg0) {
		    	try {
		    	Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food","root","pass");
		        	String s = "Select * from fast_food.product WHERE Section = 'Main' and Name = ?";
		        	PreparedStatement pst = conn.prepareStatement(s);
		        	pst.setString(1, (String)MainCB.getSelectedItem());
		        	java.sql.ResultSet rs=pst.executeQuery();
		        	
		        
		        	while(rs.next()) 
		        	{
		        		PriceBox.setText(rs.getString("Price"));
		        		DescriptionBox.setText(rs.getString("Description"));
		        		//AlergenBox.setText(rs.getString("Allergies"));
		        	}
		        	pst.close();
					} catch (SQLException | ClassNotFoundException e1) 
		    	{
						
						System.out.print(e1);
					}
					
		        }

		    });
			
		frmMenu.getContentPane().add(MainCB);
		
		JLabel lblSides = new JLabel("Side's");
		lblSides.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblSides.setBounds(10, 161, 92, 34);
		frmMenu.getContentPane().add(lblSides);
		
		JComboBox<String> SideCB = new JComboBox<String>();
		SideCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Sides"}));
		SideCB.setBounds(10, 206, 223, 27);
		try
		{
			java.sql.ResultSet rs;
			java.sql.Statement st;
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food","root","pass");
			st = conn.createStatement();
			String s = "Select Name from fast_food.product WHERE Section = 'Side';";
			rs = st.executeQuery(s);
			while(rs.next())
			{
				SideCB.addItem(rs.getString(1));
			}
		}
			catch (Exception x2)
			{
				System.out.print(x2);
				JOptionPane.showMessageDialog(null, "Error");
			}
		SideCB.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent arg0) {
		    	try {
		    	Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food","root","pass");
		        	String s = "Select * from fast_food.product WHERE Section = 'Side' and Name = ?";
		        	PreparedStatement pst = conn.prepareStatement(s);
		        	pst.setString(1, (String)SideCB.getSelectedItem());
		        	java.sql.ResultSet rs=pst.executeQuery();
		        
		        
		        	while(rs.next()) 
		        	{
		        		PriceBox.setText(rs.getString("Price"));
		        		DescriptionBox.setText(rs.getString("Description"));
		        		//AlergenBox.setText(rs.getString("Allergies"));
		        	}
		        	pst.close();
					} catch (SQLException | ClassNotFoundException e1) 
		    	{
						
						System.out.print(e1);
					}
					
		        }

		    });
		frmMenu.getContentPane().add(SideCB);
		
		JLabel lblDesserts = new JLabel("Dessert's");
		lblDesserts.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblDesserts.setBounds(10, 280, 127, 34);
		frmMenu.getContentPane().add(lblDesserts);
		
		JComboBox<String> DessertCB = new JComboBox<String>();
		DessertCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Dessert"}));
		DessertCB.setBounds(10, 325, 223, 27);
		try
		{
			java.sql.ResultSet rs;
			java.sql.Statement st;
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food","root","pass");
			st = conn.createStatement();
			String s = "Select Name from fast_food.product WHERE Section = 'Dessert';";
			rs = st.executeQuery(s);
			while(rs.next())
			{
				DessertCB.addItem(rs.getString(1));
			}
		}
			catch (Exception x2)
			{
				System.out.print(x2);
				JOptionPane.showMessageDialog(null, "Error");
			}
		DessertCB.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent arg0) {
		    	try {
		    	Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food","root","pass");
		        	String s = "Select * from fast_food.product WHERE Section = 'Dessert' and Name = ?";
		        	PreparedStatement pst = conn.prepareStatement(s);
		        	pst.setString(1, (String)DessertCB.getSelectedItem());
		        	java.sql.ResultSet rs=pst.executeQuery();
		        	
		        
		        	while(rs.next()) 
		        	{
		        		PriceBox.setText(rs.getString("Price"));
		        		DescriptionBox.setText(rs.getString("Description"));
		        		//AlergenBox.setText(rs.getString("Allergies"));
		        	}
		        	pst.close();
					} catch (SQLException | ClassNotFoundException e1) 
		    	{
						
						System.out.print(e1);
					}
					
		        }

		    });
		frmMenu.getContentPane().add(DessertCB);
		
		JLabel lblDrinks = new JLabel("Drink's");
		lblDrinks.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblDrinks.setBounds(10, 400, 92, 34);
		frmMenu.getContentPane().add(lblDrinks);
		
		JComboBox<String> DrinkCB = new JComboBox<String>();
		DrinkCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Drink"}));
		DrinkCB.setBounds(10, 445, 223, 27);
		try
		{
			java.sql.ResultSet rs;
			java.sql.Statement st;
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food","root","pass");
			st = conn.createStatement();
			String s = "Select Name from fast_food.product WHERE Section = 'Drink';";
			rs = st.executeQuery(s);
			while(rs.next())
			{
				DrinkCB.addItem(rs.getString(1));
			}
		}
			catch (Exception x2)
			{
				System.out.print(x2);
				JOptionPane.showMessageDialog(null, "Error");
			}
		
		DrinkCB.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent arg0) {
		    	try {
		    	Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food","root","pass");
		        	String s = "Select * from fast_food.product WHERE Section = 'Drink' and Name = ?";
		        	PreparedStatement pst = conn.prepareStatement(s);
		        	pst.setString(1, (String)DrinkCB.getSelectedItem());
		        	java.sql.ResultSet rs=pst.executeQuery();
		        	
		        
		        	while(rs.next()) 
		        	{
		        		PriceBox.setText(rs.getString("Price"));
		        		DescriptionBox.setText(rs.getString("Description"));
		        		//AlergenBox.setText(rs.getString("Allergies"));
		        	}
		        	pst.close();
					} catch (SQLException | ClassNotFoundException e1) 
		    	{
						
						System.out.print(e1);
					}
					
		        }

		    });
		frmMenu.getContentPane().add(DrinkCB);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblDescription.setBounds(300, 417, 98, 27);
		frmMenu.getContentPane().add(lblDescription);
		
		
		
		JLabel lblAllergens = new JLabel("Allergens:");
		lblAllergens.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblAllergens.setBounds(316, 446, 114, 27);
		frmMenu.getContentPane().add(lblAllergens);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblPrice.setBounds(350, 478, 114, 27);
		frmMenu.getContentPane().add(lblPrice);
		
		JLabel lblOrderSummary = new JLabel("Order Summary:");
		lblOrderSummary.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblOrderSummary.setBounds(780, 11, 241, 34);
		frmMenu.getContentPane().add(lblOrderSummary);
		
		JButton DeleteBtn = new JButton("Delete");
		DeleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		DeleteBtn.setBounds(816, 479, 223, 32);
		frmMenu.getContentPane().add(DeleteBtn);
		
		
		
		JButton ConfirmBtn = new JButton("Confirm Order");
		ConfirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ConfirmBtn.setBounds(944, 516, 130, 34);
		frmMenu.getContentPane().add(ConfirmBtn);
		
		JButton addBtn = new JButton("Add To Order");
		addBtn.setBounds(461, 516, 142, 34);
		frmMenu.getContentPane().add(addBtn);
		addBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				
				try {
			    	Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food","root","pass");
			        	String s = "INSERT INTO fast_food.Order_Item(Quantity, Total_Price) VALUES(?, ?) where ID = ?;";
			        	PreparedStatement stmt = conn.prepareStatement(s);
			        	
			        	
				
				}catch(Exception e2)
				{
					System.out.print(e2);
				}
			}
		});
	
	
	JButton CancelBtn = new JButton("Cancel Order");
	CancelBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			WelcomeMenu wm = new WelcomeMenu();
			wm.main(null);
			
			//CloseWindow upon button press
			JComponent comp = (JComponent) arg0.getSource();
	         Window win = SwingUtilities.getWindowAncestor(comp);
	         win.dispose();
		}
		}
	);
	CancelBtn.setBounds(780, 516, 127, 34);
	frmMenu.getContentPane().add(CancelBtn);
	
}
}
