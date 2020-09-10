package com.company.combinations;

import com.company.enums.Combinations;
import com.company.enums.Rank;

import java.util.ArrayList;
import java.util.List;

public class HighCard extends Combination {
    private ArrayList<Rank> handCards;

    public HighCard(List<Rank> handCards) {
        super(Combinations.HIGH_CARD, handCards.get(0));
        this.handCards = new ArrayList<>(handCards);

    }

    public ArrayList<Rank> getHandCards() {
        return handCards;
    }

    @Override
    protected int compareSpecificSameCombination(Combination candidate) {
        HighCard candidateHighCard = (HighCard) candidate;
        for (int i = 0; i < handCards.size(); i++) {
            int comparisionResult = Integer.compare(handCards.get(i).getStrength(), candidateHighCard.getHandCards().get(i).getStrength());
            if (comparisionResult != 0) {
                return comparisionResult;
            }
        }
        return 0;
    }
}
