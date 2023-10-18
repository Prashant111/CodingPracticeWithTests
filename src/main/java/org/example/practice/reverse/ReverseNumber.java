package org.example.practice.reverse;

import static java.lang.Math.abs;

public class ReverseNumber {
    public int reverse(int n) {
        long reversed = 0;

        boolean isNeg = n < 0;
        int absN = abs(n);

        while (absN > 0) {
            int lsd = absN % 10;
            reversed = reversed * 10 + lsd;
            if (reversed > Integer.MAX_VALUE)
                return 0;
            absN /= 10;
        }
        return (int) (isNeg ? -reversed : reversed);
    }
}
