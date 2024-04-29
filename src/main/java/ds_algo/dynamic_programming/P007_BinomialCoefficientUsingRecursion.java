package ds_algo.dynamic_programming;

public class P007_BinomialCoefficientUsingRecursion {

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

        return calculateBinomialCoefficientNumber(num - 1, rec)
                + calculateBinomialCoefficientNumber(num - 1, rec - 1);
    }

    private int calculateBinomialCoefficientNumber(int num, int rec) {
        if (num == rec || rec == 0)
            return 1;

        return binomialCoefficientNumber(num - 1, rec) + binomialCoefficientNumber(num - 1, rec - 1);
    }
}
