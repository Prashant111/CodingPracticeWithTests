package ds_algo.dynamic_programming;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class P005_CatalanNumberUsingDPTest {

    private static P005_CatalanNumberUsingDP catalanNumber;
    private static int maxLimit;

    @BeforeAll
    static void beforeAll() {
        maxLimit = 19;
        catalanNumber = new P005_CatalanNumberUsingDP(maxLimit);
    }

    @Test
    void nthCatalanNumberNegativeNumberInputTest() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                                                         () -> new P005_CatalanNumberUsingDP(-10));
        assertEquals("Negative input is not allowed", runtimeException.getMessage());
    }

    @Test
    void nthCatalanNumberZeroInputTestFor0() {
        assertEquals(1, catalanNumber.getCatalanNumber(0));
    }

    @Test
    void nthCatalanNumberOneInputTestFor1() {
        assertEquals(1, catalanNumber.getCatalanNumber(1));
    }

    @Test
    void nthCatalanNumberForInput2Test() {
        assertEquals(2, catalanNumber.getCatalanNumber(2));

    }

    @Test
    void nthCatalanNumberForInput3Test() {
        assertEquals(5, catalanNumber.getCatalanNumber(3));

    }

    @Test
    void nthCatalanNumberForInput4Test() {
        assertEquals(14, catalanNumber.getCatalanNumber(4));

    }

    @Test
    void nthCatalanNumberForInput5Test() {
        assertEquals(42, catalanNumber.getCatalanNumber(5));

    }

    @Test
    void nthCatalanNumberForInput6Test() {
        assertEquals(132, catalanNumber.getCatalanNumber(6));

    }

    @Test
    void nthCatalanNumberForInput7Test() {
        assertEquals(429, catalanNumber.getCatalanNumber(7));

    }

    @Test
    void nthCatalanNumberForInput8Test() {
        assertEquals(1430, catalanNumber.getCatalanNumber(8));

    }

    @Test
    void nthCatalanNumberForInput9Test() {
        assertEquals(4862, catalanNumber.getCatalanNumber(9));
    }

    @Test
    void nthCatalanNumberForInputMaxLimitTest() {
        assertEquals(1767263190, catalanNumber.getCatalanNumber(maxLimit));
    }

    @Test
    void nthCatalanNumberForInputBeyondLimitTest() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                                                                         () -> catalanNumber.getCatalanNumber(maxLimit + 1));
        assertEquals("Requested number beyond limit", illegalArgumentException.getMessage());
    }
}