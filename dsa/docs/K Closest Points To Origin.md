## Problem Statement
https://leetcode.com/problems/k-closest-points-to-origin/description/

## Approaches
#### Approach 1
here key is distance from origin.

###### Code
```java
class Solution {
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
```