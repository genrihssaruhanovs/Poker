package com.company.enums;

import java.util.HashMap;
import java.util.Map;

public enum Suit {
    HEART('h' ),
    DIAMOND('d' ),
    CROSS('c' ),
    SPADE('s' );

    private final char charValue;
    private static final Map<Character, Suit> lookup = new HashMap<>();

    Suit(char charValue) {
        this.charValue = charValue;
    }

    public char getCharValue() {
        return charValue;
    }

    public static Suit get(char charValue) {
        Suit suit = lookup.get(charValue);
        if (suit == null) {
            throw new IllegalArgumentException();
        } else {
            return lookup.get(charValue);
        }
    }

    static {
        for (Suit suit : Suit.values()) {
            lookup.put(suit.getCharValue(), suit);
        }
    }
}
