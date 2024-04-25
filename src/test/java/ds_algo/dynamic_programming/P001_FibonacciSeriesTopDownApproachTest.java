package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class P001_FibonacciSeriesTopDownApproachTest {
    private P001_FibonacciSeriesTopDownApproach p001FibonacciSeriesTopDownApproach;

    @Test
    void getNthNumberForNull() {
        p001FibonacciSeriesTopDownApproach = null;
        assertThrows(NullPointerException.class, () -> p001FibonacciSeriesTopDownApproach.getNthNumber());
    }

    @Test
    void getNthNumberForNegativeArray() {
        String inputShouldNotBeNegative = "Input should not be negative";
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> new P001_FibonacciSeriesTopDownApproach(-10)
        );
        assertEquals(inputShouldNotBeNegative, runtimeException.getMessage());
    }

    @Test
    void getNthNumberForZeroSizedArray() {
        p001FibonacciSeriesTopDownApproach = new P001_FibonacciSeriesTopDownApproach(0);
        assertEquals(1, p001FibonacciSeriesTopDownApproach.getNthNumber());
    }

    @Test
    void getNthNumberForOneSizedArray() {
        p001FibonacciSeriesTopDownApproach = new P001_FibonacciSeriesTopDownApproach(1);
        assertEquals(1, p001FibonacciSeriesTopDownApproach.getNthNumber());
    }

    @Test
    void getNthNumberForOtherSizes() {
        p001FibonacciSeriesTopDownApproach = new P001_FibonacciSeriesTopDownApproach(2);
        assertEquals(2, p001FibonacciSeriesTopDownApproach.getNthNumber());

        p001FibonacciSeriesTopDownApproach = new P001_FibonacciSeriesTopDownApproach(3);
        assertEquals(3, p001FibonacciSeriesTopDownApproach.getNthNumber());

        p001FibonacciSeriesTopDownApproach = new P001_FibonacciSeriesTopDownApproach(4);
        assertEquals(5, p001FibonacciSeriesTopDownApproach.getNthNumber());

        p001FibonacciSeriesTopDownApproach = new P001_FibonacciSeriesTopDownApproach(5);
        assertEquals(8, p001FibonacciSeriesTopDownApproach.getNthNumber());

        p001FibonacciSeriesTopDownApproach = new P001_FibonacciSeriesTopDownApproach(6);
        assertEquals(13, p001FibonacciSeriesTopDownApproach.getNthNumber());

        p001FibonacciSeriesTopDownApproach = new P001_FibonacciSeriesTopDownApproach(7);
        assertEquals(21, p001FibonacciSeriesTopDownApproach.getNthNumber());

        p001FibonacciSeriesTopDownApproach = new P001_FibonacciSeriesTopDownApproach(8);
        assertEquals(34, p001FibonacciSeriesTopDownApproach.getNthNumber());

    }
}