package ds_algo.company_focused.google.topics.dynamic_programming;

public class FibonacciSeriesTopDownApproach {
    private final int n;
    private final int[] cachedArray;

    public FibonacciSeriesTopDownApproach(int n) {
        if (n < 0) {
            throw new RuntimeException("Input should not be negative");
        }
        this.n = n;
        this.cachedArray = new int[n + 1];
    }

    public int getNthNumber() {
        if (n == 0 || n == 1)
            return 1;

        cachedArray[0] = 1;
        cachedArray[1] = 1;
        for (int i = 2; i <= n; i++) {
            int lv = cachedArray[i - 2];
            int pi = cachedArray[i - 1];
            cachedArray[i] = lv + pi;
        }
        return cachedArray[n];
    }
}
