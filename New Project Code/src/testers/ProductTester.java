import java.util.*;   
public class ProductTester {
   private static Scanner kIn;

public static void main(String[] args) {
      int menuOpt=0;   
      kIn = new Scanner(System.in);
      Product myProduct = new Product();
       
      do {
         System.out.println("\t\tFastfood Menu");
         System.out.println("\t1. Display all Products");
         System.out.println("\t2. Search and display one Product");
         System.out.println("\t3. Add a Product");
         System.out.println("\t4. Delete a Product");
         System.out.println("\t5. Set/change Product price");
         
         System.out.println("\t0. Exit the system");
         menuOpt=kIn.nextInt();
         
         switch(menuOpt)  {
         
            case 1://display all Products
             
               ArrayList<Product> allProducts = myProduct.getAllProducts();
               System.out.println("View All Products");
               System.out.println("Product Code \tProduct Name \tPrice \t\tKill Date");
               Iterator<Product> productIterator = allProducts.iterator();
               while(productIterator.hasNext())    {
                  Product DisplayProduct = productIterator.next();
                  System.out.println(DisplayProduct.getProductCode() + " \t" +  
                                          DisplayProduct.getPName() + " \t\t" +  
                                          DisplayProduct.getPPrice() + " \t\t"  
                                          );//DisplayProduct.getSKillDate() );
               }
            
               break;
               
            case 2:// Search and display one Product
               int searchProductCode=0;
               System.out.println("\n\nEnter the Product Code");
               searchProductCode=kIn.nextInt();      
               Product SearchProduct = myProduct.getProduct(searchProductCode);
               System.out.println(SearchProduct.getProductCode() + " \t" +  
                                          SearchProduct.getPName() + " \t\t" +  
                                          SearchProduct.getPPrice() + " \t\t"  
                                          );//SearchProduct.getSKillDate() );
               break;
                
            case 3://add a new Product
               System.out.println("\n\n Please enter the new Product details");
               System.out.print("Enter Product code:\t");
               int nProductCode=kIn.nextInt();
               kIn.nextLine(); // clear keyboard buffer
               System.out.print("Enter price of the product:\t");
               double nProductPrice=kIn.nextDouble();
               System.out.print("Enter Product name:\t");
               String nProductName=kIn.nextLine();
               System.out.print("Enter the product description:");
               String nProductDesc=kIn.nextLine();
               kIn.nextLine();//clear keyboard buffer
               Product newProduct = new Product(nProductCode,nProductPrice,nProductName,nProductDesc);
               int addStatus = myProduct.addProduct(newProduct);
               if (addStatus==1)
                  System.out.println("Added to Database");
               break;   
               
            case 4://delete a Product
               int delProductCode=0;
               System.out.print("\n\nEnter the Product code of the item:");
               delProductCode=kIn.nextInt(); 
               int delStatus = myProduct.deleteProduct(delProductCode);
               if (delStatus==1)
                  System.out.println("Deleted from database");          
               break;
               
            case 5://set the price of a Product
               int pProductCode=0;
               double newPrice=0;
               double changeStatus=0;
               System.out.print("\n\nEnter the Product code to set price: ");
               pProductCode=kIn.nextInt(); 
               System.out.print("\n\nEnter the price of the Product: ");
               newPrice=kIn.nextDouble(); 
               changeStatus=myProduct.setPrice(pProductCode, newPrice);
               if (changeStatus==1)
                  System.out.println("Deleted from database");
               break;
         
         }
      } while (menuOpt!=0);          
   }
}