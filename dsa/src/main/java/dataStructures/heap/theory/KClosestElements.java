package dataStructures.heap.theory;

import java.util.*;
import java.util.stream.Collectors;

public class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Comparator<Integer> comp = Comparator.comparingInt((Integer a) -> Math.abs(a - x)).thenComparingInt(a -> a);
        List<Integer> input = Arrays.stream(arr).boxed().collect(Collectors.toList());
        PriorityQueue<Integer> pq = new PriorityQueue<>(comp);
        pq.addAll(input);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.remove());
        }
        return res;
    }
}
