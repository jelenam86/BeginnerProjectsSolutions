package mihajlovic.jelena;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/*
 * Imagine that your friend is a cashier, but has a hard time counting back change to customers.
Create a program that allows him to input a certain amount of change, 
and then print how how many quarters, dimes, nickels, and pennies are needed to make up the amount needed. 
Example: if he inputs 1.47, the program will say that he needs 5 quarters, 2 dimes, 0 nickels, and 2 pennies.
Subgoals:
So your friend doesn't have to calculate how much change is needed, allow him to type in the amount of money 
given to him and the price of the item. The program should then tell him the amount of each coin he needs like usual.
To make the program even easier to use, loop the program back to the top so your friend can continue 
to use the program without having to close and open it every time he needs to count change.
 */

public class ChangeCalculator {

	private static JFrame frame;
	private static JButton quit, reset, calculate;
	private static JLabel priceOfTheItem, amountOfMoney, totalMoney, dimes, nickles, quarters, pennies, lbl;
	private static JTextField textPrice, textMoney;

	private static boolean isNumber(String s) {
		try {
			if (Double.parseDouble(s) >= 0)
				return true;
		} catch (NumberFormatException e) {
		}
		return false;
	}

	private static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(Double.toString(value));
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	private static ActionListener quit() {
		ActionListener ae = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		return ae;
	}

	private static ActionListener reset() {
		ActionListener ae = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textPrice.setText("");
				textMoney.setText("");
				totalMoney.setText("");
				dimes.setText("");
				nickles.setText("");
				quarters.setText("");
				pennies.setText("");
				lbl.setText("");
			}
		};
		return ae;
	}

	private static ActionListener calculate() {
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isNumber(textPrice.getText()) && isNumber(textMoney.getText())) {
					double money = Double.parseDouble(textMoney.getText());
					double price = Double.parseDouble(textPrice.getText());
					totalMoney.setText("Change: " + round(money - price, 2));
					int m = (int) (round(money - price, 2) * 100);
					int q = m / 25;
					int d = (m - 25 * q) / 10;
					int n = (m - 25 * q - 10 * d) / 5;
					int p = m - 25 * q - 10 * d - 5 * n;
					lbl.setText("Coins you'll need:");
					pennies.setText("PENNIES: " + p);
					dimes.setText("DIMES: " + d);
					nickles.setText("NICKLES: " + n);
					quarters.setText("QUARTERS: " + q);
				} else
					JOptionPane.showMessageDialog(null, "Only positive numbers!");
			}
		};
		return al;
	}

	private static void prepareGUI() {
		frame = new JFrame("Change Calculator");
		frame.setPreferredSize(new Dimension(500, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		priceOfTheItem = new JLabel("Enter price of the item:", JLabel.CENTER);
		priceOfTheItem.setFont(new Font(Font.SERIF, Font.BOLD, 16));
		amountOfMoney = new JLabel("Enter amount of money:", JLabel.CENTER);
		amountOfMoney.setFont(new Font(Font.SERIF, Font.BOLD, 16));
		lbl = new JLabel();
		totalMoney = new JLabel();
		totalMoney.setFont(new Font(Font.SERIF, Font.BOLD, 16));
		pennies = new JLabel("", JLabel.CENTER);
		nickles = new JLabel("", JLabel.CENTER);
		dimes = new JLabel("", JLabel.CENTER);
		quarters = new JLabel("", JLabel.CENTER);

		textPrice = new JTextField();
		textPrice.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
		textMoney = new JTextField();
		textMoney.setFont(new Font(Font.SERIF, Font.PLAIN, 16));

		calculate = new JButton("calculate");
		calculate.addActionListener(calculate());

		reset = new JButton("reset");
		reset.addActionListener(reset());

		quit = new JButton("quit");
		quit.addActionListener(quit());

		frame.setLayout(new GridLayout(10, 2));
		frame.add(new JLabel("     "));
		frame.add(new JLabel("     "));
		frame.add(priceOfTheItem);
		frame.add(textPrice);
		frame.add(amountOfMoney);
		frame.add(textMoney);
		frame.add(calculate);
		frame.add(new JLabel("     "));
		frame.add(new JLabel("     "));
		frame.add(totalMoney);
		frame.add(lbl);
		frame.add(new JLabel("     "));
		frame.add(pennies);
		frame.add(nickles);
		frame.add(dimes);
		frame.add(quarters);
		frame.add(reset);
		frame.add(quit);
		frame.getContentPane();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				prepareGUI();
			}
		});
	}

}
