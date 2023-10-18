package org.example.java8_plus.team_contribution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class EmployeeGenerator {

    private static List<Employee> employeeList;
    private static final String[] FIRST_NAMES = {"John", "Alice", "Bob", "Eva", "David", "Emma", "James", "Sophia", "Michael", "Olivia"};
    private static final String[] LAST_NAMES = {"Doe", "Smith", "Johnson", "Williams", "Brown", "Miller", "Davis", "Wilson", "Lee", "Anderson"};
    private static final String[] EMAIL_DOMAINS = {"google.com", "atlassian.com", "meta.com", "amazon.com", "apple.com"};
    private static final Random RANDOM = new Random();

    private static List<Employee> getRandomEmployees(int count) {
        if (Objects.isNull(employeeList)) {
            synchronized (EmployeeGenerator.class) {
                if (Objects.isNull(employeeList)) {
                    employeeList = new ArrayList<>();
                    for (int i = 1; i <= count; i++) {
                        String firstName = FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
                        String lastName = LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)];
                        String emailId = "employee" + i + "@" + EMAIL_DOMAINS[RANDOM.nextInt(EMAIL_DOMAINS.length)];
                        int age = 20 + RANDOM.nextInt(40); // Random age between 20 and 59
                        employeeList.add(new Employee(i, firstName, lastName, emailId, age));
                    }
                }
            }
        }
        return employeeList;
    }

    public static List<Employee> getEmployeeList(int count) {
        return getRandomEmployees(count);
    }

}