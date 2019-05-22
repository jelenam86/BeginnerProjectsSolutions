package mihajlovic.jelena;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Magic8ball {

	/*
	 * Simulate a magic 8-ball. Allow the user to enter their question. Display an
	 * in progress message(i.e. "thinking"). Create 20 responses, and show a random
	 * response. Allow the user to ask another question or quit. Bonus: Add a gui.
	 * It must have box for users to enter the question. It must have at least 4
	 * buttons: ask, clear (the text box), play again, quit (this must close the
	 * window)
	 */

	private static JTextField text;
	private static JButton ask;
	private static JButton clear;
	private static JButton play;
	private static JButton quit;
	private static JLabel answer;

	private static MyGUI gui = new MyGUI("Magic 8-ball", 400, 200, "resources/magic8ball.png");

	private static String response() {

		ArrayList<String> listAnswers = new ArrayList<String>();
		listAnswers.add("Outlook good.");
		listAnswers.add("It is decidedly so.");
		listAnswers.add("Better not tell you now.");
		listAnswers.add("Most likely.");
		listAnswers.add("Yes definitely.");
		listAnswers.add("My sources say no.");
		listAnswers.add("My reply is no.");
		listAnswers.add("Without a doubt.");
		listAnswers.add("It is certain.");
		listAnswers.add("Ask again later.");
		listAnswers.add("Don't count on it.");
		listAnswers.add("Signs point to yes.");
		listAnswers.add("Cannot predict now.");
		listAnswers.add("You may rely on it.");
		listAnswers.add("As I see it, yes.");
		listAnswers.add("Outlook not so good.");
		listAnswers.add("Reply hazy, try again.");
		listAnswers.add("Very doubtful.");
		listAnswers.add("Yes.");
		listAnswers.add("Concentrate and ask again.");

		return listAnswers.get(new Random().nextInt(listAnswers.size()));

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				gui.addLabel("Magic 8-ball at your service.");
				text = gui.addTextField("Enter your question here...");
				ask = gui.addButton("ask");
				clear = gui.addButton("clear");
				play = gui.addButton("play again");
				quit = gui.addButton("quit");

				ask.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						if (text.getText().isBlank() || text.getText().equals(gui.getJTextDefault())) {
							JOptionPane.showMessageDialog(null, "Please enter your question first.");

						} else {
							JLabel think = gui.addLabel("thinking...");
							if (think.isShowing()) {
								new Timer().schedule(new TimerTask() {

									@Override
									public void run() {

										think.setVisible(false);
										answer = gui.addLabel("Magic 8-ball says: " + response());
									}
								}, 2000);
							}
							ask.setEnabled(false);
						}
					}
				});

				clear.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						text.setText("");
					}
				});

				play.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						text.setText("");
						gui.setPrompt(gui.getJTextDefault());
						ask.setEnabled(true);
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
		});

	}
}
