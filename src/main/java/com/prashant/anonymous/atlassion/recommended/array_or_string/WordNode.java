package com.prashant.anonymous.atlassion.recommended.array_or_string;

class WordNode {
    public String word;
    public int noOfSteps;

    public WordNode(String word, int noOfSteps) {
        this.word = word;
        this.noOfSteps = noOfSteps;
    }

    @Override
    public String toString() {
        return "WordNode{" + "word='" + word + '\'' + ", noOfSteps=" + noOfSteps + '}';
    }
}
