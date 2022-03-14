package com.educative.coding.patterns.merge.intervals;

import java.util.*;

/**
 * Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually
 * exclusive intervals.
 *
 * Example 1:
 * Intervals: [[1,4], [2,5], [7,9]]
 * Output: [[1,5], [7,9]]
 * Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
 * one [1,5].
 *
 * Example 2:
 * Intervals: [[6,7], [2,4], [5,9]]
 * Output: [[2,4], [5,9]]
 * Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].
 *
 * Example 3:
 * Intervals: [[1,4], [2,6], [3,5]]
 * Output: [[1,6]]
 * Explanation: Since all the given intervals overlap, we merged them into one.
 */
public class MergeIntervals
{
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;

        // sort the intervals by start time
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new LinkedList<>();
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;

        while (intervalItr.hasNext()) {
            interval = intervalItr.next();
            if (interval.start <= end) { // overlapping intervals, adjust the 'end'
                end = Math.max(interval.end, end);
            } else { // non-overlapping interval, add the previous interval and reset
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        // add the last interval
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

    public static List<Interval> myMerge(List<Interval> intervals) {
        if(intervals.size() < 2)
        {
            return intervals;
        }

        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));

        List<Interval> mergedIntervals = new ArrayList<>();
        int index = 1;
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        while(index < intervals.size())
        {
            int newStart = intervals.get(index).start;
            int newEnd = intervals.get(index).end;

            if(start <= newStart && newStart <= end)
            {
                end = Math.max(end, newEnd);
            }
            else
            {
                mergedIntervals.add(new Interval(start, end));
                start = newStart;
                end = newEnd;
            }
            index++;
        }

        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

        public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : myMerge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : myMerge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : myMerge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
