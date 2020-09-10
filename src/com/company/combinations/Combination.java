package com.company.combinations;

import com.company.enums.Combinations;
import com.company.enums.Rank;

public abstract class Combination {
    private Combinations combination;
    private Rank highestRank;

    public Combination(Combinations combination, Rank highestRank) {
        this.combination = combination;
        this.highestRank = highestRank;
    }

    public int getHighCardStrength() {
        return highestRank.getStrength();
    }

    public int getValue() {
        return combination.getStrength();
    }

    public int compareSameCombination(Combination candidate) {
        return (this.getHighCardStrength() < candidate.getHighCardStrength() ? -1 :
                (this.getHighCardStrength() > candidate.getHighCardStrength() ? 1 : this.compareSpecificSameCombination(candidate)));
    }

    protected int compareSpecificSameCombination(Combination candidate) {
        return 0;
    }
}
