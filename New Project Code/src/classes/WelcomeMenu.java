package GUI;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.Color;

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
		frmWelcome.setBounds(100, 100, 1001, 677);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frmWelcome.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to");
		lblWelcome.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 55));
		lblWelcome.setBounds(44, 43, 514, 73);
		panel.add(lblWelcome);
		
		JButton btnNewButton = new JButton("Menu");
		btnNewButton.setMnemonic('M');
		btnNewButton.setFont(new Font("Open Sans", Font.BOLD, 40));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(412, 412, 238, 78);
		panel.add(btnNewButton);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setContentAreaFilled(false);
		btnAdmin.setBorderPainted(false);
		btnAdmin.setFont(new Font("Open Sans", Font.BOLD, 20));
		btnAdmin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Manager manager = new Manager();
				manager.main(null);
			}
		});
		btnAdmin.setBounds(37, 552, 192, 53);
		panel.add(btnAdmin);
		
		JLabel label_logo = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\New Project Code\\src\\logo.JPG"));
		label_logo.setBounds(290, 157, 431, 245);
		panel.add(label_logo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 69, 69));
		panel_1.setBounds(0, 0, 983, 175);
		panel.add(panel_1);
		
		JLabel label = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\New Project Code\\src\\menu.png"));
		label.setBounds(374, 413, 120, 88);
		panel.add(label);
		
		JLabel label_1 = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\New Project Code\\src\\admin.png"));
		label_1.setBounds(12, 544, 96, 84);
		panel.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 550, 983, 88);
		panel_3.setBackground(new Color(115, 168, 212));

		panel.add(panel_3);
		
		JLabel label_2 = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\New Project Code\\src\\burger.JPG"));
		label_2.setBounds(64, 277, 221, 175);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\New Project Code\\src\\chip.JPG"));
		label_3.setBounds(743, 239, 228, 226);
		panel.add(label_3);
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
