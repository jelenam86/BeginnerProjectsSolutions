package mihajlovic.jelena;

import java.util.ArrayList;
import java.util.List;

public class WhatsMyNumber {

	/*
	 * Between 1 and 1000, there is only 1 number that meets the following criteria:
	 * The number has two or more digits. The number is prime. The number does NOT
	 * contain a 1 or 7 in it. The sum of all of the digits is less than or equal to
	 * 10. The first two digits add up to be odd. The second to last digit is even
	 * and greater than 1. The last digit is equal to how many digits are in the
	 * number.
	 */

	private static List<Integer> getAllNumbers(int start, int end) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = start; i <= end; i++)
			list.add(i);
		return list;
	}

	private static List<Integer> digits(int n) {
		List<Integer> digits = new ArrayList<Integer>();
		int size = Integer.toString(n).length();
		for (int i = 1; i <= size; i++) {
			digits.add(n % 10);
			n = n / 10;
		}
		return digits;
	}

	private static boolean twoOrMoreDigits(int n) {
		if (digits(n).size() >= 2)
			return true;
		return false;
	}

	private static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; 2 * i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	private static boolean oneOrSeven(int n) {
		if (digits(n).contains(1) || digits(n).contains(7))
			return true;
		return false;
	}

	private static boolean sum(int n) {
		int sum = 0;
		for (int i = 0; i < digits(n).size(); i++) {
			sum += digits(n).get(i);
		}
		if (sum <= 10)
			return true;
		return false;
	}

	private static boolean oddSum(int n) {
		if ((digits(n).get(digits(n).size() - 1) + digits(n).get(digits(n).size() - 2)) % 2 == 1)
			return true;
		return false;
	}

	public static boolean secondToLast(int n) {
		if (digits(n).get(1) % 2 == 0 && digits(n).get(1) > 1)
			return true;
		return false;
	}

	private static boolean lastDigit(int n) {
		if (digits(n).get(0) == digits(n).size())
			return true;
		return false;
	}

	public static void main(String[] args) {

		List<Integer> list = getAllNumbers(1, 1000);

		for (int i = 0; i < list.size(); i++) {
			int x = list.get(i);
			boolean condition = twoOrMoreDigits(x) && isPrime(x) && !oneOrSeven(x) && sum(x) && oddSum(x)
					&& secondToLast(x) && lastDigit(x);
			if (condition) {
				System.out.println(x);
			}
		}
	}
}
