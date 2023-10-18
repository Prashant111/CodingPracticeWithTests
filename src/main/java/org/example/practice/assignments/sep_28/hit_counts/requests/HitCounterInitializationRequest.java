package org.example.practice.assignments.sep_28.hit_counts.requests;

import java.util.Arrays;

public class HitCounterInitializationRequest implements HitCounterRequest {
    public static final String name = "HitCounter";


    @Override
    public void setValues(Integer[] input) {
        // no need to set values
    }

    @Override
    public Integer[] getValues() {
        return new Integer[0];
    }
}
