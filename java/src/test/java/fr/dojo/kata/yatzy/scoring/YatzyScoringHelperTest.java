package fr.dojo.kata.yatzy.scoring;

import fr.dojo.kata.yatzy.YatzyDiceRoll;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class YatzyScoringHelperTest {

    // TODO : Tester la levée d'exception lorsque la valeur des dés sors de l'interval [0:6]

    @Test
    @Parameters(method = "chanceScoresSumOfAllDiceParams")
    public void chanceScoresSumOfAllDice(int expected, YatzyDiceRoll diceRoll) {
        // Arrange

        // Act
        int actual = YatzyScoringHelper.chance(diceRoll);

        // Assert
        assertEquals(expected, actual);
    }
    // Paramètres du test chanceScoresSumOfAllDice
    public Object chanceScoresSumOfAllDiceParams() {
        return new Object[] {
          new Object[] {15, new YatzyDiceRoll(2, 3, 4, 5, 1)},
          new Object[] {16, new YatzyDiceRoll(3, 3, 4, 5, 1)},
          new Object[] {0, new YatzyDiceRoll(0, 0, 0, 0, 0)}
        };
    }

    @Test
    @Parameters(method = "yatzyScoresFiftyParams")
    public void yatzyScoresFifty(int expected, YatzyDiceRoll diceRoll) {
        // Arrange

        // Act
        int actual = YatzyScoringHelper.yatzy(diceRoll);

        // Assert
        assertEquals(expected, actual);
        assertEquals(expected, YatzyScoringHelper.yatzy(diceRoll));
    }
    // Paramètres du test
    public Object yatzyScoresFiftyParams() {
        return new Object[] {
                new Object[] {50, new YatzyDiceRoll(4,4,4,4,4)},
                new Object[] {50, new YatzyDiceRoll(6,6,6,6,6)}
        };
    }

    @Test
    public void yatzyScoresZero() {
        // Arrange
        int expected = 0;
        YatzyDiceRoll diceRoll = new YatzyDiceRoll(6,6,6,6,3);

        // Act
        int actual = YatzyScoringHelper.yatzy(diceRoll);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @Parameters(method = "testOnesParams")
    public void testOnes(int expected, YatzyDiceRoll diceRoll) {
        // Arrange

        // Act
        int actual = YatzyScoringHelper.ones(diceRoll);

        // Assert
        assertEquals(expected, actual);
    }
    public Object testOnesParams() {
        return new Object[] {
                new Object[] {1, new YatzyDiceRoll(1,2,3,4,5)},
                new Object[] {2, new YatzyDiceRoll(1,2,1,4,5)},
                new Object[] {0, new YatzyDiceRoll(6,2,2,4,5)},
                new Object[] {4, new YatzyDiceRoll(1,2,1,1,1)}
        };
    }

    @Test
    @Parameters(method = "testTwosParams")
    public void testTwos(int expected, YatzyDiceRoll diceRoll) {
        assertEquals(expected, YatzyScoringHelper.twos(diceRoll));
    }
    public Object testTwosParams() {
        return new Object[] {
                new Object[] {4, new YatzyDiceRoll(1,2,3,2,6)},
                new Object[] {10, new YatzyDiceRoll(2,2,2,2,2)}
        };
    }

    @Test
    @Parameters(method = "testThreesParams")
    public void testThrees(int expected, YatzyDiceRoll diceRoll) {
        assertEquals(expected, YatzyScoringHelper.threes(diceRoll));
    }
    public Object testThreesParams() {
        return new Object[] {
                new Object[] {6, new YatzyDiceRoll(1,2,3,2,3)},
                new Object[] {12, new YatzyDiceRoll(2,3,3,3,3)}
        };
    }

    @Test
    @Parameters(method = "testFoursParams")
    public void testFours(int expected, YatzyDiceRoll diceRoll)
    {
        assertEquals(expected, YatzyScoringHelper.fours(diceRoll));
    }
    public Object testFoursParams() {
        return new Object[] {
                new Object[] {12, new YatzyDiceRoll(4,4,4,5,5)},
                new Object[] {8, new YatzyDiceRoll(4,4,5,5,5)},
                new Object[] {4, new YatzyDiceRoll(4,5,5,5,5)}
        };
    }

    @Test
    @Parameters(method = "testFivesParams")
    public void testFives(int expected, YatzyDiceRoll diceRoll) {
        assertEquals(expected, YatzyScoringHelper.fives(diceRoll));
    }
    public Object testFivesParams() {
        return new Object[] {
                new Object[] {10, new YatzyDiceRoll(4,4,4,5,5)},
                new Object[] {15, new YatzyDiceRoll(4,4,5,5,5)},
                new Object[] {20, new YatzyDiceRoll(4,5,5,5,5)}
        };
    }

    @Test
    public void testSixes() {
        assertEquals(0, new YatzyScoringHelper(4,4,4,5,5).sixes());
        assertEquals(6, new YatzyScoringHelper(4,4,6,5,5).sixes());
        assertEquals(18, new YatzyScoringHelper(6,5,6,6,5).sixes());
    }

    @Test
    public void one_pair() {
        assertEquals(6, YatzyScoringHelper.score_pair(3,4,3,5,6));
        assertEquals(10, YatzyScoringHelper.score_pair(5,3,3,3,5));
        assertEquals(12, YatzyScoringHelper.score_pair(5,3,6,6,5));
    }

    @Test
    public void two_Pair() {
        assertEquals(16, YatzyScoringHelper.two_pair(3,3,5,4,5));
        assertEquals(16, YatzyScoringHelper.two_pair(3,3,5,5,5));
    }

    @Test
    public void three_of_a_kind()
    {
        assertEquals(9, YatzyScoringHelper.three_of_a_kind(3,3,3,4,5));
        assertEquals(15, YatzyScoringHelper.three_of_a_kind(5,3,5,4,5));
        assertEquals(9, YatzyScoringHelper.three_of_a_kind(3,3,3,3,5));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, YatzyScoringHelper.four_of_a_kind(3,3,3,3,5));
        assertEquals(20, YatzyScoringHelper.four_of_a_kind(5,5,5,4,5));
        assertEquals(9, YatzyScoringHelper.three_of_a_kind(3,3,3,3,3));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, YatzyScoringHelper.smallStraight(1,2,3,4,5));
        assertEquals(15, YatzyScoringHelper.smallStraight(2,3,4,5,1));
        assertEquals(0, YatzyScoringHelper.smallStraight(1,2,2,4,5));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, YatzyScoringHelper.largeStraight(6,2,3,4,5));
        assertEquals(20, YatzyScoringHelper.largeStraight(2,3,4,5,6));
        assertEquals(0, YatzyScoringHelper.largeStraight(1,2,2,4,5));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, YatzyScoringHelper.fullHouse(6,2,2,2,6));
        assertEquals(0, YatzyScoringHelper.fullHouse(2,3,4,5,6));
    }
}
