package bank_management_system;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {
       public int checkEmployee(int employeeId, String password ) {
    	   int check=0;
    	   try {
    	   Connection con=DBconnection.createDBConnection();
    	   Statement st=con.createStatement();
    	   
    	   ResultSet rs = st.executeQuery("select * from employee where employeeId="+employeeId+" and password='"+password+"';");
    	   if (rs.next()) {
				check=1;
			} 
    	   }catch(SQLException e){
    		   e.printStackTrace();
    	   }
    	   return check;
       }
}
