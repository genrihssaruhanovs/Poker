package com.company;

import com.company.enums.Rank;
import com.company.enums.Suit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HandCombinations {
    private ArrayList<Card> handCards;
    private ArrayList<Rank> singleCards = new ArrayList<>();
    private ArrayList<Rank> pairs = new ArrayList<>();
    private Rank threeOfAKind; // only first one matters
    private Rank fourOfAKind;  // can only be one
    private ArrayList<CardSet> straights = new ArrayList<>(); //needs multiple for straight flush evaluation
    private ArrayList<CardSet> flushes = new ArrayList<>();

    public HandCombinations(CardSet handCards) {
        this.handCards = handCards.getCards();
    }

    public ArrayList<Rank> getPairs() {
        return pairs;
    }

    public Rank getThreeOfAKind() {
        return threeOfAKind;
    }

    public Rank getFourOfAKind() {
        return fourOfAKind;
    }

    public ArrayList<CardSet> getStraights() {
        return straights;
    }

    public ArrayList<CardSet> getFlushes() {
        return flushes;
    }

    public ArrayList<Rank> getSingleCards() {
        return singleCards;
    }

    public void buildCombinations() {
        ArrayList<Card> currentStraight = new ArrayList<>();
        Map<Suit, ArrayList<Card>> flushCounter = new HashMap<>();
        initializeFlushCounter(flushCounter);
        int matchCounter = 1;

        for (int i = 0; i < handCards.size(); i++) {
            Card currentCard = handCards.get(i);
            Card nextCard = i == handCards.size() - 1 ? handCards.get(0) : handCards.get(i + 1);
            resetCurrentStraight(currentStraight, currentCard);

            if (currentCard.getRank() == nextCard.getRank()) {
                matchCounter++;
            } else if (currentCard.getRank().isPrevious(nextCard.getRank())) {
                determineStraight(currentStraight, nextCard);
                matchCounter = applyAndResetMatch(matchCounter, currentCard.getRank());
            } else {
                currentStraight.clear();
                matchCounter = applyAndResetMatch(matchCounter, currentCard.getRank());
            }

            determineFlushes(flushCounter, currentCard);
        }
    }

    private void resetCurrentStraight(ArrayList<Card> currentStraight, Card card) {
        if (currentStraight.size() == 0) {
            currentStraight.add(card);
        }
    }

    private int applyAndResetMatch(int matchCounter, Rank rank) {
        switch (matchCounter) {
            case 1:
                singleCards.add(rank);
                break;
            case 2:
                pairs.add(rank);
                break;
            case 3:
                if (threeOfAKind == null) {
                    threeOfAKind = rank;
                }
                break;
            case 4:
                fourOfAKind = rank;
        }
        return 1;
    }


    private void initializeFlushCounter(Map<Suit, ArrayList<Card>> flushCounter) {
        for (Suit suit : Suit.values()) {
            flushCounter.put(suit, new ArrayList<>());
        }
    }

    private void determineFlushes(Map<Suit, ArrayList<Card>> flushCounter, Card card) {
        ArrayList<Card> suitCards = flushCounter.get(card.getSuit());
        suitCards.add(card);
        if (suitCards.size() == 5) {
            flushes.add(new CardSet(suitCards));
            suitCards.remove(0);
        }
    }

    private void determineStraight(ArrayList<Card> currentStraight, Card card) {
        currentStraight.add(card);
        if (currentStraight.size() == 5) {
            straights.add(new CardSet(currentStraight));
            currentStraight.remove(0);
        }
    }
}
