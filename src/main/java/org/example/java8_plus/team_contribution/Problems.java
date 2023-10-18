package org.example.java8_plus.team_contribution;

import java.util.Collections;
import java.util.List;

public class Problems {
    // 1. Given a list of strings, return the list of strings are duplicated

    public List<String> getDuplicatedStrings(List<String> strings) {
        return strings.stream()
                      .filter(string -> Collections.frequency(strings, string) > 1)
                      .distinct()
                      .toList();

    }
}
