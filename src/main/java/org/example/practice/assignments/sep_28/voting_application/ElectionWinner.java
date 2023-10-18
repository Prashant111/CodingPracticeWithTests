package org.example.practice.assignments.sep_28.voting_application;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;

public class ElectionWinner {
    public List<String> getWinners(List<String> votes, int k) {
        List<String> winners = new ArrayList<>();
        PriorityQueue<Candidate> priorityQueue = new PriorityQueue<>(
                Comparator.comparing(Candidate::getVotes, Comparator.reverseOrder()));

        Map<String, Candidate> candidateNameMap = new HashMap<>();

        for (String vote : votes) {
            if (candidateNameMap.containsKey(vote)) {
                candidateNameMap.put(vote, new Candidate(vote));
            } else {
                Candidate candidate = candidateNameMap.get(vote);
                candidate.addVote();
                candidateNameMap.put(vote, candidate);
            }
        }

        for (String candidateName : candidateNameMap.keySet()) {
            priorityQueue.add(candidateNameMap.get(candidateName));
        }

        for (int i = 0; i < k && i < candidateNameMap.size(); i++) {
            winners.add(Objects.requireNonNull(priorityQueue.poll())
                               .getName());
        }


        Candidate[][] candidateList = new Candidate[][]{{}};

        Candidate[][] candidates = new Candidate[][]{
                {
                        new Candidate("1"),
                        new Candidate("2"),
                        new Candidate("3"),
                        new Candidate("4"),
                }, {
                new Candidate("5"),
                new Candidate("6"),
                new Candidate("7"),
                new Candidate("8"),
        },
        };

        printField(candidates, (i, j) -> System.out.print(candidates[i][j] + " "));
        printField(candidates, (i, j) -> System.out.print(candidates[i][j].getName() + " "));


        System.out.println();
        printField(candidates, (i, j) -> System.out.print(candidates[i][j].getVotes() + " "));

        return null;

    }

    public void printField(Candidate[][] candidates,
                           BiConsumer<Integer, Integer> consumer) {
        IntStream.range(0, candidates.length)
                 .forEach(i -> {
                     System.out.println();
                     IntStream.range(0, candidates[i].length)
                              .forEach(j -> consumer.accept(i, j));
                 });
        System.out.println();
    }
}
