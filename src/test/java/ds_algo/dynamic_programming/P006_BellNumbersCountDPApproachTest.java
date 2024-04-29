package ds_algo.dynamic_programming;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class P006_BellNumbersCountDPApproachTest {

    private static P006_BellNumbersCountDPApproach bellNumbersCountDPApproach;
    private static int maxLimit;

    @BeforeAll
    static void beforeAll() {
        maxLimit = 12;
        bellNumbersCountDPApproach = new P006_BellNumbersCountDPApproach(maxLimit);
    }

    @Test
    void getSetCombinationForNegativeMaxLimitInput() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                                                         () -> new P006_BellNumbersCountDPApproach(-10));
        assertEquals("Negative input is not allowed", runtimeException.getMessage());
    }

    @Test
    void getSetCombinationForNegativeInput() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                                                                         () -> bellNumbersCountDPApproach.getSetCombinations(
                                                                                 -10));
        assertEquals("Should not give negative input", illegalArgumentException.getMessage());
    }

    @Test
    void getSetCombinationForZeroInput() {
        int combinationsCount = bellNumbersCountDPApproach.getSetCombinations(0);
        assertEquals(1, combinationsCount);
    }

    @Test
    void getSetCombinationForOneInput() {
        int combinationsCount = bellNumbersCountDPApproach.getSetCombinations(1);
        assertEquals(1, combinationsCount);
    }

    @Test
    void getSetCombinationForTwoInput() {
        int combinationsCount = bellNumbersCountDPApproach.getSetCombinations(2);
        assertEquals(2, combinationsCount);
    }

    @Test
    void getSetCombinationForThreeInput() {
        int combinationsCount = bellNumbersCountDPApproach.getSetCombinations(3);
        assertEquals(5, combinationsCount);
    }

    @Test
    void getSetCombinationForFourInput() {
        int combinationsCount = bellNumbersCountDPApproach.getSetCombinations(4);
        assertEquals(15, combinationsCount);
    }

    @Test
    void getSetCombinationForFiveInput() {
        int combinationsCount = bellNumbersCountDPApproach.getSetCombinations(5);
        assertEquals(52, combinationsCount);
    }

    @Test
    void getSetCombinationForSixInput() {
        int combinationsCount = bellNumbersCountDPApproach.getSetCombinations(6);
        assertEquals(203, combinationsCount);
    }

    @Test
    void getSetCombinationForSevenInput() {
        int combinationsCount = bellNumbersCountDPApproach.getSetCombinations(7);
        assertEquals(877, combinationsCount);
    }

    @Test
    void getSetCombinationForEightInput() {
        int combinationsCount = bellNumbersCountDPApproach.getSetCombinations(8);
        assertEquals(4140, combinationsCount);
    }

    @Test
    void getSetCombinationForNineInput() {
        int combinationsCount = bellNumbersCountDPApproach.getSetCombinations(9);
        assertEquals(21147, combinationsCount);
    }

    @Test
    void getSetCombinationForTenInput() {
        int combinationsCount = bellNumbersCountDPApproach.getSetCombinations(10);
        assertEquals(115975, combinationsCount);
    }

    @Test
    void getSetCombinationForElevenInput() {
        int combinationsCount = bellNumbersCountDPApproach.getSetCombinations(11);
        assertEquals(678570, combinationsCount);
    }

    @Test
    void getSetCombinationForMoreThanMaxLimitInput() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                                                                         () -> bellNumbersCountDPApproach.getSetCombinations(
                                                                                 maxLimit + 1));
        assertEquals("Input is higher than limit", illegalArgumentException.getMessage());
    }
}