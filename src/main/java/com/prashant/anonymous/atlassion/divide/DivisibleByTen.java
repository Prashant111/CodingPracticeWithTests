package com.prashant.anonymous.atlassion.divide;

//A List of logs of a server which contains IP address and time stamp of the logs. Find the IP address
//with maximum number of log entries.
public class DivisibleByTen {
    private final Integer number;

    public DivisibleByTen(final int number) {
        this.number = number;
    }

    public boolean isDivisibleBy10() {
        return String.valueOf(number).charAt(String.valueOf(number).length() - 1) == '0';
    }


    public static void main(String[] args) {
        DivisibleByTen loggerProblem = new DivisibleByTen(34524344);
        System.out.println(loggerProblem.isDivisibleBy10());
    }
}
