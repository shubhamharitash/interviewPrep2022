package dataStructures.heap.theory;

import java.util.*;

class Pair {
    int key;
    int val;

    public Pair(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class TopKFrequentElements {
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
