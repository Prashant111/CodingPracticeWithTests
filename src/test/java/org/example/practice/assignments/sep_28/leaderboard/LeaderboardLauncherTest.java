package org.example.practice.assignments.sep_28.leaderboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LeaderboardLauncherTest {
    private LeaderboardLauncher leaderboardLauncher;

    @BeforeEach
    void setUp() {
        leaderboardLauncher = new LeaderboardLauncher();
    }

    void assertArrayLists(List<Integer> expected, List<Integer> actual) {
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void testIdealInput() {
        String[] requestNames = {"Leaderboard", "addScore", "addScore", "addScore", "addScore", "addScore", "top", "reset", "reset", "addScore", "top"};
        Integer[][] requestParams = {{}, {1, 73}, {2, 56}, {3, 39}, {4, 51}, {5, 4}, {1}, {1}, {2}, {2, 51}, {3}};

        List<Integer> actual = leaderboardLauncher
                .getProcessedRequestsResult(requestNames, requestParams);

        List<Integer> expected = Arrays.asList(null, null, null, null, null, null, 73, null, null, null, 141);
        assertArrayLists(expected, actual);
    }
}