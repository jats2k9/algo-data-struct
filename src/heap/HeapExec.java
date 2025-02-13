package heap;

import java.util.*;

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
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(Point::getDis).reversed());
        for (int i = 0; i < points.length; i++) {
            Point point = new Point(points[i][0], points[i][1], i);
            if (pq.size() < k) {
                pq.add(point);
                continue;
            }
            if (pq.peek().dis > point.dis) {
                pq.poll();
                pq.add(point);
            }
        }
        int[][] res = new int[k][2];
        int i = 0;

        Iterator<Point> iterator = pq.iterator();
        while (iterator.hasNext()) {
            Point point = iterator.next();
            res[i] = new int[] { point.x, point.y };
            i++;
        }
        return res;
    }

    class Point {
        int x;

        int y;

        int dis;

        int index;

        public Point(final int x, final int y, final int index) {
            this.x = x;
            this.y = y;
            this.dis = (x * x) + (y * y);
            this.index = index;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDis() {
            return dis;
        }

        public int getIndex() {
            return index;
        }
    }

    /**
     * top-k-frequent-elements
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        map.entrySet().forEach(e -> pq.add(e));
        return pq.stream().limit(k).mapToInt(e -> e.getKey()).toArray();
    }


    /**
     * TODO
     * find-k-pairs-with-smallest-sums
     */
}
