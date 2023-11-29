package com.prashant.anonymous.epam.count_characters;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CountCharacters {
    private String input;

    public CountCharacters(final String input) {
        if (Objects.isNull(input)) {
            throw new NoStringAvaialbleException(input);
        }
        this.input = input;
    }

    public Map<Character, Integer> getCharacterCount() {
        return input.chars().mapToObj(c -> (char) c).collect(Collectors.toMap(inp -> inp, inp -> 1, Integer::sum));
    }

}
