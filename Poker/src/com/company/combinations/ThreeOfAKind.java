package com.company.combinations;

import com.company.enums.Combinations;
import com.company.enums.Rank;

import java.util.ArrayList;
import java.util.List;

public class ThreeOfAKind extends Combination {
    private ArrayList<Rank> remainingHandCards;

    public ThreeOfAKind(Rank highRank, List<Rank> remainingHandCards) {
        super(Combinations.THREE_OF_A_KIND, highRank);
        this.remainingHandCards = new ArrayList<>(remainingHandCards);
    }

    public ArrayList<Rank> getRemainingHandCards() {
        return remainingHandCards;
    }

    @Override
    protected int compareSpecificSameCombination(Combination candidate) {
        ThreeOfAKind candidateThreeOfAKind = (ThreeOfAKind) candidate;
        for (int i = 0; i < remainingHandCards.size(); i++) {
            int comparisionResult = Integer.compare(remainingHandCards.get(i).getStrength(), candidateThreeOfAKind.getRemainingHandCards().get(i).getStrength());
            if (comparisionResult != 0) {
                return comparisionResult;
            }
        }
        return 0;
    }
}
