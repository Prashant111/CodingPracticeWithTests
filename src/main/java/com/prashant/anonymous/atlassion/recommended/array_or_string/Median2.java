package com.prashant.anonymous.atlassion.recommended.array_or_string;

import org.jetbrains.annotations.NotNull;

import static com.prashant.anonymous.common.utility.ArrayUtils.isEmpty;
import static com.prashant.anonymous.common.utility.NumberUtils.average;
import static com.prashant.anonymous.common.utility.NumberUtils.isOdd;
import static com.prashant.anonymous.common.utility.ValidationUtility.validateArray;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class Median2 {
    private final int[] sortedArray1;
    private final int[] sortedArray2;

    private final int arraySum;

    public Median2(int[] sortedArray1, int[] sortedArray2) {
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

        if (canAvoidProcessing()) {
            return getEarlyResult();
        }

        int low = 0;
        int high = n1;
        while (low <= high) {
            PartitionCorners partitionCorners = getResult(n1, n2, low, high);

            if (partitionCorners.l1() <= partitionCorners.r2() && partitionCorners.l2() <= partitionCorners.r1()) {
                return isOdd(arraySum) ? max(partitionCorners.l1(), partitionCorners.l2()) : average(max(partitionCorners.l1(), partitionCorners.l2()), min(partitionCorners.r1(), partitionCorners.r2()));
            } else if (partitionCorners.l1() > partitionCorners.r2()) {
                high--;
            } else if (partitionCorners.l2() > partitionCorners.r1())
                low++;
        }
        return -1;
    }

    @NotNull
    private PartitionCorners getResult(int n1, int n2, int low, int high) {
        int cut1 = (low + high) >> 1;
        int cut2 = ((n1 + n2 + 1) >> 1) - cut1;

        int l1 = cut1 == 0 ? Integer.MIN_VALUE : sortedArray1[cut1 - 1];
        int l2 = cut2 == 0 ? Integer.MIN_VALUE : sortedArray2[cut2 - 1];

        int r1 = cut1 == n1 ? Integer.MAX_VALUE : sortedArray1[cut1];
        int r2 = cut2 == n2 ? Integer.MAX_VALUE : sortedArray2[cut2];
        return new PartitionCorners(l1, l2, r1, r2);
    }

    private record PartitionCorners(int l1, int l2, int r1, int r2) {
    }

    private double getEarlyResult() {
        if (isEmpty(sortedArray1) && isEmpty(sortedArray2)) {
            return -1.0;
        } else if (isEmpty(sortedArray1)) {
            int middle = sortedArray2.length / 2;
            return isOdd(sortedArray2.length) ? sortedArray2[middle] : average(sortedArray2[middle - 1], sortedArray2[middle]);
        } else {
            int middle = sortedArray1.length / 2;
            return isOdd(sortedArray1.length) ? sortedArray1[middle] : average(sortedArray1[middle - 1], sortedArray1[middle]);
        }
    }

    private boolean canAvoidProcessing() {
        return isEmpty(sortedArray1) || isEmpty(sortedArray2);
    }

}
