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
}