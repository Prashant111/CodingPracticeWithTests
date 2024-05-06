package ds_algo.dynamic_programming;

public class P012_CuttingRodUsingDP {
    private final int[] perUnitRodPrices;
    private final int rodLength;
    private final int dp[];


    public P012_CuttingRodUsingDP(int[] perUnitRodPrices, int rodLength) {
        if (perUnitRodPrices == null || perUnitRodPrices.length == 0)
            throw new RuntimeException("Per unit rod price is invalid");

        if (rodLength < 0)
            throw new RuntimeException("Rod length is invalid");

        this.perUnitRodPrices = perUnitRodPrices;
        this.rodLength = rodLength;
        this.dp = new int[rodLength + 1];
    }

    public int maxPriceValue() {
        dp[0] = 0;

        for (int i = 1; i <= rodLength; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, perUnitRodPrices[j] + dp[i - j - 1]);
            }
            dp[i] = max;
        }
        return dp[rodLength];
    }
}
