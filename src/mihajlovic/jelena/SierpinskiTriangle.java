package mihajlovic.jelena;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SierpinskiTriangle {

    /*
     * The Sierpinski triangle (https://en.wikipedia.org/wiki/Sierpi%C5%84ski_triangle) (also with the
     * original orthography Sierpinski), also called the Sierpinski gasket or the
     * Sierpinski Sieve, is a fractal and attractive fixed set with the overall
     * shape of an equilateral triangle, subdivided recursively into smaller
     * equilateral triangles. Originally constructed as a curve, this is one of the
     * basic examples of self-similar sets, i.e., it is a mathematically generated
     * pattern that can be reproducible at any magnification or reduction. It is
     * named after the Polish mathematician Waclaw Sierpinski, but appeared as a
     * decorative pattern many centuries prior to the work of Sierpinski.
     * 
     * Task in hand : 
     * 	- create and visualize a fractal generator that forms a standard sierpinski triangle. 
     * 	- perform this using recursive calls. 
     * Subgoals: 
     * 	- Also accept depth for which the fractal should be generated.
     */

    private JFrame frame;
    private JPanel panel;

    public static void main(String[] args) {

	String answer = JOptionPane.showInputDialog("Set depth (3 is for standard output):");
	if (answer != null && answer.matches("[0-9]+")) {
	    int depth = Integer.valueOf(answer);
	    SwingUtilities.invokeLater(new Runnable() {

		@Override
		public void run() {
		    new SierpinskiTriangle().createTriangle(depth);
		}
	    });
	}
    }

    public void createTriangle(int depth) {
	frame = new JFrame("Sierpinski Triangle");
	panel = new JPanel() {
	    private static final long serialVersionUID = 1L;

	    @Override
	    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int[] xCooradinates = { panel.getWidth() / 2, 10, panel.getWidth() - 10 };
		int[] yCoordinates = { 10, panel.getHeight() - 10, panel.getHeight() - 10 };
		g.fillPolygon(xCooradinates, yCoordinates, 3);
		g.setColor(Color.WHITE);
		createTriangle(depth, xCooradinates, yCoordinates, g);
		g.dispose();
	    }

	    @Override
	    public Dimension getPreferredSize() {
		return new Dimension(800, 800);
	    }
	};

	frame.add(panel);
	frame.pack();
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
    }

    private void createTriangle(int depth, int[] xCoordinates, int[] yCoordinates, Graphics g) {
	if (depth == 0)
	    return;
	depth--;
	int[][] middlePoints = getMiddlePoints(xCoordinates, yCoordinates);
	g.fillPolygon(middlePoints[0], middlePoints[1], 3);
	int[][] xtriangles = { { xCoordinates[0], middlePoints[0][0], middlePoints[0][2] },
		{ middlePoints[0][0], xCoordinates[1], middlePoints[0][1] },
		{ middlePoints[0][2], middlePoints[0][1], xCoordinates[2] } };
	int[][] ytriangles = { { yCoordinates[0], middlePoints[1][0], middlePoints[1][2] },
		{ middlePoints[1][0], yCoordinates[1], middlePoints[1][1] },
		{ middlePoints[1][2], middlePoints[1][1], yCoordinates[2] } };
	for (int i = 0; i < xtriangles.length; i++)
	    createTriangle(depth, xtriangles[i], ytriangles[i], g);
    }

    private int[][] getMiddlePoints(int[] x, int[] y) {
	int x1 = (x[0] + x[1]) / 2;
	int x2 = (x[1] + x[2]) / 2;
	int x3 = (x[0] + x[2]) / 2;
	int y1 = (y[0] + y[1]) / 2;
	int y2 = (y[1] + y[2]) / 2;
	int y3 = (y[0] + y[2]) / 2;
	return new int[][] { { x1, x2, x3 }, { y1, y2, y3 } };
    }
}
