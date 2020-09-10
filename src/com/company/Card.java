package com.company;

import com.company.enums.Rank;
import com.company.enums.Suit;

public class Card implements Comparable<Card> {
    private Rank rank;
    private Suit suit;

    public Card(String cardString) {
        try {
            this.rank = Rank.get(cardString.charAt(0));
        } catch (IllegalArgumentException e) {
            throw new IncorrectInputStringException("Rank " + cardString.charAt(0) + " does not exist");
        }

        try {
            this.suit = Suit.get(cardString.charAt(1));
        } catch (StringIndexOutOfBoundsException e) {
            throw new IncorrectInputStringException("Card " + cardString + " is not a correct input");
        } catch (IllegalArgumentException e) {
            throw new IncorrectInputStringException("Suit " + cardString.charAt(1) + " does not exist");
        }

    }

    public Suit getSuit() {
        return suit;
    }

    public int getStrength() {
        return rank.getStrength();
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public int compareTo(Card candidate) {
        return (Integer.compare(this.getStrength(), candidate.getStrength()));
    }


    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()){
            return false;
        }
        Card candidate = (Card) obj;
        return this.getRank() == candidate.getRank() && this.getSuit() == candidate.getSuit();
    }

    @Override
    public String toString() {
        return "" + rank.getCharValue() + suit.getCharValue();
    }
}
