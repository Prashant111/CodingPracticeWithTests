package org.example.practice.assignments.sep_28.voting_application;

public class Candidate {
    private String name;
    private long votes;

    public Candidate(String name) {
        this.name = name;
        this.votes = 1;
    }

    public String getName() {
        return name;
    }

    public long getVotes() {
        return votes;
    }

    public void addVote() {
        this.votes++;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", votes=" + votes +
                '}';
    }
}
