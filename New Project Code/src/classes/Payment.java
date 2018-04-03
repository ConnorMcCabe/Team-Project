package classes;

import java.awt.EventQueue;

import javax.swing.JFrame;

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

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;


public class Payment {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	//VARIABLES FOR DATABSE CONNECTION
	private String url = "jdbc:mysql://localhost:3306/";
	private String dbName = "fast_food?autoReconnect=true&useSSL=false";
	private String driver = "com.mysql.jdbc.Driver";
	private String userName = "root";
	private String passwordDB = "password";
	private Statement statement = null;   
    private ResultSet resultSet = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment window = new Payment();
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
	public Payment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
	    
		frame.getContentPane().setFont(new Font("Open Sans", Font.BOLD, 20));
		frame.getContentPane().setBackground(new Color(115, 168, 212));

		frame.setBounds(100, 100, 1098, 775);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPleaseEnterCard = new JLabel("Please Enter Card Details");
		lblPleaseEnterCard.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 50));
		lblPleaseEnterCard.setBounds(0, 13, 929, 151);
		frame.getContentPane().add(lblPleaseEnterCard);
		
		JLabel lblCardType = new JLabel("Card Type:");
		lblCardType.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblCardType.setBounds(271, 231, 116, 28);
		frame.getContentPane().add(lblCardType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Visa ", "Mastercard"}));
		comboBox.setFont(new Font("Open Sans", Font.BOLD, 20));
		comboBox.setBounds(501, 228, 175, 34);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNumber.setBounds(271, 286, 116, 28);
		frame.getContentPane().add(lblNumber);
		
		textField = new JTextField();
		textField.setFont(new Font("Open Sans", Font.PLAIN, 19));
		textField.setBounds(501, 284, 175, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCsv = new JLabel("CCV:");
		lblCsv.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblCsv.setBounds(271, 340, 94, 34);
		frame.getContentPane().add(lblCsv);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Open Sans", Font.PLAIN, 19));
		textField_1.setBounds(501, 341, 83, 34);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEx = new JLabel("Expiry Date (MM/YY):");
		lblEx.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblEx.setBounds(271, 397, 212, 34);
		frame.getContentPane().add(lblEx);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Open Sans", Font.PLAIN, 19));
		textField_2.setBounds(501, 398, 83, 34);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
			
		});
		btnConfirm.setContentAreaFilled(false);
		btnConfirm.setBorderPainted(false);
		btnConfirm.setFont(new Font("Open Sans", Font.BOLD, 20));
		btnConfirm.setBounds(512, 497, 221, 51);
		frame.getContentPane().add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
				Class.forName("com.mysql.jdbc.Driver");
		        Connection conn = DriverManager.getConnection(url+dbName,userName,passwordDB);
		        statement=conn.createStatement(); 
				}
				
				catch(Exception ee)
				{
					
				}
				
				
			}
		});
		btnCancel.setContentAreaFilled(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setFont(new Font("Open Sans", Font.BOLD, 20));
		btnCancel.setBounds(257, 497, 175, 51);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\New Project Code\\src\\pay.png"));
		lblNewLabel.setBounds(479, 485, 105, 78);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\New Project Code\\src\\remove.png"));
		lblNewLabel_1.setBounds(241, 485, 83, 64);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
