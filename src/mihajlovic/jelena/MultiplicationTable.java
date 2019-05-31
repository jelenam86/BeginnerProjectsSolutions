package mihajlovic.jelena;

import javax.swing.JOptionPane;

/*
 * Create a program that prints out a multiplication table for the numbers 1 through 9.
It should include the numbers 1 through 9 on the top and left axises, and it should be 
relatively easy to find the product of two numbers. Do not simply write out every line manually 
(ie print('7 14 21 28 35 49 56 63') ).
Subgoals:
As your products get larger, your columns will start to get crooked from the number of characters on each line. 
Clean up your table by evenly spacing columns so it is very easy to find the product of two numbers.
Allow the user to choose a number to change the size of the table (so if they type in 12, the table printed out 
should be a 12x12 multiplication table).
 */

public class MultiplicationTable {

	private static String table(int n) {

		String s = "";
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				s += j + " * " + i + " = " + i * j + "\t";
			}
			s += "\n";
		}
		return s;
	}

	public static void main(String[] args) {

		String answer = JOptionPane.showInputDialog("Choose a number to set the size of the table:");
		int size = Integer.parseInt(answer);
		System.out.println(table(size));
	}

}
