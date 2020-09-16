package fr.dojo.kata.yatzy.roll;

public class YatzyDiceRollUtils {
    public static int getScoreFromValue(int value, YatzyDiceRoll diceRoll) {
        int count = 0;

        for (int die : YatzyDiceRollUtils.getDiceAsArray(diceRoll)) {
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

    public static int[] getDiceAsArray(YatzyDiceRoll diceRoll) {
        return new int[]{
                diceRoll.getD1(),
                diceRoll.getD2(),
                diceRoll.getD3(),
                diceRoll.getD4(),
                diceRoll.getD5()
        };
    }

    public static boolean hasPairOfValue(int i, YatzyDiceRoll diceRoll) {
        int count = getValueCountFromDiceRoll(i, diceRoll);

        if (count >= 2) {
            return true;
        }

        return false;
    }

    public static int getValueCountFromDiceRoll(int value, YatzyDiceRoll diceRoll) {
        int count = 0;

        for (int i : YatzyDiceRollUtils.getDiceAsArray(diceRoll)) {
            if (i == value) {
                count++;
            }
        }

        return count;
    }
}