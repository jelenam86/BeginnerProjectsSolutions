package mihajlovic.jelena;

import java.util.Random;

import javax.swing.JOptionPane;

public class HigherLowerGuessingGame {

	/*
	 * Create a simple game where the computer randomly selects a number between 1
	 * and 100 and the user has to guess what the number is. After every guess, the
	 * computer should tell the user if the guess is higher or lower than the
	 * answer. When the user guesses the correct number, print out a congratulatory
	 * message. Subgoals: Add an introductory message that explains to the user how
	 * to play your game. In addition to the congratulatory message at the end of
	 * the game, also print out how many guesses were taken before the user arrived
	 * at the correct answer. At the end of the game, allow the user to decide if
	 * they want to play again (without having to restart the program).
	 */

	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null,
				"Higher Lower Guessing Game - Introduction\nThe computer randomly selects a "
						+ "number between 1 and 100 and you have to guess what the number is.\n"
						+ "Every time you guess, you will get information - is your number higher, l"
						+ "ower or equal to computer's number.\nGood luck!");

		int playAgain = 0;

		while (playAgain == 0) {
			int rand = new Random().nextInt(100) + 1;
			int number = 0;
			int count = -1;
			while (number != rand) {

				String answer = JOptionPane.showInputDialog("Guess number between 1 and 100");
				try {
					number = Integer.parseInt(answer);
					if (number > 100 || number < 1) {
						JOptionPane.showMessageDialog(null, "Enter only numbers between 1 and 100!");
						continue;
					}
					count++;
				} catch (NumberFormatException e) {
					int more = JOptionPane.showConfirmDialog(null, "Do you want to quit the game?");
					if (more == 0)
						System.exit(0);
					else {
						JOptionPane.showMessageDialog(null, "Then enter only numbers!");
						continue;
					}
				}

				if (number > rand)
					JOptionPane.showMessageDialog(null, number + " is too high.");
				else if (number < rand)
					JOptionPane.showMessageDialog(null, number + " is too low.");
			}
			JOptionPane.showMessageDialog(null,
					"Congratulations! You won! Number of guesses before correct answer: " + count);
			playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
		}
	}
}
