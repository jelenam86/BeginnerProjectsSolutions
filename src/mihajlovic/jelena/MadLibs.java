package mihajlovic.jelena;

import javax.swing.JOptionPane;

public class MadLibs {

	/*
	 * Create a Mad Libs style game, where the program asks the user for certain
	 * types of words, and then prints out a story with the words that the user
	 * inputted. 
	 * Subgoals: If the user has to put in a name, change the first letter
	 * to a capital letter. Change the word "a" to "an" when the next word in the
	 * sentence begins with a vowel.
	 */

	private String number, firstNameOfAPerson, animal, location, adjective, noun, color, animalPlural, color2,
			adjective2, noun2, celebrityName, nounPlural, adverb, adjective3, noun3, exclamation, verbPresent,
			celebrityName2, verbPresent2, noun4, exclamation2;

	public MadLibs() {
		JOptionPane.showMessageDialog(null, "Magic Mushrooms - Mad Libs Story Maker");
	}

	private void settings() {
		this.number = JOptionPane.showInputDialog("Enter number:");
		String name = JOptionPane.showInputDialog("Enter first name of a person:");
		if (name.isBlank())
			name = "John";
		this.firstNameOfAPerson = name.substring(0, 1).toUpperCase() + name.substring(1);
		this.animal = JOptionPane.showInputDialog("Enter animal:");
		name = JOptionPane.showInputDialog("Enter location:");
		if (name.isBlank())
			name = "London";
		this.location = name.substring(0, 1).toUpperCase() + name.substring(1);
		this.adjective = JOptionPane.showInputDialog("Enter adjective:");
		this.noun = JOptionPane.showInputDialog("Enter noun:");
		this.color = JOptionPane.showInputDialog("Enter color:");
		this.animalPlural = JOptionPane.showInputDialog("Enter animal (plural):");
		this.color2 = JOptionPane.showInputDialog("Enter color:");
		this.adjective2 = JOptionPane.showInputDialog("Enter adjective:");
		this.noun2 = JOptionPane.showInputDialog("Enter noun:");
		name = JOptionPane.showInputDialog("Enter celebrity name:");
		if (name.isBlank())
			name = "Justin Bieber";
		this.celebrityName = name.substring(0, 1).toUpperCase() + name.substring(1);
		this.nounPlural = JOptionPane.showInputDialog("Enter noun (plural):");
		this.adverb = JOptionPane.showInputDialog("Enter adverb:");
		this.adjective3 = JOptionPane.showInputDialog("Enter adjective:");
		this.noun3 = JOptionPane.showInputDialog("Enter noun:");
		this.exclamation = JOptionPane.showInputDialog("Enter exclamation:");
		this.verbPresent = JOptionPane.showInputDialog("Enter verb - present ends in ING:");
		name = JOptionPane.showInputDialog("Enter celebrity name:");
		if (name.isBlank())
			name = "John Travolta";
		this.celebrityName2 = name.substring(0, 1).toUpperCase() + name.substring(1);
		this.verbPresent2 = JOptionPane.showInputDialog("Enter verb - present ends in ING:");
		this.noun4 = JOptionPane.showInputDialog("Enter noun:");
		this.exclamation2 = JOptionPane.showInputDialog("Enter exclamation:");
	}

	private String vowel(String noun) {
		char[] chars = { 'a', 'e', 'i', 'o', 'u' };
		try {
			for (int i = 0; i < chars.length; i++) {
				if (noun.charAt(0) == chars[i])
					return "an";
			}
		} catch (StringIndexOutOfBoundsException e) {
		}
		return "a";
	}

	private String magicMushrooms() {
		String s = "";
		s = "I'll never forget the time I ate " + this.number + " magic mushrooms! \nMy friend "
				+ this.firstNameOfAPerson + " turned into  " + vowel(this.animal) + " " + this.animal
				+ ". \nAnd we flew over " + this.location + " on " + vowel(this.adjective) + " " + this.adjective
				+ this.noun + "! \nI was seeing " + this.color + " and green " + this.animalPlural + " everywhere. "
				+ "\nWe decided to go skiing on " + vowel(this.color2) + " " + this.color2 + " mountain called the "
				+ this.adjective2 + "\n" + this.noun2 + " where we later joined " + vowel(this.celebrityName) + " "
				+ this.celebrityName + " fan club but everyone turned into " + this.nounPlural
				+ ". \nWe were surrounded but escaped " + this.adverb + " with the help of " + vowel(this.adjective3)
				+ " " + this.adjective3 + " " + this.noun3 + ". \nI know crazy. " + this.exclamation
				+ ", he shouted. \nAfter hours of " + this.verbPresent
				+ " everything was back to normal but then I saw " + this.celebrityName2 + "\n" + this.verbPresent2
				+ " to " + vowel(this.noun4) + " " + this.noun4 + " orchestra " + this.exclamation2 + " I cried out.";
		return s;
	}

	public static void main(String[] args) {

		MadLibs ml = new MadLibs();
		ml.settings();
		JOptionPane.showMessageDialog(null, ml.magicMushrooms());
	}

}
