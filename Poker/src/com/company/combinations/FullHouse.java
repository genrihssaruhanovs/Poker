package com.company.combinations;

import com.company.enums.Combinations;
import com.company.enums.Rank;

public class FullHouse extends Combination {
    private Rank lowRank;

    public FullHouse(Rank highRank, Rank lowRank) {
        super(Combinations.FULL_HOUSE, highRank);
        this.lowRank = lowRank;
    }

    public int getLowCardStrength() {
        return lowRank.getStrength();
    }

    @Override
    protected int compareSpecificSameCombination(Combination candidate) {
        FullHouse candidateFullHouse = (FullHouse) candidate;
        return (Integer.compare(this.getLowCardStrength(), candidateFullHouse.getLowCardStrength()));
    }
}
