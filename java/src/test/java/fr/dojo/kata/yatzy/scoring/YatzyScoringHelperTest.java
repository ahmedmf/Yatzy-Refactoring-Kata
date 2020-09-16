package fr.dojo.kata.yatzy.scoring;

import fr.dojo.kata.yatzy.YatzyDiceRoll;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class YatzyScoringHelperTest {

    // TODO : Tester la levée d'exception lorsque la valeur des dés sors de l'interval [0:6]

    @Test
    @Parameters(method = "testChanceScoresSumOfAllDiceParams")
    public void testChanceScoresSumOfAllDice(int expected, YatzyDiceRoll diceRoll) {
        // Arrange

        // Act
        int actual = YatzyScoringHelper.chance(diceRoll);

        // Assert
        assertEquals(expected, actual);
    }
    // Paramètres du test chanceScoresSumOfAllDice
    public Object testChanceScoresSumOfAllDiceParams() {
        return new Object[] {
          new Object[] {15, new YatzyDiceRoll(2, 3, 4, 5, 1)},
          new Object[] {16, new YatzyDiceRoll(3, 3, 4, 5, 1)},
          new Object[] {0, new YatzyDiceRoll(0, 0, 0, 0, 0)}
        };
    }

    @Test
    @Parameters(method = "testYatzyScoresFiftyParams")
    public void testYatzyScoresFifty(int expected, YatzyDiceRoll diceRoll) {
        // Arrange

        // Act
        int actual = YatzyScoringHelper.yatzy(diceRoll);

        // Assert
        assertEquals(expected, actual);
        assertEquals(expected, YatzyScoringHelper.yatzy(diceRoll));
    }
    // Paramètres du test
    public Object testYatzyScoresFiftyParams() {
        return new Object[] {
                new Object[] {50, new YatzyDiceRoll(4,4,4,4,4)},
                new Object[] {50, new YatzyDiceRoll(6,6,6,6,6)}
        };
    }

    @Test
    public void testYatzyScoresZero() {
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
    @Parameters(method = "testSixesParams")
    public void testSixes(int expected, YatzyDiceRoll diceRoll) {
        assertEquals(expected, YatzyScoringHelper.sixes(diceRoll));
    }
    public Object testSixesParams() {
        return new Object[] {
                new Object[] {0, new YatzyDiceRoll(4,4,4,5,5)},
                new Object[] {6, new YatzyDiceRoll(4,4,6,5,5)},
                new Object[] {18, new YatzyDiceRoll(6,5,6,6,5)}
        };
    }

    @Test
    @Parameters(method = "testOnePairParams")
    public void testOnePair(int expected, YatzyDiceRoll diceRoll) {
        assertEquals(expected, YatzyScoringHelper.scorePair(diceRoll));
    }
    public Object testOnePairParams() {
        return new Object[] {
                new Object[] {6, new YatzyDiceRoll(3,4,3,5,6)},
                new Object[] {10, new YatzyDiceRoll(5,3,3,3,5)},
                new Object[] {12, new YatzyDiceRoll(5,3,6,6,5)}
        };
    }

    @Test
    public void testTwoPair() {
        assertEquals(16, YatzyScoringHelper.twoPair(new YatzyDiceRoll(3,3,5,4,5)));
        assertEquals(16, YatzyScoringHelper.twoPair(new YatzyDiceRoll(3,3,5,5,5)));
    }

    @Test
    public void testThreeOfAKind()
    {
        assertEquals(9, YatzyScoringHelper.threeOfAKind(new YatzyDiceRoll(3,3,3,4,5)));
        assertEquals(15, YatzyScoringHelper.threeOfAKind(new YatzyDiceRoll(5,3,5,4,5)));
        assertEquals(9, YatzyScoringHelper.threeOfAKind(new YatzyDiceRoll(3,3,3,3,5)));
    }

    @Test
    public void testFourOfAKind() {
        assertEquals(12, YatzyScoringHelper.fourOfAKind(new YatzyDiceRoll(3,3,3,3,5)));
        assertEquals(20, YatzyScoringHelper.fourOfAKind(new YatzyDiceRoll(5,5,5,4,5)));
        assertEquals(9, YatzyScoringHelper.threeOfAKind(new YatzyDiceRoll(3,3,3,3,3)));
    }

    @Test
    public void testSmallStraight() {
        assertEquals(15, YatzyScoringHelper.smallStraight(new YatzyDiceRoll(1,2,3,4,5)));
        assertEquals(15, YatzyScoringHelper.smallStraight(new YatzyDiceRoll(2,3,4,5,1)));
        assertEquals(0, YatzyScoringHelper.smallStraight(new YatzyDiceRoll(1,2,2,4,5)));
    }

    @Test
    public void testLargeStraight() {
        assertEquals(20, YatzyScoringHelper.largeStraight(new YatzyDiceRoll(6,2,3,4,5)));
        assertEquals(20, YatzyScoringHelper.largeStraight(new YatzyDiceRoll(2,3,4,5,6)));
        assertEquals(0, YatzyScoringHelper.largeStraight(new YatzyDiceRoll(1,2,2,4,5)));
    }

    @Test
    public void testFullHouse() {
        assertEquals(18, YatzyScoringHelper.fullHouse(new YatzyDiceRoll(6,2,2,2,6)));
        assertEquals(0, YatzyScoringHelper.fullHouse(new YatzyDiceRoll(2,3,4,5,6)));
    }
}
