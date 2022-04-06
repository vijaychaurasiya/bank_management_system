package bank_management_system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerOperations {
        
	  Connection con= DBconnection.createDBConnection();
      Statement st;
	
	   public int viewBalence(int mobileNumber) {
		   int Balance=-1;
		   try {
			st=con.createStatement();
			ResultSet rs=st.executeQuery("Select balence from customer where customerid="+mobileNumber+";");
			rs.next(); 
			Balance=rs.getInt(1);
			//System.out.println("CustomerId"+" "+mobileNumber+"  "+"Balance"+rs.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return Balance;
	   }
	   
	   public int deposit(int mobileNumber,int amount) {
		   int status=0;
		   try {
			   st = con.createStatement();
			   status =st.executeUpdate("update customer set balence=balence+"+amount+" where customerid="+mobileNumber+";");
			     
			   st.execute("insert into log values("+mobileNumber+","+amount+",'deposit');");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   return status;
	   }
	   
       public int withdraw(int mobileNumber,int amount) {
    	   int status=0;
		   try {
			   st = con.createStatement();
			   status =st.executeUpdate("update customer set balence=balence-"+amount+" where customerid="+mobileNumber+";");
			   st.execute("insert into log values("+mobileNumber+","+amount+",'withdraw');");
				//rs.next(); 
				//Balance=rs.getInt(1);
				//System.out.println("CustomerId"+" "+mobileNumber+"  "+"Balance"+rs.next());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   return status;
	   }
       
       public int transfer(int mobileNumber,int amount,int reciverID) {
		   int status=0;
		   int status1=0;
		   int status2=0;
		  // Statement st = con.createStatement();
			Statement st1;
			try {
				st = con.createStatement();
				st1 = con.createStatement();
				status1 =st.executeUpdate("update customer set balence=balence-"+amount+" where customerid="+mobileNumber+";");
			 	status2 =st1.executeUpdate("update customer set balence=balence+"+amount+" where customerid="+reciverID+";");
			 	st.execute("insert into log values("+mobileNumber+","+amount+",'transferred',"+reciverID+");");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(status1!=0 && status2!=0) {
				status=1;
			}
		 	return status;
	   }
       
       public void transctionHistory(int mobileNumber) {
    	   try {
			st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from log where customerid="+mobileNumber+";");
			while(rs.next()) {
				System.out.println("CustomerID:"+rs.getInt(1)+","+" Balance:"+rs.getInt(2)+","+" TransctionType:"+rs.getString(3)+","+" To/From:"+rs.getInt(4));
			}
			rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	    
       }
       
}
