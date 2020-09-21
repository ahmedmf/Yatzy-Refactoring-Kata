package fr.dojo.kata.yatzy.roll;

public enum Die {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int dieValue;

    private Die(int dieValue) {
        this.dieValue = dieValue;
    }

    public int getDieValue() {
        return this.dieValue;
    }
}
