package ds_algo.dynamic_programming;

public class P009_CoinChangeUsingRecursion {
    private final int[] coins;
    private final int target;

    public P009_CoinChangeUsingRecursion(int[] coins, int target) {
        if (coins == null || coins.length == 0)
            throw new RuntimeException("Invalid coins value");

        if (target < 0)
            throw new RuntimeException("Invalid target value");

        this.coins = coins;
        this.target = target;
    }

    public int getCoinsCombination() {
        return getCoinsCombinationHelper(coins, coins.length, target);
    }

    private int getCoinsCombinationHelper(int[] coins, int n, int sum) {
        if (sum == 0)
            return 1;

        if (sum < 0)
            return 0;

        if (n <= 0)
            return 0;

        return getCoinsCombinationHelper(coins, n - 1, sum)
                + getCoinsCombinationHelper(coins, n, sum - coins[n - 1]);
    }
}