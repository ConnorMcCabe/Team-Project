
package classes;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.ResultSet;
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
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;

public class GUI {

	private JFrame frmMenu;
	private JTextField textField;

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
		//panel_3.setBackground(new Color(115, 168, 212));

		frmMenu.getContentPane().setBackground(new Color(115, 168, 212));
		frmMenu.setTitle("MENU");
		frmMenu.setBounds(100, 100, 1398, 889);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.getContentPane().setLayout(null);
		
		JLabel name = new JLabel("");
		
		JLabel ImageLabel = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\New Project Code\\src\\logo.JPG"));
		ImageLabel.setBounds(335, 94, 432, 364);
		frmMenu.getContentPane().add(ImageLabel);

		
		JTextArea PriceBox = new JTextArea();
		PriceBox.setFont(new Font("Open Sans", Font.PLAIN, 19));
		PriceBox.setText("");
		//PriceBox.setFormat("%.2f");
		PriceBox.setEditable(false);
		PriceBox.setBounds(422, 686, 114, 34);
		frmMenu.getContentPane().add(PriceBox);
		
		JTextArea DescriptionBox = new JTextArea();
		DescriptionBox.setLineWrap(true);

		DescriptionBox.setFont(new Font("Open Sans", Font.PLAIN, 19));
		DescriptionBox.setText("");
		DescriptionBox.setEditable(false);
		DescriptionBox.setBounds(422, 506, 345, 63);
		frmMenu.getContentPane().add(DescriptionBox);
		
		JTextArea AllergenBox = new JTextArea();
		AllergenBox.setLineWrap(true);

		AllergenBox.setFont(new Font("Open Sans", Font.PLAIN, 19));
		AllergenBox.setText("");
		AllergenBox.setEditable(false);
		AllergenBox.setBounds(422, 598, 345, 63);
		frmMenu.getContentPane().add(AllergenBox);
		String columns[] = new String[] {"Product", "Quantity", "Price"};
		DefaultTableModel dtm = new DefaultTableModel(columns, 0);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setFont(new Font("Open Sans", Font.PLAIN, 19));
		scrollPane_1.setBounds(853, 94, 515, 475);
		frmMenu.getContentPane().add(scrollPane_1);
		
		JTable OrderSummary = new JTable();
		OrderSummary.setBackground(Color.WHITE);
		OrderSummary.setFont(new Font("Open Sans", Font.PLAIN, 16));
		scrollPane_1.setViewportView(OrderSummary);
		OrderSummary.setModel(dtm);
		//dtm.addRow(new Object[]{"--Product--", "--Quantity--", "--Price--"});
		
		
		JLabel lblNewLabel = new JLabel("Main's");
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 42, 127, 34);
		frmMenu.getContentPane().add(lblNewLabel);
		
		JComboBox<String> MainCB = new JComboBox<String>();
		MainCB.setBackground(new Color(194, 200, 205));
		MainCB.setFont(new Font("Open Sans", Font.BOLD, 19));
		MainCB.setModel(new DefaultComboBoxModel<>(new String[] {"Select Main"}));
		MainCB.setBounds(10, 87, 225, 40);
		try
		{
			java.sql.ResultSet rs;
			java.sql.Statement st;
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food?autoReconnect=true&useSSL=false","root","password");
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
				java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food?autoReconnect=true&useSSL=false","root","password");
		        	String s = "Select * from fast_food.product WHERE Section = 'Main' and Name = ?";
		        	PreparedStatement pst = conn.prepareStatement(s);
		        	pst.setString(1, (String)MainCB.getSelectedItem());
		        	java.sql.ResultSet rs=pst.executeQuery();
		        	
		        
		        	while(rs.next()) 
		        	{
		        		PriceBox.setText(rs.getString("Price"));
		        		DescriptionBox.setText(rs.getString("Description"));
		        		AllergenBox.setText(rs.getString("Alergy"));
		        		name.setText(rs.getString("Name"));
						
		        		
					
					 byte[] img = rs.getBytes("Image");
		                    //Resize The ImageIcon
		                    ImageIcon image = new ImageIcon(img);
		                    Image im = image.getImage();
		                    Image myImg = im.getScaledInstance(ImageLabel.getWidth(), ImageLabel.getHeight(),Image.SCALE_SMOOTH);
		                    ImageIcon newImage = new ImageIcon(myImg);
		                    ImageLabel.setIcon(newImage);
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
		lblSides.setFont(new Font("Open Sans", Font.BOLD, 30));
		lblSides.setBounds(10, 161, 114, 34);
		frmMenu.getContentPane().add(lblSides);
		
		JComboBox<String> SideCB = new JComboBox<String>();
		SideCB.setFont(new Font("Open Sans", Font.BOLD, 19));
		SideCB.setBackground(new Color(194, 200, 205));
		SideCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Sides"}));
		SideCB.setBounds(10, 206, 225, 40);
		try
		{
			java.sql.ResultSet rs;
			java.sql.Statement st;
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food?autoReconnect=true&useSSL=false","root","password");
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
				java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food?autoReconnect=true&useSSL=false","root","password");
		        	String s = "Select * from fast_food.product WHERE Section = 'Side' and Name = ?";
		        	PreparedStatement pst = conn.prepareStatement(s);
		        	pst.setString(1, (String)SideCB.getSelectedItem());
		        	java.sql.ResultSet rs=pst.executeQuery();
		        
		        
		        	while(rs.next()) 
		        	{
		        		PriceBox.setText(rs.getString("Price"));
		        		DescriptionBox.setText(rs.getString("Description"));
		        		AllergenBox.setText(rs.getString("Alergy"));
		        		name.setText(rs.getString("Name"));
		        		
					
					 byte[] img = rs.getBytes("Image");
		                    //Resize The ImageIcon
		                    ImageIcon image = new ImageIcon(img);
		                    Image im = image.getImage();
		                    Image myImg = im.getScaledInstance(ImageLabel.getWidth(), ImageLabel.getHeight(),Image.SCALE_SMOOTH);
		                    ImageIcon newImage = new ImageIcon(myImg);
		                    ImageLabel.setIcon(newImage);
		        		
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
		lblDesserts.setFont(new Font("Open Sans", Font.BOLD, 30));
		lblDesserts.setBounds(10, 280, 164, 34);
		frmMenu.getContentPane().add(lblDesserts);
		
		JComboBox<String> DessertCB = new JComboBox<String>();
		DessertCB.setFont(new Font("Open Sans", Font.BOLD, 19));
		DessertCB.setBackground(new Color(194, 200, 205));
		DessertCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Dessert"}));
		DessertCB.setBounds(10, 325, 225, 40);
		try
		{
			java.sql.ResultSet rs;
			java.sql.Statement st;
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food?autoReconnect=true&useSSL=false","root","password");
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
				java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food?autoReconnect=true&useSSL=false","root","password");
		        	String s = "Select * from fast_food.product WHERE Section = 'Dessert' and Name = ?";
		        	PreparedStatement pst = conn.prepareStatement(s);
		        	pst.setString(1, (String)DessertCB.getSelectedItem());
		        	java.sql.ResultSet rs=pst.executeQuery();
		        	
		        
		        	while(rs.next()) 
		        	{
		        		PriceBox.setText(rs.getString("Price"));
		        		DescriptionBox.setText(rs.getString("Description"));
		        		AllergenBox.setText(rs.getString("Alergy"));
		        		name.setText(rs.getString("Name"));
		        		
					
					 byte[] img = rs.getBytes("Image");
		                    //Resize The ImageIcon
		                    ImageIcon image = new ImageIcon(img);
		                    Image im = image.getImage();
		                    Image myImg = im.getScaledInstance(ImageLabel.getWidth(), ImageLabel.getHeight(),Image.SCALE_SMOOTH);
		                    ImageIcon newImage = new ImageIcon(myImg);
		                    ImageLabel.setIcon(newImage);
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
		lblDrinks.setFont(new Font("Open Sans", Font.BOLD, 30));
		lblDrinks.setBounds(10, 399, 142, 34);
		frmMenu.getContentPane().add(lblDrinks);
		
		JComboBox<String> DrinkCB = new JComboBox<String>();
		DrinkCB.setFont(new Font("Open Sans", Font.BOLD, 19));
		DrinkCB.setBackground(new Color(194, 200, 205));
		DrinkCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Drink"}));
		DrinkCB.setBounds(10, 445, 225, 40);
		try
		{
			java.sql.ResultSet rs;
			java.sql.Statement st;
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food?autoReconnect=true&useSSL=false","root","password");
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
				java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food?autoReconnect=true&useSSL=false","root","password");
		        	String s = "Select * from fast_food.product WHERE Section = 'Drink' and Name = ?";
		        	PreparedStatement pst = conn.prepareStatement(s);
		        	pst.setString(1, (String)DrinkCB.getSelectedItem());
		        	java.sql.ResultSet rs=pst.executeQuery();
		        	
		        
		        	while(rs.next()) 
		        	{
		        		PriceBox.setText(rs.getString("Price"));
		        		DescriptionBox.setText(rs.getString("Description"));
		        		AllergenBox.setText(rs.getString("Alergy"));
		        		name.setText(rs.getString("Name"));
		        		
					
					 byte[] img = rs.getBytes("Image");
		                    //Resize The ImageIcon
		                    ImageIcon image = new ImageIcon(img);
		                    Image im = image.getImage();
		                    Image myImg = im.getScaledInstance(ImageLabel.getWidth(), ImageLabel.getHeight(),Image.SCALE_SMOOTH);
		                    ImageIcon newImage = new ImageIcon(myImg);
		                    ImageLabel.setIcon(newImage);
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
		lblDescription.setFont(new Font("Open Sans", Font.PLAIN, 25));
		lblDescription.setBounds(276, 531, 187, 27);
		frmMenu.getContentPane().add(lblDescription);
		
		
		
		JLabel lblAllergens = new JLabel("Allergens:");
		lblAllergens.setFont(new Font("Open Sans", Font.PLAIN, 25));
		lblAllergens.setBounds(276, 617, 114, 40);
		frmMenu.getContentPane().add(lblAllergens);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Open Sans", Font.PLAIN, 25));
		lblPrice.setBounds(276, 686, 114, 27);
		frmMenu.getContentPane().add(lblPrice);
		
		JLabel lblOrderSummary = new JLabel("Order Summary:");
		lblOrderSummary.setFont(new Font("Open Sans", Font.BOLD, 30));
		lblOrderSummary.setBounds(853, 42, 294, 34);
		frmMenu.getContentPane().add(lblOrderSummary);
		
		JButton DeleteBtn = new JButton("Delete");
		DeleteBtn.setContentAreaFilled(false);
		DeleteBtn.setBorderPainted(false);
		DeleteBtn.setFont(new Font("Open Sans", Font.BOLD, 20));
		DeleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		DeleteBtn.setBounds(973, 685, 294, 40);
		frmMenu.getContentPane().add(DeleteBtn);
		
		
		
		JButton ConfirmBtn = new JButton("Confirm Order");
		ConfirmBtn.setFont(new Font("Open Sans", Font.BOLD, 20));
		ConfirmBtn.setContentAreaFilled(false);
		ConfirmBtn.setBorderPainted(false);
		ConfirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ConfirmBtn.setBounds(1122, 622, 225, 40);
		frmMenu.getContentPane().add(ConfirmBtn);
		
		JButton addBtn = new JButton("Add To Order");
		addBtn.setContentAreaFilled(false);
		addBtn.setBorderPainted(false);
		addBtn.setFont(new Font("Open Sans", Font.BOLD, 20));
		addBtn.setBounds(444, 755, 225, 52);
		frmMenu.getContentPane().add(addBtn);
		addBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				
				Double fprice = Double.parseDouble(( PriceBox).getText());
				String fname = name.getText();
				
				
				DefaultTableModel dtm = (DefaultTableModel) OrderSummary.getModel();
				dtm.addRow(new Object[]{fname, 1, fprice});
				
				
				int rows = OrderSummary.getRowCount();
				double total = 0;
				
				for(int i =0; i<rows; i++)
				{
					total=total+Double.parseDouble(OrderSummary.getValueAt(i, 2)+"");
				}
			        
			    
				String res = Double.toString(total);
				
				System.out.print(res);
				
				JTextField FinalPrice = new JTextField();
				FinalPrice.setBounds(966, 582, 116, 27);
				frmMenu.getContentPane().add(FinalPrice);
				FinalPrice.setColumns(10);
				FinalPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
				FinalPrice.setEditable(false);
			    FinalPrice.setText(res);
			    
				
			    
				
				
//				try 
//				{
//			    	Class.forName("com.mysql.jdbc.Driver");
//					java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food","root","password");
//			        java.sql.ResultSet rs;
//				
//			        String choice = DescriptionBox.getText();
//			        	
//			        String pd = "SELECT Product_Code From fast_food.Product where Description ='" +choice
//			        		+"'";
//			        PreparedStatement stmt = conn.prepareStatement(pd);
//			        rs = stmt.executeQuery();
//			        
//			        while(rs.next())
//			        {
//			        	
//			        // double price = (rs.getDouble("Price"));
//			         String name = (rs.getString(2));
//			        
//			        // PreparedStatement putIn;
//			         String putIn = "Insert into fast_food.OrderItem" 
//			         +"(Product_Name)"
//			         +"(?)";
//			         PreparedStatement preparedStatement = conn.prepareStatement(putIn);
//			         preparedStatement.setString(5, name);
//			         preparedStatement.executeUpdate();
//			         
//			        }
//			        	
//					stmt.close();
//			        	
//				}catch(Exception e2)
//				{
//					System.out.print(e2);
//				}
				
//				 try {
//					 	Class.forName("com.mysql.jdbc.Driver");
//						java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food","root","password");
//				        PreparedStatement pst;
//			            pst = conn.prepareStatement("select Product_Name, Quantity from fast_food.Order_Item");
//			            java.sql.ResultSet rs = pst.executeQuery();
//			            int i = 0;
//			            if (rs.next()) {
//			                String pname = rs.getString("Name");
//			                int quan = rs.getInt("Quantity");
//			                //OrderSummary.addRow(new Object[]{Product_Name, Quantity});
//			                i++;
//			            }
//				 }
//				 catch(Exception e3)
//			            {
//			            	System.out.print(e3);
//			            }
			}
		});
	
		
//	    
//	    JLabel FinalPrice = new JLabel();
//    	FinalPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
//    	FinalPrice.setBounds(857, 448, 127, 27);
//    	frmMenu.getContentPane().add(FinalPrice);
    	
	JButton CancelBtn = new JButton("Cancel Order");
	CancelBtn.setFont(new Font("Open Sans", Font.BOLD, 20));
	CancelBtn.setContentAreaFilled(false);
	CancelBtn.setBorderPainted(false);
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
	CancelBtn.setBounds(863, 621, 212, 40);
	frmMenu.getContentPane().add(CancelBtn);
	
	JLabel lblTotal = new JLabel("Total:");
	lblTotal.setFont(new Font("Open Sans", Font.BOLD, 30));
	lblTotal.setBounds(853, 582, 101, 27);
	frmMenu.getContentPane().add(lblTotal);
	
	JLabel label = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\New Project Code\\src\\add.png"));
	label.setBounds(419, 744, 83, 74);
	frmMenu.getContentPane().add(label);
	
	JLabel label_1 = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\New Project Code\\src\\remove.png"));
	label_1.setBounds(832, 617, 83, 53);
	frmMenu.getContentPane().add(label_1);
	
	JLabel label_2 = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\New Project Code\\src\\ok.png"));
	label_2.setBounds(1082, 609, 93, 63);
	frmMenu.getContentPane().add(label_2);
	
	JLabel label_3 = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\New Project Code\\src\\bin.png"));
	label_3.setBounds(1005, 674, 93, 69);
	frmMenu.getContentPane().add(label_3);
	
	
    
	//JTextField FinalPrice = new JTextField();
    //FinalPrice.setEditable(false);
   // FinalPrice.setText(res);
	//FinalPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
	//FinalPrice.setBounds(857, 448, 127, 27);
	//frmMenu.getContentPane().add(FinalPrice);

	
	
}
}