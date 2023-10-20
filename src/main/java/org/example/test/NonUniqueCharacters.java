package org.example.test;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Collections.frequency;
import static org.example.utilities.StringUtils.EMPTY_STRING;

public class NonUniqueCharacters {

    public String getUniqueCharacters(String input) {
        if (Objects.isNull(input))
            return EMPTY_STRING;

        Collection<Character> characterList = getCharacterList(input);
        return input.chars()
                    .mapToObj(c -> (char) c)
                    .filter(c -> frequency(characterList, c) > 1)
                    .distinct()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
    }

    private Collection<Character> getCharacterList(String input) {
        return input.chars().mapToObj(c -> (char) c).toList();
    }
}
