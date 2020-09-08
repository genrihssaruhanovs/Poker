package com.company.combinations.decorator;

import com.company.HandCombinations;
import com.company.enums.Rank;
import com.company.combinations.Combination;
import com.company.combinations.ThreeOfAKind;

import java.util.ArrayList;

public class ThreeOfAKindCreator extends CombinationCreator {
    public ThreeOfAKindCreator(CombinationCreator combinationCreator, HandCombinations handCombinations) {
        super(combinationCreator, handCombinations);
    }

    @Override
    Combination createCombination() {
        Rank threeOfAKind = getHandCombinations().getThreeOfAKind();
        ArrayList<Rank> singleCards = getHandCombinations().getSingleCards();

        return threeOfAKind != null ? new ThreeOfAKind(threeOfAKind, singleCards.subList(0, 2)) : null;
    }
}
