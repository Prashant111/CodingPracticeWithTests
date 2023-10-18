package org.example.java8_plus.team_contribution;

public class Employee {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String emailId;
    private final int age;

    public Employee(int id, String firstName, String lastName, String emailId, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }
}
