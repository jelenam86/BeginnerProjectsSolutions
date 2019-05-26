package mihajlovic.jelena;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class RockPaperScisscors {

	/*
	 * Create a rock-paper-scissors game. Ask the player to pick rock, paper or
	 * scissors. Have the computer chose its move. Compare the choices and decide
	 * who wins. Print the results. Subgoals: Give the player the option to play
	 * again. Keep a record of the score (e.g. Player: 3 / Computer: 6).
	 */

	private static String computerChoice() {
		int x = new Random().nextInt(3);
		if (x == 0)
			return "rock";
		else if (x == 1)
			return "paper";
		else
			return "scisscors";
	}

	private static String scoreChange(JLabel lbl) {
		int x = Integer.parseInt(lbl.getText());
		x++;
		return Integer.toString(x);
	}

	private static void setScore(JLabel l1, JLabel l2) {
		if (l1.getText().isBlank())
			l1.setText("0");
		if (l2.getText().isBlank())
			l2.setText("0");
	}

	private static void rock(String comp, String player, JLabel lbl, JLabel scoreC, JLabel scoreP) {
		setScore(scoreC, scoreP);
		if (comp.equals("rock")) {
			if (player.equals("paper")) {
				lbl.setText("You won!");
				scoreP.setText(scoreChange(scoreP));
			} else {
				lbl.setText("You lose!");
				scoreC.setText(scoreChange(scoreC));
			}
		}
	}

	private static void paper(String comp, String player, JLabel lbl, JLabel scoreC, JLabel scoreP) {
		setScore(scoreC, scoreP);
		if (comp.equals("paper")) {
			if (player.equals("scisscors")) {
				lbl.setText("You won!");
				scoreP.setText(scoreChange(scoreP));
			} else {
				lbl.setText("You lose!");
				scoreC.setText(scoreChange(scoreC));
			}
		}
	}

	private static void scisscors(String comp, String player, JLabel lbl, JLabel scoreC, JLabel scoreP) {
		setScore(scoreC, scoreP);
		if (comp.equals("scisscors")) {
			if (player.equals("rock")) {
				lbl.setText("You won!");
				scoreP.setText(scoreChange(scoreP));
			} else {
				lbl.setText("You lose!");
				scoreC.setText(scoreChange(scoreC));
			}
		}
	}

	private static void equality(String comp, String player, JLabel lbl, JLabel scoreC, JLabel scoreP) {
		if (comp.equals(player)) {
			lbl.setText("Tie!");
			setScore(scoreC, scoreP);
		} else {
			rock(comp, player, lbl, scoreC, scoreP);
			paper(comp, player, lbl, scoreC, scoreP);
			scisscors(comp, player, lbl, scoreC, scoreP);
		}
	}

	private static void addComponentsToPane(Container pane) {

		JButton rock, paper, scisscors, reset, quit;
		JLabel label, lblPlayer, lblComp, lblResultP, lblResulC, player, comp, lblScore, lblText;

		GridBagLayout gridBag = new GridBagLayout();
		pane.setLayout(gridBag);

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;

		label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		label.setText("Choose one:");

		gbc.weightx = 0.5;

		gbc.fill = GridBagConstraints.CENTER;
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.gridx = 1;
		gbc.gridy = 1;
		pane.add(label, gbc);

		player = new JLabel();
		player.setHorizontalAlignment(JLabel.CENTER);
		player.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 20;
		gbc.weightx = 2;
		gbc.gridx = 0;
		gbc.gridy = 5;
		pane.add(player, gbc);

		comp = new JLabel();
		comp.setHorizontalAlignment(JLabel.CENTER);
		comp.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 20;
		gbc.gridx = 2;
		gbc.gridy = 5;
		pane.add(comp, gbc);

		lblText = new JLabel();
		lblText.setHorizontalAlignment(JLabel.CENTER);
		lblText.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 18));
		lblText.setText("");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 5;
		pane.add(lblText, gbc);

		lblResultP = new JLabel();
		lblResultP.setHorizontalAlignment(JLabel.CENTER);
		lblResultP.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
		gbc.ipady = 0;
		gbc.weightx = 2;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 6;
		gridBag.setConstraints(lblResultP, gbc);
		pane.add(lblResultP);

		lblResulC = new JLabel();
		lblResulC.setHorizontalAlignment(JLabel.CENTER);
		lblResulC.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
		gbc.ipady = 0;
		gbc.weightx = 2;
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		gbc.gridy = 6;
		gridBag.setConstraints(lblResulC, gbc);
		pane.add(lblResulC);

		rock = new JButton("rock");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.weighty = 0.2;
		gbc.gridx = 0;
		gbc.gridy = 2;
		rock.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.setText("rock");
				comp.setText(computerChoice());
				equality(comp.getText(), player.getText(), lblText, lblResulC, lblResultP);
			}
		});
		pane.add(rock, gbc);

		paper = new JButton("paper");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 1;
		gbc.gridy = 2;
		paper.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.setText("paper");
				comp.setText(computerChoice());
				equality(comp.getText(), player.getText(), lblText, lblResulC, lblResultP);
			}
		});
		pane.add(paper, gbc);

		scisscors = new JButton("scisscors");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 2;
		gbc.gridy = 2;
		scisscors.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.setText("scisscors");
				comp.setText(computerChoice());
				equality(comp.getText(), player.getText(), lblText, lblResulC, lblResultP);
			}
		});
		pane.add(scisscors, gbc);

		lblPlayer = new JLabel();
		lblPlayer.setHorizontalAlignment(JLabel.CENTER);
		lblPlayer.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 22));
		lblPlayer.setText("Player");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 4;
		pane.add(lblPlayer, gbc);

		lblComp = new JLabel();
		lblComp.setHorizontalAlignment(JLabel.CENTER);
		lblComp.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 22));
		lblComp.setText("Computer");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 2;
		gbc.gridy = 4;
		pane.add(lblComp, gbc);

		lblScore = new JLabel("Score");
		lblScore.setHorizontalAlignment(JLabel.CENTER);
		lblScore.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
		gbc.ipady = 0;
		gbc.weightx = 0.0;
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 6;
		gridBag.setConstraints(lblScore, gbc);
		pane.add(lblScore);

		reset = new JButton("reset");
		gbc.ipady = 0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		gbc.weightx = 0.5;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gridBag.setConstraints(reset, gbc);
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.setText("");
				comp.setText("");
				lblResulC.setText("0");
				lblResultP.setText("0");
				lblText.setText("");
			}
		});
		pane.add(reset);

		quit = new JButton("quit");
		gbc.ipady = 0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.SOUTH;
		gbc.weightx = 0.5;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 2;
		gbc.gridwidth = 2;
		gridBag.setConstraints(quit, gbc);
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit the game?");
				if (answer == 0) {
					if (lblResulC.getText().isBlank() || lblResultP.getText().isBlank()
							|| (lblResulC.getText().equals("0") && lblResultP.getText().equals("0")))
						System.exit(0);
					int result = Integer.parseInt(lblResulC.getText()) - Integer.parseInt(lblResultP.getText());
					String str;
					if (result > 0)
						str = "You lose the game. Better luck next time!";
					else if (result < 0)
						str = "Congratulations! You won the game!";
					else
						str = "Tie!";
					JOptionPane.showMessageDialog(null, "Result:\n" + "Player: " + lblResultP.getText() + "\nComputer: "
							+ lblResulC.getText() + "\n" + str);
					System.exit(0);
				}
			}
		});
		pane.add(quit);
	}

	private static void loader() {

		JFrame frame = new JFrame("Rock - Paper - Scisscors game");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				loader();
			}
		});
	}

}
