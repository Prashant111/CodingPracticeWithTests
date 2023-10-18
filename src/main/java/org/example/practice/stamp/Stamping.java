package org.example.practice.stamp;

import java.util.ArrayList;
import java.util.List;

public class Stamping {
    public int[] movesToStamp(String stamp, String string) {
        char[] stampChars = stamp.toCharArray();
        char[] stringChars = string.toCharArray();

        int stampLength = stampChars.length;
        int stringLength = stringChars.length;
        int diffLength = stringLength - stampLength;

        boolean[] visited = new boolean[stringLength];

        int count = 0;
        while (count != stringLength) {
            boolean changed = false;
            for (int i = 0; i < diffLength; i++) {
//                if (!visited[i] && canReplace(stampChars, ))
            }
        }
        return new int[0];
    }
}
