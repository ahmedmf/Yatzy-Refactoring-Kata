package fr.dojo.kata.yatzy.roll;

import java.util.Arrays;
import java.util.TreeSet;

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

    public static boolean hasNValues(int value, int n, YatzyDiceRoll diceRoll) {
        int count = getValueCountFromDiceRoll(value, diceRoll);

        if (count >= n) {
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

    public static TreeSet<Integer> extractAndSortNValues(int n, YatzyDiceRoll diceRoll) {
        TreeSet<Integer> nValues = new TreeSet<>();

        for(int i = 6; i > 0; i--) {
            if(hasNValues(i, n, diceRoll)) {
                nValues.add(i);
            }
        }
        return nValues;
    }

    public static int[] getDiceAsOrderedArray(YatzyDiceRoll diceRoll) {
        int[] unorderedDiceAsArray = YatzyDiceRollUtils.getDiceAsArray(diceRoll);

        Arrays.sort(unorderedDiceAsArray);

        return unorderedDiceAsArray;
    }
}