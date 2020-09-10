package com.company.combinations;

import com.company.enums.Combinations;
import com.company.enums.Rank;

public class FourOfAKind extends Combination {
    public FourOfAKind(Rank highRank) {
        super(Combinations.FOUR_OF_A_KIND, highRank);
    }
}
