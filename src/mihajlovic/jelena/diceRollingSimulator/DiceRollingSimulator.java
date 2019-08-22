package mihajlovic.jelena.diceRollingSimulator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class DiceRollingSimulator {

	/*
	 * By using the random module, Python can do things like pseudo-random number
	 * generation.
	 * 
	 * Allow the user to input the amount of sides on a dice and how many times it
	 * should be rolled. Your program should simulate dice rolls and keep track of
	 * how many times each number comes up (this does not have to be displayed).
	 * Finally, print out how many times each number came up.
	 * 
	 * Subgoals: Adjust your program so that if the user does not type in a number
	 * when they need to, the program will keep prompting them to type in a real
	 * number until they do so. Put the program into a loop so that the user can
	 * continue to simulate dice rolls without having to restart the entire program.
	 * In addition to printing out how many times each side appeared, also print out
	 * the percentage it appeared. If you can, round the percentage to 4 digits
	 * total OR two decimal places.
	 * 
	 * Bonus: You are about to play a board game, but you realize you don't have any
	 * dice. Fortunately you have this program. Create a program that opens a new
	 * window and draws 2 six-sided dice. Allow the user to quit, or roll again.
	 * Allow the user to select the number of dice to be drawn on screen(1-4). Add
	 * up the total of the dice and display it.
	 */

	private static Map<Integer, Integer> frequency;

	private static Map<Integer, Integer> createDice(int sides) {
		frequency = new HashMap<Integer, Integer>();
		for (int i = 1; i <= sides; i++) {
			frequency.put(i, 0);
		}
		return frequency;
	}

	public static int roll(int sides) {
		Random rand = new Random();
		return rand.nextInt(sides) + 1;
	}

	public static void rolled(int sides, int times) {
		for (int i = 0; i < times; i++) {
			int number = roll(sides);
			frequency.put(number, frequency.get(number) + 1);
		}
	}

	private static int enterInteger(Scanner scanner) {
		while (!scanner.hasNextInt()) {
			System.out.println("Please enter positive integer.");
			scanner.next();
		}
		return scanner.nextInt();
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int sides = 0;
		int times = 0;
		String exit = "";

		while (!exit.equalsIgnoreCase("x")) {
			do {
				System.out.println("Enter the amount of sides on a dice: ");
				sides = enterInteger(scan);
			} while (sides <= 0);

			createDice(sides);

			do {
				System.out.println("How many times the dice should be rolled?");
				times = enterInteger(scan);
			} while (times <= 0);

			rolled(sides, times);
			for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
				if (entry.getValue() > 0) {
					String per = String.format("%.2f", (float) entry.getValue() * 100 / times);
					System.out.println("Number " + entry.getKey() + " comes up " + entry.getValue()
							+ " time(s), percental " + per + "%.");
				}

			}
			System.out.println("Press \"enter\" to roll again or \"x\" to exit.");
			exit = scan.nextLine();
			exit = scan.nextLine();
		}
		scan.close();
	}

}
