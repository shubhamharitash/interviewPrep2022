## Problem Statement
https://leetcode.com/problems/sort-array-by-increasing-frequency/description/

## Approaches
#### Approach 1
Similar to [[K Frequent Elements]]

###### Code
```java
class Solution {
    class Pair {
        int key;
        int val;

        public Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(e -> {
            if (map.containsKey(e)) {
                map.put(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
            }
        });
        List<Pair> input = new ArrayList<>();
        map.forEach((key, value) -> input.add(new Pair(value, key)));
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt((Pair a) -> a.key).thenComparingInt(a -> -a.val));
        pq.addAll(input);
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair element = pq.remove();
            res.addAll(Collections.nCopies(element.key, element.val));
        }
        return res.stream().mapToInt((Integer i) -> i).toArray();
    }
}
```