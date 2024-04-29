package ds_algo.dynamic_programming;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P008_BinomialCoefficientUsingDPTest {
    private static P008_BinomialCoefficientUsingDP binomialCoefficientUsingRecursion;

    @BeforeAll
    static void setUp() {
        binomialCoefficientUsingRecursion = new P008_BinomialCoefficientUsingDP();
    }

    @Test
    void binomialCoefficientUsingRecursionForNegativeCoefficientNInput() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                                                                         () -> binomialCoefficientUsingRecursion.binomialCoefficientNumber(
                                                                                 -10,
                                                                                 2)
        );
        assertEquals("Illegal coefficient n", illegalArgumentException.getMessage());
    }

    @Test
    void binomialCoefficientUsingRecursionForNegativeCoefficientRInput() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                                                                         () -> binomialCoefficientUsingRecursion.binomialCoefficientNumber(
                                                                                 10,
                                                                                 -2)
        );
        assertEquals("Illegal coefficient r", illegalArgumentException.getMessage());
    }

    @Test
    void binomialCoefficientUsingRecursionForNegativeCoefficientNAndRInput() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                                                                         () -> binomialCoefficientUsingRecursion.binomialCoefficientNumber(
                                                                                 -10,
                                                                                 -2)
        );
        assertEquals("Illegal coefficient n", illegalArgumentException.getMessage());
    }

    @Test
    void binomialCoefficientUsingRecursionForPositiveCoefficientNAndRInput() {
        assertEquals(10, binomialCoefficientUsingRecursion.binomialCoefficientNumber(5, 2));
    }

    @Test
    void binomialCoefficientUsingRecursionForSameCoefficientNAndRInput() {
        boolean isOne = true;
        for (int i = 1; i <= 30; i++)
            isOne = isOne && (binomialCoefficientUsingRecursion.binomialCoefficientNumber(5, 5) == 1);
        assertTrue(isOne);
    }
}