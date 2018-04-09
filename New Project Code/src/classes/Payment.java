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

import com.sun.glass.events.KeyEvent;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;


public class Payment extends JFrame {

	private JFrame frame;
	private JTextField payment_numberIn;
	private JTextField payment_ccvIn;
	
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
		frame.getContentPane().setBackground(new Color(255, 216, 120));

		frame.setBounds(100, 100, 1098, 775);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPleaseEnterCard = new JLabel("Please Enter Card Details");
		lblPleaseEnterCard.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 50));
		lblPleaseEnterCard.setBounds(24, 13, 929, 151);
		frame.getContentPane().add(lblPleaseEnterCard);
		
		JLabel lblCardType = new JLabel("Card Type:");
		lblCardType.setFont(new Font("Open Sans", Font.BOLD, 25));
		lblCardType.setBounds(271, 231, 164, 28);
		frame.getContentPane().add(lblCardType);
		
		JComboBox payment_cardIn = new JComboBox();
		payment_cardIn.setBackground(Color.WHITE);
		payment_cardIn.setModel(new DefaultComboBoxModel(new String[] {"","Visa ", "Mastercard"}));
		payment_cardIn.setFont(new Font("Open Sans", Font.BOLD, 20));
		payment_cardIn.setBounds(583, 230, 204, 34);
		frame.getContentPane().add(payment_cardIn);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setFont(new Font("Open Sans", Font.BOLD, 25));
		lblNumber.setBounds(271, 286, 116, 28);
		frame.getContentPane().add(lblNumber);
		
		payment_numberIn = new JTextField();
			  
		payment_numberIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent e) 
			{
				char vchar = e.getKeyChar();
				if(!(Character.isDigit(vchar)) 
						|| (vchar == KeyEvent.VK_BACKSPACE)
                         || (vchar == KeyEvent.VK_DELETE)) 
						{
                    e.consume();
                    
						}
                    
                   //JOptionPane.showMessageDialog(null, "NO LETTERS, NUMBERS ONLY","TRY AGAIN", JOptionPane.ERROR_MESSAGE);
                  
                    else if(payment_numberIn.getText().length() >= 15 )
                    {
						 JOptionPane.showMessageDialog(null, "NO MORE THAN 16 DIGITS","WARNING", JOptionPane.WARNING_MESSAGE);

                    }
				
                   
		
			}	
	
});
		payment_numberIn.setFont(new Font("Open Sans", Font.PLAIN, 20));
		payment_numberIn.setBounds(583, 286, 204, 34);
		frame.getContentPane().add(payment_numberIn);
		payment_numberIn.setColumns(10);
		
		JLabel lblCsv = new JLabel("CCV:");
		lblCsv.setFont(new Font("Open Sans", Font.BOLD, 25));
		lblCsv.setBounds(271, 340, 94, 34);
		frame.getContentPane().add(lblCsv);
		
		payment_ccvIn = new JTextField();
		payment_ccvIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent e) 
			{
				char vchar = e.getKeyChar();
				if(!(Character.isDigit(vchar)) 
						|| (vchar == KeyEvent.VK_BACKSPACE)
                         || (vchar == KeyEvent.VK_DELETE)) 
						{
                    e.consume();
                    
						}
                    
                   //JOptionPane.showMessageDialog(null, "NO LETTERS, NUMBERS ONLY","TRY AGAIN", JOptionPane.ERROR_MESSAGE);
                  
                    else if(payment_ccvIn.getText().length() >= 3)
                    {
                    	 e.consume(); 
						 JOptionPane.showMessageDialog(null, "NO MORE THAN 3 DIGITS","WARNING", JOptionPane.WARNING_MESSAGE);
				         e.consume(); 

                    }
			}
			

		});
		
		
		payment_ccvIn.setToolTipText("3 DIGIT CODE AT THE BACK OF THE CARD");
		payment_ccvIn.setFont(new Font("Open Sans", Font.PLAIN, 20));
		payment_ccvIn.setBounds(583, 343, 83, 34);
		frame.getContentPane().add(payment_ccvIn);
		payment_ccvIn.setColumns(10);
		
		JLabel lblEx = new JLabel("Expiry Date (MMM/YY):");
		lblEx.setFont(new Font("Open Sans", Font.BOLD, 25));
		lblEx.setBounds(271, 397, 300, 34);
		frame.getContentPane().add(lblEx);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\New Project Code\\src\\pay.png"));
		lblNewLabel.setBounds(490, 471, 105, 78);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\New Project Code\\src\\remove.png"));
		lblNewLabel_1.setBounds(249, 471, 83, 64);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox payment_monthIn = new JComboBox();
		payment_monthIn.setModel(new DefaultComboBoxModel(new String[] {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}));
		payment_monthIn.setBackground(Color.WHITE);
		payment_monthIn.setFont(new Font("Open Sans", Font.BOLD, 20));
		payment_monthIn.setBounds(583, 388, 83, 34);
		frame.getContentPane().add(payment_monthIn);
		
		JComboBox payment_yearIn = new JComboBox();
		payment_yearIn.setModel(new DefaultComboBoxModel(new String[] {"", "18", "19", "20", "21", "22", "23", "24", "25", "26"}));
		payment_yearIn.setBackground(Color.WHITE);
		payment_yearIn.setFont(new Font("Open Sans", Font.BOLD, 20));
		payment_yearIn.setBounds(704, 388, 83, 34);
		frame.getContentPane().add(payment_yearIn);
		
		
		
		JButton btnConfirm = new JButton("Pay");
	
		btnConfirm.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				
				   try 
				   {
					   String cardIn = (String)payment_cardIn.getSelectedItem();
					   String numberIn = payment_numberIn.getText();
					   String ccvIn = payment_ccvIn.getText();
					   String monthIn = (String)payment_monthIn.getSelectedItem();
					   String yearIn = (String)payment_yearIn.getSelectedItem();
					   
					   //numberIn.getDocument().getLength();

					   if(e.getSource() == btnConfirm && numberIn.equals("") || ccvIn.equals("") || ccvIn.equals("") || monthIn.equals("") || yearIn.equals(""))
						 {

							 JOptionPane.showMessageDialog(null, "Cannot be left blank, TRY AGAIN","TRY AGAIN", JOptionPane.ERROR_MESSAGE);
						 }
					   
					   else if(e.getSource() == btnConfirm && cardIn == "Visa" || numberIn.contains("4319"))
					   {
							 JOptionPane.showMessageDialog(null, "Thank You", "Enjoy ", JOptionPane.ERROR_MESSAGE);
							 payment_cardIn.setSelectedItem("");
							 payment_numberIn.setText(null);
							 payment_ccvIn.setText(null);
							 payment_monthIn.setSelectedItem("");
							 payment_yearIn.setSelectedItem("");
					   }
					   
					   else if(e.getSource() == btnConfirm && cardIn == "Visa" || !numberIn.contains("4319"))
					   {
							 JOptionPane.showMessageDialog(null, "INVALID CARD", "TRY AGAIN ", JOptionPane.ERROR_MESSAGE);
							 payment_cardIn.setSelectedItem("");
							 payment_numberIn.setText(null);
							 payment_ccvIn.setText(null);
							 payment_monthIn.setSelectedItem("");
							 payment_yearIn.setSelectedItem("");

					   }
					   
					   else if(e.getSource() == btnConfirm && cardIn == "Mastercard" || numberIn.contains("5432"))
					   {
							 JOptionPane.showMessageDialog(null, "Thank You", "Enjoy ", JOptionPane.ERROR_MESSAGE);
							 payment_cardIn.setSelectedItem("");
							 payment_numberIn.setText(null);
							 payment_ccvIn.setText(null);
							 payment_monthIn.setSelectedItem("");
							 payment_yearIn.setSelectedItem("");
					   }
					   
					   else if(e.getSource() == btnConfirm && cardIn == "Mastercard" || !numberIn.contains("5432"))
					   {
							 JOptionPane.showMessageDialog(null, "INVALID CARD", "TRY AGAIN ", JOptionPane.ERROR_MESSAGE);
							 payment_cardIn.setSelectedItem("");
							 payment_numberIn.setText(null);
							 payment_ccvIn.setText(null);
							 payment_monthIn.setSelectedItem("");
							 payment_yearIn.setSelectedItem("");

					   }
					   
					   
					  

				   }catch(Exception ee) 
					
				   {

					   	System.out.println(ee);
				
				  }
			
			}});
		btnConfirm.setContentAreaFilled(false);
		btnConfirm.setBorderPainted(false);
		btnConfirm.setFont(new Font("Open Sans", Font.BOLD, 30));
		btnConfirm.setBounds(509, 485, 221, 51);
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
		btnCancel.setFont(new Font("Open Sans", Font.BOLD, 30));
		btnCancel.setBounds(280, 485, 175, 51);
		frame.getContentPane().add(btnCancel);
		
		
	}
}
