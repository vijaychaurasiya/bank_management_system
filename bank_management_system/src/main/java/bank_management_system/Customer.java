package bank_management_system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer {
    
    	
    	public int checkCustomer(int mobile,String password){
    		int check=0;
    		try {
    	    	   Connection con=DBconnection.createDBConnection();
    	    	   Statement st=con.createStatement();
    	    	   
    	    	   ResultSet rs = st.executeQuery("select * from customer where customerid='"+mobile+"' and password='"+password+"';");
    	    	   if (rs.next()) {
    					check=1;
    				} 
    	    	   }catch(SQLException e){
    	    		   e.printStackTrace();
    	    	   }
    		return check;
    	}
    	
    
}
