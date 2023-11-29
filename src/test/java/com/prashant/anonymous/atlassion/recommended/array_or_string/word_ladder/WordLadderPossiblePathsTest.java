package com.prashant.anonymous.atlassion.recommended.array_or_string.word_ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordLadderPossiblePathsTest {

    @Test
    void getPossiblePathToReactEndWordTest() {
        String startWord = "hit";
        String endWord = "cog";
        Set<String> dictionary = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        List<List<String>> actual = new WordLadderPossiblePaths(startWord, endWord, dictionary).getPossiblePathToReactEndWord();
        assertEquals((Arrays.asList(Arrays.asList("hit", "hot", "dot", "lot", "log", "cog"), Arrays.asList("hit", "hot", "dot", "dog", "log", "cog"))), actual);
    }
}