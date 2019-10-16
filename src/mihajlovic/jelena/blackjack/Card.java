package mihajlovic.jelena.blackjack;

import java.util.List;

enum Suits {
	HEARTHS, SPADES, DIAMONDS, CLUBS
}

enum Ranks {
	ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10),
	KING(10);

	private final int value;

	private Ranks(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

public class Card {

	private Suits suit;
	private Ranks rank;

	Card(Ranks rank, Suits suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getValue() {
		return this.rank.getValue();
	}

	public String getName() {
		return this.rank.name();
	}

	public String getSuit() {
		return this.suit.name();
	}

	public static int add(List<Card> hand) {
		int sum = 0;
		for (Card card : hand)
			sum += card.getValue();
		return sum;
	}

	@Override
	public String toString() {
		return "Card: " + getName() + " of " + getSuit();
	}
}
