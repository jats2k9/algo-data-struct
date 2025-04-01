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

    /**
     * https://leetcode.com/problems/median-of-two-sorted-arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        int[] merged = new int[nums1.length + nums2.length];
        int a = 0;
        int b = 0;
        int index = 0;
        while (a < nums1.length && nums2.length > b) {
            merged[index] = Math.min(nums1[a], nums2[b]);
            if (merged[index] == nums1[a]) {
                a++;
            } else {
                b++;
            }
            index++;
        }
        while (a < nums1.length) {
            merged[index] = nums1[a];
            a++;
            index++;
        }
        while (nums2.length > b) {
            merged[index] = nums2[b];
            b++;
            index++;
        }
        if (merged.length % 2 == 1) {
            return merged[merged.length / 2];
        } else {
            return (merged[merged.length / 2] + merged[(merged.length / 2) - 1]) / 2.0;
        }
    }
}
