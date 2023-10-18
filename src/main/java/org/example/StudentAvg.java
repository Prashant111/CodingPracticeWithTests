package org.example;

public class StudentAvg {
    private String name;
    private double avgMarks;

    public StudentAvg(String name, double avgMarks) {
        this.name = name;
        this.avgMarks = avgMarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAvgMarks() {
        return avgMarks;
    }

    public void setAvgMarks(double avgMarks) {
        this.avgMarks = avgMarks;
    }

    @Override
    public String toString() {
        return "StudentAvg{" +
                "name='" + name + '\'' +
                ", avgMarks=" + avgMarks +
                '}';
    }
}