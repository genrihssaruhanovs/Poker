package com.company.combinations;

import com.company.enums.Combinations;
import com.company.enums.Rank;

import java.util.ArrayList;
import java.util.List;

public class Pair extends Combination {
    private ArrayList<Rank> remainingHandCards;

    public Pair(Rank highRank, List<Rank> remainingHandCards) {
        super(Combinations.PAIR, highRank);
        this.remainingHandCards = new ArrayList<>(remainingHandCards);
    }

    public ArrayList<Rank> getRemainingHandCards() {
        return remainingHandCards;
    }

    @Override
    protected int compareSpecificSameCombination(Combination candidate) {
        Pair candidatePair = (Pair) candidate;
        for (int i = 0; i < remainingHandCards.size(); i++) {
            int comparisionResult = Integer.compare(remainingHandCards.get(i).getStrength(), candidatePair.getRemainingHandCards().get(i).getStrength());
            if (comparisionResult != 0) {
                return comparisionResult;
            }
        }
        return 0;
    }
}
