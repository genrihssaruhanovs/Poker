package com.company.combinations;

import com.company.enums.Combinations;
import com.company.enums.Rank;

public class Straight extends Combination {
    public Straight(Rank highRank) {
        super(Combinations.STRAIGHT, highRank);
    }
}
