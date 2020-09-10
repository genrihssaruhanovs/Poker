package com.company.enums;

public enum PokerTableTypes {
    TEXAS(2),
    OMAHA(4);

    private final int handCardCount;

    PokerTableTypes(int handCardCount) {
        this.handCardCount = handCardCount;
    }

    public int getHandCardCount() {
        return handCardCount;
    }
}
