package org.example.practice.assignments.sep_28.leaderboard;

import org.example.practice.assignments.sep_28.leaderboard.requests.GameRequest;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoard {
    private final List<Integer> playerIds;
    private final List<Integer> scores;
    private int size;

    protected LeaderBoard() {
        this.playerIds = new ArrayList<>();
        this.scores = new ArrayList<>();
        this.size = 0;
    }

    public synchronized Integer processRequest(@NotNull GameRequest gameRequest) {
        return gameRequest.getResult(this);
    }

    public List<Integer> getPlayerIds() {
        return playerIds;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public int getSize() {
        return size;
    }

    public void incrementSize() {
        size++;
    }

    public void decrementSize() {
        size--;
    }

    @Override
    public String toString() {
        return "LeaderBoard{" +
                "playerIds=" + playerIds +
                ", scores=" + scores +
                ", size=" + size +
                "}\n";
    }
}
