package ds_algo.dynamic_programming;

public class P002_CatalanNumberIterativeApproach {
    private final int n;

    public P002_CatalanNumberIterativeApproach(int n) {
        if (n < 0)
            throw new RuntimeException("Input can not be negative number.");
        this.n = n;
    }

    public int nthCatalanNumber() {
        return calculateNthCatalanNumber(n);
    }

    private int calculateNthCatalanNumber(int ind) {
        if (ind <= 1) {
            return 1;
        }
        int result = 0;

        for (int i = 0; i < ind; i++) {
            result += calculateNthCatalanNumber(i) * calculateNthCatalanNumber(ind - i - 1);
        }

        return result;
    }
}
