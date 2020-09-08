package com.company.combinations.decorator;

import com.company.CardSet;
import com.company.HandCombinations;
import com.company.combinations.Combination;
import com.company.combinations.StraightFlush;

import java.util.ArrayList;

public class StraightFlushCreator extends CombinationCreator {
    public StraightFlushCreator(CombinationCreator combinationCreator, HandCombinations handCombinations) {
        super(combinationCreator, handCombinations);
    }

    @Override
    Combination createCombination() {
        ArrayList<CardSet> straights = getHandCombinations().getStraights();
        ArrayList<CardSet> flushes = getHandCombinations().getFlushes();
        if (straights.size() != 0 && flushes.size() != 0) {
            for (CardSet straight : straights) {
                for (CardSet flush : flushes) {
                    if (straight.isEqualByValue(flush)) {
                        return new StraightFlush(straight.getCards().get(0).getRank());
                    }
                }
            }
        }
        return null;
    }
}
