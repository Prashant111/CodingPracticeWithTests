package ds_algo.company_focused.google.topics.dynamic_programming;

public class FibonacciSeriesBottomUpApproach {
    private final int n;
    private final int[] cachedArray;

    public FibonacciSeriesBottomUpApproach(int n) {
        if (n < 0) {
            throw new RuntimeException("Input should not be negative");
        }
        this.n = n;
        this.cachedArray = new int[n + 1];
    }

    public int getNthNumber() {
        if (n == 0 || n == 1) {
            return 1;
        }
        cachedArray[0] = 1;
        cachedArray[1] = 1;
        return getFibonacciResult(n);
    }

    private int getFibonacciResult(int currentIndex) {
        if (currentIndex < 0) {
            return 0;
        }

        int previousValue = 0;
        int pi = currentIndex - 2;
        if (pi >= 0) {
            cachedArray[pi] = cachedArray[pi] > 0 ? cachedArray[pi] : getFibonacciResult(pi);
            previousValue = cachedArray[pi];
        }

        int li = currentIndex - 1;
        int lastValue = 0;
        if (li >= 0) {
            cachedArray[li] = cachedArray[li] > 0 ? cachedArray[li] : getFibonacciResult(li);
            lastValue = cachedArray[li];
        }

        return previousValue + lastValue;
    }
}
