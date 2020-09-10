package com.company.combinations.decorator;

import com.company.combinations.Combination;
import com.company.HandCombinations;
import com.company.combinations.HighCard;
import com.company.enums.Rank;

import java.util.ArrayList;

public class HighCardCreator extends CombinationCreator {
    public HighCardCreator(CombinationCreator combinationCreator, HandCombinations handCombinations) {
        super(combinationCreator, handCombinations);
    }

    @Override
    Combination createCombination() {
        ArrayList<Rank> singleCards = getHandCombinations().getSingleCards();
        return singleCards.size() > 5 ? new HighCard(singleCards.subList(0, 6)) : new HighCard(singleCards);
    }
}
