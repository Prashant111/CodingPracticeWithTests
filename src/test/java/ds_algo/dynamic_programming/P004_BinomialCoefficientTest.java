package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class P004_BinomialCoefficientTest {

    private P004_BinomialCoefficient binomialCoefficient;

    @Test
    void binomialTreeNegativeInputExpectException() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                                                         () -> new P004_BinomialCoefficient(-10)
        );
        assertEquals("Input can not be negative", runtimeException.getMessage());
    }

    @Test
    void setBinomialCoefficientZeroSizeInputTest() {
        binomialCoefficient = new P004_BinomialCoefficient(0);
        assertEquals(1, binomialCoefficient.binomialTree().length);
        assertEquals(1, binomialCoefficient.binomialTree()[0].length);
        assertEquals(1, binomialCoefficient.binomialTree()[0][0]);
    }

    @Test
    void setBinomialCoefficientOneSizeInputTest() {
        binomialCoefficient = new P004_BinomialCoefficient(1);
        int[][] result = binomialCoefficient.binomialTree();
        assertEquals(2, result.length);
        assertEquals(2, result[0].length);
        assertEquals(1, result[0][0]);
        assertEquals(1, result[1][0]);
        assertEquals(1, result[1][1]);
    }

    @Test
    void setBinomialCoefficientTwoSizeInputTest() {
        binomialCoefficient = new P004_BinomialCoefficient(2);
        int[][] result = binomialCoefficient.binomialTree();
        assertEquals(3, result.length);
        assertEquals(3, result[0].length);
        assertEquals(1, result[2][0]);
        assertEquals(2, result[2][1]);
        assertEquals(1, result[2][2]);
    }

    @Test
    void setBinomialCoefficientThreeSizedInputTest() {
        binomialCoefficient = new P004_BinomialCoefficient(3);
        int[][] result = binomialCoefficient.binomialTree();
        assertEquals(4, result.length);
        assertEquals(4, result[0].length);
        assertEquals(1, result[3][0]);
        assertEquals(3, result[3][1]);
        assertEquals(3, result[3][2]);
        assertEquals(1, result[3][3]);
    }

    @Test
    void setBinomialCoefficientFiveSizedInputTest() {
        binomialCoefficient = new P004_BinomialCoefficient(5);
        int[][] result = binomialCoefficient.binomialTree();
        assertEquals(6, result.length);
        assertEquals(6, result[0].length);
        assertEquals(1, result[5][0]);
        assertEquals(5, result[5][1]);
        assertEquals(10, result[5][2]);
        assertEquals(10, result[5][3]);
        assertEquals(5, result[5][4]);
        assertEquals(1, result[5][5]);
    }

    @Test
    void setBinomialCoefficientFourSizedInputTest() {
        binomialCoefficient = new P004_BinomialCoefficient(4);
        int[][] result = binomialCoefficient.binomialTree();
        assertEquals(5, result.length);
        assertEquals(5, result[0].length);
        assertEquals(1, result[4][0]);
        assertEquals(4, result[4][1]);
        assertEquals(6, result[4][2]);
        assertEquals(4, result[4][3]);
        assertEquals(1, result[4][4]);
    }
}