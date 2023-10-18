package org.example.practice.assignments.sep_28.leaderboard.requests;

import org.example.practice.assignments.sep_28.leaderboard.LeaderBoard;

import java.util.List;

public interface GameRequest {
    public Integer[] getValues();

    public void setValues(Integer... values);

    public Integer getResult(LeaderBoard leaderBoard);

    default int binarySearch(List<Integer> list, int key) {
        int size = list.size();
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = list.get(mid);
            if (num == key)
                return mid;
            else if (num > key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -low - 1;
    }
}