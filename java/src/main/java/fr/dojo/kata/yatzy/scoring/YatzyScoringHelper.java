package fr.dojo.kata.yatzy.scoring;

import fr.dojo.kata.yatzy.YatzyDiceRoll;

public class YatzyScoringHelper {

    public static int chance(YatzyDiceRoll diceRoll) {
        int total = 0;
        total += diceRoll.getD1();
        total += diceRoll.getD2();
        total += diceRoll.getD3();
        total += diceRoll.getD4();
        total += diceRoll.getD5();

        return total;
    }

    public static int yatzy(YatzyDiceRoll diceRoll) {
        int dieRef = diceRoll.getD1();

        int[] dice = {
                diceRoll.getD2(),
                diceRoll.getD3(),
                diceRoll.getD4(),
                diceRoll.getD5()
        };

        for (int die : dice) {
            if (die != dieRef) {
                return 0;
            }
        }

        return 50;
    }

    private static int getScoreFromValue(int value, YatzyDiceRoll diceRoll) {
        int count = 0;

        for (int die : diceRoll.getDiceAsArray()) {
            if (die == value) {
                count++;
            }
        }

        return count * value;
    }

    public static int ones(YatzyDiceRoll diceRoll) {
        return getScoreFromValue(1, diceRoll);
    }

    public static int twos(YatzyDiceRoll diceRoll) {
        return getScoreFromValue(2, diceRoll);
    }

    public static int threes(YatzyDiceRoll diceRoll) {
        return getScoreFromValue(3, diceRoll);
    }

    public static int fours(YatzyDiceRoll diceRoll) {
        return getScoreFromValue(4, diceRoll);
    }

    public static int fives(YatzyDiceRoll diceRoll) {
        return getScoreFromValue(5, diceRoll);
    }

    public static int sixes(YatzyDiceRoll diceRoll) {
        return getScoreFromValue(6, diceRoll);
    }

    public static int scorePair(YatzyDiceRoll diceRoll) {
        int[] counts = new int[6];
        counts[diceRoll.getD1() - 1]++;
        counts[diceRoll.getD2() - 1]++;
        counts[diceRoll.getD3() - 1]++;
        counts[diceRoll.getD4() - 1]++;
        counts[diceRoll.getD5() - 1]++;
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6 - at - 1] >= 2)
                return (6 - at) * 2;
        return 0;
    }

    public static int twoPair(YatzyDiceRoll diceRoll) {
        int[] counts = new int[6];
        counts[diceRoll.getD1() - 1]++;
        counts[diceRoll.getD2() - 1]++;
        counts[diceRoll.getD3() - 1]++;
        counts[diceRoll.getD4() - 1]++;
        counts[diceRoll.getD5() - 1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public static int fourOfAKind(YatzyDiceRoll diceRoll) {
        int[] tallies;
        tallies = new int[6];
        tallies[diceRoll.getD1() - 1]++;
        tallies[diceRoll.getD2() - 1]++;
        tallies[diceRoll.getD3() - 1]++;
        tallies[diceRoll.getD4() - 1]++;
        tallies[diceRoll.getD5() - 1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i + 1) * 4;
        return 0;
    }

    public static int threeOfAKind(YatzyDiceRoll diceRoll) {
        int[] t;
        t = new int[6];
        t[diceRoll.getD1() - 1]++;
        t[diceRoll.getD2() - 1]++;
        t[diceRoll.getD3() - 1]++;
        t[diceRoll.getD4() - 1]++;
        t[diceRoll.getD5() - 1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i + 1) * 3;
        return 0;
    }

    public static int smallStraight(YatzyDiceRoll diceRoll) {
        int[] tallies;
        tallies = new int[6];
        tallies[diceRoll.getD1() - 1] += 1;
        tallies[diceRoll.getD2() - 1] += 1;
        tallies[diceRoll.getD3() - 1] += 1;
        tallies[diceRoll.getD4() - 1] += 1;
        tallies[diceRoll.getD5() - 1] += 1;
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
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



