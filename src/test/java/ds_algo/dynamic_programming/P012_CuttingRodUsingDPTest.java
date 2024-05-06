package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class P012_CuttingRodUsingDPTest {
    private P012_CuttingRodUsingDP cuttingRodUsingDP;

    @Test
    void testInvalidPerUnitRodThrowsException() {
        String invalidPerUnitLengthArrayExceptionMessage = "Per unit rod price is invalid";
        RuntimeException runtimeExceptionForNullArray = assertThrows(
                RuntimeException.class,
                () -> new P012_CuttingRodUsingDP(null, 1));
        assertEquals(invalidPerUnitLengthArrayExceptionMessage, runtimeExceptionForNullArray.getMessage());

        RuntimeException runtimeExceptionForEmptyArray = assertThrows(
                RuntimeException.class,
                () -> new P012_CuttingRodUsingDP(new int[]{}, 1));
        assertEquals(invalidPerUnitLengthArrayExceptionMessage, runtimeExceptionForEmptyArray.getMessage());
    }

    @Test
    void testInvalidForNegativeRodLengthThrowsException() {
        String invalidRodLengthExceptionMessage = "Rod length is invalid";
        RuntimeException runtimeExceptionForNullArray = assertThrows(
                RuntimeException.class,
                () -> new P012_CuttingRodUsingDP(new int[]{1, 2}, -1));
        assertEquals(invalidRodLengthExceptionMessage, runtimeExceptionForNullArray.getMessage());
    }

    @Test
    void testPositiveScenario() {
        cuttingRodUsingDP = new P012_CuttingRodUsingDP(new int[]{1, 5, 8, 9, 10, 17, 17, 20}, 8);
        int maxPriceValue = cuttingRodUsingDP.maxPriceValue();
        assertEquals(22, maxPriceValue);
    }
}