package Classes;
// Connor McCabe
// The Chippy - Order Item class
// 15/03/18
import java.sql.*;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class Order_Item 
{
	//Instance Variables
	private int productCode;
	private int orderQuantity;
	private Double orderPrice;
	private String orderName;
	//SQL Variables
	ResultSet resultSet = null;
	
	//private String
	public Order_Item()
	{}
		
//	public Order_Item(int productCode, String orderName ,double orderPrice, int orderQuantity)
//	{
//		this.productCode=productCode;
//		this.orderQuantity=orderQuantity;
//		this.orderPrice=orderPrice;
//		this.orderName=orderName;
//	}

	public Order_Item(int productCode , int orderQuantity, double orderPrice)
	{
		this.productCode=productCode;
		this.orderQuantity=orderQuantity;
		this.orderPrice=orderPrice;
		this.orderName=orderName;
	}
	//Getter Methods
		public int getProductCode()
		{
			return productCode;
		}
		public int getOrderQuantity()
		{
			return orderQuantity;
		}
		public double getOrderPrice()
		{		
			return orderPrice;
		}		
		public String getOrderName()
		{
			return orderName;
		}
	
		public ArrayList<Order_Item> TotalOrder()      { 
		      ArrayList<Order_Item> TotalOrder = new ArrayList<Order_Item>();
		      try {
		    	  Class.forName("com.mysql.jdbc.Driver");  
		  		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food","root","password"); 
		         
		         while ( resultSet.next() )    {
//		            Order_Item nextItem = new Order_Item(resultSet.getInt("productCode"),resultSet.getString("orderName"), 
//		            		resultSet.getDouble("Price"),resultSet.getInt("orderQuantity"));           
		        	 Order_Item nextItem = new Order_Item(resultSet.getInt("productCode"),resultSet.getInt("orderQuantity"),resultSet.getDouble("orderPrice")); 
		            TotalOrder.add(nextItem);
		         }
		         con.close();
		      } 
		      catch (Exception e) {
		         e.printStackTrace();
		      }
		      return TotalOrder;     		
}		
}
