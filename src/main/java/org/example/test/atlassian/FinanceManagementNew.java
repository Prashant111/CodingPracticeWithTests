package org.example.test.atlassian;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.example.utilities.ValidationUtils.requireValidValue;

public class FinanceManagementNew {
    public int solution(int[] A) {
        if (baseConditionMatched(A))
            return 0;

        PriorityQueue<Integer> negatives = new PriorityQueue<>();
        int moves = 0;
        long netSum = 0;

        for (int currentNum : A) {
            if (currentNum < 0)
                negatives.offer(currentNum);

            netSum += currentNum;
            if (netSum < 0L) {
                moves++;
                int maxNegativeAbsoluteValue = !negatives.isEmpty() ? -negatives.poll() : 0;
                netSum += maxNegativeAbsoluteValue;
            }
        }
        return moves;
    }

    private boolean baseConditionMatched(int[] arr) {
        requireNonNull(arr, "Array can not be null");

        int sum = IntStream.of(arr).sum();
        requireValidValue(sum, sum >= 0, format("Sum %d must be greater than 0", sum));

        return arr.length <= 1;
    }
}