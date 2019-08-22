package mihajlovic.jelena.diceRollingSimulator.bonus;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DicePanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DrawingDice[] dice;
	private int total;
	private JButton roll, quit;
	private JLabel label;

	public DicePanel(int dices) {

		dice = new DrawingDice[dices];
		roll = new JButton("Roll");
		quit = new JButton("Quit");
		label = new JLabel();

		for (int i = 0; i < dice.length; i++) {
			dice[i] = new DrawingDice();
		}

		addComponents();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == quit)
			System.exit(0);
		for (DrawingDice d : dice)
			total += d.roll();
		label.setText("Total: " + total);
		total = 0;
	}

	private JPanel south() {
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		south.add(roll);
		south.add(quit);
		return south;
	}

	private JPanel north() {
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout());
		for (DrawingDice d : dice)
			north.add(d);
		return north;
	}

	private void addComponents() {
		roll.addActionListener(this);
		quit.addActionListener(this);

		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);

		setLayout(new BorderLayout(10, 10));
		add(north(), BorderLayout.NORTH);
		add(label, BorderLayout.CENTER);
		add(south(), BorderLayout.SOUTH);
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}

}
