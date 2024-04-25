package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class P003_CatalanNumberDPApproachTest {

    private P003_CatalanNumberDPApproach catalanNumber;

    @Test
    void nthCatalanNumberNegativeNumberInputTest() {
        assertThrows(RuntimeException.class,
                     () -> new P003_CatalanNumberDPApproach(-10));
    }

    @Test
    void nthCatalanNumberZeroInputTest() {
        catalanNumber = new P003_CatalanNumberDPApproach(0);
        assertEquals(1, catalanNumber.nthCatalanNumber());
    }

    @Test
    void nthCatalanNumberOneInputTest() {
        catalanNumber = new P003_CatalanNumberDPApproach(1);
        assertEquals(1, catalanNumber.nthCatalanNumber());
    }

    @Test
    void nthCatalanNumberOtherInputTest() {
        catalanNumber = new P003_CatalanNumberDPApproach(2);
        assertEquals(2, catalanNumber.nthCatalanNumber());

        catalanNumber = new P003_CatalanNumberDPApproach(3);
        assertEquals(5, catalanNumber.nthCatalanNumber());

        catalanNumber = new P003_CatalanNumberDPApproach(4);
        assertEquals(14, catalanNumber.nthCatalanNumber());

        catalanNumber = new P003_CatalanNumberDPApproach(5);
        assertEquals(42, catalanNumber.nthCatalanNumber());

        catalanNumber = new P003_CatalanNumberDPApproach(6);
        assertEquals(132, catalanNumber.nthCatalanNumber());

        catalanNumber = new P003_CatalanNumberDPApproach(7);
        assertEquals(429, catalanNumber.nthCatalanNumber());

        catalanNumber = new P003_CatalanNumberDPApproach(8);
        assertEquals(1430, catalanNumber.nthCatalanNumber());

        catalanNumber = new P003_CatalanNumberDPApproach(9);
        assertEquals(4862, catalanNumber.nthCatalanNumber());
    }
}