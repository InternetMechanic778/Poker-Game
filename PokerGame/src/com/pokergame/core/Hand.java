package com.pokergame.core;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> cards = new ArrayList<>();
	private EHandType handType;

	public Hand() {

	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public EHandType getHandType() {
		return handType;
	}

	public void setHandType(EHandType handType) {
		this.handType = handType;
	}

}
