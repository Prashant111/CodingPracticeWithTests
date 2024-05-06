package ds_algo.dynamic_programming;

import java.util.Arrays;

public class P013_MinimumJumps {
    private final int[] jumps;
    private final int dp[];


    public P013_MinimumJumps(int[] jumps) {
        if (jumps == null || jumps.length == 0)
            throw new RuntimeException("Jump array is invalid");

        this.jumps = jumps;
        this.dp = new int[jumps.length];
    }

    public int calculateMinimumJumps() {
        Arrays.fill(dp, -1);
        return calculateMinimumJumpsHelper(jumps, 0, jumps.length - 1, dp);
    }

    private int calculateMinimumJumpsHelper(int[] jumps, int idx, int end, int[] dp) {
        if (idx == end)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int minJumps = Integer.MAX_VALUE;
        for (int i = jumps[idx]; i >= 1; --i) {
            if (idx + i <= end)
                minJumps = Math.min(minJumps, 1 + calculateMinimumJumpsHelper(jumps, idx + i, end, dp));
        }

        return dp[idx] = minJumps;
    }
}
