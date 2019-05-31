import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mihajlovic.jelena.FibonacciSequence;

class FibonacciSequenceTest {

	@Test
	void testFibRecursion() {

		assertEquals(0, FibonacciSequence.fibRecursion(0));
		assertEquals(1, FibonacciSequence.fibRecursion(1));
		assertEquals(1, FibonacciSequence.fibRecursion(2));
		assertEquals(2, FibonacciSequence.fibRecursion(3));
		assertEquals(3, FibonacciSequence.fibRecursion(4));
		assertEquals(5, FibonacciSequence.fibRecursion(5));
		assertEquals(8, FibonacciSequence.fibRecursion(6));
		assertEquals(13, FibonacciSequence.fibRecursion(7));
		assertEquals(21, FibonacciSequence.fibRecursion(8));
		assertEquals(34, FibonacciSequence.fibRecursion(9));
		assertEquals(55, FibonacciSequence.fibRecursion(10));
	}

	@Test
	void testFibLoop() {

		assertEquals(0, FibonacciSequence.fibLoop(0));
		assertEquals(1, FibonacciSequence.fibLoop(1));
		assertEquals(1, FibonacciSequence.fibLoop(2));
		assertEquals(2, FibonacciSequence.fibLoop(3));
		assertEquals(3, FibonacciSequence.fibLoop(4));
		assertEquals(5, FibonacciSequence.fibLoop(5));
		assertEquals(8, FibonacciSequence.fibLoop(6));
		assertEquals(13, FibonacciSequence.fibLoop(7));
		assertEquals(21, FibonacciSequence.fibLoop(8));
		assertEquals(34, FibonacciSequence.fibLoop(9));
		assertEquals(55, FibonacciSequence.fibLoop(10));
	}

	@Test
	void testUseLambda() {

		assertEquals(0, FibonacciSequence.useLambda(0));
		assertEquals(1, FibonacciSequence.useLambda(1));
		assertEquals(1, FibonacciSequence.useLambda(2));
		assertEquals(2, FibonacciSequence.useLambda(3));
		assertEquals(3, FibonacciSequence.useLambda(4));
		assertEquals(5, FibonacciSequence.useLambda(5));
		assertEquals(8, FibonacciSequence.useLambda(6));
		assertEquals(13, FibonacciSequence.useLambda(7));
		assertEquals(21, FibonacciSequence.useLambda(8));
		assertEquals(34, FibonacciSequence.useLambda(9));
		assertEquals(55, FibonacciSequence.useLambda(10));
	}

}
