package ds_algo.dynamic_programming;

public class P004_BinomialCoefficient {
    private final int n;
    private final int[][] pascalTree;

    public P004_BinomialCoefficient(int n) {
        if (n < 0) {
            throw new RuntimeException("Input can not be negative");
        }
        this.n = n;
        pascalTree = new int[n + 1][n + 1];
    }

    public int[][] binomialTree() {
        pascalTree[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            pascalTree[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                pascalTree[i][j] = pascalTree[i - 1][j - 1] + pascalTree[i - 1][j];
            }
        }
        return pascalTree;
    }
}
