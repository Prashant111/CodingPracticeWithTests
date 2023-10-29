package org.example.test.atlassian;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FinanceManagementTest {
    private FinanceManagement financeManagement;

    @BeforeEach
    void setUp() {
        financeManagement = new FinanceManagement();
    }

    @Test
    void testSumNegativeShouldThrowException() {
        assertEquals(0, financeManagement.solution(new int[]{-10}));
        assertEquals(0, financeManagement.solution(new int[]{10, -1, -10}));
        assertEquals(0, financeManagement.solution(new int[]{10, 40, -100}));
    }

    @Test
    void testNullInputShouldThrowException() {
        assertThrows(NullPointerException.class, () -> financeManagement.solution(null));
    }

    @Test
    void testSolutionSingleDigit() {
        assertEquals(0, financeManagement.solution(new int[]{0}));
        assertEquals(0, financeManagement.solution(new int[]{1}));
        assertEquals(0, financeManagement.solution(new int[]{2}));
    }

    @Test
    void testSolutionTwoDigit() {
        assertEquals(0, financeManagement.solution(new int[]{0, 0}));
        assertEquals(0, financeManagement.solution(new int[]{0, 1}));
        assertEquals(0, financeManagement.solution(new int[]{1, 0}));
        assertEquals(0, financeManagement.solution(new int[]{1, -1}));
        assertEquals(1, financeManagement.solution(new int[]{-1, 1}));
        assertEquals(1, financeManagement.solution(new int[]{-1, 2}));
        assertEquals(0, financeManagement.solution(new int[]{1, 1}));
        assertEquals(0, financeManagement.solution(new int[]{2, 1}));
        assertEquals(0, financeManagement.solution(new int[]{1, 2}));
    }

    @Test
    void testSolutionThreeDigit() {
        assertEquals(0, financeManagement.solution(new int[]{0, 0, 0}));
        assertEquals(0, financeManagement.solution(new int[]{0, 0, 1}));
        assertEquals(0, financeManagement.solution(new int[]{0, 1, 0}));
        assertEquals(0, financeManagement.solution(new int[]{1, 0, 0}));
        assertEquals(0, financeManagement.solution(new int[]{1, 1, 0}));
        assertEquals(0, financeManagement.solution(new int[]{1, 1, 1}));
        assertEquals(2, financeManagement.solution(new int[]{-1, -2, 10}));
        assertEquals(2, financeManagement.solution(new int[]{-2, -1, 10}));
        assertEquals(1, financeManagement.solution(new int[]{-2, 0, 2}));
        assertEquals(1, financeManagement.solution(new int[]{-2, 0, 3}));
        assertEquals(0, financeManagement.solution(new int[]{0, 0, 1}));
        assertEquals(1, financeManagement.solution(new int[]{0, -1, 1}));
        assertEquals(1, financeManagement.solution(new int[]{0, -1, 3}));
        assertEquals(0, financeManagement.solution(new int[]{0, 1, 3}));
        assertEquals(0, financeManagement.solution(new int[]{0, 4, 3}));
        assertEquals(0, financeManagement.solution(new int[]{0, 4, 3}));
        assertEquals(0, financeManagement.solution(new int[]{4, -2, 2}));
        assertEquals(0, financeManagement.solution(new int[]{4, -2, 3}));
        assertEquals(1, financeManagement.solution(new int[]{4, -5, 1}));
        assertEquals(1, financeManagement.solution(new int[]{4, -5, 2}));
    }

    @Test
    void testSolutionFourDigit() {
        assertEquals(0, financeManagement.solution(new int[]{4, -2, -1, 1}));
        assertEquals(1, financeManagement.solution(new int[]{4, -2, -3, 5}));
        assertEquals(1, financeManagement.solution(new int[]{40, -40, -3, -3, 6}));
        assertEquals(0, financeManagement.solution(new int[]{40, -3, -3, 5, -39}));
        assertEquals(0, financeManagement.solution(new int[]{40, -3, -3, 5, 1, -40}));
        assertEquals(1, financeManagement.solution(new int[]{4, -3, -2, 5}));
        assertEquals(0, financeManagement.solution(new int[]{4, -3, -1, 5}));
        assertEquals(2, financeManagement.solution(new int[]{4, -6, -6, 9}));
        assertEquals(3, financeManagement.solution(new int[]{-5, -5, -5, 15}));
    }

    @Test
    void testSolution() {
        assertEquals(1, financeManagement.solution(new int[]{10, -10, -1, -1, 10}));
        assertEquals(3, financeManagement.solution(new int[]{-1, -1, -1, 1, 1, 1, 1}));
        assertEquals(0, financeManagement.solution(new int[]{5, -2, -3, 1}));
        assertEquals(1, financeManagement.solution(new int[]{5, -2, -4, 1}));
        assertEquals(1, financeManagement.solution(new int[]{5, -4, -2, 1}));
        assertEquals(1, financeManagement.solution(new int[]{5, -7, -2, 10}));
        assertEquals(2, financeManagement.solution(new int[]{5, -7, -7, 10}));
        assertEquals(2, financeManagement.solution(new int[]{-20, 50, 21, -100, 45, 33, -20}));
        assertEquals(1, financeManagement.solution(new int[]{-100, 50, 2, -20, 45, 33, -10}));
        assertEquals(0, financeManagement.solution(new int[]{10}));
        assertEquals(0, financeManagement.solution(new int[]{}));
        assertEquals(0, financeManagement.solution(new int[]{10, -5, 1}));
        assertEquals(1, financeManagement.solution(new int[]{10, -11, 1}));
        assertEquals(0, financeManagement.solution(new int[]{10, -10, 10, -10, 10, -10}));
        assertEquals(1, financeManagement.solution(new int[]{-10, 10, -10, 10, -10, 10}));
        assertEquals(0, financeManagement.solution(new int[]{10}));
        assertEquals(3, financeManagement.solution(
                new int[]{1, 23, 3, 4, 5, 65, 6, 67, 7, 7, -8399494, 3283, 4, 23, 4, -98858334, 3433, 365, -48849, 107299377}));
        assertEquals(2, financeManagement.solution(
                new int[]{1, 23, 3, 4, 5, 65, 6, 67, 7, 7, -8399494, 3283, 4, 23, 4, -98858334, 3433, 365, 107299377, -48849}));
        assertEquals(2, financeManagement.solution(new int[]{-100, 10, -12, 3, 45, 3, -34, 85}));
        assertEquals(1, financeManagement.solution(new int[]{-100, 10, -8, 3, 45, 3, -34, 81}));
        assertEquals(2, financeManagement.solution(new int[]{-12, 10, -100, 3, 45, 3, -34, 85}));
        assertEquals(2, financeManagement.solution(new int[]{-1, 10, -100, 3, 45, 3, -34, 74}));
    }

    @Test
    void testHugeNumber() {
        int[] hugeNumberArray = getInputOfSizeIncreasingPattern(1, 1_000_000_01,
                                                                getSameNumberWithChangedSign()
                                                               );
        assertEquals(0, financeManagement.solution(hugeNumberArray));
    }

    @NotNull
    private static IntUnaryOperator getSameNumberWithChangedSign() {
        return i -> i > 0 ? -1 * Math.abs(i) : Math.abs(i) + 1;
    }

    private int[] getInputOfSizeIncreasingPattern(int initial, int maxSize, IntUnaryOperator operator) {
        return IntStream.iterate(initial, operator).limit(maxSize)
                        .toArray();
    }

    @Test
    void testProvidedInputs_SmallCornerCases() {
        assertEquals(1, financeManagement.solution(new int[]{0, 0, 0, -10, 0, 0, 0, 10, 20}));
    }

    @Test
    void testProvidedInputs_AlmostAllNegativesExceptSum() {
        assertEquals(6, financeManagement.solution(new int[]{-10, -3, -5, -30, -2, -8, 2000}));
        assertEquals(6, financeManagement.solution(new int[]{-10, -3, -5, -30, -2, -8, 2000, -5, -4, -6, -90}));
    }

    @Test
    void testProvidedInputs_NegativeInTheMiddle() {
        assertEquals(0, financeManagement.solution(new int[]{5, 2, 6, 2, 5, -8, 100, 45}));
        assertEquals(1, financeManagement.solution(new int[]{5, 2, 6, 2, 5, -80, 100, 45}));
    }

    @Test
    void testProvidedInputs_NegativeElementsFollowedByNonNegativeNumbers() {
        assertEquals(2, financeManagement.solution(new int[]{-5, 5, -8, 8, -9, 9}));
        assertEquals(1, financeManagement.solution(new int[]{-5, 5, -2, 2, -1, 1}));
    }

}