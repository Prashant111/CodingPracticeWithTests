package com.prashant.anonymous.atlassion.recommended.array_or_string;

import com.prashant.anonymous.common.exception.InvalidInputException;
import com.prashant.anonymous.common.exception.NullInputException;

import java.util.Arrays;

import static com.prashant.anonymous.common.utility.ArrayUtils.isEmpty;
import static java.lang.Math.min;
import static java.util.Objects.isNull;

public class HourlyEmployeeCounter {
    private static final int HOURS_IN_DAY = 24;
    private final int[][] employeeEntryExitTime;

    public HourlyEmployeeCounter(int[][] employeeEntryExitTime) {
        validateEmployeeTimings(employeeEntryExitTime);
        this.employeeEntryExitTime = employeeEntryExitTime;
    }

    private void validateEmployeeTimings(int[][] employeeEntryExitTime) {
        if (isNull(employeeEntryExitTime) || isNull(employeeEntryExitTime[0]))
            throw new NullInputException();
        if (isEmpty(employeeEntryExitTime) && employeeEntryExitTime.length != 2)
            throw new InvalidInputException(employeeEntryExitTime);
    }

    public int[] hourlyEmployeeCount() {
        int[] employeeCountForEachHour = new int[HOURS_IN_DAY + 1];

        int[][] copyInteger = new int[employeeEntryExitTime.length][employeeEntryExitTime[0].length];
        for (int i = 0; i < employeeEntryExitTime.length; i++) {
            for (int j = 0; j < employeeEntryExitTime[i].length; j++) {
                copyInteger[i][j] = employeeEntryExitTime[i][j];
            }
        }

        Arrays.stream(copyInteger).forEach(ints -> System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints)));
        for (int i = 0; i < copyInteger.length; i++) {
            int entry = copyInteger[i][0] % HOURS_IN_DAY;
            int exit = copyInteger[i][1] % HOURS_IN_DAY;

//            exit = entry < exit ? exit : exit + HOURS_IN_DAY;

            int maxWorkingHours = min(exit, HOURS_IN_DAY);

            for (int hour = entry; hour <= maxWorkingHours; hour++) {
                System.out.println("hour " + hour + " filled by employee " + i);
                employeeCountForEachHour[hour]++;
            }
        }
        return employeeCountForEachHour;
    }
}
