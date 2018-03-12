package Classes;
// Connor McCabe
// The Chippy - Order Item class
// 10/03/18
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import com.mysql.jdbc.Connection;

public class Order_Item 
{
	//Instance Variables
	private int productCode;
	private int quantity;
	private int orderNum;
	private double totalPrice;

	//SQL Variables
	ResultSet resultSet = null;
	
	//private String
	public Order_Item()
	{
	
	}
		
	public Order_Item(int productCode, int quantity, double totalPrice)
	{
		this.productCode=productCode;
		this.quantity=quantity;
		this.totalPrice=totalPrice;
	}
	public Vector getOrderItems(int j)
	{
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Fast_Food","root","password");
			Statement stmt = con.createStatement();
		
			String sqlString = "select Product_Code, Price from product";
			stmt.executeQuery(sqlString);
			Vector vector = new Vector();
			Vector<String> orderItem = new Vector<String>();
			int i=0;
			while(rs.next())
			{
				Vector<String> items = new Vector <String>();
				rs.getInt("ProductCode");
				rs.getInt("Quantity");
				rs.getDouble("Total_Price");
			}
			return vector;
		}catch(Exception e)
		{
			System.out.print("error \t ");
		}
		return null;
	}
	
	//Getter Methods
	public int getProductCode()
	{
		return productCode;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public double getTotalPrice()
	{		
		return totalPrice;
	}
	
}
