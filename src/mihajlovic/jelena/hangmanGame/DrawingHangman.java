package mihajlovic.jelena.hangmanGame;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DrawingHangman extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final int X_START = 200;
	private static final int Y_START = 30;
	private static final int X_BODY = X_START + 120;
	private static final int WIRE_LENGTH = 40;
	private static final int HEAD = 15;
	private static final int ARM_LENGTH = HEAD + 5;
	private static final int Y_ARM = Y_START + WIRE_LENGTH + (2 * HEAD) + ARM_LENGTH;
	private static final int LEG_LENGTH = 2 * HEAD;
	private static final int Y_LEG = Y_ARM + LEG_LENGTH;

	private void drawPole(int x, int y, Graphics g) {
		Graphics2D graph = (Graphics2D) g;
		graph.setStroke(new BasicStroke(2));
		graph.drawRect(x - HEAD, X_START + Y_START, ARM_LENGTH + LEG_LENGTH, 10);
		graph.drawRect(x, y, 10, X_START);
		graph.drawLine(x, y + 20, x + 20, y);
		graph.drawLine(x, y, X_BODY, y);
		graph.drawLine(X_BODY, y, X_BODY, y + WIRE_LENGTH);
	}

	private void drawHead(int x, int y, Graphics g) {
		g.drawOval(x, y, 2 * HEAD, 2 * HEAD);
	}

	private void drawBody(int x, int y, Graphics g) {
		g.drawLine(x, y, x, y + ARM_LENGTH + LEG_LENGTH);
	}

	private void drawLeftArm(int x, int y, Graphics g) {
		g.drawLine(x, y, x - ARM_LENGTH, y + ARM_LENGTH + HEAD);
	}

	private void drawRightArm(int x, int y, Graphics g) {
		g.drawLine(x, y, x + ARM_LENGTH, y + ARM_LENGTH + HEAD);
	}

	private void drawLeftLeg(int x, int y, Graphics g) {
		int a = x - LEG_LENGTH + HEAD;
		int b = y + LEG_LENGTH + HEAD;
		g.drawLine(x, y, a, b);
		g.drawLine(a, b, a - 5, b - 5);
	}

	private void drawRightLeg(int x, int y, Graphics g) {
		int a = x + LEG_LENGTH - HEAD;
		int b = y + LEG_LENGTH + HEAD;
		g.drawLine(x, y, a, b);
		g.drawLine(a, b, a + 5, b - 5);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		switch (GameFrame.hangman.lives) {
		case 0:
			drawLeftArm(X_BODY, Y_ARM, g);

		case 1:
			drawRightArm(X_BODY, Y_ARM, g);

		case 2:
			drawLeftLeg(X_BODY, Y_LEG, g);

		case 3:
			drawRightLeg(X_BODY, Y_LEG, g);

		case 4:
			drawBody(X_BODY, Y_START + WIRE_LENGTH + (2 * HEAD), g);

		case 5:
			drawHead(X_BODY - HEAD, Y_START + WIRE_LENGTH, g);

		case 6:
			drawPole(X_START, Y_START, g);
		}
		revalidate();
		repaint();
	}
}