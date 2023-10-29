package org.example.test.atlassian;

import java.util.Objects;
import java.util.PriorityQueue;

public class FinanceManagement {
    public int solution(int[] A) {
        int lastPositiveNumberIndex = getLastPositiveNumberIndex(A);
        return getMinRelocations(A, lastPositiveNumberIndex);
    }

    private static int getLastPositiveNumberIndex(int[] arr) {
        int lastPositiveNumberIndex = arr.length;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > 0) break;
            lastPositiveNumberIndex = i;
        }
        return lastPositiveNumberIndex;
    }

    int getMinRelocations(int[] arr, int lastPositiveNumberIndex) {
        if (Objects.isNull(arr) || arr.length <= 1) {
            return 0;
        }
        int lastIndex = Math.min(lastPositiveNumberIndex, arr.length);
        PriorityQueue<Integer> negativeNumsPQ = new PriorityQueue<>();
        int relocations = 0;
        int sum = 0;
        for (int i = 0; i < lastIndex; i++) {
            int localSum = sum + arr[i];
            if (arr[i] < 0) {
                negativeNumsPQ.offer(arr[i]);
            }
            if (localSum < 0) {
                relocations++;
                int mostNegativeValue = negativeNumsPQ.poll();
                sum = localSum - mostNegativeValue;
            } else {
                sum = localSum;
            }
        }
        return relocations;
    }
}