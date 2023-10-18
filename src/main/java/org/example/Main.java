package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }

        List<Student> students = Arrays.asList(
                new Student("Alice", "Math", 85),
                new Student("Bob", "Math", 92),
                new Student("Bob", "Math", 92),
                new Student("Charlie", "Math", 78),
                new Student("Alice", "Science", 90),
                new Student("Bob", "Science", 88),
                new Student("Charlie", "Science", 82),
                new Student("Alice", "English", 78),
                new Student("Bob", "English", 95),
                new Student("Charlie", "English", 85));


        List<StudentAvg> collect = students
                .stream()
                .collect(Collectors.groupingBy(Student::getName)).values().stream().map(students1 ->
                {
                    String name = students1.get(0).getName();
                    return new StudentAvg(name, students1.stream().mapToInt(student -> student.getMarks()).average().orElse(0.0));
                })
                .sorted((s1, s2) -> Double.compare(s2.getAvgMarks(), s1.getAvgMarks()))
                .collect(toList());
        System.out.println("collect = " + collect);
    }
}