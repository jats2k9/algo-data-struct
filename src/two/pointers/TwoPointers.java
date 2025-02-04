package two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoPointers {
    /**
     * https://leetcode.com/problems/container-with-most-water/
     */
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = Math.min(height[start], height[end]) * (end - start);

        while (start < end) {
            int curr = Math.min(height[start], height[end]) * (end - start);
            if (curr > maxArea)
                maxArea = curr;
            if (height[start] < height[end])
                start++;
            else
                end--;
        }
        return maxArea;
    }


    /**
     * https://leetcode.com/problems/two-sum/
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            Integer index = map.get(complement);
            if (index != null && index != i) {
                return new int[]{index, i};
            } else {
                map.put(nums[i], i);
            }
        }
        //sorted solution
//        int i = 0;
//        int j = nums.length - 1;
//        Arrays.sort(nums);
//
//        while (i < j) {
//            int sum = nums[i] + nums[j];
//            if (sum == target)
//                return new int[]{i, j};
//            if (sum > target) {
//                j--;
//            } else {
//                i++;
//            }
//        }
        return new int[0];
    }

    /**
     * https://leetcode.com/problems/3sum/
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    do {
                        j++;
                    } while (j < k && nums[j] == nums[j - 1]);
                }
            }
        }
        return result;
    }

    /**
     * https://leetcode.com/problems/move-zeroes/description/
     */
    // [1,0]
    // head = 0
    // tail = 0
    public void moveZeroes(int[] nums) {
        int tail = 0;
        int head = 0;

        while (head < nums.length) {
            while (head < nums.length && nums[head] == 0) {
                head++;
            }
            if (head >= nums.length) return;
            int temp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = temp;
            tail++;
            head++;
        }
    }

    /**
     * https://leetcode.com/problems/linked-list-cycle/
     */
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode tail = head;
        head = head.next;
        while (head != null) {
            head = head.next;
            if (head != null) {
                head = head.next;
            }
            if (tail != null) {
                tail = tail.next;
            }
            if (tail == head)
                return true;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
