package com.prashant.anonymous.atlassion.recommended.array_or_string.word_ladder;

import com.prashant.anonymous.common.utility.CollectionUtils;
import com.prashant.anonymous.common.utility.StringUtils;
import com.prashant.anonymous.common.utility.ValidationUtility;

import java.util.*;

import static com.prashant.anonymous.common.utility.ValidationUtility.validateString;

public class WordLadderPossiblePaths {
    private final String startWord;
    private final String endWord;
    private final Set<String> dictionary;

    public WordLadderPossiblePaths(String startWord, String endWord, Set<String> dictionary) {
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

    public List<List<String>> getPossiblePathToReactEndWord() {
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(startWord)));

        Set<String> localDictionary = new HashSet<>(dictionary);
        localDictionary.add(endWord);

        LinkedList<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(startWord, 1));

        while (!queue.isEmpty()) {
            WordNode top = queue.remove();

            if (top.word.equals(endWord)) {
                result.stream().forEach(list -> list.add(top.word));
                return result;
            }

            char[] topCharArray = top.word.toCharArray();
            for (int i = 0; i < topCharArray.length; i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    char temp = topCharArray[i];
                    topCharArray[i] = j;
                    String newWord = String.valueOf(topCharArray);
                    if (localDictionary.contains(newWord)) {
                        addResultIfAllowed(result, queue, top, newWord);
                        queue.add(new WordNode(newWord, top.noOfSteps + 1));
                        localDictionary.remove(newWord);
                    }
                    topCharArray[i] = temp;
                }
            }
        }
        return new ArrayList<>();
    }

    private void addResultIfAllowed(List<List<String>> result, LinkedList<WordNode> queue, WordNode top, String newWord) {
        if (!StringUtils.areStringEquals(newWord, endWord)) {
            if (CollectionUtils.isNotNullButEmpty(result)) {
                result.add(new ArrayList<>(List.of(newWord)));
            } else if (CollectionUtils.isNotNullButEmpty(queue)) {
                result.stream().forEach(list -> list.add(newWord));
            } else if (CollectionUtils.isNonEmpty(queue) && queue.get(queue.size() - 1).noOfSteps == top.noOfSteps) {
                List<String> lastResult = new ArrayList<>(result.get(result.size() - 1));
                lastResult.remove(lastResult.size() - 1);
                lastResult.add(newWord);
                result.add(lastResult);
            } else {
                result.stream().forEach(list -> list.add(newWord));
            }
        }
    }
}

