package mihajlovic.jelena.menuCalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuCalculator {
	/*
	 * Imagine you have started up a small restaurant and are trying to make it
	 * easier to take and calculate orders. Since your restaurant only sells 9
	 * different items, you assign each one to a number, as shown below.
	 * 
	 * i. Chicken Strips - $3.50 
	 * ii. French Fries - $2.50 
	 * iii. Hamburger - $4.00 
	 * iv. Hotdog - $3.50
	 * v. Large Drink - $1.75 
	 * vi. Medium Drink - $1.50 
	 * vii. Milk Shake - $2.25 
	 * vii. Salad - $3.75
	 * ix. Small Drink - $1.25 
	 * 
	 * To quickly take orders, your program should allow the
	 * user to type in a string of numbers and then it should calculate the cost of
	 * the order. For example, if one large drink, two small drinks, two hamburgers,
	 * one hotdog, and a salad are ordered, the user should type in 5993348, and the
	 * program should say that it costs $19.50. Also, make sure that the program
	 * loops so the user can take multiple orders without having to restart the
	 * program each time.
	 * 
	 * Subgoals: If you decide to, print out the items and prices every time before
	 * the user types in an order. Once the user has entered an order, print out how
	 * many of each item have been ordered, as well as the total price. If an item
	 * was not ordered at all, then it should not show up.
	 */

	private static Map<Integer, Items> createMenu() {
		Map<Integer, Items> items = new HashMap<Integer, Items>();
		items.put(1, new Items("Chicken Strips", 3.5f));
		items.put(2, new Items("French Fries", 2.5f));
		items.put(3, new Items("Hamburger", 4f));
		items.put(4, new Items("Hotdog", 3.5f));
		items.put(5, new Items("Large Drink", 1.75f));
		items.put(6, new Items("Medium Drink", 1.5f));
		items.put(7, new Items("Milk Shake", 2.25f));
		items.put(8, new Items("Salad", 3.75f));
		items.put(9, new Items("Small Drink", 1.25f));
		return items;
	}

	private static void printMenu(Map<Integer, Items> items) {
		for (Integer key : items.keySet()) {
			System.out.println(key + ". " + items.get(key).toString());
		}
	}

	private static int frequency(long order, int number) {
		int count = 0;
		while (order > 0) {
			if (order % 10 == number)
				count++;
			order /= 10;
		}
		return count;
	}

	private static float getOrder(String order, Map<Integer, Items> items) {
		long ordered = Long.valueOf(order).longValue();
		float price = 0f;
		for (Integer key : items.keySet()) {
			int count = frequency(ordered, key.intValue());
			if (count > 0)
				System.out.println("You have ordered " + count + " " + items.get(key).getName());
			price += count * items.get(key).getPrice();
		}
		return price;
	}

	public static void main(String[] args) {

		Map<Integer, Items> menu = createMenu();
		Scanner scan = new Scanner(System.in);
		float price = 0f;
		String answer = "yes";

		while (answer.equalsIgnoreCase("yes")) {
			printMenu(menu);
			System.out.print("\nEnter your order: ");
			String order = scan.next();
			try {
				price += getOrder(order, menu);
			} catch (NumberFormatException e) {
				System.out.println("Only ordinals of items are allowed in order.");
			}
			System.out.println(String.format("Total price of your order(s): %.2f$", price));
			System.out.println("Do you want to take another order? Enter \"yes\" or \"no\".");
			answer = scan.next();
		}

		scan.close();
	}

}
