package com.company.combinations.decorator;

import com.company.HandCombinations;
import com.company.enums.Rank;
import com.company.combinations.Combination;
import com.company.combinations.Pair;

import java.util.ArrayList;

public class PairCreator extends CombinationCreator {
    public PairCreator(CombinationCreator combinationCreator, HandCombinations handCombinations) {
        super(combinationCreator, handCombinations);
    }

    @Override
    Combination createCombination() {
        ArrayList<Rank> pairs = getHandCombinations().getPairs();
        ArrayList<Rank> singleCards = getHandCombinations().getSingleCards();

        return pairs.size() != 0 ? new Pair(pairs.get(0), singleCards.subList(0, 3)) : null;
    }
}
