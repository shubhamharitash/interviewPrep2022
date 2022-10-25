package ch7.questions;

import java.util.Arrays;
import java.util.Scanner;

public class Ch7_Q16_ExecutionTime {
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static int[] generateNRandomIntegersInRange(int start, int end, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (end - start) + start);
        }
        return arr;
    }

    public static int generateKey(int start, int end) {
        return (int) (Math.random() * (end - start) + start);
    }

    public static void main(String[] args) {
        int[] arr = generateNRandomIntegersInRange(1, (int) 1e8, (int) 1e8);
        int key = generateKey(1, (int) 1e8);

        long startTime = System.currentTimeMillis();
        Arrays.parallelSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by parallel sort:" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        System.out.println(linearSearch(arr, key));
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by linear search:" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        System.out.println(binarySearch(arr, key));
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by binary search:" + (endTime - startTime));
    }
}
