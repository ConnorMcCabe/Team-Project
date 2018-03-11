import java.sql.*;
/*
import java.util.ArrayList;
import java.util.Date;
*/
public class Product {
	//instance variables
	private double pPrice, productCode;
	private String pDesc, pName;
	
	//sql and database variables
	private String url = "jdbc:mysql://localhost:3306/";
	private String dbName = "fastfood";
	private String driver = "com.mysql.jdbc.Driver";
	private String userName = "root";
	private String password = "password";
	private Statement stmnt = null;   
	private ResultSet resultSet = null;

	//methods & constructors
	public Product(double priceIn, double productCodeIn, String descIn, String nameIn) {
		pPrice = priceIn;
		productCode = productCodeIn;
		pDesc = descIn;
		pName = nameIn;
	}
	
	public Product() {
		
	}
	
	//methods
	public double getProductCode() {
		return productCode;
	}
	
	public double getPPrice() {
		return pPrice;
	}
	
	public String getPName() {
		return pName;
	}
	
	public String getPDesc() {
		return pDesc;
	}
	
	//Database Access & Update Methods
	public int addProduct(Product pIn) { 
	      int status=0;
	      String sqlString="insert into fastfood.product(productcode,pname,pprice,pdesc) values("+
	                                          pIn.getProductCode() + ",\"" + pIn.getPName() + "\"," +
	                                          pIn.getPPrice() + ",\'"+ pIn.getPDesc()+ "\'"+ ")";
	    status = dbUpdate(sqlString);
	    return status;
	}
	
	public int deleteProduct(int productCodeIn) {
	     int status=0;  
	     String sqlString= "delete from fastfood.product where snumber=" + productCodeIn;     
	     
	     status = dbUpdate(sqlString);                                        
	     return status;
	}
	
	public double setPrice(int productCodeIn, double priceIn) {
		int status=0;
		String sqlString="update fastfood.product set pprice="+priceIn
		                                         + " where productcode="+productCodeIn;
	    status = dbUpdate(sqlString);                                           
		               
		return status;
	}
	private int dbUpdate(String sqlUpdate) {
		int status=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(url+dbName,userName,password);
	        stmnt=conn.createStatement();
	        status=stmnt.executeUpdate(sqlUpdate);
	        conn.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	

}
