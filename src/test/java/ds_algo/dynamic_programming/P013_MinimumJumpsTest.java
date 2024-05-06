package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class P013_MinimumJumpsTest {
    private P013_MinimumJumps minimumJumps;

    @Test
    void testInvalidInputArrayThrowsException() {
        String jumpArrayExceptionMessage = "Jump array is invalid";
        RuntimeException runtimeExceptionForNullArray = assertThrows(
                RuntimeException.class,
                () -> new P013_MinimumJumps(null));
        assertEquals(jumpArrayExceptionMessage, runtimeExceptionForNullArray.getMessage());

        RuntimeException runtimeExceptionForEmptyArray = assertThrows(
                RuntimeException.class,
                () -> new P013_MinimumJumps(new int[]{}));
        assertEquals(jumpArrayExceptionMessage, runtimeExceptionForEmptyArray.getMessage());
    }

    @Test
    void testMinimumJumpsPositiveScenario() {
        minimumJumps = new P013_MinimumJumps(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9});
        int minJumps = minimumJumps.calculateMinimumJumps();
        assertEquals(3, minJumps);
    }
}