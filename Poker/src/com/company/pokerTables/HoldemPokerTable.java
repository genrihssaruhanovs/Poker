package com.company.pokerTables;

import com.company.Card;
import com.company.CardSet;
import com.company.EvaluatedHand;
import com.company.IncorrectInputStringException;
import com.company.enums.PokerTableTypes;

import java.util.ArrayList;

public abstract class HoldemPokerTable {
    PokerTableTypes tableType;
    ArrayList<Card> allTableCards = new ArrayList<>();
    CardSet board;
    ArrayList<CardSet> hands;
    ArrayList<EvaluatedHand> evaluatedHands = new ArrayList<>();

    public HoldemPokerTable(String inputString, PokerTableTypes tableType) {
        this.tableType = tableType;
        this.hands = new ArrayList<>();

        String[] splitInput = inputString.split("\\s+");

        this.board = new CardSet(splitInput[0]);
        validateBoard();

        for (int i = 1; i < splitInput.length; i++) {
            CardSet hand = new CardSet(splitInput[i]);
            validateHand(hand);
            hands.add(new CardSet(splitInput[i]));
        }
    }

    private void validateBoard() {
        if (board.getCards().size() != 5) {
            throw new IncorrectInputStringException("Board (" + board.toString() + ") card amount is not equals to 5");
        }
        checkDuplicates(this.board);
    }

    private void validateHand(CardSet hand) {
        if (hand.getCards().size() != tableType.getHandCardCount()) {
            throw new IncorrectInputStringException("Hand (" + hand.toString() + ") card amount is not equals to " + tableType.getHandCardCount());
        }
        checkDuplicates(hand);
    }

    public abstract void evaluateTable();


    protected void checkDuplicates(CardSet cardSet) {
        for (Card card : cardSet.getCards()) {
            if (allTableCards.contains(card)) {
                throw new IncorrectInputStringException("Table contains duplicate cards (" + card.toString() + ")");
            } else {
                allTableCards.add(card);
            }
        }
    }

    @Override
    public String toString() {
        String returnString = "";
        EvaluatedHand previousHand = null;

        for (EvaluatedHand hand : evaluatedHands) {
            if (previousHand == null) {
                returnString = hand.toString();
            } else {
                if (hand.compareHandByCombinations(previousHand) == 0) {
                    returnString += "=";
                } else {
                    returnString += " ";
                }
                returnString += hand.toString();
            }
            previousHand = hand;
        }

        return returnString;
    }
}
