package test;

import org.junit.Test;
import static org.junit.Assert.*;
import bank_management_system.CustomerOperations;

public class TestDeposit {
   CustomerOperations cop=new CustomerOperations();
   
   @Test
   public void testDeposit() {
	   assertEquals(1,cop.deposit(9794, 100));
   }
   
   ////////////Negative Test/////////////////
   @Test
   public void NegativeTestDeposit() {
	   assertNotEquals(1,cop.deposit(9794453, 100));
   }
   
   
   
}
