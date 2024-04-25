package ds_algo.dynamic_programming;

public class P003_CatalanNumberDPApproach {
    private final int n;
    public int[] catalin;

    public P003_CatalanNumberDPApproach(int n) {
        if (n < 0)
            throw new RuntimeException("Input can not be negative number.");
        this.n = n;
        this.catalin = new int[n + 2];
    }

    public int nthCatalanNumber() {
        return calculateNthCatalanNumber(n);
    }

    private int calculateNthCatalanNumber(int ind) {
        if (ind <= 1)
            return 1;

        catalin[0] = 1;
        catalin[1] = 1;

        for (int i = 2; i <= ind; i++) {
            catalin[i] = 0;
            for (int j = 0; j < i; j++) {
                catalin[i] += catalin[j] * catalin[i - j - 1];
            }
        }
        return catalin[ind];
    }
}
