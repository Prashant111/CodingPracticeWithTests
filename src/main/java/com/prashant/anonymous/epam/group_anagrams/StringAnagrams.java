package com.prashant.anonymous.epam.group_anagrams;

import com.prashant.anonymous.common.exception.NullInputException;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class StringAnagrams {
    private List<String> inputList;

    public StringAnagrams(final List<String> inputList) {
        if (inputList == null) {
            throw new NullInputException();
        }
        this.inputList = inputList;
    }

    public List<List<String>> getGroupedAnagrams() {
        Map<String, List<String>> charsMap = new HashMap<>();
        for (String string : inputList) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String sortedCharsString = new String(chars);

            charsMap.computeIfAbsent(sortedCharsString, k-> new ArrayList<>());
            charsMap.get(sortedCharsString).add(string);
        }
        return new ArrayList<>(charsMap.values());
    }

}
