package mihajlovic.jelena;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

/*
 * Turn Based Pokemon Style Game Write a simple game that allows the user and the computer to take turns 
 * selecting moves to use against each other. Both the computer and the player should start out at the 
 * same amount of health (such as 100), and should be able to choose between the three moves: 
 * 		The first move should do moderate damage and has a small range (such as 18-25).
 * 		The second move should have a large range of damage and can deal high or low damage (such as 10-35). 
 * 		The third move should heal whoever casts it a moderate amount, similar to the first move. 
 * After each move, a message should be printed out that tells the user what just happened, and how much health
 * the user and computer have. 
 * Once the user or the computer's health reaches 0, the game should end. 
 * 
 * Subgoals: 
 * When someone is defeated, make sure the game prints out that their health has reached 0, 
 * and not a negative number. 
 * When the computer's health reaches a set amount (such as 35%), increase it's
 * chance to cast heal. 
 * Give each move a name.
 */

enum KEYS_TO_BE_PRESSED {
	a, b, c;
}

public class TurnBasedPokemonStyleGame {

	private static final int START_HEALTH = 100;
	private static final int MIN_MODERATE_DAMAGE = 18;
	private static final int MAX_MODERATE_DAMAGE = 25;
	private static final int MIN_LOW_TO_HIGH_DAMAGE = 10;
	private static final int MAX_LOW_TO_HIGH_DAMAGE = 35;
	private static final int MIN_HEAL_UNITS = 10;
	private static final int MAX_HEAL_UNITS = 25;
	private static final int COMPUTER_HEALTH = 35;
	private int health;
	private String name;
	private static String answer;
	private KEYS_TO_BE_PRESSED key;
	Scanner scanner = new Scanner(System.in);

	TurnBasedPokemonStyleGame(String name) {
		this.health = START_HEALTH;
		this.name = name;
	}

	private int getHealth() {
		return this.health > 0 ? this.health : 0;
	}

	private void changeHealth(int health) {
		this.health += health;
	}

	private int moderateDamage() {
		return new Random().nextInt(MAX_MODERATE_DAMAGE - MIN_MODERATE_DAMAGE) + MIN_MODERATE_DAMAGE;
	}

	private int lowToHighDamage() {
		return new Random().nextInt(MAX_LOW_TO_HIGH_DAMAGE - MIN_LOW_TO_HIGH_DAMAGE) + MIN_LOW_TO_HIGH_DAMAGE;
	}

	private int heal() {
		int rand = new Random().nextInt(MAX_HEAL_UNITS - MIN_HEAL_UNITS) + MIN_HEAL_UNITS;
		changeHealth(rand);
		return rand;
	}

	private String randomChoice() {
		int rand = new Random().nextInt(KEYS_TO_BE_PRESSED.values().length);
		if (this.name.equals("Computer") && getHealth() <= COMPUTER_HEALTH * START_HEALTH / 100)
			rand = rand == KEYS_TO_BE_PRESSED.values().length - 1 ? rand : rand++;
		return KEYS_TO_BE_PRESSED.values()[rand].name();
	}

	private String enterChoice() {
		String keys = "";
		for (int i = 0; i < KEYS_TO_BE_PRESSED.values().length - 1; i++) {
			keys += KEYS_TO_BE_PRESSED.values()[i].name() + ", ";
		}
		keys += "or " + KEYS_TO_BE_PRESSED.values()[KEYS_TO_BE_PRESSED.values().length - 1] + ": ";
		boolean rightKeyPressed = false;
		do {
			System.out.print("Press " + keys);
			answer = scanner.nextLine();
			rightKeyPressed = Stream.of(KEYS_TO_BE_PRESSED.values()).filter(key -> key.name().equalsIgnoreCase(answer))
					.findFirst().isPresent();
		} while (!rightKeyPressed);
		return answer.toLowerCase();
	}

	private int play(String choice) {
		key = KEYS_TO_BE_PRESSED.valueOf(choice);
		switch (key) {
		case a:
			int damage = moderateDamage();
			System.out.println("-> " + this.name + " chose moderate damage.");
			System.out.println(this.name + " did " + damage + " damage to the opponent.");
			return damage;
		case b:
			int lDamage = lowToHighDamage();
			System.out.println("-> " + this.name + " chose low to high damage.");
			System.out.println(this.name + " did " + lDamage + " damage to the opponent.");
			return lDamage;
		case c:
			int heal = heal();
			System.out.println("-> " + this.name + " chose to heal. + " + heal + " health units.");
			return heal;
		}
		return 0;
	}

	private static void game(TurnBasedPokemonStyleGame p1, TurnBasedPokemonStyleGame p2, String choice) {
		if (p1.getHealth() == 0 || p2.getHealth() == 0)
			return;
		if (choice.equals(KEYS_TO_BE_PRESSED.a.name()) || choice.equals(KEYS_TO_BE_PRESSED.b.name()))
			p2.changeHealth(-p1.play(choice));
		else
			p1.play(choice);
		System.out.println(p1.name + ": " + p1.getHealth() + ", " + p2.name + ": " + p2.getHealth());
	}

	public static void main(String[] args) {

		String welcome = "This is the simple game against Computer.\n"
				+ "Both of you have same amount of health (100 units) and can choose between three moves:\n"
				+ "MOVE A: do moderate damage and has a small range (such as 18-25)\n"
				+ "MOVE B: do high or low damage (such as 10-35)\n" + "MOVE C: heal a moderate amount (such as 10-25)\n"
				+ "Press a, b or c to play. Once someone is defeated (health reaches 0), the game will end. Good luck!";
		System.out.println(welcome);

		TurnBasedPokemonStyleGame computer = new TurnBasedPokemonStyleGame("Computer");
		TurnBasedPokemonStyleGame user = new TurnBasedPokemonStyleGame("You");
		int countRound = 0;

		while (computer.getHealth() > 0 && user.getHealth() > 0) {
			System.out.println();
			System.out.println("ROUND: " + ++countRound);
			game(user, computer, user.enterChoice());
			game(computer, user, computer.randomChoice());
		}
		System.out.println(user.getHealth() > 0 ? "You won the game!" : "Computer won the game.");
	}

}
