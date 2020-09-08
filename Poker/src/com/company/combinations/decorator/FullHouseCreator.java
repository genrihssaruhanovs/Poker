package com.company.combinations.decorator;

import com.company.HandCombinations;
import com.company.enums.Rank;
import com.company.combinations.Combination;
import com.company.combinations.FullHouse;


import java.util.ArrayList;

public class FullHouseCreator extends CombinationCreator {
    public FullHouseCreator(CombinationCreator combinationCreator, HandCombinations handCombinations) {
        super(combinationCreator, handCombinations);
    }

    @Override
    Combination createCombination() {
        Rank threeOfAKind = getHandCombinations().getThreeOfAKind();
        ArrayList<Rank> pairs = getHandCombinations().getPairs();
        return threeOfAKind != null && pairs.size() != 0 ? new FullHouse(threeOfAKind, pairs.get(0)) : null;
    }
}
