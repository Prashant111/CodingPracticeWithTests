package org.example.test.atlassian;

import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.requireNonNull;

public class CloseNumber {
    public boolean containsCloseNumbers(int[] input) {
        requireNonNull(input);

        Set<Integer> set = new HashSet<>();
        for (int num : input) {
            if (set.contains(num + 1) || set.contains(num - 1))
                return true;
            set.add(num);
        }
        return false;
    }

}
