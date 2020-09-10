package com.company.pokerTables;

import com.company.CardSet;
import com.company.EvaluatedHand;
import com.company.combinations.CombinationFactory;
import com.company.enums.PokerTableTypes;

import java.util.Collections;

public class TexasHoldemPokerTable extends HoldemPokerTable {
    public TexasHoldemPokerTable(String inputString) {
        super(inputString, PokerTableTypes.TEXAS);
    }

    @Override
    public void evaluateTable() {
        for (CardSet hand : hands) {
            evaluatedHands.add(new EvaluatedHand(hand, CombinationFactory.getBestCombination(board, hand)));
        }
        Collections.sort(evaluatedHands);
    }
}
