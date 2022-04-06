package bank_management_system;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class NewCustomer {
    public int newApplication(String fname, String lname, int mobile, String city,int pincoad, int balence, String password) {
    	  int check=0;
    	Connection con= DBconnection.createDBConnection();
    	try {
			Statement st=con.createStatement();
			boolean status=st.execute("insert into application(customerid,fname,lname,mobile,city,pincoad,balence,password)" + "values("+mobile+",'"+fname+"','"+lname+"',"+mobile+",'"+city+"',"+pincoad+","+balence+",'"+password+"');");
		   // System.out.println(status);
			if(status==false) {
		    	check=1;
		    }
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return check;
    }
}
