package sliding.window;

import java.util.HashMap;

public class SlidingWindow {

    /**
     * https://leetcode.com/problems/fruit-into-baskets/description/
     */
    public int totalFruit(int[] fruits) {
        int tail = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int head = 0; head < fruits.length; head++) {
            map.compute(fruits[head], (_, v) -> v == null ? 1 : v + 1);
            if (map.size() >= 3) {
                if (map.get(fruits[tail]) == 1) {
                    map.remove(fruits[tail]);
                } else {
                    map.compute(fruits[tail], (_, v) -> v - 1);
                }
                tail++;
            }
            if (max < (head - tail + 1)) {
                max = (head - tail + 1);
            }
        }
        return max;
    }


    /**
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/
     */
    public int lengthOfLongestSubstring(String s) {
        int tail = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int head = 0; head < chars.length; head++) {
            if (map.containsKey(chars[head])) {
                if (map.get(chars[head]) >= tail) {
                    tail = map.get(chars[head]) + 1;
                }
                map.remove(chars[head]);
            }
            map.put(chars[head], head);
            if (max < (head - tail + 1)) {
                max = (head - tail + 1);
            }
        }
        return max;
    }
}
