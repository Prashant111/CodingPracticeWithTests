package com.prashant.anonymous.epam.count_characters;

public class CountCharactersLauncher {
    public static void main(String[] args) {
        String string = "abcdeabcefabcde";
        CountCharacters countCharacters = new CountCharacters(string);
        System.out.println("countCharacters.getCharacterCount() = " + countCharacters.getCharacterCount());
    }

}
