package mihajlovic.jelena;

public class ArmstrongNumber {

	/*
	 * Define a function that allows the user to check whether a given number is
	 * armstrong number or not.
	 * 
	 * Hint: To do this, first determine the number of digits of the given number.
	 * Call that n. Then take every digit in the number and raise it to the nth
	 * power. Add them, and if your answer is the original number then it is an
	 * Armstrong number.
	 * 
	 * Example: Take 1634. Four digits. So, 1^4 + 6^4 + 3^4 + 4^4 = 1 + 1296 + 81 +
	 * 256 = 1634. So 1634 is an Armstrong number.
	 * 
	 * Tip: All single digit numbers are Armstrong numbers.
	 * 
	 * Learn about armstrong numbers:
	 * https://en.wikipedia.org/wiki/Narcissistic_number
	 */

	// will check whether a given number is Armstrong in any number base
	public static boolean narcissisticFunction(String number, int base) {
		if (number.length() == 1)
			return true;
		int sum = 0;
		String result = "";
		for (char c : number.toCharArray()) {
			int n = Integer.parseInt(String.valueOf(c), base);
			result = Integer.toString(sum + (int) Math.pow(n, number.length()), base);
			sum = Integer.parseInt(result, base);
		}
		return result.equalsIgnoreCase(number);
	}

	public static void main(String[] args) {

		System.out.println(narcissisticFunction("1634", 10));
		System.out.println(narcissisticFunction("122", 3));
		// for more examples, see ArmstrongNumberTest class
	}
}
