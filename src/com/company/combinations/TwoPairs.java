package com.company.combinations;

import com.company.enums.Combinations;
import com.company.enums.Rank;

public class TwoPairs extends Combination {
    private int lowCardStrength;
    private int fifthCardStrength;

    public TwoPairs(Rank highRank, Rank lowRank, Rank fifthCardStrength) {
        super(Combinations.TWO_PAIRS, highRank);
        this.lowCardStrength = lowRank.getStrength();
        this.fifthCardStrength = fifthCardStrength.getStrength();
    }

    private int getLowCardStrength() {
        return lowCardStrength;
    }

    private int getFifthCardStrength() {
        return fifthCardStrength;
    }

    @Override
    protected int compareSpecificSameCombination(Combination candidate) {
        TwoPairs candidateTwoPairs = (TwoPairs) candidate;
        int lowCardComparisionResult = Integer.compare(this.lowCardStrength, candidateTwoPairs.getLowCardStrength());
        return lowCardComparisionResult != 0 ? lowCardComparisionResult : Integer.compare(this.fifthCardStrength, candidateTwoPairs.getFifthCardStrength());
    }
}
