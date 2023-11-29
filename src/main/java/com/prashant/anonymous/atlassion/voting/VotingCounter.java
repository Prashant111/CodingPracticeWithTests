package com.prashant.anonymous.atlassion.voting;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class VotingCounter {
    private final int[] persons;
    private final int[] times;

    private TreeMap<Integer, Integer> resultAtTime;

    public VotingCounter(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;

        this.resultAtTime = new TreeMap<>();
        initializeValues();

    }

    private void initializeValues() {
        int maxValue = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < persons.length; i++) {
            countMap.put(persons[i], countMap.getOrDefault(persons[i], 0) + 1);

            if (countMap.get(persons[i]) >= maxValue) {
                maxValue = countMap.get(persons[i]);
                resultAtTime.put(times[i], persons[i]);
            }
        }
    }

    public int q(int time) {
        return resultAtTime.floorEntry(time).getValue();
    }
}
