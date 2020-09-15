package fr.dojo.kata.yatzy;

import lombok.Getter;

/**
 * Classe modélisant un jet de 5 dés au sein du jeu "Yatzy".
 */
@Getter
public class YatzyDiceRoll {

    private int d1;
    private int d2;
    private int d3;
    private int d4;
    private int d5;

    public YatzyDiceRoll(int d1, int d2, int d3, int d4, int d5) {
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.d4 = d4;
        this.d5 = d5;
    }

    @Override
    public String toString() {
        return "YatzyDiceRoll{" +
                "d1=" + d1 +
                ", d2=" + d2 +
                ", d3=" + d3 +
                ", d4=" + d4 +
                ", d5=" + d5 +
                '}';
    }
}
