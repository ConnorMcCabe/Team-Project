package classes;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
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

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import java.awt.TextArea;
import javax.swing.JTextArea;

public class Recommendations {

	private JFrame frame;
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement ppdStmt;
	private ResultSet resultSet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recommendations window = new Recommendations();
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
	public Recommendations() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 609, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		/***************JPANELS CREATED***************/
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 224, 147));
		frame.getContentPane().add(panel_1, "name_280259102687753");
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 224, 147));
		frame.getContentPane().add(panel_2, "name_280286358221424");
		panel_2.setLayout(null);
		
		/********************PANEL 1 CODE*********************/

		JButton btnRecomm = new JButton("Recommendations");
		btnRecomm.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRecomm.setMnemonic('R');
		btnRecomm.setFont(new Font("Open Sans", Font.BOLD, 40));
		btnRecomm.setBackground(UIManager.getColor("Button.darkShadow"));
		btnRecomm.setBounds(105, 149, 390, 60);
		panel_1.add(btnRecomm);
		
		btnRecomm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				
			}
		});
		
		/********************PANEL 2 CODE*********************/
		
		JLabel lblRSelections = new JLabel("Recommended Selections");
		lblRSelections.setHorizontalAlignment(SwingConstants.CENTER);
		lblRSelections.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 35));
		lblRSelections.setBounds(65, 19, 490, 60);
		panel_2.add(lblRSelections);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(65, 101, 490, 227);
		panel_2.add(textArea);
		
		
		/*try
		{
			ResultSet res;
			Statement stmt;
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food?autoReconnect=true&useSSL=false","root","password");
			stmt = conn.createStatement();
			res = stmt.executeQuery("Select * from fast_food.product");
			while(res.next())
			{
				panel_2.add(rs.getString(1));
			}
		}
			catch (Exception x2)
			{
				System.out.print(x2);
				JOptionPane.showMessageDialog(null, "Error");
			}*/
		
	}
}
