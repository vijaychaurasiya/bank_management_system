package bank_management_system;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;

public class EmployeeOperations {
	      Scanner scan=new Scanner(System.in);
	     Connection con= DBconnection.createDBConnection();
	     Statement st;
	     public void viewCustomerDetails() {
	    	 
	    	 
			try {
				st = con.createStatement();
				ResultSet rs=st.executeQuery("Select * from customer;");
				while(rs.next()) {
					System.out.println("Coustmer Id : "+rs.getString(1));
					System.out.println("Password : "+rs.getString(2));
					System.out.println("Name : "+rs.getString(3)+" "+rs.getString(4));
					System.out.println("Mobile : "+rs.getInt(5));
					System.out.println("City : "+rs.getString(6));
					System.out.println("Pincoad : "+rs.getInt(7));
					System.out.println("Balence : "+rs.getInt(8));
					System.out.println("*******************************************");
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 
	    	 
	     }
	     
	     public int pendingApplication() {
	    	 int check=0;
	    	    try {
					st=con.createStatement();
					ResultSet rs=st.executeQuery("Select * from application;");
					
					while(rs.next()) {
						System.out.println("Coustmer Id : "+rs.getString(1));
						System.out.println("Password : "+rs.getString(2));
						System.out.println("Name : "+rs.getString(3)+" "+rs.getString(4));
						System.out.println("Mobile : "+rs.getInt(5));
						System.out.println("City : "+rs.getString(6));
						System.out.println("Pincoad : "+rs.getInt(7));
						System.out.println("Balence : "+rs.getInt(8));
						System.out.println("*******************************************");
					}
					System.out.println("Enter Customerid to accept specific application Or Enter 0 to accept all application");
					int pendingCustomerid=scan.nextInt();
					if(pendingCustomerid!=0) {
						boolean status=st.execute("insert into customer (select * from application where customerid="+pendingCustomerid+");");
						st.execute("delete from application where customerid="+pendingCustomerid+";");
						 //System.out.println(status);
						if(status==false) {
							check=1;
						}
						   
					}
					else {
						boolean status=st.execute("insert into customer select * from application;");
						st.execute("delete from application;");
						if(status==false) {
							check=1;
						}
						   // System.out.println(status);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    return check;
	     }
	     
	      public void viewTracnsctions(){
	    	     try {
					st=con.createStatement();
					ResultSet rs=st.executeQuery("Select * from log;");
							while(rs.next()) {
								System.out.println("CoustmerId:"+rs.getInt(1)+"," + " Amount:"+rs.getInt(2)+"," + " TransctionType:"+rs.getString(3)+"," + " To/From:"+rs.getInt(4)+",");
							}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
	      
	       public void logout() {
	    	  try {
				st=con.createStatement();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	  
	      }
}
