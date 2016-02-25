package com.pokergame.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards = new ArrayList<>();
	private int totalCards = 0;
	private final int handSize = 5;

	public Deck() {

	}

	/**
	 * shuffles the cards in the deck
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}

	/**
	 * builds the deck with all available suits and card ranks
	 */
	public void buildDeck() {
		for (ECardRank rank : ECardRank.values()) {
			for (ESuites suit : ESuites.values()) {
				totalCards++;
				cards.add(new Card(suit, rank));
			}
		}
	}
	
	public Hand deal(){
		Hand hand = new Hand();
		for(int x = 0; x<handSize; x++){
			hand.getCards().add(cards.get(x));
		}
		return hand;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public int getTotalCards() {
		return totalCards;
	}

}
