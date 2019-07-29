package mihajlovic.jelena.hangmanGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class HelperMethods {

	private static final int NUMBER_OF_LETTERS = 26;
	static JButton[] letters = new JButton[NUMBER_OF_LETTERS];

	static List<String> loadFile(String pathname) {
		List<String> messages = new ArrayList<String>();
		File file = new File(pathname);
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String aLine;
			while ((aLine = buffer.readLine()) != null) {
				messages.add(aLine);
			}
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return messages;
	}

	static JButton[] letters() {
		int i = 0;
		for (char letter = 'A'; letter <= 'Z'; letter++, i++) {
			letters[i] = new JButton("" + letter);
			char key = letter;
			JButton button = letters[i];
			letters[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					GameFrame.hangman.updateSecretWord(key);
					button.setEnabled(false);
					if (GameFrame.hangman.lives == 0 || GameFrame.hangman.isGameWon()) {
						JOptionPane.showMessageDialog(null, String.format("%s The puzzle was: %s.",
								GameFrame.hangman.endOfGame(), GameFrame.hangman.word));
						GameFrame.hangman.loadWord();
						for (int i = 0; i < letters.length; i++)
							letters[i].setEnabled(true);
					}
				}
			});
		}
		return letters;
	}
}