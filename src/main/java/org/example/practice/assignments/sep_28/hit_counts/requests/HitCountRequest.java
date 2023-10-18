package org.example.practice.assignments.sep_28.hit_counts.requests;

public class HitCountRequest implements HitCounterRequest {
    public static final String name = "getHits";
    private final Integer[] timestamps = new Integer[1];


    @Override
    public void setValues(Integer[] input) {
        this.timestamps[0] = input[0];
    }

    @Override
    public Integer[] getValues() {
        return new Integer[0];
    }
}
