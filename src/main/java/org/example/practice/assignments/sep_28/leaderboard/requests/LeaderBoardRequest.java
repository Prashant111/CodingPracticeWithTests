package org.example.practice.assignments.sep_28.leaderboard.requests;

import org.example.practice.assignments.sep_28.leaderboard.LeaderBoard;

public class LeaderBoardRequest implements GameRequest {
    public static final String NAME = "Leaderboard";

    @Override
    public Integer[] getValues() {
        return new Integer[0];
    }

    @Override
    public void setValues(Integer... values) {
        //nothing to set
    }

    @Override
    public Integer getResult(LeaderBoard leaderBoard) {
        return null;
    }
}
