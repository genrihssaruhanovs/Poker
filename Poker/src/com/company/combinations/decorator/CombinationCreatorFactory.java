package com.company.combinations.decorator;

import com.company.HandCombinations;
import com.company.enums.Combinations;

public class CombinationCreatorFactory {
    public static CombinationCreator getInstance(Combinations combination, CombinationCreator combinationCreator, HandCombinations handCombinations) {
        switch (combination) {
            case HIGH_CARD:
                return new HighCardCreator(combinationCreator, handCombinations);
            case PAIR:
                return new PairCreator(combinationCreator, handCombinations);
            case TWO_PAIRS:
                return new TwoPairsCreator(combinationCreator, handCombinations);
            case THREE_OF_A_KIND:
                return new ThreeOfAKindCreator(combinationCreator, handCombinations);
            case STRAIGHT:
                return new StraightCreator(combinationCreator, handCombinations);
            case FLUSH:
                return new FlushCreator(combinationCreator, handCombinations);
            case FULL_HOUSE:
                return new FullHouseCreator(combinationCreator, handCombinations);
            case FOUR_OF_A_KIND:
                return new FourOfAKindCreator(combinationCreator, handCombinations);
            case STRAIGHT_FLUSH:
                return new StraightFlushCreator(combinationCreator, handCombinations);
            default:
                return null;
        }
    }
}
