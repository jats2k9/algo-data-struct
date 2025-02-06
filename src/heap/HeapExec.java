package heap;

import java.util.Arrays;

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
}
