package org.example.practice.assignments.sep_28.leaderboard.requests;

import org.example.practice.assignments.sep_28.leaderboard.LeaderBoard;

public class TopRequest implements GameRequest {
    public static final String NAME = "top";
    private Integer scoreSum;

    @Override
    public Integer[] getValues() {
        return new Integer[]{scoreSum};
    }

    @Override
    public void setValues(Integer... values) {
        scoreSum = values[0];
    }

    @Override
    public Integer getResult(LeaderBoard leaderBoard) {
        int topK = Math.min(scoreSum, leaderBoard.getSize());

        return leaderBoard.getScores()
                          .stream()
                          .limit(topK)
                          .mapToInt(Integer::intValue)
                          .sum();
    }
}
