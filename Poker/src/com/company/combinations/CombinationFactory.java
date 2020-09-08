package com.company.combinations;

import com.company.CardSet;
import com.company.HandCombinations;
import com.company.combinations.decorator.*;
import com.company.enums.Combinations;


public class CombinationFactory {
    public static Combination getBestCombination(CardSet board, CardSet hand) {
        HandCombinations handCombinations = new HandCombinations(CardSet.MergeAndSort(board, hand));
        handCombinations.buildCombinations();

        CombinationCreator combinationCreator = buildCombinationCreator(handCombinations);

        return combinationCreator.getCombination();
    }

    private static CombinationCreator buildCombinationCreator(HandCombinations handCombinations) {

        CombinationCreator combinationCreator = null;
        for (Combinations combination : Combinations.values()) {
            combinationCreator = CombinationCreatorFactory.getInstance(combination, combinationCreator, handCombinations);
        }

        return combinationCreator;
    }
}
