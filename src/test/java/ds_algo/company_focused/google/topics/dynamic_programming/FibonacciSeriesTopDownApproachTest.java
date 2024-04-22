package ds_algo.company_focused.google.topics.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class FibonacciSeriesTopDownApproachTest {
    private FibonacciSeriesTopDownApproach fibonacciSeriesTopDownApproach;

    @Test
    void getNthNumberForNull() {
        fibonacciSeriesTopDownApproach = null;
        assertThrows(NullPointerException.class, () -> fibonacciSeriesTopDownApproach.getNthNumber());
    }

    @Test
    void getNthNumberForNegativeArray() {
        String inputShouldNotBeNegative = "Input should not be negative";
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> new FibonacciSeriesTopDownApproach(-10)
        );
        assertEquals(inputShouldNotBeNegative, runtimeException.getMessage());
    }

    @Test
    void getNthNumberForZeroSizedArray() {
        fibonacciSeriesTopDownApproach = new FibonacciSeriesTopDownApproach(0);
        assertEquals(1, fibonacciSeriesTopDownApproach.getNthNumber());
    }

    @Test
    void getNthNumberForOneSizedArray() {
        fibonacciSeriesTopDownApproach = new FibonacciSeriesTopDownApproach(1);
        assertEquals(1, fibonacciSeriesTopDownApproach.getNthNumber());
    }

    @Test
    void getNthNumberForOtherSizes() {
        fibonacciSeriesTopDownApproach = new FibonacciSeriesTopDownApproach(2);
        assertEquals(2, fibonacciSeriesTopDownApproach.getNthNumber());

        fibonacciSeriesTopDownApproach = new FibonacciSeriesTopDownApproach(3);
        assertEquals(3, fibonacciSeriesTopDownApproach.getNthNumber());

        fibonacciSeriesTopDownApproach = new FibonacciSeriesTopDownApproach(4);
        assertEquals(5, fibonacciSeriesTopDownApproach.getNthNumber());

        fibonacciSeriesTopDownApproach = new FibonacciSeriesTopDownApproach(5);
        assertEquals(8, fibonacciSeriesTopDownApproach.getNthNumber());

        fibonacciSeriesTopDownApproach = new FibonacciSeriesTopDownApproach(6);
        assertEquals(13, fibonacciSeriesTopDownApproach.getNthNumber());

        fibonacciSeriesTopDownApproach = new FibonacciSeriesTopDownApproach(7);
        assertEquals(21, fibonacciSeriesTopDownApproach.getNthNumber());

        fibonacciSeriesTopDownApproach = new FibonacciSeriesTopDownApproach(8);
        assertEquals(34, fibonacciSeriesTopDownApproach.getNthNumber());

    }
}