package org.example.practice.assignments.sep_28.hit_counts;

import org.example.practice.assignments.sep_28.hit_counts.requests.HitCounterRequest;

import java.util.ArrayList;
import java.util.List;

public class HitCounter {
    public static final int RETENTION_SECONDS = 300;
    private List<Hit> hits;

    public HitCounter() {
        this.hits = new ArrayList<>();
    }

    public Integer processRequest(HitCounterRequest hitCounterRequest) {
        return -1;
    }

    public void hit(int timestamp) {

    }

    public int getHits(int timestamp) {
        return 0;
    }
}
