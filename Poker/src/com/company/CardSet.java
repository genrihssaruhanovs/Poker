package com.company;

import com.company.enums.Rank;

import java.util.ArrayList;

import java.util.Collections;

public class CardSet {
    private ArrayList<Card> cards;

    public CardSet(ArrayList<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public CardSet(String cardsListString) {
        this.cards = new ArrayList<>();
        String[] cardsList = cardsListString.split(("(?<=\\G.{2})"));
        for (String cardString : cardsList) {
            this.cards.add(new Card(cardString));
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void sortDescending() {
        Collections.sort(this.cards, Collections.reverseOrder());
    }

    @Override
    public String toString() {
        String cardsString = "";
        for (Card card : cards) {
            cardsString += card.toString();
        }
        return cardsString;
    }

    public boolean isEqualByValue(CardSet comparedSet) {
        if (cards.size() != comparedSet.getCards().size()) {
            return false;
        }
        for (Card card : cards) {
            if (!comparedSet.containsValue(card.getRank())) {
                return false;
            }
        }
        return true;
    }

    public boolean containsValue(Rank value) {
        for (Card card : cards) {
            if (card.getRank() == value) {
                return true;
            }
        }
        return false;
    }

    public static CardSet MergeAndSort(CardSet cardSet1, CardSet cardSet2) {
        ArrayList<Card> mergedCards = new ArrayList<>();
        mergedCards.addAll(cardSet1.getCards());
        mergedCards.addAll(cardSet2.getCards());
        CardSet returnSet = new CardSet(mergedCards);
        returnSet.sortDescending();
        return returnSet;
    }
}
