package mihajlovic.jelena;

import java.util.function.UnaryOperator;

/*
 * Define a function that allows the user to find the value of the nth term in the sequence.
To make sure you've written your function correctly, test the first 10 numbers of the sequence.
You can assume either that the first two terms are 0 and 1 or that they are both 1.
There are two methods you can employ to solve the problem. One way is to solve it using a loop 
and the other way is to use recursion.
Try implementing a solution using both methods.
 */
public class FibonacciSequence {

	public static int fibRecursion(int n) {
		if (n < 2)
			return n;
		else
			return fibRecursion(n - 1) + fibRecursion(n - 2);
	}

	public static int fibLoop(int n) {
		int first = 0;
		int second = 1;
		int value = 0;
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int i = 1;
		while (n > i) {
			value = first + second;
			first = second;
			second = value;
			i++;
		}
		return value;
	}

	static UnaryOperator<Integer> fibonacci = n -> n < 2 ? n
			: FibonacciSequence.fibonacci.apply(n - 1) + FibonacciSequence.fibonacci.apply(n - 2);

	public static int useLambda(int n) {
		return fibonacci.apply(n);
	}
}
