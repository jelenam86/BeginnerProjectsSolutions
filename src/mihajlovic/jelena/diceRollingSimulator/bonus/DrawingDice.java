package mihajlovic.jelena.diceRollingSimulator.bonus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;

import javax.swing.JComponent;

public class DrawingDice extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int DIAMETAR = 10;
	private int value;

	Random rand = new Random();

	public DrawingDice() {
		setPreferredSize(new Dimension(70, 70));
		roll();
	}

	public int roll() {
		value = rand.nextInt(6) + 1;
		repaint();
		return value;
	}

	private void drawSpot(Graphics2D g2, int x, int y) {
		g2.fillOval(x - DIAMETAR / 2, y - DIAMETAR / 2, DIAMETAR, DIAMETAR);
	}

	@Override
	public void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.BLACK);

		g2.drawRect(0, 0, width - 1, height - 1);

		switch (value) {
		case 1:
			drawSpot(g2, width / 2, height / 2);
			break;
		case 3:
			drawSpot(g2, width / 2, height / 2);
		case 2:
			drawSpot(g2, width / 4, height / 4);
			drawSpot(g2, 3 * width / 4, 3 * height / 4);
			break;
		case 5:
			drawSpot(g2, width / 2, height / 2);
		case 4:
			drawSpot(g2, width / 4, height / 4);
			drawSpot(g2, 3 * width / 4, 3 * height / 4);
			drawSpot(g2, 3 * width / 4, height / 4);
			drawSpot(g2, width / 4, 3 * height / 4);
			break;
		case 6:
			drawSpot(g2, width / 4, height / 4);
			drawSpot(g2, 3 * width / 4, 3 * height / 4);
			drawSpot(g2, 3 * width / 4, height / 4);
			drawSpot(g2, width / 4, 3 * height / 4);
			drawSpot(g2, width / 4, height / 2);
			drawSpot(g2, 3 * width / 4, height / 2);
			break;
		}
	}
}
