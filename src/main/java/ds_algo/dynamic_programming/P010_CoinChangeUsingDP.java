package ds_algo.dynamic_programming;

public class P010_CoinChangeUsingDP {
    private final int[] coins;
    private final int target;
    private final int[][] dp;

    public P010_CoinChangeUsingDP(int[] coins, int target) {
        if (coins == null || coins.length == 0)
            throw new RuntimeException("Invalid coins value");

        if (target < 0)
            throw new RuntimeException("Invalid target value");

        this.coins = coins;
        this.target = target;
        this.dp = new int[coins.length + 1][target + 1];
    }

    public int getCoinsCombination() {
        return getCoinsCombinationHelper(coins, coins.length, target);
    }

    private int getCoinsCombinationHelper(int[] coins, int n, int sum) {
        if (sum == 0)
            return dp[n][sum] = 1;

        if (sum < 0)
            return 0;

        if (n <= 0)
            return 0;

        if (dp[n][sum] > 0)
            return dp[n][sum];

        dp[n][sum] = getCoinsCombinationHelper(coins, n - 1, sum)
                + getCoinsCombinationHelper(coins, n, sum - coins[n - 1]);
        return dp[n][sum];
    }
}