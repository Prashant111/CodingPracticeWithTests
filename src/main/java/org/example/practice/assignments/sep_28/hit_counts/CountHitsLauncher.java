package org.example.practice.assignments.sep_28.hit_counts;

import org.example.practice.assignments.sep_28.hit_counts.factories.HitRequestFactory;
import org.example.practice.assignments.sep_28.hit_counts.requests.HitCounterRequest;
import org.example.practice.assignments.sep_28.leaderboard.LeaderBoard;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class CountHitsLauncher {

    public List<Integer> getHits(String[] commands, Integer[][] timeStamps) {

        List<HitCounterRequest> requests = IntStream.range(0, commands.length)
                                                    .boxed()
                                                    .map(getHistRequestFunction(commands, timeStamps))
                                                    .toList();

        return getProcessedRequestsResult(requests);
//        IntStream.range(0, commands.length)
//                         .mapToObj(index -> {
//                             Integer[] timeStampsInSec = timeStamps[index];
//                             List<Integer> collect = Arrays.stream(timeStampsInSec)
//                                                           .collect(Collectors.toList());
//                             collect.stream().map(timeStamp -> new Hit(timeStamp, commands[index]))
//                         })
//        Arrays.stream(commands)
//              .forEach(command ->
//                               executeCommand(command, timeStamps));
//
//        return new Integer[0];
    }

    private Function<Integer, HitCounterRequest> getHistRequestFunction(String[] requestNames, Integer[][] timeStamps) {
        return index -> getHitRequest(requestNames, timeStamps, index);
    }

    private HitCounterRequest getHitRequest(String[] requestNames, Integer[][] timeStamps, Integer index) {
        String requestName = requestNames[index];
        Integer[] timesStamp = timeStamps[index];

        HitCounterRequest hitCounterRequest = HitRequestFactory.getHitRequest(requestName);
        hitCounterRequest.setValues(timesStamp);

        return hitCounterRequest;
    }

    private List<Integer> getProcessedRequestsResult(List<HitCounterRequest> requests) {
        HitCounter hitCounter = new HitCounter();
        return IntStream.range(0, requests.size())
                        .boxed()
                        .map(index -> hitCounter.processRequest(requests.get(index)))
                        .toList();
    }
}
