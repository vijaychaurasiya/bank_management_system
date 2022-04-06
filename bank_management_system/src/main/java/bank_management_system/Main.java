package bank_management_system;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		/////////////////MAIN CONSOLE///////////////////
		Scanner scan=new Scanner(System.in);
		   System.out.println("");
		   System.out.println("**************Welcome to Vijaya Bank******************");
		   System.out.println("1.Customer Login \n" + "2.Employee Login \n" + "3.New Customer \n"+ "Enter Your Choice");
		   int mainInput=scan.nextInt();
		   
		   ////////////////////////////CUSTOMER LOGIN////////////////
		   if(mainInput==1) {
			   System.out.println("**************Welcome to Vijaya Bank******************");
			   System.out.println("Enter Mobile Number");
			   int mobileNumber=scan.nextInt();
			   System.out.println("Enter Password");
			   String customerPassword=scan.next();
			   /// call db connection
			   Customer c=new Customer();
			   int temp=c.checkCustomer(mobileNumber, customerPassword);
			   
			   //////////CUSTOMER OPERATION///////////////
			   if(temp==1) {
				   System.out.println("Customer Login Successfully");
				   System.out.println("********Welcome To Coustmer Login***********");
				   System.out.println("\n1. View Account Balance \n2. Deposit \n3. Withdrawl \n4. Transfer \n5. Transction History  \n6. logout \nEnter Your Choice");
				   int customerOption=scan.nextInt();
				   CustomerOperations ce=new CustomerOperations();
				   
				   //////////VIEW BALANCE////////
				   if(customerOption==1) {
					   System.out.println("View Balance");
					  int balence= ce.viewBalence(mobileNumber);
					  if(balence>-1) {
						  System.out.println("CustomerID: "+mobileNumber+" "+"Balance: "+balence);
					  }
					  else {
						  System.out.println("This mobile number is not registerd");
					  }
				   }
				   ////////////DEPOSIT BALANCE/////////////
				   else if(customerOption==2) {
					   System.out.println("Deposite Balance");
					   System.out.println("Enter Amount:");
					   int amount=scan.nextInt();
					   if(amount<=0) {
						   System.out.println("Enter valid amount");
						   
					   }
					   else {
						   int check=ce.deposit(mobileNumber,amount);
						   if(check!=0) {
							   System.out.println("Transction Successful");
						   }
						   else {
							   System.out.println("Transction Failed");
						   }
					   }
					   
				   }
				   /////////////////WITHDRAW BALANCE////////////////
                   else if(customerOption==3) {
                	   System.out.println("Withdraw Balance");
                	   System.out.println("Enter Amount:");
					   int amount=scan.nextInt();
					   if(amount<=0) {
						   System.out.println("Enter valid amount");
						   
					   }
					   else {
						   int check=ce.withdraw(mobileNumber,amount);
						   if(check!=0) {
							   System.out.println("Transction Successful");
						   }
						   else {
							   System.out.println("Transction Failed");
						   }
					   }
				   }
				   ////////////TRANSFER BALENCE/////////////
                   else if(customerOption==4) {
                	   System.out.println("Transfer Balance");
                	   System.out.println("Enter Amount:");
                	   int amount=scan.nextInt();
                	   if(amount<=0) {
                		   System.out.println("Enter Valid Amount");
                	   }
                	   else {
                		   System.out.println("Enter ReciverID:");
                		   int reciverID=scan.nextInt();
                		   int check=ce.transfer(mobileNumber,amount,reciverID);
                		   if(check!=0) {
							   System.out.println("Transction Successful");
						   }
						   else {
							   System.out.println("Transction Failed");
						   }
                	   }
					   
				   }
				   //////////TRANSACTION HISTORY////////////
                   else if(customerOption==5) {
					   ce.transctionHistory(mobileNumber);
				   }
                   else if(customerOption==6) {
					   System.out.println("Logout Successfully");
				   }
			   }
			   else {
				   System.out.println("Credentials invalid");
			   }
			  
			   
		   }
		   ////////////////////////ADMIN LOGIN////////////////
		   else if(mainInput==2) {
			   System.out.println("**************Welcome to Admin portal******************");
			   System.out.println("Enter Employee Id");
			   int employeeId=scan.nextInt();
			   System.out.println("Enter Password");
			   String employeePassword=scan.next();
			   // call db connection
			   Employee e=new Employee();
			   int temp=e.checkEmployee(employeeId, employeePassword);
			   
			   //////////////////ADMIN OPERATIONS//////////////////
			   if(temp==1) {
				   System.out.println("Employee Login Successfully");
				   System.out.println("\n1. View Coustmer Details  \n2. Pending Request For Account Opening \n3. All Transcation \n4.Logout \nEnter Your Choice");
				   int empOption=scan.nextInt();
				   EmployeeOperations eo= new EmployeeOperations();
				   
				   ////////////////VIEW CUSTOMER DETAIL///////
				   if(empOption==1) {
					   eo.viewCustomerDetails();
				   }
				   ///////////PENDING APPLICATION/////////////////
				   else if(empOption==2) {
					   int temp1=eo.pendingApplication();
					   if(temp1==1) {
						   System.out.println("Accepted Successfully");
					   }
					   else {
						   System.out.println("Something wrong try again");
					   }
				   }
				   ////////////////////VIEW TRANSCTION/////////////
                   else if(empOption==3) {
					   eo.viewTracnsctions();
				   }
				   ////////////////LOGOUT////////////////
                   else if(empOption==4) {
					   System.out.println("Logout Successfully");
				   }
			   }
			   else {
				   System.out.println("Credentials invalid");
			   }
		   }
		   ////////////////////////NEW CUSTOMER//////////////////////
           else if(mainInput==3) {
        	   System.out.println("**************Welcome to Vijaya Bank******************");
        	   System.out.println("Enter First Name");
			   String firstName=scan.next();
			   System.out.println("Enter Last Name");
			   String lastName=scan.next();
			   System.out.println("Enter Mobile Number");
			   int mobileNumber=scan.nextInt();
			   System.out.println("Enter City");
			   String city=scan.next();
			   System.out.println("Enter Pincoad");
			   int pincoad=scan.nextInt();
			   System.out.println("Enter Opening Balence");
			   int balence=scan.nextInt();
			   System.out.println("Enter Password");
			   String customerPassword=scan.next();
			   /// call db connection
			   NewCustomer nc= new NewCustomer();
			   int temp=nc.newApplication(firstName, lastName, mobileNumber, city, pincoad, balence, customerPassword);
			   if(temp!=0) {
				   System.out.println("Application Submitted successfully");
			   }
			   else {
				   System.out.println("Application Submission Failed. Try again later");
			   }
		   }
		   scan.close();
	}
}