package com.company.combinations.decorator;

import com.company.CardSet;
import com.company.HandCombinations;
import com.company.combinations.Combination;
import com.company.combinations.Flush;

import java.util.ArrayList;

public class FlushCreator extends CombinationCreator {
    public FlushCreator(CombinationCreator combinationCreator, HandCombinations handCombinations) {
        super(combinationCreator, handCombinations);
    }

    @Override
    Combination createCombination() {
        ArrayList<CardSet> flushes = getHandCombinations().getFlushes();
        return flushes.size() != 0 ? new Flush(flushes.get(0)) : null;
    }
}
