package mihajlovic.jelena.hangmanGame;

import javax.swing.SwingUtilities;

public class Main {

	/**
	 * Create a program that selects a random word and then allows the user to guess
	 * it in a game of hangman. Like the real game, there should be blank spots for
	 * each letter in the word, and a part of the body should be added each time the
	 * user guesses a letter that is not in the answer. You may choose how many
	 * wrong turns the user can make until the game ends. 
	 * Subgoals: 
	 * If the user loses, print out the word at the end of the game. 
	 * Create a "give up" option.
	 */

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GameFrame().loader();
			}
		});
	}
}