package org.example.java8_plus.team_contribution.utils;

import org.example.java8_plus.team_contribution.Employee;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;

import static java.util.stream.Collectors.*;

public class PredicateUtils {
    public static BiPredicate<Employee, Integer> employeeBelowAge = ((employee, age) -> employee.getAge() < age);
    public static Predicate<Employee> adultEmployee = employee -> employee.getAge() >= 18;
    public static Function<Employee, String> getFullName = employee -> employee.getFirstName()
                                                                               .concat(" ")
                                                                               .concat(employee.getLastName());

    public static Function<List<Integer>, Integer> getMaxAgeEmployee = emp -> emp.stream()
                                                                                 .mapToInt(
                                                                                         Integer::intValue)
                                                                                 .max()
                                                                                 .orElse(0);

    public static Collector<Employee, ?, Integer> mappingToMaxAgedEmployee = mapping(Employee::getAge,
                                                                                     collectingAndThen(toList(),
                                                                                                       getMaxAgeEmployee
                                                                                                      )
                                                                                    );
}
