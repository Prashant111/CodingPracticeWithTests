package com.prashant.anonymous.atlassion;

import com.prashant.anonymous.atlassion.voting.VotingCounter;

public class AtlassianMain {
    public static void main(String[] args) {
        VotingCounter votingCounter = new VotingCounter(new int[]{0, 1, 1, 0, 0, 1}, new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println("votingCounter.q(3) = " + votingCounter.q(3));
        System.out.println("votingCounter.q(12) = " + votingCounter.q(12));
        System.out.println("votingCounter.q(25) = " + votingCounter.q(25));
        System.out.println("votingCounter.q(15) = " + votingCounter.q(15));
        System.out.println("votingCounter.q(24) = " + votingCounter.q(24));
        System.out.println("votingCounter.q(8) = " + votingCounter.q(8));
    }
}
