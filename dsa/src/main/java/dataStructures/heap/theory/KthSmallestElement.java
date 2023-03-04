package dataStructures.heap.theory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // capacity is not limited
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(3, Comparator.reverseOrder());
        Arrays.stream(arr).forEach(e -> {
            if (priorityQueue.size() < 3) {
                priorityQueue.add(e);
            } else {
                priorityQueue.add(e);
                priorityQueue.remove();
            }
        });
        System.out.println(priorityQueue.peek());
    }
}
