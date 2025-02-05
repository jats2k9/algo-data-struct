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
}
