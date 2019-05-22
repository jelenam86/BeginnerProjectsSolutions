package mihajlovic.jelena;

public class Bottles99 {

	/*
	 * Create a program that prints out every line to the song
	 * "99 bottles of beer on the wall." Do not use a list for all of the numbers,
	 * and do not manually type them all in. Use a built in function instead.
	 * Besides the phrase "take one down," you may not type in any numbers/names of
	 * numbers directly into your song lyrics. Remember, when you reach 1 bottle
	 * left, the word "bottles" becomes singular.
	 * 
	 * 
	 * http://99-bottles-of-beer.net/
	 */

	private static void lyrics(int n, int m) {

		String bottle = "bottle";
		String beer = "bottle";
		String number = "no more";

		if (n == 0)
			System.out.println("\nNo more bottles of beer on the wall, no more bottles of beer. \n"
					+ "Go to the store and buy some more, " + m + " bottles of beer on the wall.");
		else {
			if (n > 1) {
				number = Integer.toString(n - 1);
				bottle += "s";
			}
			if (n > 2 || number.equals("no more"))
				beer += "s";
			System.out.println("\n" + n + " " + bottle + " of beer on the wall, " + n + " " + bottle + " of beer.\n"
					+ "Take one down and pass it around, " + number + " " + beer + " of beer on the wall.");
			lyrics(n - 1, m + 1);
		}
	}

	public static void main(String[] args) {

		lyrics(99, 0);
	}

}
