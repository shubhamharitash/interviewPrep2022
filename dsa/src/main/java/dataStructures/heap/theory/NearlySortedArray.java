package dataStructures.heap.theory;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NearlySortedArray {
    public static ArrayList<Integer> nearlySorted(int arr[], int num, int k) {
        // your code here
        ArrayList<Integer> res = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            input.add(arr[i]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(input);
        res.add(pq.remove());
        for (int i = 1; i < arr.length - k; i++) {
            pq.add(arr[i + k]);
            res.add(pq.remove());
        }
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(nearlySorted(new int[]{6,5,3,2,8,10,9}, 7, 3));
    }
}
