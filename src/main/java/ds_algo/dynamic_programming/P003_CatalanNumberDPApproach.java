package ds_algo.dynamic_programming;

public class P003_CatalanNumberDPApproach {
    private final int n;
    public final int[] catalan;

    public P003_CatalanNumberDPApproach(int n) {
        if (n < 0)
            throw new RuntimeException("Input can not be negative number.");
        this.n = n;
        this.catalan = new int[n + 2];
    }

    public int nthCatalanNumber() {
        return calculateNthCatalanNumber(n);
    }

    private int calculateNthCatalanNumber(int ind) {
        if (ind <= 1)
            return 1;

        catalan[0] = 1;
        catalan[1] = 1;

        for (int i = 2; i <= ind; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        return catalan[ind];
    }
}
