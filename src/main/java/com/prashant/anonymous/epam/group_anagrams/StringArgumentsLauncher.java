package com.prashant.anonymous.epam.group_anagrams;

import java.util.Arrays;

public class StringArgumentsLauncher {
    public static void main(String[] args) {
        StringAnagrams stringAnagrams = new StringAnagrams(Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat"));
        System.out.println("stringAnagrams.getGroupedAnagrams() = " + stringAnagrams.getGroupedAnagrams());
    }
}
