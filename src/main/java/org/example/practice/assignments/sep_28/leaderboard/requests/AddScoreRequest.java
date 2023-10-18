package org.example.practice.assignments.sep_28.leaderboard.requests;

import org.example.practice.assignments.sep_28.leaderboard.LeaderBoard;

public class AddScoreRequest implements GameRequest {
    public static final String NAME = "addScore";
    private Integer playerId;
    private Integer score;

    @Override
    public Integer[] getValues() {
        return new Integer[]{playerId, score};
    }

    @Override
    public void setValues(Integer... values) {
        if (values.length < 2)
            throw new RuntimeException("Incorrect values");
        playerId = values[0];
        score = values[1];
    }

    @Override
    public Integer getResult(LeaderBoard leaderBoard) {
        if (leaderBoard.getSize() == 0) {
            leaderBoard.getPlayerIds()
                       .add(playerId);
            leaderBoard.getScores()
                       .add(score);
        } else {
            int idIndex = leaderBoard.getPlayerIds()
                                     .indexOf(playerId);

            if (idIndex >= 0)
                handleIfIdExists(leaderBoard, idIndex, score, playerId);
            else
                handleIfIdDoesNotExists(leaderBoard, score, playerId);
        }
        leaderBoard.incrementSize();
        return null;
    }

    private void handleIfIdDoesNotExists(LeaderBoard leaderBoard, int score, int playerId) {
        int index = binarySearch(leaderBoard.getScores(), score);
        if (index < 0)
            index = -index - 1;
        leaderBoard.getPlayerIds()
                   .add(index, playerId);
        leaderBoard.getScores()
                   .add(index, score);
    }

    void handleIfIdExists(LeaderBoard leaderBoard, int idIndex, int score, int playerId) {
        int newScore = leaderBoard.getScores()
                                  .get(idIndex) + score;
        leaderBoard.getPlayerIds()
                   .remove(idIndex);
        leaderBoard.getScores()
                   .remove(idIndex);
        handleIfIdDoesNotExists(leaderBoard, newScore, playerId);
    }
}
