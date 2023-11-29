package com.prashant.anonymous.atlassion.recommended.array_or_string.word_ladder;

public class WordNode {
    public static String word;
    public static int noOfSteps;

    public WordNode(String word, int noOfSteps) {
        this.word = word;
        this.noOfSteps = noOfSteps;
    }

    @Override
    public String toString() {
        return "WordNode{" + "word='" + word + '\'' + ", noOfSteps=" + noOfSteps + '}';
    }
}
