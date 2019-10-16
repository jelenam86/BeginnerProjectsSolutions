package mihajlovic.jelena.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

enum Range {

	A(90, 100), B(80, 89), C(70, 79), D(60, 69), F(50, 59), OTHER(49, -5);

	private final int minValue;
	private final int maxValue;

	private Range(int min, int max) {
		this.minValue = min;
		this.maxValue = max;
	}

	public static Range getFrom(int score) {
		return Arrays.asList(Range.values()).stream().filter(t -> (score >= t.minValue && score <= t.maxValue))
				.findAny().orElse(OTHER);
	}
}

public class VariationOf21 {

	private int numberOfRounds;
	private int gameScore;
	private int roundScore;
	private Deck deck;
	private List<Card> hand;
	private Scanner scanner = new Scanner(System.in);

	public VariationOf21() {
		this.deck = new Deck();
		this.hand = new ArrayList<Card>();
		this.numberOfRounds = 5;
		this.gameScore = 100;
	}

	public int getNumberOfRounds() {
		return numberOfRounds;
	}

	public int getGameScore() {
		return gameScore;
	}

	public int getRoundScore() {
		return roundScore;
	}

	public void setRoundScore(int score) {
		this.roundScore = score;
	}

	public Deck getDeck() {
		return deck;
	}

	public List<Card> getCards() {
		return hand;
	}

	private void startRound() {
		Card card = deck.dealCard();
		System.out.println("You got " + card.toString());
		hand.add(card);
		drawAnotherCard();
	}

	private void drawAnotherCard() {
		Card card = deck.dealCard();
		System.out.println("You got " + card.toString());
		hand.add(card);
		this.roundScore = Card.add(hand);
		System.out.println("Your total: " + getRoundScore());
	}

	private void printMessage() {
		if (getRoundScore() > 21) {
			System.out.println("You are busted!");
		} else if (getRoundScore() == 21) {
			System.out.println("Blackjack!");
		}
	}

	private void resetRound() {
		this.gameScore = 21 - this.roundScore >= 0 ? this.gameScore - 21 + this.roundScore : this.gameScore - 21;
		setRoundScore(0);
		this.numberOfRounds--;
		deck.resetDeck();
		hand.clear();
	}

	private void playRound() {
		startRound();
		System.out.println("Do you want to draw another card?");
		String answer = scanner.next();
		while (answer.equalsIgnoreCase("yes")) {
			drawAnotherCard();
			if (getRoundScore() >= 21) {
				printMessage();
				break;
			}
			System.out.println("Do you want to draw another card?");
			answer = scanner.next();
		}
		System.out.println("The round is now ended...");
	}

	public void play() {
		while (getNumberOfRounds() > 0) {
			System.out.println("Begin round No " + (6 - getNumberOfRounds()) + ". Total game score: " + getGameScore());
			playRound();
			resetRound();
			System.out.println();
		}
		System.out.println("Game is over. You get " + Range.getFrom(getGameScore()).name() + " with " + getGameScore()
				+ " points.");
	}
}
