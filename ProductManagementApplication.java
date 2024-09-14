package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.List;

import dao.ProjectManagmentDao;
import pojo.Product;

public class ProductManagementApplication {
	
	// we use buffer reader instead of scanner to take input from  console 

	
	 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
	 // import ProjectManagment class and create a reference variable of it because we have to call product management methods again and again
	 
	 static ProjectManagmentDao dao = new ProjectManagmentDao();
	 
	 
	 
	public static void main(String[] args) throws Exception {
					
  // take an empty string to create menu
		String option ="";
		
		do {
			 System.out.println("A. View Products");
	            System.out.println("B. Add Product");
	            System.out.println("C. Update Product");
	            System.out.println("D. Delete Product");
	            System.out.println("E. Search Product");
	            System.out.println("F. Exit");
	            System.out.println("===========================================");
	            System.out.println("Enter an option");
	            System.out.println("===========================================");
	            option = br.readLine();
	            System.out.println("\n");
	            
	            switch(option.toUpperCase())
	            {
	            case "A":
	                viewProducts();
	                break;

	            case "B":
	                addProduct();
	                break;

	            case "C":
	                updateProduct();
	                break;

	            case "D":
	                deleteProduct();
	                break;

	            case "E":
	                searchProduct();
	                break;
	            case "F":
	                System.out.println("******************************THANK YOU********************");
	                System.exit(0);
	                break;
	            }
			
			
		}
		while(option.equals("F"));
		
	}
		
		  public static void viewProducts()
		    {
		        System.out.println("-----------------------------------------------");

		        //get all the product from the dao getallProducts() method and store
		        //them to a Product type productList
		        List<Product> productList = dao.getAllProducts();
		        
		        // for each loop to see all products 
		        
		        for(Product product: productList)
		        {
		            //display product one by one
		        	
		            displayProduct(product);
		        }
		        System.out.println("-----------------------------------------------");
		        System.out.println("\n");

		    }
		  
	      public static void displayProduct(Product product)
	      {
	          System.out.println("Product ID: "+product.getProductId());
	          System.out.println("Product Name: "+product.getProductName());
	          System.out.println("Product Price: "+product.getProductPrice());
	          System.out.println("\n");
	      

		
	}
		  
		  public static void addProduct() throws Exception
		    {
		        System.out.println("------------------------------------------------");
		        System.out.println("Enter Product ID:");
		        System.out.println("------------------------------------------------");
		        String productId = br.readLine();
		        System.out.println("------------------------------------------------");
		        System.out.println("Enter Product Name:");
		        System.out.println("------------------------------------------------");
		        String productName = br.readLine();
		        System.out.println("------------------------------------------------");
		        System.out.println("Enter Product Price:");
		        System.out.println("------------------------------------------------");
		        
		        int productPrice = Integer.parseInt(br.readLine());
		        
		        //after user enters values, store them in a Product variable
		        Product product = new Product(productId, productName,productPrice);
		        int status = dao.addProduct(product);
		        if(status ==1 )
		        {
		            System.out.println("Product added successfully");
		        }
		        else
		        {
		            System.out.println("ERROR while adding product");
		        }
		        System.out.println("\n");
		    }
		
		  public static void updateProduct() throws Exception
	      {
	          System.out.println("------------------------------------------------");
	          System.out.println("Enter Product ID:");
	          System.out.println("------------------------------------------------");
	          String productId = br.readLine();
	          System.out.println("------------------------------------------------");
	          System.out.println("Enter New Product Name:");
	          System.out.println("------------------------------------------------");
	          String productName = br.readLine();
	          System.out.println("------------------------------------------------");
	          System.out.println("Enter New Product Price:");
	          System.out.println("------------------------------------------------");
	          int productPrice = Integer.parseInt(br.readLine());
	          //after user enters values, store them in a Product variable
	          Product product = new Product(productId, productName,productPrice);
	          int status = dao.updateProduct(product);
	          if(status ==1 )
	          {
	              System.out.println("Product updated successfully");
	          }
	          else
	          {
	              System.out.println("ERROR while updating product");
	          }
	          System.out.println("\n");

	      }

	   public static void deleteProduct() throws Exception
	      {
	          System.out.println("------------------------------------------------");
	          System.out.println("Enter Product ID:");
	          System.out.println("------------------------------------------------");
	          String productId = br.readLine();
	          int status = dao.deleteProduct(productId);
	          if(status == 1 )
	          {
	              System.out.println("Product deleted successfully");
	          }
	          else
	          {
	              System.out.println("ERROR while deleting product");
	          }
	          System.out.println("\n");

	      }
	   
	   //ask user for productId and use Dao method to display product
	      public static void searchProduct() throws Exception
	      {
	          System.out.println("------------------------------------------------");
	          System.out.println("Enter Product ID:");
	          System.out.println("------------------------------------------------");
	          String productId = br.readLine();
	          Product product = dao.getProductById(productId);
	          displayProduct(product);
	          System.out.println("\n");
	      }
	      
	    

}
