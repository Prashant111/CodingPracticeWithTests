package ds_algo.dynamic_programming;

public class P011_CoinChangeUsingDPSpaceOptimized {
    private final int[] coins;
    private final int target;
    private final int[] dp;

    public P011_CoinChangeUsingDPSpaceOptimized(int[] coins, int target) {
        if (coins == null || coins.length == 0)
            throw new RuntimeException("Invalid coins value");

        if (target < 0)
            throw new RuntimeException("Invalid target value");

        this.coins = coins;
        this.target = target;
        this.dp = new int[target + 1];
    }

    public int getCoinsCombination() {
        return getCoinsCombinationHelper(coins, coins.length, target);
    }

    private int getCoinsCombinationHelper(int[] coins, int n, int sum) {
        dp[0] = 1;
        for (int i = 0; i < n; i++)
            for (int j = coins[i]; j <= sum; j++)
                dp[j] += dp[j - coins[i]];

        return dp[sum];
    }
}