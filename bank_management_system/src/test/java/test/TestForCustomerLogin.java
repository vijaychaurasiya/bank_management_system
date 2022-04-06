package test;
import static org.junit.Assert.*;
import org.junit.Test;
import bank_management_system.Customer;
public class TestForCustomerLogin {
	Customer co = new Customer();

	@Test
    public void testCustomer()
    {
		assertEquals(1,co.checkCustomer(9794,"1234"));
		
	}
	
	////////// Negative Test/////////////////
	@Test
	public void negativeTestCustomer() {
		assertNotEquals(1,co.checkCustomer(9793,"1235"));
	}
}
