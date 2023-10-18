package org.example.practice.assignments.sep_28.leaderboard;

import org.example.practice.assignments.sep_28.leaderboard.factory.GameFactory;
import org.example.practice.assignments.sep_28.leaderboard.requests.GameRequest;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class LeaderboardLauncher {
    public List<Integer> getProcessedRequestsResult(String[] requestNames, Integer[][] requestParams) {
        List<GameRequest> requests = IntStream.range(0, requestNames.length)
                                              .boxed()
                                              .map(getIntegerGameRequestFunction(requestNames, requestParams))
                                              .toList();
        return getProcessedRequestsResult(requests);
    }

    private static Function<Integer, GameRequest> getIntegerGameRequestFunction(String[] requests,
                                                                                Integer[][] requestParams) {
        return index -> getGameRequest(requests, requestParams, index);
    }

    private static GameRequest getGameRequest(String[] requests, Integer[][] requestParams, Integer index) {
        String requestName = requests[index];
        Integer[] requestInputs = requestParams[index];

        GameRequest gameRequest = GameFactory.getGameRequestFactory(requestName);
        gameRequest.setValues(requestInputs);

        return gameRequest;
    }

    private List<Integer> getProcessedRequestsResult(List<GameRequest> requests) {
        LeaderBoard leaderBoard = new LeaderBoard();
        return requests.stream()
                       .map(leaderBoard::processRequest)
                       .toList();

    }
}
