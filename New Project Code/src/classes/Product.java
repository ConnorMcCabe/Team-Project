import java.sql.*;
import java.util.ArrayList;

public class Product {
	//instance variables
	private double pPrice;
	private int productCode;
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
	public Product(int productCodeIn, double pPriceIn, String nameIn, String descIn) {
		productCode = productCodeIn;
		pPrice = pPriceIn;
		pName = nameIn;
		pDesc = descIn;
	}
	
	public Product() {
		
	}
	
	//methods
	public int getProductCode() {
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
	      String sqlString="insert into fastfood.product(productcode,pprice,pname,pdesc) values("+
	                                          pIn.getProductCode() + ",\"" + pIn.getPPrice() + "\"," +
	                                          pIn.getPName() + ",\'"+ pIn.getPDesc()+ "\'"+ ")";
	    status = dbUpdate(sqlString);
	    return status;
	}
	
	public int deleteProduct(int productCodeIn) {
	     int status=0;  
	     String sqlString= "delete from fastfood.product where productcode=" + productCodeIn;     
	     
	     status = dbUpdate(sqlString);                                        
	     return status;
	}
	
	public Product getProduct(int searchNum) {
	      Product foundProduct= new Product();
	      try{
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection(url+dbName,userName,password);
	         stmnt=conn.createStatement();
	         resultSet=stmnt.executeQuery("select * from fastfood.product where fastfood.product.productCode=" + searchNum);
	                 
	         while (resultSet.next()) {
	        	 foundProduct = new Product(resultSet.getInt("productcode"), resultSet.getDouble("pprice"),
                         resultSet.getString("pname"), resultSet.getString("pdesc"));                
	         }
	         conn.close();
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	      }  
	      return foundProduct;
    }
	
	public ArrayList<Product> getAllProducts()      { 
	      ArrayList<Product> AllProducts = new ArrayList<Product>();
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection(url+dbName,userName,password);
	         stmnt=conn.createStatement();
	         resultSet=stmnt.executeQuery("select * from fastfood.product");
	         
	         while ( resultSet.next() )    {
	            Product nextProduct = new Product(resultSet.getInt("productcode"), resultSet.getDouble("pprice"),
	                                         resultSet.getString("pname"), resultSet.getString("pdesc"));                
	            AllProducts.add(nextProduct);
	         }
	         conn.close();
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return AllProducts;     
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
