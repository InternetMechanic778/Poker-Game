package com.pokergame.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.pokergame.core.Card;
import com.pokergame.core.Deck;
import com.pokergame.core.ECardRank;
import com.pokergame.core.EHandType;
import com.pokergame.core.ESuites;
import com.pokergame.core.Hand;
import com.pokergame.utility.HandEvaluatorImpl;

public class HandEvaluatorTest {

	private static HandEvaluatorImpl engin;
	private static Deck deck;
	private static Hand hand;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		engin = new HandEvaluatorImpl();
		deck = new Deck();
		hand = new Hand();
	}

	@Test
	public void test() {
		deck.buildDeck();
		deck.shuffle();
		hand = deck.deal();
		EHandType handType = engin.findRank(buildHandSample());
		printCards(buildHandSample().getCards());
		System.out.println("This is the hand:" + handType);
	}

	private Hand buildHandSample() {
		Hand hand = new Hand();
		hand.getCards().add(new Card(ESuites.HEARTS, ECardRank.FOUR));
		hand.getCards().add(new Card(ESuites.HEARTS, ECardRank.FOUR));
		hand.getCards().add(new Card(ESuites.HEARTS, ECardRank.FOUR));
		hand.getCards().add(new Card(ESuites.HEARTS, ECardRank.FOUR));
		hand.getCards().add(new Card(ESuites.CLUBS, ECardRank.KING));
		return hand;
	}

	private void printCards(List<Card> cards) {
		for (Card card : cards) {
			System.out.println(card.getSuit() + " " + card.getCardRank());
		}
	}

}
