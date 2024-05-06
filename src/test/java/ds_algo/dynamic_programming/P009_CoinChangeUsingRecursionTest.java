package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class P009_CoinChangeUsingRecursionTest {
    private P009_CoinChangeUsingRecursion coinChangeUsingRecursion;

    @Test
    void testCoinChangeOnInvalidCoinsRunTimeException() {
        String invalidCoinsValue = "Invalid coins value";

        RuntimeException nullInputArrayException = assertThrows(
                RuntimeException.class,
                () -> new P009_CoinChangeUsingRecursion(null, 5)

        );
        assertEquals(invalidCoinsValue, nullInputArrayException.getMessage());

        RuntimeException emptyInputArrayException = assertThrows(
                RuntimeException.class,
                () -> new P009_CoinChangeUsingRecursion(new int[]{},
                                                        5)
        );
        assertEquals(invalidCoinsValue, emptyInputArrayException.getMessage());
    }

    @Test
    void testCoinChangeTest() {
        coinChangeUsingRecursion = new P009_CoinChangeUsingRecursion(new int[]{1, 2, 3}, 5);
        int coinsCombination = coinChangeUsingRecursion.getCoinsCombination();
        assertEquals(5, coinsCombination);
    }

    @Test
    void testCoinChangeTest2() {
        coinChangeUsingRecursion = new P009_CoinChangeUsingRecursion(new int[]{1, 2, 3, 4, 5, 6}, 20);
        int coinsCombination = coinChangeUsingRecursion.getCoinsCombination();
        assertEquals(282, coinsCombination);
    }

}