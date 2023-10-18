package org.example.practice.assignments.sep_28.leaderboard.factory;

import org.example.practice.assignments.sep_28.leaderboard.requests.*;

public class GameFactory {
    private GameFactory() {
    }

    public static GameRequest getGameRequestFactory(String requestName) {
        return switch (requestName) {
            case LeaderBoardRequest.NAME -> new LeaderBoardRequest();
            case AddScoreRequest.NAME -> new AddScoreRequest();
            case TopRequest.NAME -> new TopRequest();
            case ResetRequest.NAME -> new ResetRequest();
            default -> null;
        };
    }
}
