package com.company.combinations.decorator;

import com.company.HandCombinations;
import com.company.enums.Combinations;

public class CombinationCreatorFactory {
    public static CombinationCreator getInstance(Combinations combination, CombinationCreator combinationCreator, HandCombinations handCombinations) {
        return switch (combination) {
            case HIGH_CARD -> new HighCardCreator(combinationCreator, handCombinations);
            case PAIR -> new PairCreator(combinationCreator, handCombinations);
            case TWO_PAIRS -> new TwoPairsCreator(combinationCreator, handCombinations);
            case THREE_OF_A_KIND -> new ThreeOfAKindCreator(combinationCreator, handCombinations);
            case STRAIGHT -> new StraightCreator(combinationCreator, handCombinations);
            case FLUSH -> new FlushCreator(combinationCreator, handCombinations);
            case FULL_HOUSE -> new FullHouseCreator(combinationCreator, handCombinations);
            case FOUR_OF_A_KIND -> new FourOfAKindCreator(combinationCreator, handCombinations);
            case STRAIGHT_FLUSH -> new StraightFlushCreator(combinationCreator, handCombinations);
        };
    }
}
