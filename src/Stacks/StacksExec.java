package Stacks;

import java.util.*;

public class StacksExec {

    /**
     * TODO
     * largest-rectangle-in-histogram
     */

    /**
     * https://leetcode.com/problems/daily-temperatures/
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();


        ArrayDeque<Integer> q = new ArrayDeque<>();


        return null;
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
        System.out.println(Arrays.toString(new StacksExec().nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
    }


}
