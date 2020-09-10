package com.company.combinations.decorator;

import com.company.HandCombinations;
import com.company.enums.Rank;
import com.company.combinations.Combination;
import com.company.combinations.TwoPairs;

import java.util.ArrayList;

public class TwoPairsCreator extends CombinationCreator {
    public TwoPairsCreator(CombinationCreator combinationCreator, HandCombinations handCombinations) {
        super(combinationCreator, handCombinations);
    }

    @Override
    Combination createCombination() {
        ArrayList<Rank> pairs = getHandCombinations().getPairs();
        ArrayList<Rank> singleCards = getHandCombinations().getSingleCards();
        return pairs.size() >= 2 ? new TwoPairs(pairs.get(0), pairs.get(1), singleCards.get(0)) : null;
    }
}
