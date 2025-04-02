package Stacks;

import java.util.*;

public class StacksExec {

    /** TODO
     * largest-rectangle-in-histogram
     */
    public int largestRectangleArea(int[] heights) {

        return 0;
    }

    /**
     * https://leetcode.com/problems/daily-temperatures/
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int t = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] <= t) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                answer[i] = stack.peek()[1] - i;
            }
            stack.push(new int[]{t, i});
        }
        return answer;
    }

    /**
     * https://leetcode.com/problems/next-greater-element-i/
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) stack.pop();

            if (stack.isEmpty())
                map.put(nums2[i], -1);
            else
                map.put(nums2[i], stack.peek());

            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.get(nums1[i]);

        return nums1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new StacksExec().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }


}
