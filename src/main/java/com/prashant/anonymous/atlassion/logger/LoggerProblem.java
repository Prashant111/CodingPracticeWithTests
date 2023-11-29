package com.prashant.anonymous.atlassion.logger;

import java.util.*;

//A List of logs of a server which contains IP address and time stamp of the logs. Find the IP address
//with maximum number of log entries.
public class LoggerProblem {
    private final List<String> logEntries;

    public LoggerProblem(final List<String> logEntries) {
        //new String[]{"10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20", "10.0.0.3 - GET 2020-08-24","10.0.0.3 - GET 2020-08-24","10.0.0.3 - GET 2020-08-24","10.0.0.4 - GET 2020-08-24",
        this.logEntries = logEntries;
    }

    public List<String> getIPAddressesWithMaxLogs() {
        int maxFreq = 0;
        Map<String, Integer> ipAddressEntriesCountMap = new HashMap<>();
        Set<String> ipAddresses = new HashSet<>();

        for (String logEntry : logEntries) {
            String ipAddress = getIpAddress(logEntry);
            int freq = ipAddressEntriesCountMap.getOrDefault(ipAddress, 0) + 1;
            ipAddressEntriesCountMap.put(ipAddress, freq);


            if (freq >= maxFreq) {
                if (freq > maxFreq)
                    ipAddresses.clear();
                ipAddresses.add(ipAddress);
            }
            maxFreq = Math.max(freq, maxFreq);
        }
        return new ArrayList<>(ipAddresses);
    }

    private String getIpAddress(String logEntry) {
        String[] splittedLogEntry = logEntry.split(" - ");
        return splittedLogEntry[0].trim();
    }

    public static void main(String[] args) {
        LoggerProblem loggerProblem = new LoggerProblem(
                Arrays.asList(new String[]{
                        "10.0.0.1 - GET 2020-08-24",
                        "10.0.0.1 - GET 2020-08-24",
                        "10.0.0.2 - GET 2020-08-20",
                        "10.0.0.3 - GET 2020-08-24",
                        "10.0.0.3 - GET 2020-08-24",
                        "10.0.0.3 - GET 2020-08-24",
                        "10.0.0.4 - GET 2020-08-24"}));
        System.out.println(loggerProblem.getIPAddressesWithMaxLogs());
    }
}
