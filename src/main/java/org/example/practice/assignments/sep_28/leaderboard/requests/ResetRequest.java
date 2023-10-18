package org.example.practice.assignments.sep_28.leaderboard.requests;

import org.example.practice.assignments.sep_28.leaderboard.LeaderBoard;

public class ResetRequest implements GameRequest {
    public static final String NAME = "reset";
    private Integer playerId;

    @Override
    public Integer[] getValues() {
        return new Integer[]{playerId};
    }

    @Override
    public void setValues(Integer... values) {
        if (values.length < 1)
            throw new RuntimeException("Incorrect values");
        playerId = values[0];
    }

    @Override
    public Integer getResult(LeaderBoard leaderBoard) {
        int index = leaderBoard.getPlayerIds()
                               .indexOf(playerId);
        leaderBoard.getPlayerIds()
                   .remove(index);
        leaderBoard.getScores()
                   .remove(index);
        leaderBoard.decrementSize();
        return null;
    }
}
