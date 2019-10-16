package mihajlovic.jelena.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

	private List<Card> cards;

	public Deck() {
		this.cards = createDeck();
	}

	public List<Card> createDeck() {
		cards = new ArrayList<Card>();
		for (Suits s : Suits.values())
			for (Ranks r : Ranks.values())
				cards.add(new Card(r, s));
		shuffle(cards);
		return cards;
	}

	public void resetDeck() {
		cards.clear();
		this.cards = createDeck();
	}

	public void shuffle(List<Card> cards) {
		Collections.shuffle(cards);
	}

	public Card dealCard() {
		return cards.remove(new Random().nextInt(cards.size()));
	}

}
