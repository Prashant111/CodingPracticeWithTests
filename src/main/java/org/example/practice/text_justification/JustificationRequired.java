package org.example.practice.text_justification;

import java.util.List;

import static org.example.utilities.StringUtils.SINGLE_SPACE;

public enum JustificationRequired {
    NOT_REQUIRED {
        public String getJustifiedString(List<String> words, int maxWidth) {
            return null;
        }

    }, LEFT_JUSTIFIED {
        public String getJustifiedString(List<String> words, int maxWidth) {
            String joinedStringBySpace = String.join(SINGLE_SPACE, words);
            return joinedStringBySpace.concat(SINGLE_SPACE.repeat(maxWidth - joinedStringBySpace.length()));
        }
    }, FULLY_JUSTIFIED {
        public String getJustifiedString(List<String> words, int maxWidth) {
            StringBuilder stringBuilder = new StringBuilder();

            int sum = words.stream().mapToInt(String::length).sum();
            int diff = maxWidth - sum;
            int eachDistribution = diff / (words.size() - 1);

            if (Integer.valueOf(diff % (words.size() - 1) * 10) > 0) {
                eachDistribution++;
            }
            stringBuilder.append(words.get(0));
            System.out.println("---------------------------------------------------------------------");
            System.out.println("\nwords = " + words);
            System.out.println("maxWidth = " + maxWidth);
            System.out.println("i = " + 0);
            System.out.println("words = " + words.get(0));
            System.out.println("eachDistribution = " + eachDistribution);
            System.out.println("diff = " + diff);
            System.out.println(
                    "diff / (words.size() - 1) : " + diff + "/" + (words.size() - 1) + " = " + diff / (words.size() - 1));
            System.out.println(
                    "diff % (words.size() - 1)  : " + diff + "%" + (words.size() - 1) + " = " + diff % (words.size() - 1));
            System.out.println("stringBuilder = " + stringBuilder);
            for (int i = 1; i < words.size(); i++) {
                stringBuilder.append(
                        SINGLE_SPACE.repeat(i < words.size() - 1 ? eachDistribution : diff).concat(words.get(i)));
                diff -= eachDistribution;
                System.out.println("\ni = " + i);
                System.out.println("words = " + words.get(i));
                System.out.println("eachDistribution = " + eachDistribution);
                System.out.println("diff = " + diff);
                System.out.println("(words.size() - i - 1) = " + (words.size() - i - 1));
                if (diff > 0 && diff % (words.size() - i - 1) == 0)
                    eachDistribution = diff / (words.size() - i - 1);
//                System.out.println("diff / (words.size() - 1) = " + diff / (words.size() - 1));
//                System.out.println("diff % (words.size() - 1) = " + diff % (words.size() - 1));
                System.out.println("stringBuilder = " + stringBuilder);
            }
            return stringBuilder.toString();
        }
    };

    public static JustificationRequired getType(List<String> input, int rowEvaluating) {
        if ((rowEvaluating == input.size() - 1) || (input.size() == 1))
            return LEFT_JUSTIFIED;
        else if (input.isEmpty())
            return NOT_REQUIRED;
        else
            return FULLY_JUSTIFIED;
    }

    public abstract String getJustifiedString(List<String> words, int maxWidth);
}
