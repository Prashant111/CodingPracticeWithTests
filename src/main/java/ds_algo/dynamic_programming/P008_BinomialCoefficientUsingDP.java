package ds_algo.dynamic_programming;

public class P008_BinomialCoefficientUsingDP {
    private int[][] binomialNumber;

    public int binomialCoefficientNumber(int num, int rec) {
        if (num < 0) {
            throw new IllegalArgumentException("Illegal coefficient n");
        }
        if (rec < 0) {
            throw new IllegalArgumentException("Illegal coefficient r");
        }
        if (num < rec) {
            throw new IllegalArgumentException("n can not be more than r");
        }
        if (num == rec || rec == 0)
            return 1;

        binomialNumber = new int[num + 1][rec + 1];
        return calculateBinomialCoefficientNumber(num, rec);
    }

    private int calculateBinomialCoefficientNumber(int num, int rec) {
        if (num == rec || rec == 0)
            return 1;

        if (binomialNumber[num][rec] > 0) {
            return binomialNumber[num][rec];
        }

        int leftSubTree = 0;
        if (binomialNumber[num - 1][rec] > 0) {
            leftSubTree = binomialNumber[num - 1][rec];
        } else {
            leftSubTree = calculateBinomialCoefficientNumber(num - 1, rec);
        }

        int rightSubTree = 0;
        if (binomialNumber[num - 1][rec - 1] > 0) {
            leftSubTree = binomialNumber[num - 1][rec - 1];
        } else {
            rightSubTree = calculateBinomialCoefficientNumber(num - 1, rec - 1);
        }

        int sum = leftSubTree + rightSubTree;
        binomialNumber[num][rec] = sum;

        return sum;
    }
}
