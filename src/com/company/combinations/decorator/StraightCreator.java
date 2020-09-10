package com.company.combinations.decorator;

import com.company.CardSet;
import com.company.HandCombinations;
import com.company.combinations.Combination;
import com.company.combinations.Straight;

import java.util.ArrayList;

public class StraightCreator extends CombinationCreator {
    public StraightCreator(CombinationCreator combinationCreator, HandCombinations handCombinations) {
        super(combinationCreator, handCombinations);
    }

    @Override
    Combination createCombination() {
        ArrayList<CardSet> straights = getHandCombinations().getStraights();
        return straights.size() != 0 ? new Straight(straights.get(0).getCards().get(0).getRank()) : null;
    }
}
