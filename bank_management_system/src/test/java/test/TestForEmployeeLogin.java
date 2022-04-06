package test;

import org.junit.Test;
import static org.junit.Assert.*;
import bank_management_system.Employee;

public class TestForEmployeeLogin {
    Employee e=new Employee();
    
    @Test
    public void testEmployee() {
    	assertEquals(1,e.checkEmployee(7458, "1234"));
    }
    
    ////////////Negative Test////////////////
    @Test
    public void negativeTestEmployee() {
    	assertNotEquals(1,e.checkEmployee(7458, "1235"));
    }

}
