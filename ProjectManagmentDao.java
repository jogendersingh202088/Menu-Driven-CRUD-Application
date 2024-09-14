package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import dbutil.DBUtil;
import pojo.Product;

public class ProjectManagmentDao {

	
	// create a use collection(give a list of all product ) 
	
	public List<Product>getAllProducts(){
		
		
		List<Product>productList = new ArrayList<Product>() ;
		
		
		try {
			
			// load and make connection by calling connection method 
			
			Connection conn = DBUtil.getConnection();
			
			
			
			
			// create statement 
			
			
			Statement st = conn.createStatement();
			
			// create a ResultSet to execute query
			
			ResultSet rs = st.executeQuery("select*from product");
			
			while(rs.next()) {
				
				Product product = new Product(rs.getString("productId"),
						                      rs.getString("productName"),
						                      rs.getInt("productPrice"));
			/* to add data into productList	*/    productList.add(product);
				
			}
			
			DBUtil.CloseConnection(conn);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return productList;
	}
		
		
	// creating a method to get product 
	
	public Product getProductById(String productId) throws ClassNotFoundException, SQLException {
		
		Product product = null;
		
		// load and make connection 
		
		Connection conn = DBUtil.getConnection();
		
		// ---create a prepared statement because we have to take input from user to search
		
		PreparedStatement ps = conn.prepareStatement("select*from product where productId =?");
		ps.setString(1, productId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			product = new Product(rs.getString("productId"),
                    rs.getString("productName"),
                    rs.getInt("productPrice"));

		}

		
		
		return product;
		}
	
	
	// to add the product in the products database
	
	public int addProduct(Product product) throws Exception
	  {
	    int status = 0;
	    
	    Connection conn = DBUtil.getConnection();
	    PreparedStatement ps = conn.prepareStatement("INSERT INTO product VALUES(?,?,?)");
	    ps.setString(1, product.getProductId());
	    ps.setString(2, product.getProductName());
	    ps.setInt(3, product.getProductPrice());
	    
	    status = ps.executeUpdate();
	    
	    return status;
	    
	  }
	
	
	
	
	
	// to update the product details 
	  
	  
	  public int updateProduct(Product product) throws Exception
	  {
	    int status=0;
	    
	    Connection conn = DBUtil.getConnection();
	    
	    PreparedStatement ps = conn.prepareStatement("UPDATE product SET productName=?, productPrice=? WHERE productId=?");
	    ps.setString(1, product.getProductName());
	        ps.setInt(2, product.getProductPrice());
	        ps.setString(3, product.getProductId());
	        
	         status = ps.executeUpdate();
	    
	    
	    return status;
	    
	  }
	  
	  
	  
	  // to delete the product 
	  
	  
	  public int deleteProduct(String productId) throws Exception
	  {
	    int status=0;
	    
	    Connection conn = DBUtil.getConnection();
	        PreparedStatement ps = conn.prepareStatement("DELETE FROM product where productId = ?");
	        ps.setString(1, productId);
	        status = ps.executeUpdate(); 
	    return status;
	    
	    
	  }
	  
	}
	
	

