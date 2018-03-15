package classes;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

public class WelcomeMenu {
	
	private JFrame frmWelcome;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeMenu window = new WelcomeMenu();
					window.frmWelcome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setTitle("Welcome");
		frmWelcome.setBounds(100, 100, 639, 475);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmWelcome.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to TheChippy");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblWelcome.setBounds(57, 11, 514, 73);
		panel.add(lblWelcome);
		
		JButton btnNewButton = new JButton("Menu");
		btnNewButton.setBounds(217, 180, 179, 78);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				GUI fm = new GUI();
				fm.Menu();
				
				//CloseWindow upon button press
				JComponent comp = (JComponent) arg0.getSource();
		         Window win = SwingUtilities.getWindowAncestor(comp);
		         win.dispose();
				
				
				
			}
		});
	}
	

	

	
}
