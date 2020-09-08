package com.company.enums;

public enum Combinations {
    HIGH_CARD(1),
    PAIR(2),
    TWO_PAIRS(3),
    THREE_OF_A_KIND(4),
    STRAIGHT(5),
    FLUSH(6),
    FULL_HOUSE(7),
    FOUR_OF_A_KIND(8),
    STRAIGHT_FLUSH(9);


    private final int strength;

    Combinations(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }
}
