package mihajlovic.jelena;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class MultiplicationTable3 {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultiplicationTable3 window = new MultiplicationTable3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MultiplicationTable3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Multiplication table");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		table = new JTable(new MTable());
		table.setCellSelectionEnabled(true);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(true);

		frame.getContentPane().add(table);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
}

class MTable extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int[] columnes;
	int[][] data;

	MTable() {
		String answerData = JOptionPane.showInputDialog("Set size of table:");
		int answer = Integer.parseInt(answerData);
		columnes = new int[answer];
		data = new int[answer][answer];
		for (int i = 1; i <= data.length; i++) {
			for (int j = 1; j <= data[0].length; j++) {
				setValueAt(i * j, i - 1, j - 1);
			}
		}
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return columnes.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}

	public void setValueAt(int value, int row, int col) {

		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}

}
