package dataStructures.heap.theory;


import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    class Pair {
        int key;
        int[] point;

        public Pair(int key, int[] point) {
            this.key = key;
            this.point = point;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(e -> -e.key));
        for (int[] point : points) {
            if (pq.size() < k) {
                pq.add(new Pair((int) Math.pow(point[0], 2) + (int) Math.pow(point[1], 2), point));
            } else {
                pq.add(new Pair((int) Math.pow(point[0], 2) + (int) Math.pow(point[1], 2), point));
                pq.remove();
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove().point;
        }
        return res;
    }
}
