package fr.dojo.kata.yatzy.roll.scoring;

import fr.dojo.kata.yatzy.roll.YatzyDiceRoll;
import fr.dojo.kata.yatzy.roll.YatzyDiceRollUtils;

import java.util.Arrays;
import java.util.TreeSet;

public class YatzyScoring {

    public static int chance(YatzyDiceRoll diceRoll) {
        return YatzyDiceRollUtils.getTotalFromDiceValues(diceRoll);
    }

    public static int yatzy(YatzyDiceRoll diceRoll) {
        TreeSet<Integer> yatzyValues = YatzyDiceRollUtils.extractAndSortNValues(5, diceRoll);

        if(yatzyValues.size() == 1) {
            return 50;
        }

        return 0;
    }

    public static int ones(YatzyDiceRoll diceRoll) {
        return YatzyDiceRollUtils.getScoreFromValue(1, diceRoll);
    }

    public static int twos(YatzyDiceRoll diceRoll) {
        return YatzyDiceRollUtils.getScoreFromValue(2, diceRoll);
    }

    public static int threes(YatzyDiceRoll diceRoll) {
        return YatzyDiceRollUtils.getScoreFromValue(3, diceRoll);
    }

    public static int fours(YatzyDiceRoll diceRoll) {
        return YatzyDiceRollUtils.getScoreFromValue(4, diceRoll);
    }

    public static int fives(YatzyDiceRoll diceRoll) {
        return YatzyDiceRollUtils.getScoreFromValue(5, diceRoll);
    }

    public static int sixes(YatzyDiceRoll diceRoll) {
        return YatzyDiceRollUtils.getScoreFromValue(6, diceRoll);
    }

    public static int scorePair(YatzyDiceRoll diceRoll) {
        TreeSet<Integer> pairValues = YatzyDiceRollUtils.extractAndSortNValues(2, diceRoll);

        if (pairValues.size() < 1) {
            return 0;
        }

        int highestPairValue = pairValues.pollLast();

        return 2 * highestPairValue;
    }

    public static int twoPair(YatzyDiceRoll diceRoll) {
        TreeSet<Integer> pairValues = YatzyDiceRollUtils.extractAndSortNValues(2, diceRoll);

        if (pairValues.size() < 2) {
            return 0;
        }

        int highestPairValue = pairValues.pollLast();
        int secondPairValue = pairValues.pollLast();

        return 2 * highestPairValue + 2 * secondPairValue;
    }

    public static int threeOfAKind(YatzyDiceRoll diceRoll) {
        TreeSet<Integer> tripletValues = YatzyDiceRollUtils.extractAndSortNValues(3, diceRoll);

        if (tripletValues.size() < 1) {
            return 0;
        }

        int highestTripletValue = tripletValues.pollLast();

        return 3 * highestTripletValue;
    }

    public static int fourOfAKind(YatzyDiceRoll diceRoll) {
        TreeSet<Integer> quadrupletValues = YatzyDiceRollUtils.extractAndSortNValues(4, diceRoll);

        if (quadrupletValues.size() < 1) {
            return 0;
        }

        int highestQuadrupletValue = quadrupletValues.pollLast();

        return 4 * highestQuadrupletValue;
    }

    public static int smallStraight(YatzyDiceRoll diceRoll) {
        int[] smallStraightReference = {1, 2, 3, 4, 5};
        int[] diceAsOrderedArray = YatzyDiceRollUtils.getDiceAsOrderedArray(diceRoll);

        if (Arrays.equals(smallStraightReference, diceAsOrderedArray)) {
            return 15;
        }

        return 0;
    }

    public static int largeStraight(YatzyDiceRoll diceRoll) {
        int[] largeStraightReference = {2, 3, 4, 5, 6};
        int[] diceAsOrderedArray = YatzyDiceRollUtils.getDiceAsOrderedArray(diceRoll);

        if (Arrays.equals(largeStraightReference, diceAsOrderedArray)) {
            return 20;
        }

        return 0;
    }

    public static int fullHouse(YatzyDiceRoll diceRoll) {
        TreeSet<Integer> yatzyValues = YatzyDiceRollUtils.extractAndSortNValues(5, diceRoll);
        TreeSet<Integer> tripletValues = YatzyDiceRollUtils.extractAndSortNValues(3, diceRoll);
        TreeSet<Integer> pairValues = YatzyDiceRollUtils.extractAndSortNValues(2, diceRoll);

        if(yatzyValues.size() == 1) {
            return 0;
        }

        if (tripletValues.size() < 1) {
            return 0;
        }

        if (pairValues.size() < 1) {
            return 0;
        }

        int tripletValue = tripletValues.pollLast();
        int pairValue = pairValues.pollLast();

        if (pairValue == tripletValue) {
            pairValue = pairValues.pollLast();
        }

        return 3 * tripletValue + 2 * pairValue;
    }
}



