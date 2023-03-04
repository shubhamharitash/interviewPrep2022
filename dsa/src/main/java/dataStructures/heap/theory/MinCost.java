package dataStructures.heap.theory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinCost {
    long minCost(long[] arr, int n) {
        List<Long> input = new ArrayList<>();
        Arrays.stream(arr).forEach(input::add);
        PriorityQueue<Long> pq = new PriorityQueue<>(input);
        long res = 0;
        while (pq.size() > 1) {
            long val1 = pq.remove();
            long val2 = pq.remove();
            pq.add(val1 + val2);
            res += (val1 + val2);
        }
        return res;
    }
}
