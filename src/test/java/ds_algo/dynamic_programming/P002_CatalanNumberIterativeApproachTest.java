package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class P002_CatalanNumberIterativeApproachTest {

    private P002_CatalanNumberIterativeApproach catalanNumber;

    @Test
    void nthCatalanNumberNegativeNumberInputTest() {
        assertThrows(RuntimeException.class,
                     () -> new P002_CatalanNumberIterativeApproach(-10));
    }

    @Test
    void nthCatalanNumberZeroInputTest() {
        catalanNumber = new P002_CatalanNumberIterativeApproach(0);
        assertEquals(1, catalanNumber.nthCatalanNumber());
    }

    @Test
    void nthCatalanNumberOneInputTest() {
        catalanNumber = new P002_CatalanNumberIterativeApproach(1);
        assertEquals(1, catalanNumber.nthCatalanNumber());
    }

    @Test
    void nthCatalanNumberOtherInputTest() {
        catalanNumber = new P002_CatalanNumberIterativeApproach(2);
        assertEquals(2, catalanNumber.nthCatalanNumber());

        catalanNumber = new P002_CatalanNumberIterativeApproach(3);
        assertEquals(5, catalanNumber.nthCatalanNumber());

        catalanNumber = new P002_CatalanNumberIterativeApproach(4);
        assertEquals(14, catalanNumber.nthCatalanNumber());

        catalanNumber = new P002_CatalanNumberIterativeApproach(5);
        assertEquals(42, catalanNumber.nthCatalanNumber());

        catalanNumber = new P002_CatalanNumberIterativeApproach(6);
        assertEquals(132, catalanNumber.nthCatalanNumber());

        catalanNumber = new P002_CatalanNumberIterativeApproach(7);
        assertEquals(429, catalanNumber.nthCatalanNumber());

        catalanNumber = new P002_CatalanNumberIterativeApproach(8);
        assertEquals(1430, catalanNumber.nthCatalanNumber());

        catalanNumber = new P002_CatalanNumberIterativeApproach(9);
        assertEquals(4862, catalanNumber.nthCatalanNumber());
    }
}