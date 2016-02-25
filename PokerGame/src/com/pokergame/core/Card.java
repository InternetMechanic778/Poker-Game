package com.pokergame.core;

import java.util.Comparator;

public class Card implements Comparator<Card> {
	private ESuites suit;
	private ECardRank cardRank;

	public Card() {
		super();
	}

	public Card(ESuites suit, ECardRank cardRank) {
		super();
		this.suit = suit;
		this.cardRank = cardRank;
	}

	public ESuites getSuit() {
		return suit;
	}

	public void setSuit(ESuites suit) {
		this.suit = suit;
	}

	public ECardRank getCardRank() {
		return cardRank;
	}

	public void setCardRank(ECardRank cardRank) {
		this.cardRank = cardRank;
	}

	@Override
	public int compare(Card c1, Card c2) {
		return Integer.valueOf(c1.getCardRank().compareTo(c2.getCardRank()));

	}

	@Override
	public String toString() {
		return "Card [suit=" + suit + ", cardRank=" + cardRank + "]";
	}

}
