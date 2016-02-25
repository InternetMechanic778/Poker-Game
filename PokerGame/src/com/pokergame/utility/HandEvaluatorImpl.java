package com.pokergame.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.pokergame.core.AnalyzeHand;
import com.pokergame.core.Card;
import com.pokergame.core.ECardRank;
import com.pokergame.core.EHandType;
import com.pokergame.core.ESuites;
import com.pokergame.core.Hand;
import com.pokergame.core.HandEvaluator;

public class HandEvaluatorImpl implements AnalyzeHand, HandEvaluator {

	@Override
	public EHandType findHighestRank(Hand hand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EHandType findLowestRank(Hand hand) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Evaluate the hand type by using a list to get the highest order depending
	 * on the enum value weight
	 */
	@Override
	public EHandType findRank(Hand hand) {
		List<EHandType> handTypes = new ArrayList<>();
		handTypes.add(EHandType.HIGH_CARD);
		if (isStraightFlush(hand))
			handTypes.add(EHandType.STRAIGHT_FLUSH);
		else if (isFlush(hand))
			handTypes.add(EHandType.FLUSH);
		else if (isStraight(hand))
			handTypes.add(EHandType.STRAIGHT);
		else if (isOnePair(hand))
			handTypes.add(EHandType.ONE_PAIR);

		System.out.println("Hand before sort:" + handTypes.get(0));
		Collections.sort(handTypes);
		System.out.println("Hand after sort:" + handTypes.get(0));
		// return the first element as it has the hightest rank
		return handTypes.get(0);
	}

	@Override
	public boolean isOnePair(Hand hand) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStraightFlush(Hand hand) {
		if (isFlush(hand) && isStraight(hand))
			return true;
		else
			return false;
	}

	@Override
	public boolean isFlush(Hand hand) {
		if (getSameSuit(hand.getCards()).size() == hand.getCards().size())
			return true;
		else
			return false;
	}

	@Override
	public boolean isStraight(Hand hand) {
		// TODO Auto-generated method stub
		return false;
	}

	private List<Card> getSameSuit(List<Card> cards) {
		Map<ESuites, List<Card>> suitCount = new HashMap<>();
		List<Card> mostOcurr = new ArrayList<>();

		for (Card card : cards) {
			if (suitCount.containsKey(card.getSuit()))
				suitCount.get(card.getSuit()).add(card);
			else
				suitCount.put(card.getSuit(),
						new ArrayList<Card>(Arrays.asList(card)));
		}
		for (Entry<ESuites, List<Card>> entry : suitCount.entrySet()) {
			if (entry.getValue().size() >= mostOcurr.size())
				mostOcurr = entry.getValue();
		}

		return mostOcurr;
	}

	private List<Card> getSameCardRanks(Hand hand) {
		List<Card> sameCards = new ArrayList<>();
		sortHand(hand);
		for(Card card : hand.getCards()){
			int freq = 0;
			freq = Collections.frequency(hand.getCards(), card);
		}
		return sameCards;
	}

	private void sortHand(Hand hand) {
		Collections.sort(hand.getCards(), new Card());
		List<String> lines = Arrays.asList("spring", "node", "mkyong");

		List<String> result = lines.stream() 			//convert list to stream
			.filter(line -> !"mkyong". equals (line))	//filters the line, equals to "mkyong"
			.collect(Collectors.toList());			//collect the output and convert streams to a List

		result.forEach(System.out::println);	
	}

	private List<Card> getCardSequence(Hand hand) {
		List<Card> cardSeq = new ArrayList<>();
		sortHand(hand);

		ECardRank nextRank;
		for (Card card : hand.getCards()) {
			nextRank = ECardRank.fromInt(card.getCardRank().getValue() + 1);
			if (card.getCardRank().compareTo(nextRank) > 0)
				cardSeq.add(card);
		}
		return cardSeq;
	}

	@Override
	public boolean isTwoPair(Hand hand) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isThreePair(Hand hand) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFourOfAKind(Hand hand) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFullHouse(Hand hand) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRoyalFlush(Hand hand) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Card getHighCard(Hand hand) {
		sortHand(hand);
		return hand.getCards().get(0);
	}
}
