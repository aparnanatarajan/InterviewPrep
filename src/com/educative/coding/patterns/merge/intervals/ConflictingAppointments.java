package com.educative.coding.patterns.merge.intervals;

import java.util.Arrays;
import java.util.List;

public class ConflictingAppointments
{
    public static boolean canAttendAllAppointments(Interval[] intervals) {
        if(intervals == null || intervals.length < 2)
        {
            return true;
        }

        List<Interval> intList = Arrays.asList(intervals);
        intList.sort((a,b) -> Integer.compare(a.start, b.start));
//        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        int start = intList.get(0).start;
        int end = intList.get(0).end;
        int index = 1;
        while(index < intList.size())
        {
            Interval temp = intList.get(index++);
            if(start < temp.start && end <= temp.start)
            {
                start = temp.start;
                end = temp.end;
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        boolean result = canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result = canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result = canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }
}
