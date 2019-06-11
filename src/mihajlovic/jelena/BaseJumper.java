package mihajlovic.jelena;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * Create a program that converts an integer to the specified base.
The program should ask for 3 inputs. The number to convert. The base the number is in. 
And the base to convert the number to.
The program should accept a base that is in the range of 2 to 16 inclusive.
Display the result to the user and ask if they want to exit or convert another number.
Subgoals:
Do not display leading zero's in the result.
Validate that the number entered is valid for the specified base
 */

public class BaseJumper {

	private static Map<Character, Integer> digits() {
		Map<Character, Integer> digits = new LinkedHashMap<Character, Integer>();
		digits.put('0', 0);
		digits.put('1', 1);
		digits.put('2', 2);
		digits.put('3', 3);
		digits.put('4', 4);
		digits.put('5', 5);
		digits.put('6', 6);
		digits.put('7', 7);
		digits.put('8', 8);
		digits.put('9', 9);
		digits.put('A', 10);
		digits.put('B', 11);
		digits.put('C', 12);
		digits.put('D', 13);
		digits.put('E', 14);
		digits.put('F', 15);
		return digits;
	}

	private static boolean checkTheNumber(String number, int base) {
		char[] digits = number.toCharArray();

		int count = 0;
		List<Character> baseDigits = new ArrayList<Character>();
		for (Map.Entry<Character, Integer> entry : digits().entrySet()) {
			if (count == base)
				break;
			baseDigits.add(entry.getKey());
			count++;
		}

		for (int i = 0; i < digits.length; i++) {
			if (!baseDigits.contains(digits[i]))
				return false;
		}
		return true;
	}

	private static int fromBaseToDecimal(String number, int base) {
		char[] digitsOfNumber = number.toCharArray();
		int value = 0;
		List<Integer> numbers = new ArrayList<Integer>();
		for (int j = 0; j < number.length(); j++) {
			numbers.add(digits().get(digitsOfNumber[j]));
			value += numbers.get(j) * Math.pow(base, number.length() - j - 1);
		}
		return value;
	}

	private static String fromDecimalToBase(int number, int base) {
		String num = "";
		while (number > 0) {
			for (Map.Entry<Character, Integer> entry : digits().entrySet()) {
				if (entry.getValue() == number % base) {
					num += entry.getKey();
					break;
				}
			}
			number /= base;
		}
		return new StringBuilder().append(num).reverse().toString();
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String again = "";
		while (!again.equals("no")) {
			System.out.print("Number: ");
			String number = scanner.next();

			int base = 0;
			boolean check = true;
			while (base < 2 || base > 16 || !check) {
				System.out.print("Base of the number: ");
				base = scanner.nextInt();
				check = checkTheNumber(number, base);
				if (!check || base < 2 || base > 16)
					System.out.println("Please enter valid base!");
			}

			int base2 = 0;
			while (base2 < 2 || base2 > 16) {
				System.out.print("To base: ");
				base2 = scanner.nextInt();
			}

			System.out.println("In base " + base2 + " the number is: "
					+ fromDecimalToBase(fromBaseToDecimal(number, base), base2));

			System.out.println();
			System.out.print("Do you want to convert another number? Type \"yes\" or \"no\": ");
			again = scanner.next();
			System.out.println();
		}

		scanner.close();
	}
}