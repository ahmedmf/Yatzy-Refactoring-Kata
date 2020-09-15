package fr.dojo.kata.yatzy.scoring;

import fr.dojo.kata.yatzy.scoring.YatzyScoringHelper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class YatzyScoringHelperTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = YatzyScoringHelper.chance(2,3,4,5,1);
        assertEquals(expected, actual);
        assertEquals(16, YatzyScoringHelper.chance(3,3,4,5,1));
    }

    @Test public void yatzy_scores_50() {
        int expected = 50;
        int actual = YatzyScoringHelper.yatzy(4,4,4,4,4);
        assertEquals(expected, actual);
        assertEquals(50, YatzyScoringHelper.yatzy(6,6,6,6,6));
        assertEquals(0, YatzyScoringHelper.yatzy(6,6,6,6,3));
    }

    @Test public void test_1s() {
        assertTrue(YatzyScoringHelper.ones(1,2,3,4,5) == 1);
        assertEquals(2, YatzyScoringHelper.ones(1,2,1,4,5));
        assertEquals(0, YatzyScoringHelper.ones(6,2,2,4,5));
        assertEquals(4, YatzyScoringHelper.ones(1,2,1,1,1));
    }

    @Test
    public void test_2s() {
        assertEquals(4, YatzyScoringHelper.twos(1,2,3,2,6));
        assertEquals(10, YatzyScoringHelper.twos(2,2,2,2,2));
    }

    @Test
    public void test_threes() {
        assertEquals(6, YatzyScoringHelper.threes(1,2,3,2,3));
        assertEquals(12, YatzyScoringHelper.threes(2,3,3,3,3));
    }

    @Test
    public void fours_test()
    {
        assertEquals(12, new YatzyScoringHelper(4,4,4,5,5).fours());
        assertEquals(8, new YatzyScoringHelper(4,4,5,5,5).fours());
        assertEquals(4, new YatzyScoringHelper(4,5,5,5,5).fours());
    }

    @Test
    public void fives() {
        assertEquals(10, new YatzyScoringHelper(4,4,4,5,5).fives());
        assertEquals(15, new YatzyScoringHelper(4,4,5,5,5).fives());
        assertEquals(20, new YatzyScoringHelper(4,5,5,5,5).fives());
    }

    @Test
    public void sixes_test() {
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
