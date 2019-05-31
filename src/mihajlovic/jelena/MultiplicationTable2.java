package mihajlovic.jelena;

import javax.swing.JOptionPane;

public class MultiplicationTable2 {

	private static void table(int n) {

		System.out.print("     ");
		for (int i = 1; i <= n; i++)
			System.out.printf("%6d", i);
		System.out.println();
		System.out.print("-----");
		for (int i = 1; i <= 6 * n; i++)
			System.out.print("-");
		System.out.println();

		for (int i = 1; i <= n; i++) {
			System.out.printf("%3d%2s", i, " |");
			for (int j = 1; j <= n; j++) {
				System.out.printf("%6d", i * j);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		String answer = JOptionPane.showInputDialog("Choose a number to set the size of the table:");
		int size = Integer.parseInt(answer);
		table(size);
	}

}
