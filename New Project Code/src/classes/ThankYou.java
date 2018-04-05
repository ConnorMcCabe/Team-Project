package Resturaunt;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class ThankYou extends GUI
{

	
	//protected static Object JTabel;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThankYou window = new ThankYou();
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
	public ThankYou() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 734, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblThankYou = new JLabel("Thank You! Your Order Has Been Placed!");
		lblThankYou.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblThankYou.setBounds(76, 24, 565, 67);
		frame.getContentPane().add(lblThankYou);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(137, 120, 416, 317);
		frame.getContentPane().add(scrollPane);
		DefaultTableModel dtm2 = new DefaultTableModel(2, 0);
		JTable JTable1 = new JTable();
		JTable1.setBackground(Color.WHITE);
		JTable1.setFont(new Font("Open Sans", Font.PLAIN, 16));
		scrollPane.setViewportView(JTable1);
		JTable1.setModel(dtm2);
		
		JLabel lblYourOrder = new JLabel("Your Order");
		lblYourOrder.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblYourOrder.setBounds(272, 91, 175, 27);
		frame.getContentPane().add(lblYourOrder);
		
		JLabel lblYourCreditCard = new JLabel("Your Credit Card Has Been Charged:");
		lblYourCreditCard.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblYourCreditCard.setBounds(44, 484, 404, 27);
		frame.getContentPane().add(lblYourCreditCard);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(458, 483, 183, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back to Menu");
		btnNewButton.setBounds(510, 523, 147, 48);
		frame.getContentPane().add(btnNewButton);
		
		//DefaultTableModel dtm2 = (DefaultTableModel) JTable1.getModel();
	}
}
