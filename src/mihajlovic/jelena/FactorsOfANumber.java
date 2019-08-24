package mihajlovic.jelena;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FactorsOfANumber {

	/*
	 * Define a function that creates a list of all the numbers that are factors of
	 * the user's number. For example, if the function is called factor, factor(36)
	 * should return [1, 2, 3, 4, 6, 9, 12, 18, 36]. The numbers in your list should
	 * be sorted from least to greatest, and 1 and the original number should be
	 * included. Remember to consider negative numbers as well as 0. Bonus: Have the
	 * program print the factors of the users number in a comma separated string,
	 * without a comma after the last number, and without the brackets of a Python
	 * list. If the user's number is prime, note it.
	 */

	private static List<Integer> divisor(int n) {
		List<Integer> factors = new ArrayList<Integer>();
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				if (n / i != i)
					factors.add(n / i);
				factors.add(i);
			}
		}
		return factors;
	}

	private static List<Integer> factors(int n) {
		List<Integer> factor = new ArrayList<Integer>();
		for (Integer i : divisor(Math.abs(n))) {
			factor.add(i);
			if (n < 0)
				factor.add(-i);
		}
		Collections.sort(factor);
		if (factor.size() == 2)
			System.out.println("Number " + n + " is prime.");
		return factor;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		while (!scanner.hasNextInt()) {
			System.out.print("Enter only integers: ");
			scanner.nextLine();
		}
		int number = scanner.nextInt();
		if (number == 0)
			System.out.println("All nonzero numbers are factors of zero.");
		else
			System.out.println("Factors of " + number + " are: "
					+ Arrays.toString(factors(number).toArray()).replaceAll("\\[|\\]", ""));
		scanner.close();
	}

}
