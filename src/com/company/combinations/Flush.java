package com.company.combinations;

import com.company.Card;
import com.company.CardSet;
import com.company.enums.Combinations;

import java.util.ArrayList;

public class Flush extends Combination {
    ArrayList<Card> flushCards;

    public ArrayList<Card> getFlushCards() {
        return flushCards;
    }

    public Flush(CardSet flush) {
        super(Combinations.FLUSH, flush.getCards().get(0).getRank());
        flushCards = flush.getCards();
    }

    @Override
    protected int compareSpecificSameCombination(Combination candidate) {
        Flush candidateFlush = (Flush) candidate;
        for (int i = 0; i < flushCards.size(); i++) {

            int comparisionResult = Integer.compare(flushCards.get(i).getStrength(), candidateFlush.getFlushCards().get(i).getStrength());
            if (comparisionResult != 0) {
                return comparisionResult;
            }
        }
        return 0;
    }
}
