package pojo;

public class Product {

		// fields 
		 String productId;
		 String productName;
		 int productPrice;
		
		// generate default constructor 
		    
		    public Product() {
		    	
		    }
		    
		// generate parameterized constructor 
		
		    public Product(String productId, String productName, int productPrice) {
		        this.productId = productId;
		        this.productName = productName;
		        this.productPrice = productPrice;
		        
		        // create getter and setter method
		    }

			public String getProductId() {
				return productId;
			}

			public void setProductId(String productId) {
				this.productId = productId;
			}

			public String getProductName() {
				return productName;
			}

			public void setProductName(String productName) {
				this.productName = productName;
			}

			public int getProductPrice() {
				return productPrice;
			}

			public void setProductPrice(int productPrice) {
				this.productPrice = productPrice;
			}
			
			
	           // create toString method = represent the objects attribute in the form of string 
			
			
			@Override
			public String toString() {
				return "Product [productId=" + productId + ", productName=" + productName + ", productPrice="
						+ productPrice + "]";
			}
			
		
			
			
			
	}


