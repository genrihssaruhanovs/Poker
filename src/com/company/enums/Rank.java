package com.company.enums;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    TWO('2', 2),
    THREE('3', 3),
    FOUR('4', 4),
    FIVE('5', 5),
    SIX('6', 6),
    SEVEN('7', 7),
    EIGHT('8', 8),
    NINE('9', 9),
    TEN('T', 10),
    JACK('J', 11),
    QUEEN('Q', 12),
    KING('K', 13),
    ACE('A', 14);

    private final char charValue;
    private final int strength;
    private static final Map<Character, Rank> lookup = new HashMap<>();
    private static Rank[] ranks = values();

    Rank(char charValue, int strength) {
        this.charValue = charValue;
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public char getCharValue() {
        return charValue;
    }

    static {
        for (Rank rank : Rank.values()) {
            lookup.put(rank.getCharValue(), rank);
        }
    }

    public static Rank get(char charValue) {
        Rank rank = lookup.get(charValue);
        if (rank == null) {
            throw new IllegalArgumentException();
        } else {
            return lookup.get(charValue);
        }
    }

    public boolean isPrevious(Rank card) {
        int previousIndex = this.ordinal() == 0 ? ranks.length - 1 : this.ordinal() - 1;
        return card == ranks[previousIndex];
    }
}
