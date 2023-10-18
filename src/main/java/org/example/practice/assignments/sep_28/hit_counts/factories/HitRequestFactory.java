package org.example.practice.assignments.sep_28.hit_counts.factories;

import org.example.practice.assignments.sep_28.hit_counts.requests.HitCountRequest;
import org.example.practice.assignments.sep_28.hit_counts.requests.HitCounterInitializationRequest;
import org.example.practice.assignments.sep_28.hit_counts.requests.HitCounterRequest;
import org.example.practice.assignments.sep_28.hit_counts.requests.HitRequest;

public class HitRequestFactory {
    private HitRequestFactory() {

    }

    public static HitCounterRequest getHitRequest(String requestName) {
        return switch (requestName) {
            case HitCounterInitializationRequest.name -> new HitCounterInitializationRequest();
            case HitCountRequest.name -> new HitCountRequest();
            case HitRequest.name -> new HitRequest();
            default -> null;
        };
    }
}
