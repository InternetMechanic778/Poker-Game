package com.pokergame.core;

public interface HandEvaluator {

	boolean isStraightFlush(Hand hand);

	boolean isFlush(Hand hand);

	boolean isStraight(Hand hand);

	boolean isOnePair(Hand hand);

	boolean isTwoPair(Hand hand);

	boolean isThreePair(Hand hand);
	
	boolean isFourOfAKind(Hand hand);

	boolean isFullHouse(Hand hand);

	boolean isRoyalFlush(Hand hand);

	Card getHighCard(Hand hand);

}
