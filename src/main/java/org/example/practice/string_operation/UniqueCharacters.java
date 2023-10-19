package org.example.practice.string_operation;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.utilities.StringUtils.EMPTY_STRING;

public class UniqueCharacters {
    public List<Character> getUniqueCharacters(String string) {
        return string.chars().distinct().mapToObj(c -> (char) c).toList();
    }

    public String getUniqueCharactersString(String string) {
        return string.chars()
                     .distinct()
                     .mapToObj(c -> (char) c)
                     .map(String::valueOf)
                     .collect(Collectors.joining(EMPTY_STRING));
    }
}
