package com.prashant.anonymous.atlassion.recommended.array_or_string.word_ladder;

import com.prashant.anonymous.common.utility.ValidationUtility;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static com.prashant.anonymous.common.utility.ValidationUtility.validateString;

public class WordLadder {
    private final String startWord;
    private final String endWord;
    private final Set<String> dictionary;

    public WordLadder(String startWord, String endWord, Set<String> dictionary) {
        validateInputs(startWord, endWord, dictionary);
        this.startWord = startWord;
        this.endWord = endWord;
        this.dictionary = dictionary;
    }

    private void validateInputs(String startWord, String endWord, Set<String> dictionary) {
        validateString(startWord);
        validateString(endWord);
        dictionary.stream().forEach(ValidationUtility::validateString);
    }

    public int countNumberOfStepsToReachEndWord() {
        Set<String> localDictionary = new HashSet<>(dictionary);
        localDictionary.add(endWord);

        LinkedList<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(startWord, 1));

        while (!queue.isEmpty()) {
            WordNode top = queue.remove();

            if (top.word.equals(endWord)) return top.noOfSteps;

            char[] topCharArray = top.word.toCharArray();
            for (int i = 0; i < topCharArray.length; i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    char temp = topCharArray[i];
                    topCharArray[i] = j;
                    String newWord = String.valueOf(topCharArray);
                    if (localDictionary.contains(newWord)) {
                        queue.add(new WordNode(newWord, top.noOfSteps + 1));
                        localDictionary.remove(newWord);
                    }
                    topCharArray[i] = temp;
                }
            }
        }

        return -1;
    }
}

