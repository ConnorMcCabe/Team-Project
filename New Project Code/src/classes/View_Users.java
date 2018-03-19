package classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class View_Users {

	private JFrame frame;
	private JTable view_table;
	
	//VARIABLES FOR DATABSE CONNECTION
		private String url = "jdbc:mysql://localhost:3306/";
		private String dbName = "fast_food?autoReconnect=true&useSSL=false";
		private String driver = "com.mysql.jdbc.Driver";
		private String userName = "root";
		private String passwordDB = "password";
		private Statement statement = null;   
	    private ResultSet resultSet = null;
	    private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Users window = new View_Users();
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
	public View_Users() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 322);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 408, 214);
		frame.getContentPane().add(scrollPane);
		
		view_table = new JTable();
		scrollPane.setViewportView(view_table);
		
		JButton btnViewUser = new JButton("View User");
		btnViewUser.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
			        Connection conn = DriverManager.getConnection(url+dbName,userName,passwordDB);
			        statement=conn.createStatement();
			        
			        String sql="SELECT Employee_ID, Email FROM manager";
			        PreparedStatement stmt = conn.prepareStatement(sql);
			        ResultSet rs = stmt.executeQuery(sql);
			        
			        view_table.setModel(DbUtils.resultSetToTableModel(rs));
			        
				}
				catch(Exception e1)
				{
					
				}
			}
		});
		btnViewUser.setBounds(165, 237, 97, 25);
		frame.getContentPane().add(btnViewUser);
	}

}
