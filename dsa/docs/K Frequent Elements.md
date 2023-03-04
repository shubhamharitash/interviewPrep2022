## Problem Statement

## Approaches
#### Approach 1
1) Construct a map with value <ele, freq>
2) Construct List

###### Code
```java
class Pair {
    int key;
    int val;

    public Pair(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
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
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a.key));
        pq.addAll(input);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove().val;
        }
        return res;
    }
}
```