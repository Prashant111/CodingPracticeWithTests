package org.example.practice.text_justification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.practice.text_justification.JustificationRequired.LEFT_JUSTIFIED;

public class TextJustification {
    public static void main(String[] args) {
        List<String> strings = fullJustify(new String[]{
                "ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country",
        }, 16);

        System.out.println(strings);

    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int sum = 0;
        int from = 0;
        for (int i = 0; i < words.length; i++) {
            sum += (sum == 0) ? words[i].length() : words[i].length() + 1;
            while (sum > maxWidth) {
                list.add(getJustifiedText(Arrays.asList(words).subList(from, i), maxWidth, 0));
                from = i;
                sum = words[i].length();
            }
        }
        list.add(LEFT_JUSTIFIED.getJustifiedString(Arrays.asList(words).subList(from, words.length), maxWidth));
        return list;
    }


    private static String getJustifiedText(List<String> strings, int maxWidth, int row) {
        JustificationRequired type = JustificationRequired.getType(strings, row);
        return type.getJustifiedString(strings, maxWidth);
    }
}
