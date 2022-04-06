package test;

import org.junit.Test;
import static org.junit.Assert.*;
import bank_management_system.CustomerOperations;

public class TestViewBalance {
  CustomerOperations cop=new CustomerOperations();
  
  @Test
  public void testViewBalence() {
	  assertEquals(8200,cop.viewBalence(9794));
  }
  
  //////////////Negative Test////////////////
  @Test
  public void negativeTestViewBalence() {
	  assertNotEquals(830,cop.viewBalence(9794));
  }
}
