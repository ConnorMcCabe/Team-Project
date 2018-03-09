package classes;

import java.sql.ResultSet;
import java.sql.*;
import com.mysql.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Order extends Order_Item {

		//CLASS ATTRIBUTES 
		private int orderNum;
		private int tableNum;
		private boolean status;
		private String time;
		
		//SQL VARIABLES
		private String url = "jdbc:mysql://localhost:3306/";
		private String dbName = "fast_food";
		private String driver = "com.mysql.jdbc.Driver";
		private String userName = "root";
		private String password = "password";
		private Statement statement = null;   
		private ResultSet resultSet = null;
		
		//DEFAULT CODE TO CONNECT TO THE DATABASE
		
		
		//CONSTRUCTORS 
		public Order(int orderNumIn, int tableNumIn, boolean statusIn, String timeIn)
		{
			orderNum = orderNumIn;
			tableNum = tableNumIn;
			status = statusIn;
			time = timeIn;
		}
		
		public Order()
		{
			
		}
		
		//SETTERS AND GETTERS
		public int getOrderNum() 
		{
			return orderNum;
		}
		
		public int getTableNum()
		{
			return tableNum;
		}
		
		public void setTableNum(int tableNum) 
		{
			this.tableNum = tableNum;
		}
		public boolean isStatus() 
		{
			return status;
		}
		
		public void setStatus(boolean status) 
		{
			this.status = status;
		}
		
		public String isTime() 
		{
			return time;
		}
		
	}


