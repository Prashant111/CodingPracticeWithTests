package ds_algo.company_focused.google.topics.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FibonacciSeriesBottomUpApproachTest {

    private FibonacciSeriesBottomUpApproach fibonacciSeriesBottomUpApproach;

    @Test
    void getNthNumberForNull() {
        fibonacciSeriesBottomUpApproach = null;
        assertThrows(NullPointerException.class, () -> fibonacciSeriesBottomUpApproach.getNthNumber());
    }

    @Test
    void getNthNumberForNegativeArray() {
        String inputShouldNotBeNegative = "Input should not be negative";
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> new FibonacciSeriesBottomUpApproach(-10)
        );
        assertEquals(inputShouldNotBeNegative, runtimeException.getMessage());
    }

    @Test
    void getNthNumberForZeroSizedArray() {
        fibonacciSeriesBottomUpApproach = new FibonacciSeriesBottomUpApproach(0);
        assertEquals(1, fibonacciSeriesBottomUpApproach.getNthNumber());
    }

    @Test
    void getNthNumberForOneSizedArray() {
        fibonacciSeriesBottomUpApproach = new FibonacciSeriesBottomUpApproach(1);
        assertEquals(1, fibonacciSeriesBottomUpApproach.getNthNumber());
    }

    @Test
    void getNthNumberForOtherSizes() {
        fibonacciSeriesBottomUpApproach = new FibonacciSeriesBottomUpApproach(2);
        assertEquals(2, fibonacciSeriesBottomUpApproach.getNthNumber());

        fibonacciSeriesBottomUpApproach = new FibonacciSeriesBottomUpApproach(3);
        assertEquals(3, fibonacciSeriesBottomUpApproach.getNthNumber());

        fibonacciSeriesBottomUpApproach = new FibonacciSeriesBottomUpApproach(4);
        assertEquals(5, fibonacciSeriesBottomUpApproach.getNthNumber());

        fibonacciSeriesBottomUpApproach = new FibonacciSeriesBottomUpApproach(5);
        assertEquals(8, fibonacciSeriesBottomUpApproach.getNthNumber());

        fibonacciSeriesBottomUpApproach = new FibonacciSeriesBottomUpApproach(6);
        assertEquals(13, fibonacciSeriesBottomUpApproach.getNthNumber());

        fibonacciSeriesBottomUpApproach = new FibonacciSeriesBottomUpApproach(7);
        assertEquals(21, fibonacciSeriesBottomUpApproach.getNthNumber());

        fibonacciSeriesBottomUpApproach = new FibonacciSeriesBottomUpApproach(8);
        assertEquals(34, fibonacciSeriesBottomUpApproach.getNthNumber());

    }
}