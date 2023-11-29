package com.prashant.anonymous.atlassion.recommended.array_or_string;

import static com.prashant.anonymous.common.utility.NumberUtils.isOdd;
import static com.prashant.anonymous.common.utility.ValidationUtility.validateArray;
import static java.lang.Integer.max;
import static java.lang.Math.min;

public class Median {
    private final int[] sortedArray1;
    private final int[] sortedArray2;

    int arraySum;

    public Median(int[] sortedArray1, int[] sortedArray2) {
        validateInput(sortedArray1, sortedArray2);
        this.sortedArray1 = sortedArray1;
        this.sortedArray2 = sortedArray2;
        this.arraySum = sortedArray1.length + sortedArray2.length;
    }

    private void validateInput(int[] sortedArray1, int[] sortedArray2) {
        validateArray(sortedArray1);
        validateArray(sortedArray2);
    }

    public double calculateMedian() {
        int n1 = sortedArray1.length;
        int n2 = sortedArray2.length;

        if (n1 == 0 && n2 == 0) {
            return -1;
        } else if (n1 == 0) {
            return isOdd(n2) ? sortedArray2[n2 / 2] : (sortedArray2[n2 / 2 - 1] + sortedArray2[n2 / 2]) >> 1;
        } else if (n2 == 0) {
            return isOdd(n1) ? sortedArray1[n1 / 2] : (sortedArray1[n1 / 2 - 1] + sortedArray1[n1 / 2]) >> 1;
        }
        int low = 0;
        int high = n1;

        while (low <= high) {
            int cut1 = (low + high) >> 1;
            int cut2 = ((n1 + n2 + 1) >> 1) - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : sortedArray1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : sortedArray2[cut2 - 1];

            int r1 = cut1 == n1 ? Integer.MAX_VALUE : sortedArray1[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : sortedArray2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                if (isOdd(getArraySum())) {
                    return max(l1, l2);
                } else {
                    return (max(l1, l2) + min(r1, r2)) / 2.0;
                }
            } else if (l1 < r2) {
                low++;
            } else {
                high--;
            }
        }

        return 0;
    }

    private int getArraySum() {
        return sortedArray1.length + sortedArray2.length;
    }

}
