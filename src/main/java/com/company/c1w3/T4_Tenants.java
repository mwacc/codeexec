package com.company.c1w3;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Given a set of 𝑛 segments {[𝑎0, 𝑏0], [𝑎1, 𝑏1], . . . , [𝑎𝑛−1, 𝑏𝑛−1]} with integer coordinates on a line, find
 the minimum number 𝑚 of points such that each segment contains at least one point. That is, find a
 set of integers 𝑋 of the minimum size such that for any segment [𝑎𝑖, 𝑏𝑖] there is a point 𝑥 ∈ 𝑋 such
 that 𝑎𝑖 ≤ 𝑥 ≤ 𝑏𝑖.
 Input Format. The first line of the input contains the number 𝑛 of segments. Each of the following 𝑛 lines
 contains two integers 𝑎𝑖 and 𝑏𝑖 (separated by a space) defining the coordinates of endpoints of the 𝑖-th
 segment.
 Output Format. Output the minimum number 𝑚 of points on the first line and the integer coordinates
 of 𝑚 points (separated by spaces) on the second line. You can output the points in any order. If there
 are many such sets of points, you can output any set. (It is not difficult to see that there always exist
 a set of points of the minimum size such that all the coordinates of the points are integers.)
 */
public class T4_Tenants {

    public int[] findOverlaps(int[][] intervals) {
        List<Interval> sortedIntervals = toSortedIntervals(intervals);
        List<Integer> intersectionPoints = new ArrayList<>();

        int mostLeftIntervalEnd = sortedIntervals.get(0).getEnd();
        intersectionPoints.add(mostLeftIntervalEnd);
        for(int i = 1; i < sortedIntervals.size(); i++) {
            if ( pointIsWithin(mostLeftIntervalEnd,
                    sortedIntervals.get(i).getStart(),
                    sortedIntervals.get(i).getEnd()) ) {
                continue;
            } else {
                mostLeftIntervalEnd = sortedIntervals.get(i).getEnd();
                intersectionPoints.add( mostLeftIntervalEnd );
            }
        }

        return intersectionPoints.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean pointIsWithin(int point, int start, int end){
        return point >= start && point <= end;
    }

    private List<Interval> toSortedIntervals(int[][] intervals) {
        List<Interval> arr = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            arr.add( new Interval(intervals[i][0], intervals[i][1]) );
        }

        Collections.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.getEnd() - o2.getEnd();
            }
        });

        return arr;
    }

    private class Interval {
        private int start;
        private int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

    }
}
