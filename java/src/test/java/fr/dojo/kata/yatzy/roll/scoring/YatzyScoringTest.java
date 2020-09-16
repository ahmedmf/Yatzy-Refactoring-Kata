package fr.dojo.kata.yatzy.roll.scoring;

import fr.dojo.kata.yatzy.roll.YatzyDiceRoll;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class YatzyScoringTest {

    // TODO : Tester la levée d'exception lorsque la valeur des dés sors de l'interval [0:6]

    @Test
    @Parameters(method = "testChanceScoresSumOfAllDiceParams")
    public void testChanceScoresSumOfAllDice(int expected, YatzyDiceRoll diceRoll) {
        // Arrange

        // Act
        int actual = YatzyScoring.chance(diceRoll);

        // Assert
        assertEquals(expected, actual);
    }

    // Paramètres du test chanceScoresSumOfAllDice
    public Object testChanceScoresSumOfAllDiceParams() {
        return new Object[]{
                new Object[]{15, new YatzyDiceRoll(2, 3, 4, 5, 1)},
                new Object[]{16, new YatzyDiceRoll(3, 3, 4, 5, 1)},
                new Object[]{0, new YatzyDiceRoll(0, 0, 0, 0, 0)}
        };
    }

    @Test
    @Parameters(method = "testYatzyScoresFiftyParams")
    public void testYatzyScoresFifty(int expected, YatzyDiceRoll diceRoll) {
        // Arrange

        // Act
        int actual = YatzyScoring.yatzy(diceRoll);

        // Assert
        assertEquals(expected, actual);
    }

    // Paramètres du test
    public Object testYatzyScoresFiftyParams() {
        return new Object[]{
                new Object[]{50, new YatzyDiceRoll(4, 4, 4, 4, 4)},
                new Object[]{50, new YatzyDiceRoll(6, 6, 6, 6, 6)}
        };
    }

    @Test
    public void testYatzyScoresZero() {
        // Arrange
        int expected = 0;
        YatzyDiceRoll diceRoll = new YatzyDiceRoll(6, 6, 6, 6, 3);

        // Act
        int actual = YatzyScoring.yatzy(diceRoll);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @Parameters(method = "testOnesParams")
    public void testOnes(int expected, YatzyDiceRoll diceRoll) {
        // Arrange

        // Act
        int actual = YatzyScoring.ones(diceRoll);

        // Assert
        assertEquals(expected, actual);
    }

    public Object testOnesParams() {
        return new Object[]{
                new Object[]{1, new YatzyDiceRoll(1, 2, 3, 4, 5)},
                new Object[]{2, new YatzyDiceRoll(1, 2, 1, 4, 5)},
                new Object[]{0, new YatzyDiceRoll(6, 2, 2, 4, 5)},
                new Object[]{4, new YatzyDiceRoll(1, 2, 1, 1, 1)}
        };
    }

    @Test
    @Parameters(method = "testTwosParams")
    public void testTwos(int expected, YatzyDiceRoll diceRoll) {
        int actual = YatzyScoring.twos(diceRoll);
        assertEquals(expected, actual);
    }

    public Object testTwosParams() {
        return new Object[]{
                new Object[]{4, new YatzyDiceRoll(1, 2, 3, 2, 6)},
                new Object[]{10, new YatzyDiceRoll(2, 2, 2, 2, 2)}
        };
    }

    @Test
    @Parameters(method = "testThreesParams")
    public void testThrees(int expected, YatzyDiceRoll diceRoll) {
        int actual = YatzyScoring.threes(diceRoll);
        assertEquals(expected, actual);
    }

    public Object testThreesParams() {
        return new Object[]{
                new Object[]{6, new YatzyDiceRoll(1, 2, 3, 2, 3)},
                new Object[]{12, new YatzyDiceRoll(2, 3, 3, 3, 3)}
        };
    }

    @Test
    @Parameters(method = "testFoursParams")
    public void testFours(int expected, YatzyDiceRoll diceRoll) {
        int actual = YatzyScoring.fours(diceRoll);
        assertEquals(expected, actual);
    }

    public Object testFoursParams() {
        return new Object[]{
                new Object[]{12, new YatzyDiceRoll(4, 4, 4, 5, 5)},
                new Object[]{8, new YatzyDiceRoll(4, 4, 5, 5, 5)},
                new Object[]{4, new YatzyDiceRoll(4, 5, 5, 5, 5)}
        };
    }

    @Test
    @Parameters(method = "testFivesParams")
    public void testFives(int expected, YatzyDiceRoll diceRoll) {
        int actual = YatzyScoring.fives(diceRoll);
        assertEquals(expected, actual);
    }

    public Object testFivesParams() {
        return new Object[]{
                new Object[]{10, new YatzyDiceRoll(4, 4, 4, 5, 5)},
                new Object[]{15, new YatzyDiceRoll(4, 4, 5, 5, 5)},
                new Object[]{20, new YatzyDiceRoll(4, 5, 5, 5, 5)}
        };
    }

    @Test
    @Parameters(method = "testSixesParams")
    public void testSixes(int expected, YatzyDiceRoll diceRoll) {
        int actual = YatzyScoring.sixes(diceRoll);
        assertEquals(expected, actual);
    }

    public Object testSixesParams() {
        return new Object[]{
                new Object[]{0, new YatzyDiceRoll(4, 4, 4, 5, 5)},
                new Object[]{6, new YatzyDiceRoll(4, 4, 6, 5, 5)},
                new Object[]{18, new YatzyDiceRoll(6, 5, 6, 6, 5)}
        };
    }

    @Test
    @Parameters(method = "testOnePairParams")
    public void testOnePair(int expected, YatzyDiceRoll diceRoll) {
        int actual = YatzyScoring.scorePair(diceRoll);
        assertEquals(expected, actual);
    }

    public Object testOnePairParams() {
        return new Object[]{
                new Object[]{6, new YatzyDiceRoll(3, 4, 3, 5, 6)},
                new Object[]{10, new YatzyDiceRoll(5, 3, 3, 3, 5)},
                new Object[]{12, new YatzyDiceRoll(5, 3, 6, 6, 5)}
        };
    }

    @Test
    @Parameters(method = "testTwoPairParams")
    public void testTwoPair(int expected, YatzyDiceRoll diceRoll) {
        int actual = YatzyScoring.twoPair(diceRoll);
        assertEquals(expected, actual);
    }

    public Object testTwoPairParams() {
        return new Object[]{
                new Object[]{16, new YatzyDiceRoll(3, 3, 5, 4, 5)},
                new Object[]{16, new YatzyDiceRoll(3, 3, 5, 5, 5)}
        };
    }

    @Test
    @Parameters(method = "testThreeOfAKindParams")
    public void testThreeOfAKind(int expected, YatzyDiceRoll diceRoll) {
        int actual = YatzyScoring.threeOfAKind(diceRoll);
        assertEquals(expected, actual);
    }

    public Object testThreeOfAKindParams() {
        return new Object[]{
                new Object[]{9, new YatzyDiceRoll(3, 3, 3, 4, 5)},
                new Object[]{15, new YatzyDiceRoll(5, 3, 5, 4, 5)},
                new Object[]{9, new YatzyDiceRoll(3, 3, 3, 3, 5)},
                new Object[]{9, new YatzyDiceRoll(3, 3, 3, 3, 3)}
        };
    }

    @Test
    @Parameters(method = "testFourOfAKindParams")
    public void testFourOfAKind(int expected, YatzyDiceRoll diceRoll) {
        int actual = YatzyScoring.fourOfAKind(diceRoll);
        assertEquals(expected, actual);
    }

    public Object testFourOfAKindParams() {
        return new Object[]{
                new Object[]{12, new YatzyDiceRoll(3, 3, 3, 3, 5)},
                new Object[]{20, new YatzyDiceRoll(5, 5, 5, 4, 5)},
                new Object[]{12, new YatzyDiceRoll(3, 3, 3, 3, 3)}
        };
    }

    @Test
    @Parameters(method = "testSmallStraightParams")
    public void testSmallStraight(int expected, YatzyDiceRoll diceRoll) {
        int actual = YatzyScoring.smallStraight(diceRoll);
        assertEquals(expected, actual);
    }

    public Object testSmallStraightParams() {
        return new Object[]{
                new Object[]{15, new YatzyDiceRoll(1, 2, 3, 4, 5)},
                new Object[]{15, new YatzyDiceRoll(2, 3, 4, 5, 1)},
                new Object[]{0, new YatzyDiceRoll(1, 2, 2, 4, 5)}
        };
    }

    @Test
    @Parameters(method = "testLargeStraightParams")
    public void testLargeStraight(int expected, YatzyDiceRoll diceRoll) {
        int actual = YatzyScoring.largeStraight(diceRoll);
        assertEquals(expected, actual);
    }

    public Object testLargeStraightParams() {
        return new Object[]{
                new Object[]{20, new YatzyDiceRoll(6, 2, 3, 4, 5)},
                new Object[]{20, new YatzyDiceRoll(2, 3, 4, 5, 6)},
                new Object[]{0, new YatzyDiceRoll(1, 2, 2, 4, 5)}
        };
    }

    @Test
    @Parameters(method = "testFullHouseParams")
    public void testFullHouse(int expected, YatzyDiceRoll diceRoll) {
        int actual = YatzyScoring.fullHouse(diceRoll);
        assertEquals(expected, actual);
    }

    public Object testFullHouseParams() {
        return new Object[]{
                new Object[]{18, new YatzyDiceRoll(6, 2, 2, 2, 6)},
                new Object[]{0, new YatzyDiceRoll(2, 3, 4, 5, 6)}
        };
    }
}
