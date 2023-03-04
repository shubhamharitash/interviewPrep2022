package dataStructures.heap.theory;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KLargestElements {
    public static int[] kLargest(int[] arr, int n, int k) {
        //min-heap
        PriorityQueue<Integer> pq = Arrays.stream(arr).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        while (pq.size() > k) {
            pq.remove();
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(kLargest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 9, 3)));
    }
}
