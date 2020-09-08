package com.company.combinations.decorator;

import com.company.combinations.Combination;
import com.company.HandCombinations;

public abstract class CombinationCreator {
    private CombinationCreator combinationCreator;
    private HandCombinations handCombinations;

    CombinationCreator(CombinationCreator combinationCreator, HandCombinations handCombinations) {
        this.combinationCreator = combinationCreator;
        this.handCombinations = handCombinations;
    }

    public HandCombinations getHandCombinations() {
        return handCombinations;
    }

    public Combination getCombination() {
        Combination combination = createCombination();

        if (combination == null) {
            combination = combinationCreator.getCombination();
        }

        return combination;
    }

    abstract Combination createCombination();

}
