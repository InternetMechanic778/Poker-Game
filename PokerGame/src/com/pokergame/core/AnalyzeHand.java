package com.pokergame.core;

public interface AnalyzeHand {

	EHandType findHighestRank(Hand hand);

	EHandType findLowestRank(Hand hand);
	
	EHandType findRank(Hand hand);
}
