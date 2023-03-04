package dataStructures.heap.theory;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SumOfElements {
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2) {
        // Your code goes here
        K1++;
        K2--;
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            pq.add(A[i]);
            if (pq.size() > K2) {
                pq.remove();
            }
        }
        long sum = 0;
        for (int i = 0; i < K2 - K1 + 1; i++) {
            sum += pq.remove();
        }
        return sum;
    }
}
