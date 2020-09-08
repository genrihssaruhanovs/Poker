package com.company.combinations;

import com.company.enums.Combinations;
import com.company.enums.Rank;

public class Flush extends Combination {
    public Flush(Rank highRank) {
        super(Combinations.FLUSH, highRank);
    }
}
