package mihajlovic.jelena;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fromTheWeb.TextPrompt;
import fromTheWeb.TextPrompt.Show;

/*
 * use in main method
 
 SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
			
			}
		});
 */
public class MyGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLabel label;
	private JButton button;
	private JTextField text;
	private String jTextString;
	private TextPrompt prompt;

	public MyGUI(String title, int width, int height, String path) {

		frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		label = new JLabel(washout(path));
		frame.add(label);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		frame.pack();
		frame.setVisible(true);
	}

	public JButton addButton(String name) {

		button = new JButton(name);
		label.add(button);
		button.setVisible(true);
		frame.pack();
		return button;
	}

	public JLabel addLabel(String lbl) {

		JLabel label1 = new JLabel(lbl);
		label1.setForeground(Color.BLACK);
		label1.setFont(new Font("Serif", Font.BOLD, 15));
		label.add(label1);
		label1.setVisible(true);
		frame.pack();
		return label1;
	}

	public JTextField addTextField(String str) {

		text = new JTextField(30);
		setPrompt(str);
		text.setEditable(true);
		text.setVisible(true);
		label.add(text);
		frame.pack();
		return text;
	}

	public String getJTextDefault() {
		return this.jTextString;
	}

	public void setPrompt(String str) {

		prompt = new TextPrompt(str, text);
		this.jTextString = str;
		prompt.setShow(Show.ALWAYS);
		prompt.changeStyle(Font.ITALIC);
	}

	// from ImageArray

	private static int[][][] convertToArray(BufferedImage image) {
		int[][][] imageAsArray = new int[image.getWidth()][image.getHeight()][4];

		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				Color pixelColor = new Color(image.getRGB(i, j));
				imageAsArray[i][j][0] = pixelColor.getRed();
				imageAsArray[i][j][1] = pixelColor.getGreen();
				imageAsArray[i][j][2] = pixelColor.getBlue();
				imageAsArray[i][j][3] = pixelColor.getAlpha();
			}
		}
		return imageAsArray;

	}

	private static BufferedImage convertToImage(int[][][] imageAsArray) {

		BufferedImage buff = new BufferedImage(imageAsArray.length, imageAsArray[0].length, BufferedImage.TYPE_INT_ARGB);
		for (int x = 0; x < imageAsArray.length; x++) {
			for (int y = 0; y < imageAsArray[0].length; y++) {
				Color color = new Color(imageAsArray[x][y][0], imageAsArray[x][y][1], imageAsArray[x][y][2],
						imageAsArray[x][y][3]);
				int rgb = color.getRGB();
				buff.setRGB(x, y, rgb);
			}
		}
		return buff;
	}

	private static ImageIcon washout(String path) {

		ImageIcon image = new ImageIcon(path);
		BufferedImage buffered = new BufferedImage(image.getIconWidth(), image.getIconHeight(),
				BufferedImage.TYPE_INT_ARGB);
		Graphics g = buffered.createGraphics();
		image.paintIcon(null, g, 0, 0);
		g.dispose();
		int[][][] imageAsArray = convertToArray(buffered);
		for (int[][] pixel : imageAsArray) {
			for (int[] color : pixel) {
				color[3] = 150;
			}
		}
		return new ImageIcon(convertToImage(imageAsArray));
	}
}
