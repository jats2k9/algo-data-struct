package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class HeapExec {

    /**
     * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
     * No sorting solution, can also be done with MaxHeap.
     */
    public int findKthLargest(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        int[] count = new int[max - min + 1];
        Arrays.stream(nums).forEach(i -> count[i - min]++);
        int index = k;
        for (int i = count.length - 1; i >= 0; i--) {
            index -= count[i];
            if (index <= 0) {
                return i + min;
            }
        }
        return -1;
    }

    /**
     * https://leetcode.com/problems/k-closest-points-to-origin/description/
     */
    public int[][] kClosest(int[][] points, int k) {
        Double [] dists = new Double[points[0].length];

        for (int i = 0; i < points[0].length; i++) {
            double dist = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            dists[i] = dist;
        }

        return new int[][]{};
    }
}
