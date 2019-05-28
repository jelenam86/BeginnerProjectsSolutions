package mihajlovic.jelena;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CoinEstimatorByWeight {

	/*
	 * Allow the user to input the total weight of each type of coin they have
	 * (pennies, nickels, dimes, and quarters). Print out how many of each type of
	 * coin wrapper they would need, how many coins they have, and the estimated
	 * total value of all of their money. Subgoals: Round all numbers printed out to
	 * the nearest whole number. Allow the user to select whether they want to
	 * submit the weight in either grams or pounds.
	 */

	// weight in grams
	private static final double PENNY = 2.5; // 1 cent
	private static final double NICKEL = 5; // 5 cents
	private static final double DIME = 2.268; // 10 cents
	private static final double QUARTER = 5.67; // 25 cents

	private static final double GRAM_POUNDS = 453.592;

	private static double weightInGrams(double weightInPounds) {
		return weightInPounds * GRAM_POUNDS;
	}

	// how many of each type can fit in wrapper
	private static final int PENNY_DIME_WRAPPER = 50;
	private static final int NICKEL_QUARTER_WRAPPER = 40;

	public CoinEstimatorByWeight() {
		prepareGUI();
	}

	private static int numberOfPennies(double weightInGrams) {
		return (int) Math.round(weightInGrams / PENNY);
	}

	private static int numberOfNickels(double weightInGrams) {
		return (int) Math.round(weightInGrams / NICKEL);
	}

	private static int numberOfDimes(double weightInGrams) {
		return (int) Math.round(weightInGrams / DIME);
	}

	private static int numberOfQuarters(double weightInGrams) {
		return (int) Math.round(weightInGrams / QUARTER);
	}

	private static int pennies(double weightInGrams) {
		return numberOfPennies(weightInGrams);
	}

	private static int nickels(double weightInGrams) {
		return numberOfNickels(weightInGrams) * 5;
	}

	private static int dimes(double weightInGrams) {
		return numberOfDimes(weightInGrams) * 10;
	}

	private static int quarters(double weightInGrams) {
		return numberOfQuarters(weightInGrams) * 25;
	}

	private static String pennyWrapper(double weightInGrams) {
		int wrapper = numberOfPennies(weightInGrams) / PENNY_DIME_WRAPPER;
		int left = numberOfPennies(weightInGrams) % PENNY_DIME_WRAPPER;
		return "Wrappers: " + wrapper + ", will left: " + left + " pennies.";
	}

	private static String dimeWrapper(double weightInGrams) {
		int wrapper = numberOfDimes(weightInGrams) / PENNY_DIME_WRAPPER;
		int left = numberOfDimes(weightInGrams) % PENNY_DIME_WRAPPER;
		return "Wrappers: " + wrapper + ", will left: " + left + " dimes.";
	}

	private static String nickelWrapper(double weightInGrams) {
		int wrapper = numberOfNickels(weightInGrams) / NICKEL_QUARTER_WRAPPER;
		int left = numberOfNickels(weightInGrams) % NICKEL_QUARTER_WRAPPER;
		return "Wrappers: " + wrapper + ", will left: " + left + " nickels.";
	}

	private static String quarterWrapper(double weightInGrams) {
		int wrapper = numberOfQuarters(weightInGrams) / NICKEL_QUARTER_WRAPPER;
		int left = numberOfQuarters(weightInGrams) % NICKEL_QUARTER_WRAPPER;
		return "Wrappers: " + wrapper + ", will left: " + left + " quarters.";
	}

	private static String isBlank(JTextField text) {
		if (text.getText().isBlank())
			text.setText("0");
		return text.getText();
	}

	private static boolean isNumber(String numb) {
		if (numb.isBlank())
			numb = "0";
		try {
			if (Double.parseDouble(numb) >= 0)
				return true;
		} catch (NumberFormatException e) {
		}
		return false;
	}

	private void prepareGUI() {

		JFrame mainFrame = new JFrame("Coin Estimator by Weight");
		mainFrame.setPreferredSize(new Dimension(550, 300));
		JLabel headerLabel1 = new JLabel("", JLabel.RIGHT);
		headerLabel1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
		JLabel headerLabel2 = new JLabel("", JLabel.LEFT);
		headerLabel2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		headerLabel1.setText("Enter data and choose \"grams\" or");
		headerLabel2.setText(" \"pounds\" to calculate your values.");

		JButton grams = new JButton("GRAMS");
		JButton pounds = new JButton("POUNDS");
		JButton reset = new JButton("reset");
		JButton quit = new JButton("quit");

		JLabel penny, nickel, dime, quarter, answerCoinsP, answerCoinsN, answerCoinsD, answerCoinsQ, answerWrapperP,
				answerWrapperN, answerWrapperD, answerWrapperQ, totalValue;

		penny = new JLabel("pennies:", JLabel.CENTER);
		nickel = new JLabel("nickels:", JLabel.CENTER);
		quarter = new JLabel("quarters:", JLabel.CENTER);
		dime = new JLabel("dimes:", JLabel.CENTER);

		answerCoinsP = new JLabel("", JLabel.LEFT);
		answerWrapperP = new JLabel("", JLabel.LEFT);
		answerCoinsN = new JLabel("", JLabel.LEFT);
		answerWrapperN = new JLabel("", JLabel.LEFT);
		answerCoinsD = new JLabel("", JLabel.LEFT);
		answerWrapperD = new JLabel("", JLabel.LEFT);
		answerCoinsQ = new JLabel("", JLabel.LEFT);
		answerWrapperQ = new JLabel("", JLabel.LEFT);
		totalValue = new JLabel("", JLabel.LEFT);

		JTextField textP, textN, textD, textQ;

		textP = new JTextField();
		textN = new JTextField();
		textD = new JTextField();
		textQ = new JTextField();

		grams.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textP.setText(isBlank(textP));
				textN.setText(isBlank(textN));
				textD.setText(isBlank(textD));
				textQ.setText(isBlank(textQ));

				boolean condition = isNumber(textP.getText()) && isNumber(textN.getText()) && isNumber(textD.getText())
						&& isNumber(textQ.getText());
				if (!condition) {
					JOptionPane.showMessageDialog(null, "Values must be positive numbers!");
					return;
				}

				double weightPenny = Double.parseDouble(textP.getText());
				double weightNickel = Double.parseDouble(textN.getText());
				double weightDime = Double.parseDouble(textD.getText());
				double weightQuarter = Double.parseDouble(textQ.getText());

				answerCoinsP.setText("Number of pennies: " + numberOfPennies(weightPenny));
				answerWrapperP.setText(pennyWrapper(weightPenny));
				answerCoinsN.setText("Number of nickles: " + numberOfNickels(weightNickel));
				answerWrapperN.setText(nickelWrapper(weightNickel));
				answerCoinsD.setText("Number of dimes: " + numberOfDimes(weightDime));
				answerWrapperD.setText(dimeWrapper(weightDime));
				answerCoinsQ.setText("Number of quarters: " + numberOfQuarters(weightQuarter));
				answerWrapperQ.setText(quarterWrapper(weightQuarter));

				int total = pennies(weightPenny) + nickels(weightNickel) + dimes(weightDime) + quarters(weightQuarter);
				boolean dollars = total >= 100;
				if (dollars)
					totalValue.setText("Total money: " + total / 100 + " dollars and " + total % 100 + " cents.");
				else
					totalValue.setText("Total money: " + total + " cents");
			}
		});

		pounds.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textP.setText(isBlank(textP));
				textN.setText(isBlank(textN));
				textD.setText(isBlank(textD));
				textQ.setText(isBlank(textQ));

				boolean condition = isNumber(textP.getText()) && isNumber(textN.getText()) && isNumber(textD.getText())
						&& isNumber(textQ.getText());
				if (!condition) {
					JOptionPane.showMessageDialog(null, "Values must be positive numbers!");
					return;
				}

				double weightPenny = weightInGrams(Double.parseDouble(textP.getText()));
				double weightNickel = weightInGrams(Double.parseDouble(textN.getText()));
				double weightDime = weightInGrams(Double.parseDouble(textD.getText()));
				double weightQuarter = weightInGrams(Double.parseDouble(textQ.getText()));

				answerCoinsP.setText("Number of pennies: " + numberOfPennies(weightPenny));
				answerWrapperP.setText(pennyWrapper(weightPenny));
				answerCoinsN.setText("Number of nickles: " + numberOfNickels(weightNickel));
				answerWrapperN.setText(nickelWrapper(weightNickel));
				answerCoinsD.setText("Number of dimes: " + numberOfDimes(weightDime));
				answerWrapperD.setText(dimeWrapper(weightDime));
				answerCoinsQ.setText("Number of quarters: " + numberOfQuarters(weightQuarter));
				answerWrapperQ.setText(quarterWrapper(weightQuarter));

				int total = pennies(weightPenny) + nickels(weightNickel) + dimes(weightDime) + quarters(weightQuarter);
				boolean dollars = total >= 100;
				if (dollars)
					totalValue.setText("Total money: " + total / 100 + " dollars and " + total % 100 + " cents.");
				else
					totalValue.setText("Total money: " + total + " cents");
			}
		});

		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textP.setText("");
				textN.setText("");
				textD.setText("");
				textQ.setText("");
				answerCoinsP.setText("");
				answerCoinsN.setText("");
				answerCoinsD.setText("");
				answerCoinsQ.setText("");
				answerWrapperP.setText("");
				answerWrapperN.setText("");
				answerWrapperD.setText("");
				answerWrapperQ.setText("");
				totalValue.setText("");
			}
		});

		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		mainFrame.setLayout(new GridLayout(12, 2));
		mainFrame.add(headerLabel1);
		mainFrame.add(headerLabel2);
		mainFrame.add(penny);
		mainFrame.add(textP);
		mainFrame.add(nickel);
		mainFrame.add(textN);
		mainFrame.add(dime);
		mainFrame.add(textD);
		mainFrame.add(quarter);
		mainFrame.add(textQ);
		mainFrame.add(grams);
		mainFrame.add(reset);
		mainFrame.add(pounds);
		mainFrame.add(quit);
		mainFrame.add(answerCoinsP);
		mainFrame.add(answerWrapperP);
		mainFrame.add(answerCoinsN);
		mainFrame.add(answerWrapperN);
		mainFrame.add(answerCoinsD);
		mainFrame.add(answerWrapperD);
		mainFrame.add(answerCoinsQ);
		mainFrame.add(answerWrapperQ);
		mainFrame.add(totalValue);
		mainFrame.getContentPane();
		mainFrame.pack();
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CoinEstimatorByWeight();
			}
		});

	}

}
