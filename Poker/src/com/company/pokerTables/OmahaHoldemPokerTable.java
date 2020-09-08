package com.company.pokerTables;

import com.company.Card;
import com.company.CardSet;
import com.company.EvaluatedHand;
import com.company.combinations.CombinationFactory;
import com.company.enums.PokerTableTypes;

import java.util.ArrayList;
import java.util.Collections;

public class OmahaHoldemPokerTable extends HoldemPokerTable {
    public OmahaHoldemPokerTable(String inputString) {
        super(inputString, PokerTableTypes.OMAHA);
    }

    @Override
    public void evaluateTable() {
        ArrayList<EvaluatedHand> evaluatedTwoCardHand = new ArrayList<>();
        //Since omaha player should pick exactly 2 cards from hand and 3 from board, split board to all combos of 3 cards and hand to all combos of 2 cards

        ArrayList<CardSet> splitBoard = splitBoard(board);

        for (CardSet hand : hands) {
            for (CardSet threeCardBoard : splitBoard) {
                for (CardSet twoCardHand : splitHand(hand)) {
                    evaluatedTwoCardHand.add(new EvaluatedHand(twoCardHand, CombinationFactory.getBestCombination(threeCardBoard, twoCardHand)));
                }
            }
            Collections.sort(evaluatedTwoCardHand, Collections.reverseOrder());
            evaluatedHands.add(new EvaluatedHand(hand, evaluatedTwoCardHand.get(0).getCombination()));
            evaluatedTwoCardHand.clear();

        }

        Collections.sort(evaluatedHands);
    }

    private ArrayList<CardSet> splitHand(CardSet hand) {
        ArrayList<CardSet> splitHand = new ArrayList<>();
        ArrayList<Card> handCards = hand.getCards();
        for (int i = 0; i < handCards.size(); i++) {
            for (int j = i + 1; j < handCards.size(); j++) {
                ArrayList<Card> twoCardSet = new ArrayList<>();
                twoCardSet.add(handCards.get(i));
                twoCardSet.add(handCards.get(j));
                splitHand.add(new CardSet(twoCardSet));
            }
        }
        return splitHand;
    }

    private ArrayList<CardSet> splitBoard(CardSet hand) {
        ArrayList<CardSet> splitHand = new ArrayList<>();
        ArrayList<Card> handCards = hand.getCards();
        for (int i = 0; i < handCards.size(); i++) {
            for (int j = i + 1; j < handCards.size(); j++) {
                for (int k = j + 1; k < handCards.size(); k++) {
                    ArrayList<Card> threeCardSet = new ArrayList<>();
                    threeCardSet.add(handCards.get(i));
                    threeCardSet.add(handCards.get(j));
                    threeCardSet.add(handCards.get(k));
                    splitHand.add(new CardSet(threeCardSet));
                }
            }
        }
        return splitHand;
    }
}
