package test;

import org.junit.Test;
import static org.junit.Assert.*;
import bank_management_system.CustomerOperations;

public class TestWithdraw {
  CustomerOperations cop=new CustomerOperations();
  
  @Test
  public void testWithdraw() {
	  assertEquals(1,cop.withdraw(9794, 500));
  }
  
  @Test
  public void negativeTestWithdraw() {
	  assertNotEquals(1,cop.withdraw(9794582, 500));
  }
}
