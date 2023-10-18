package org.example.java8_plus.team_contribution;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;
import static org.example.java8_plus.team_contribution.utils.PredicateUtils.*;

public class EmployeeOperator {

    //Filter employee based on the age limit
    public List<Employee> getEmployeesBelowAge(List<Employee> employees, int age) {
        return employees.stream()
                        .filter(employee -> employeeBelowAge.test(employee, age))
                        .toList();
    }

    //Map employee with their first name
    public Map<String, Employee> getEmployeeMappedByFirstName(List<Employee> employees) {
        return employees.stream()
                        .collect(toMap(Employee::getFirstName, Function.identity()));

        //What is the problem with this approach
    }

    //Map employees with their first name
    public Map<String, List<Employee>> getEmployeesMappedByFirstName(List<Employee> employees) {
        return employees.stream()
                        .collect(groupingBy(Employee::getFirstName));
    }

    //Map employees with their first name and mapped type should be LinkedList
    public Map<String, List<Employee>> getEmployeesMappedByFirstNameAndReturningLinkedList(List<Employee> employees) {
        return employees.stream()
                        .collect(
                                groupingBy(
                                        Employee::getFirstName,
                                        toCollection(LinkedList::new)
                                          )
                                );
    }

    //Map (LinkedHashMap) employees with their first name
    public Map<String, List<Employee>> getEmployeesMappedByFirstNameLinkedHashMap(List<Employee> employees) {
        return employees.stream()
                        .collect(
                                collectingAndThen(
                                        groupingBy(Employee::getFirstName),
                                        LinkedHashMap::new
                                                 )
                                );
    }

    //Map employees with their first name as key and email id as value
    public Map<String, String> getEmployeesFirstNameEmailIdMap(List<Employee> employees) {
        return employees.stream()
                        .collect(toMap(Employee::getFirstName, Employee::getEmailId
                                         , (emailId1, emailId2) -> emailId2)
                                );
    }

    //Map employees with their first name as key and email id as value by using groupingBy
    public Map<String, String> getEmployeesFirstNameEmailIdsJoiningEmailIdsMap(List<Employee> employees) {
        return employees.stream()
                        .collect(groupingBy(Employee::getFirstName,
                                            collectingAndThen(
                                                    mapping(Employee::getEmailId, toList()),
                                                    email -> email.get(email.size() - 1)
                                                             )
                                           ));
    }

    //Map employees with their first name as key and all email ids as value
    public Map<String, List<String>> getEmployeesFirstNameEmailIdsMap(List<Employee> employees) {

        return employees.stream()
                        .collect(groupingBy(Employee::getFirstName, mapping(Employee::getEmailId, toList())));
    }

    //Map employees with their first name as key and all email ids as value by using map
    public Map<String, List<String>> getEmployeesFirstNameEmailIdsMapByUsingToMap(List<Employee> employees) {
        return employees.stream()
                        .collect(
                                toMap(Employee::getFirstName,
                                      employee -> new ArrayList<>(
                                              Arrays.asList(employee.getEmailId())),
                                      (emailIds, newEmailId) -> {
                                          ArrayList<String> combinedEmailIds = new ArrayList<>(emailIds);
                                          combinedEmailIds.addAll(newEmailId);
                                          return combinedEmailIds;
                                      }
                                     ));
    }


    //Nested grouping - Map by first name and then by last name
    public Map<String, Map<String, List<Employee>>> getMap(List<Employee> employees) {
        return employees.stream()
                        .collect(groupingBy(Employee::getFirstName,
                                            groupingBy(Employee::getLastName, toList())
                                           ));

    }

    //Custom grouping logic - New blood and Experienced
    public Map<Boolean, List<Employee>> getGroupedEmployeeByYoungBloodAndExperienced(List<Employee> employees) {
        return employees.stream()
                        .collect(groupingBy(
//                                employee -> employeeBelowAge.test(employee, 25) ? "Young blood" : "Experienced"
                                adultEmployee::test, filtering(adultEmployee, toList())
                                           ));
    }

    //Group and count the frequency of the names (Default Long)
    public Map<String, Long> getEmployeeFirstNameAndCounting(List<Employee> employees) {
        return employees.stream()
                        .collect(groupingBy(Employee::getFirstName, counting()));

    }

    //Group and count the frequency of the names (By Integer)
    public Map<String, Integer> getEmployeeFirstNameAndCountingAndReturnResultAsInteger(List<Employee> employees) {
        return employees.stream()
                        .collect(groupingBy(Employee::getFirstName,
                                            collectingAndThen(counting(),
                                                              Long::intValue
                                                             )
                                           ));
    }

    //Group the employees by their first and last name and show age of most experienced employee with that experience
    public Map<String, Integer> getMapOfFirstLastNameCombinedAndAgeOfMostExperienced(List<Employee> employees) {
        return employees.stream()
                        .collect(groupingBy(getFullName, mappingToMaxAgedEmployee));
    }

    public List<Employee> getEmployeesStartingTheirNameWith(List<Employee> employees, String prefix) {
        if (Objects.isNull(prefix))
            return List.of();

        return employees.stream()
                        .filter(Objects::nonNull)
                        .filter(employee -> employee.getFirstName()
                                                    .toLowerCase()
                                                    .startsWith(prefix.toLowerCase()))
                        .toList();
    }

}
