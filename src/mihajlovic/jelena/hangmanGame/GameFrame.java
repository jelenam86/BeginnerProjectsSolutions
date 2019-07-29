package mihajlovic.jelena.hangmanGame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	static Game hangman = new Game();

	public GameFrame() {
		super("Hangman Game");
		hangman.addWords();
	}

	void loader() {
		setPreferredSize(new Dimension(500, 500));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		hangman.loadWord();
		addComponentsToPane(getContentPane());
		pack();
		setVisible(true);
	}

	private void addComponentsToPane(Container pane) {
		pane.setLayout(new BorderLayout(3, 1));
		pane.add(hangman.panel, BorderLayout.NORTH);
		pane.add(south(), BorderLayout.SOUTH);
		pane.add(center(), BorderLayout.CENTER);
	}

	private static JPanel south() {
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(7, 4));

		for (JButton button : HelperMethods.letters())
			south.add(button);

		JButton giveUp = new JButton("Give Up");
		giveUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, String.format("The puzzle was: %s.", hangman.word));
				hangman.loadWord();
				for (JButton button : HelperMethods.letters)
					button.setEnabled(true);
			}
		});
		south.add(giveUp);

		JButton exit = new JButton("Close");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		south.add(exit);
		return south;
	}

	private static JPanel center() {
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
		center.add(new DrawingHangman());
		center.add(hangman.livesLabel);
		return center;
	}
}