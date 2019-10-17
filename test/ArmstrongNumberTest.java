import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mihajlovic.jelena.ArmstrongNumber;

class ArmstrongNumberTest {

	@Test
	void testNarcissisticFunction() {

		// base 10
		assertTrue(ArmstrongNumber.narcissisticFunction("1634", 10));
		assertTrue(ArmstrongNumber.narcissisticFunction("9", 10));
		assertTrue(ArmstrongNumber.narcissisticFunction("153", 10));
		assertTrue(ArmstrongNumber.narcissisticFunction("8208", 10));
		assertTrue(ArmstrongNumber.narcissisticFunction("0", 10));
		assertTrue(ArmstrongNumber.narcissisticFunction("407", 10));
		assertFalse(ArmstrongNumber.narcissisticFunction("40", 10));
		assertFalse(ArmstrongNumber.narcissisticFunction("100", 10));
		
		// base 3
		assertTrue(ArmstrongNumber.narcissisticFunction("22", 3));
		assertTrue(ArmstrongNumber.narcissisticFunction("122", 3));
		assertFalse(ArmstrongNumber.narcissisticFunction("11", 3));
		
		// base 4
		assertTrue(ArmstrongNumber.narcissisticFunction("0", 4));
		assertTrue(ArmstrongNumber.narcissisticFunction("130", 4));
		assertTrue(ArmstrongNumber.narcissisticFunction("3303", 4));
		assertFalse(ArmstrongNumber.narcissisticFunction("100", 4));
		assertFalse(ArmstrongNumber.narcissisticFunction("1000", 4));
		
		// base 5
		assertTrue(ArmstrongNumber.narcissisticFunction("1", 5));
		assertTrue(ArmstrongNumber.narcissisticFunction("23", 5));
		assertTrue(ArmstrongNumber.narcissisticFunction("124030", 5));
		
		// base 12
		assertTrue(ArmstrongNumber.narcissisticFunction("B", 12));
		assertTrue(ArmstrongNumber.narcissisticFunction("A5", 12));
		assertTrue(ArmstrongNumber.narcissisticFunction("668", 12));
		
		// base 16
		assertTrue(ArmstrongNumber.narcissisticFunction("B", 16));
		assertTrue(ArmstrongNumber.narcissisticFunction("156", 16));
		assertTrue(ArmstrongNumber.narcissisticFunction("4A5", 16));
		assertFalse(ArmstrongNumber.narcissisticFunction("AB", 16));

	}

}
