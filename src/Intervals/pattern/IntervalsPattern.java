package Intervals.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalsPattern {

    /**
     * merge-intervals
     * insert-interval
     * non-overlapping-intervals
     */

    /**
     * https://leetcode.com/problems/merge-intervals/
     */
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (list.isEmpty() || list.get(list.size() - 1)[1] < interval[0]) {
                list.add(interval);
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], interval[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
