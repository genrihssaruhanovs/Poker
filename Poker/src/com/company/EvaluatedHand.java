package com.company;

import com.company.combinations.Combination;

public class EvaluatedHand implements Comparable<EvaluatedHand> {
    CardSet hand;
    Combination combination;

    public EvaluatedHand(CardSet hand, Combination combination) {
        this.hand = hand;
        this.combination = combination;
    }

    public CardSet getHand() {
        return hand;
    }

    public Combination getCombination() {
        return combination;
    }

    @Override
    public String toString() {
        return hand.toString();
    }

    @Override
    public int compareTo(EvaluatedHand candidate) {
        int combinationComparisionResult = compareHandByCombinations(candidate);
        return combinationComparisionResult != 0 ? combinationComparisionResult : this.hand.toString().compareTo(candidate.getHand().toString());
    }

    public int compareHandByCombinations(EvaluatedHand candidate) {
        return this.combination.getValue() < candidate.getCombination().getValue() ? -1 :
                this.combination.getValue() > candidate.getCombination().getValue() ? 1 : this.combination.compareSameCombination(candidate.getCombination());
    }
}
