package com.company.combinations.decorator;

import com.company.HandCombinations;
import com.company.enums.Rank;
import com.company.combinations.Combination;
import com.company.combinations.FourOfAKind;

public class FourOfAKindCreator extends CombinationCreator {
    public FourOfAKindCreator(CombinationCreator combinationCreator, HandCombinations handCombinations) {
        super(combinationCreator, handCombinations);
    }

    @Override
    Combination createCombination() {
        Rank fourOfAKind = getHandCombinations().getFourOfAKind();
        return fourOfAKind != null ? new FourOfAKind(fourOfAKind) : null;
    }
}
