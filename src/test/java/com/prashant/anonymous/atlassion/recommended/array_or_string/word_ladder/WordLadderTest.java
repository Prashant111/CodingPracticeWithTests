package com.prashant.anonymous.atlassion.recommended.array_or_string.word_ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordLadderTest {


    @Test
    void countNumberOfStepsToReachEndWord() {
        String startWord = "hit";
        String endWord = "cog";
        Set<String> dictionary = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        int actual = new WordLadder(startWord, endWord, dictionary).countNumberOfStepsToReachEndWord();
        assertEquals(5, actual);
    }
}