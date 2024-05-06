package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class P011_CoinChangeUsingDPSpaceOptimizedTest {
    private P011_CoinChangeUsingDPSpaceOptimized coinChangeUsingDP;

    @Test
    void testCoinChangeOnInvalidCoinsRunTimeException() {
        String invalidCoinsValue = "Invalid coins value";

        RuntimeException nullInputArrayException = assertThrows(
                RuntimeException.class,
                () -> new P011_CoinChangeUsingDPSpaceOptimized(null, 5)

        );
        assertEquals(invalidCoinsValue, nullInputArrayException.getMessage());

        RuntimeException emptyInputArrayException = assertThrows(
                RuntimeException.class,
                () -> new P011_CoinChangeUsingDPSpaceOptimized(new int[]{},
                                                               5)
        );
        assertEquals(invalidCoinsValue, emptyInputArrayException.getMessage());
    }

    @Test
    void testCoinChangeTest() {
        coinChangeUsingDP = new P011_CoinChangeUsingDPSpaceOptimized(new int[]{1, 2, 3}, 5);
        int coinsCombination = coinChangeUsingDP.getCoinsCombination();
        assertEquals(5, coinsCombination);
    }

    @Test
    void testCoinChangeTest2() {
        coinChangeUsingDP = new P011_CoinChangeUsingDPSpaceOptimized(new int[]{1, 2, 3, 4, 5, 6}, 20);
        int coinsCombination = coinChangeUsingDP.getCoinsCombination();
        assertEquals(282, coinsCombination);
    }
}