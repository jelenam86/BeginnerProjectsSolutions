package mihajlovic.jelena;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PythagoreanTriplesChecker {

	/*
	 * Allows the user to input the sides of any triangle in any order. Return
	 * whether the triangle is a Pythagorean Triple or not. Loop the program so the
	 * user can use it more than once without having to restart the program.
	 */

	private static JTextField text1;
	private static JTextField text3;
	private static JTextField text2;
	private static JButton check;
	private static JButton clear;
	private static JButton quit;
	private static JButton change;
	private static JLabel answer;

	private static MyGUI gui = new MyGUI("Pythagorean Triples Checker", 430, 330, "resources/color-triples.png");

	private static String response(int a, int b, int c) {

		if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2))
			return " ";
		return " not ";
	}

	private static boolean textFunc(JTextField text) {

		if (!text.getText().matches("[0-9]+")) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

		gui.addLabel("Input the sides of any triangle in any order.")
				.setFont(new Font(Font.SANS_SERIF, Font.HANGING_BASELINE, 12));
		gui.addLabel("The app checks whether the triangle is a Pythagorean Triple or not.")
				.setFont(new Font(Font.SANS_SERIF, Font.HANGING_BASELINE, 12));
		text1 = gui.addTextField("Enter first number here...");
		text2 = gui.addTextField("Enter second number here...");
		text3 = gui.addTextField("Enter third number here...");
		check = gui.addButton("check");
		clear = gui.addButton("clear");
		change = gui.addButton("check another");
		quit = gui.addButton("quit");

		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (!(textFunc(text1) && textFunc(text2) && textFunc(text3))) {
					JOptionPane.showMessageDialog(null,
							"The sides of any triangle must be only positive integers!\nYou may have a mismatched entry.");
				} else {
					int num1 = Integer.parseInt(text1.getText());
					int num2 = Integer.parseInt(text2.getText());
					int num3 = Integer.parseInt(text3.getText());
					int max = Math.max(Math.max(num1, num2), num3);
					int min = Math.min(Math.min(num1, num2), num3);
					int mid = num1 + num2 + num3 - max - min;
					answer = gui.addLabel("The triangle is" + response(min, mid, max) + "a Pythagorean Triple.");
					check.setEnabled(false);
				}
			}
		});

		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				text1.setText("");
				text2.setText("");
				text3.setText("");
			}
		});

		change.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				text1.setText("");
				text2.setText("");
				text3.setText("");
				gui.setPrompt(gui.getJTextDefault());
				check.setEnabled(true);
				if (answer != null)
					answer.setVisible(false);

			}
		});

		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});
	}

}
