package mihajlovic.jelena;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MeanMedianMode {

	/*
	 * In a set of numbers, the mean is the average, the mode is the number that
	 * occurs the most, and if you rearrange all the numbers numerically, the median
	 * is the number in the middle. Create three functions that allow the user to
	 * find the mean, median, and mode of a list of numbers. If you have access or
	 * know of functions that already complete these tasks, do not use them.
	 * Subgoals In the mean function, give the user a way to select how many decimal
	 * places they want the answer to be rounded to. If there is an even number of
	 * numbers in the list, return both numbers that could be considered the median.
	 * If there are multiple modes, return all of them.
	 */

	private static double mean(List<Integer> list, int places) {
		double mean = 0;
		for (Integer i : list)
			mean += i;
		mean /= list.size();
		return round(mean, places);
	}

	private static List<Integer> mode(List<Integer> list) {
		HashMap<Integer, Integer> mode = new HashMap<Integer, Integer>();
		for (int i = 0; i < list.size(); i++) {
			int value = mode.get(list.get(i)) == null ? 1 : mode.get(list.get(i)) + 1;
			mode.put(list.get(i), value);
		}
		List<Integer> allMode = new ArrayList<Integer>();
		int maxValue = Collections.max(mode.values());
		for (Integer value : mode.keySet()) {
			if (mode.get(value) == maxValue)
				allMode.add(value);
		}
		return allMode;
	}

	private static List<Integer> median(List<Integer> list) {
		List<Integer> median = new ArrayList<Integer>();
		Collections.sort(list);
		if (list.size() % 2 == 0) {
			median.add(list.get(list.size() / 2 - 1));
			median.add(list.get(list.size() / 2));
		} else
			median.add(list.get(list.size() / 2));
		return median;
	}

	private static double round(double number, int decimals) {
		if (decimals < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(Double.toString(number));
		bd = bd.setScale(decimals, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public static void main(String[] args) {

		List<Integer> example = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter numbers to calculate mean, median and mode.");
		System.out.println("Enter -1 to exit.");

		int number = scan.nextInt();
		while (number != -1) {
			example.add(number);
			number = scan.nextInt();
		}

		System.out.println("How many decimal places you want the answer for mean value to be rounded to?");
		int decimals = scan.nextInt();
		scan.close();
		Collections.sort(example);

		System.out.println();
		System.out.println("Your list sorted: " + example);
		System.out.println("Mean is: " + mean(example, decimals));
		System.out.println("Median: " + median(example).toString().substring(1).replaceFirst("]", ""));
		System.out.println("Mode: " + mode(example).toString().substring(1).replaceFirst("]", ""));
	}

}
