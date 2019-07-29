package mihajlovic.jelena.hangmanGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game {

	private Stack<String> words = new Stack<String>();
	private ArrayList<JLabel> lines = new ArrayList<JLabel>();
	int lives = 6;
	JLabel livesLabel = new JLabel();
	JPanel panel = new JPanel();
	String word;

	void addWords() {
		List<String> wordsFromFile = HelperMethods.loadFile("resources/words.txt");
		Collections.shuffle(wordsFromFile);
		wordsFromFile.forEach(str -> words.push(str.toUpperCase()));
	}

	void loadWord() {
		removeWord();
		lives = 6;
		livesLabel.setText("You have " + lives + " lives");
		word = words.pop();
		hideTheWord();
	}

	private void hideTheWord() {
		for (int i = 0; i < word.length(); i++) {
			JLabel textField = new JLabel("__");
			if (("" + word.charAt(i)).matches("[^a-zA-Z]"))
				textField.setText("" + word.charAt(i));
			lines.add(textField);
			panel.add(textField);
		}
		panel.revalidate();
		panel.repaint();
	}

	private void removeWord() {
		for (JLabel box : lines) {
			panel.remove(box);
		}
		lines.clear();
	}

	String endOfGame() {
		if (lives == 0)
			return "You are hanged!";
		return String.format("Well done! You won the game with %d lives left.", lives);
	}

	void updateSecretWord(char keyChar) {
		boolean validChar = false;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == keyChar) {
				lines.get(i).setText("" + keyChar);
				validChar = true;
			}
		}
		if (!validChar)
			livesLabel.setText("You have " + --lives + " more lives");
	}

	boolean isGameWon() {
		StringBuilder builder = new StringBuilder();
		lines.forEach(label -> builder.append(label.getText()));
		return builder.toString().equals(word);
	}
}