package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class P000_FibonacciSeriesBottomUpApproachTest {

    private P000_FibonacciSeriesBottomUpApproach p000FibonacciSeriesBottomUpApproach;

    @Test
    void getNthNumberForNull() {
        p000FibonacciSeriesBottomUpApproach = null;
        assertThrows(NullPointerException.class, () -> p000FibonacciSeriesBottomUpApproach.getNthNumber());
    }

    @Test
    void getNthNumberForNegativeArray() {
        String inputShouldNotBeNegative = "Input should not be negative";
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> new P000_FibonacciSeriesBottomUpApproach(-10)
        );
        assertEquals(inputShouldNotBeNegative, runtimeException.getMessage());
    }

    @Test
    void getNthNumberForZeroSizedArray() {
        p000FibonacciSeriesBottomUpApproach = new P000_FibonacciSeriesBottomUpApproach(0);
        assertEquals(1, p000FibonacciSeriesBottomUpApproach.getNthNumber());
    }

    @Test
    void getNthNumberForOneSizedArray() {
        p000FibonacciSeriesBottomUpApproach = new P000_FibonacciSeriesBottomUpApproach(1);
        assertEquals(1, p000FibonacciSeriesBottomUpApproach.getNthNumber());
    }

    @Test
    void getNthNumberForOtherSizes() {
        p000FibonacciSeriesBottomUpApproach = new P000_FibonacciSeriesBottomUpApproach(2);
        assertEquals(2, p000FibonacciSeriesBottomUpApproach.getNthNumber());

        p000FibonacciSeriesBottomUpApproach = new P000_FibonacciSeriesBottomUpApproach(3);
        assertEquals(3, p000FibonacciSeriesBottomUpApproach.getNthNumber());

        p000FibonacciSeriesBottomUpApproach = new P000_FibonacciSeriesBottomUpApproach(4);
        assertEquals(5, p000FibonacciSeriesBottomUpApproach.getNthNumber());

        p000FibonacciSeriesBottomUpApproach = new P000_FibonacciSeriesBottomUpApproach(5);
        assertEquals(8, p000FibonacciSeriesBottomUpApproach.getNthNumber());

        p000FibonacciSeriesBottomUpApproach = new P000_FibonacciSeriesBottomUpApproach(6);
        assertEquals(13, p000FibonacciSeriesBottomUpApproach.getNthNumber());

        p000FibonacciSeriesBottomUpApproach = new P000_FibonacciSeriesBottomUpApproach(7);
        assertEquals(21, p000FibonacciSeriesBottomUpApproach.getNthNumber());

        p000FibonacciSeriesBottomUpApproach = new P000_FibonacciSeriesBottomUpApproach(8);
        assertEquals(34, p000FibonacciSeriesBottomUpApproach.getNthNumber());

    }
}