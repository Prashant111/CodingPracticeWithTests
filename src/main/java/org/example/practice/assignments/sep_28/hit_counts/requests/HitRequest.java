package org.example.practice.assignments.sep_28.hit_counts.requests;

import org.example.practice.assignments.sep_28.hit_counts.requests.HitCounterRequest;

import java.util.Arrays;

public class HitRequest implements HitCounterRequest {
    public static final String name = "hit";
    private Integer[] timestamps;


    @Override
    public void setValues(Integer[] input) {
        this.timestamps = Arrays.copyOf(input, input.length);
    }

    @Override
    public Integer[] getValues() {
        return new Integer[0];
    }
}
