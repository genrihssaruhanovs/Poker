package com.company.combinations;

import com.company.enums.Combinations;
import com.company.enums.Rank;

public class StraightFlush extends Combination {
    public StraightFlush(Rank highRank) {
        super(Combinations.STRAIGHT_FLUSH, highRank);
    }
}
