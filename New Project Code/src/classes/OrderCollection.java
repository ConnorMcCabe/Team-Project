package classes;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class OrderCollection {
	
	/* Database Variables */
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ppdStmt = null;

	private JFrame frame;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderCollection window = new OrderCollection();
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
	public OrderCollection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 950, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 244, 147));
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 11, 910, 147);
		frame.getContentPane().add(scrollPane);
		
		/******************* ORDER STATUS LABEL AND COMBO BOX ********************/
		
		JLabel lblOrderStatus = new JLabel("Order Status");
		lblOrderStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOrderStatus.setBounds(496, 263, 170, 35);
		frame.getContentPane().add(lblOrderStatus);

		JComboBox<String> orderStatusBox = new JComboBox<String>();
		orderStatusBox.setModel(new DefaultComboBoxModel(new String[] {"Ready", "Not ready"}));
		orderStatusBox.setForeground(new Color(0,0,0));
		orderStatusBox.setBackground(new Color(255, 255, 102));
		orderStatusBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		orderStatusBox.setBounds(676, 266, 168, 30);
		try
		{
			java.sql.ResultSet rs;
			java.sql.Statement st;
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fast_Food","root","password");
			st = conn.createStatement();
			String s = "Select Order_Status from fast_food.order;";
			rs = st.executeQuery(s);
		}
		catch (Exception x2)
		{
			System.out.print(x2);
			JOptionPane.showMessageDialog(null, "Error");
		}
		
		frame.getContentPane().add(orderStatusBox);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Order No.", "Order Status", "Time"
			}
		));
		
		JButton refreshBtn = new JButton("Refresh");
		refreshBtn.setForeground(new Color(0, 0, 0));
		refreshBtn.setBackground(new Color(255, 255, 102));
		refreshBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		refreshBtn.setBounds(10, 477, 120, 23);
		frame.getContentPane().add(refreshBtn);
		
		
		

		
		/******************** ORDER NUMBER LABEL AND COMBO BOX ********************/
		
		JLabel lblOrderNumber = new JLabel("Order Number ");
		lblOrderNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOrderNumber.setBounds(10, 266, 120, 30);
		frame.getContentPane().add(lblOrderNumber);
		
		JComboBox<String> orderNumBox = new JComboBox();
		orderNumBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		orderNumBox.setForeground(new Color(0, 0, 0));
		orderNumBox.setBackground(new Color(255, 255, 255));
		orderNumBox.setModel(new DefaultComboBoxModel(new String[] {"Select Order number"}));
		orderNumBox.setBounds(140, 266, 216, 30);
		try
		{
			java.sql.ResultSet rs;
			java.sql.Statement st;
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food","root","password");
			st = conn.createStatement();
			String s = "Select Order_Number from fast_food.order;";
			rs = st.executeQuery(s);
			while(rs.next())
			{
				orderNumBox.addItem(rs.getString(1));
			}
		}
		catch (Exception x2)
		{
			System.out.print(x2);
			JOptionPane.showMessageDialog(null, "Error");
		}
		orderNumBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
		    	try {
		    	Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food","root","password");
		        	String s = "Select * from fast_food.order WHERE Order_Number = ?";

		        	if(orderNumBox.getSelectedItem() != "Select Order")
		        	{		        				        	
		        	PreparedStatement ppdStmt = conn.prepareStatement(s);
		        	ppdStmt.setString(1, (String)orderNumBox.getSelectedItem());
		        	java.sql.ResultSet rs=ppdStmt.executeQuery();
		        	table_1.setModel(DbUtils.resultSetToTableModel(rs));	
		        	} 
		        	else
		        	{		
		        		String se ="Select * from fast_food.order";
		        		PreparedStatement pst = conn.prepareStatement(se);
			        	java.sql.ResultSet rs=pst.executeQuery();
			        	table_1.setModel(DbUtils.resultSetToTableModel(rs));	        		
		        	pst.close();}
					}
		    		catch (SQLException | ClassNotFoundException eO1) 
		    		{		
		    			System.out.print(eO1);
		    		}
			}
		});
		frame.getContentPane().add(orderNumBox);
		
		JButton setStatusBtn = new JButton("Set Order Status");
		setStatusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String s = "UPDATE fast_food.order SET Order_Status = ? where Order_Number=?";
					PreparedStatement ppdStmt = conn.prepareStatement(s);
					ppdStmt.setString(1, (String)orderStatusBox.getSelectedItem());
					ppdStmt.setString(2, (String)orderNumBox.getSelectedItem());
					if(orderNumBox.getSelectedItem() == "Select Order")
		        	{
		        		JOptionPane.showMessageDialog(null, "You may not have selected a number, please try again!","Invalid Selection", JOptionPane.INFORMATION_MESSAGE);
		        	}
		        	else {
		        	ppdStmt.setString(2, (String)orderNumBox.getSelectedItem());
					int rs=ppdStmt.executeUpdate();
					ppdStmt = conn.prepareStatement(s);
					rs = ppdStmt.executeUpdate();
					ppdStmt.close();}
				}
				catch(SQLException e1) {
					System.out.print("");
				}
			}
		});
		setStatusBtn.setForeground(new Color(0, 0, 0));
		setStatusBtn.setBackground(new Color(255, 255, 102)); 
		setStatusBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		setStatusBtn.setBounds(496, 334, 202, 68);
		frame.getContentPane().add(setStatusBtn);
				
		
	}
}
