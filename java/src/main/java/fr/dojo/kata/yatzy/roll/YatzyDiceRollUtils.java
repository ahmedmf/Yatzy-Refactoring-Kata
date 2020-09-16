package fr.dojo.kata.yatzy.roll;

public class YatzyDiceRollUtils {
    public static int getScoreFromValue(int value, YatzyDiceRoll diceRoll) {
        int count = 0;

        for (int die : diceRoll.getDiceAsArray()) {
            if (die == value) {
                count++;
            }
        }

        return count * value;
    }

    public static int getTotalFromDiceValues(YatzyDiceRoll diceRoll) {
        int total = 0;
        total += diceRoll.getD1();
        total += diceRoll.getD2();
        total += diceRoll.getD3();
        total += diceRoll.getD4();
        total += diceRoll.getD5();

        return total;
    }
}