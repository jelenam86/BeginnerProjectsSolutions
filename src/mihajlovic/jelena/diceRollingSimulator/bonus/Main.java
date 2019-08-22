package mihajlovic.jelena.diceRollingSimulator.bonus;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		Object[] options = { 1, 2, 3, 4, "exit" };
		int n = JOptionPane.showOptionDialog(null, "Select the number of dice to be drawn on screen:",
				"Dice Rolling Simulator", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
				options[0]);

		if (n == 4)
			System.exit(0);

		JFrame frame = new JFrame("Dice Rolling Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension((n + 2) * 100, 180));
		frame.setResizable(false);
		frame.setContentPane(new DicePanel(n + 1));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
