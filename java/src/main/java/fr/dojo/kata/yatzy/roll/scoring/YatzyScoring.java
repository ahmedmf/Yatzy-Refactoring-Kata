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
        int dieRef = diceRoll.getD1();

        for (int die : YatzyDiceRollUtils.getDiceAsArray(diceRoll)) {
            if (die != dieRef) {
                return 0;
            }
        }

        return 50;
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
        int[] tallies;
        tallies = new int[6];
        tallies[diceRoll.getD1() - 1] += 1;
        tallies[diceRoll.getD2() - 1] += 1;
        tallies[diceRoll.getD3() - 1] += 1;
        tallies[diceRoll.getD4() - 1] += 1;
        tallies[diceRoll.getD5() - 1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(YatzyDiceRoll diceRoll) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        tallies = new int[6];
        tallies[diceRoll.getD1() - 1] += 1;
        tallies[diceRoll.getD2() - 1] += 1;
        tallies[diceRoll.getD3() - 1] += 1;
        tallies[diceRoll.getD4() - 1] += 1;
        tallies[diceRoll.getD5() - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



