package org.example.test.atlassian;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.example.utilities.StringUtils.EMPTY_STRING;

public class GenerateOddNumberedStrings {
    private final Random random = new Random();

    public String oddNumberedString(int n) {
        if (n <= 0) return EMPTY_STRING;
        if (n == 1) return String.valueOf(getRandomCharacters(1)[0]);

        char[] randomCharacters = getRandomCharacters(2);
        int[] charCount = getUniqueCharactersCount(n);

        return constructString(randomCharacters, charCount);
    }

    private String constructString(char[] characters, int[] charCount) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < characters.length; i++)
            stringBuilder.append(String.valueOf(characters[i]).repeat(Math.max(0, charCount[i])));

        return stringBuilder.toString();
    }

    private int[] getUniqueCharactersCount(int n) {
        if (isOdd(n)) return new int[]{n, 0};
        else return new int[]{n - 1, 1};
    }

    private static boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    private char[] getRandomCharacters(int count) {
        char[] charArray = IntStream.range(0, 26)
                                    .boxed()
                                    .map(index -> (char) (index + 'a'))
                                    .map(String::valueOf)
                                    .collect(Collectors.joining())
                                    .toCharArray();


        int length = charArray.length;
        for (int i = length - 1; i > length - count; i--) {
            int indexToSwapValue = random.nextInt(i);
            swap(charArray, indexToSwapValue, i);
        }

        return Arrays.copyOfRange(charArray, length - count + 1, length);
    }

    private void swap(char[] array, int i1, int i2) {
        char temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
}
