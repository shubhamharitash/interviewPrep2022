package searching.binarySearch.theory;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q1_BinarySearch {
    public static int binarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = IntStream.range(1, 100).toArray();
        // On simple arr
        System.out.println(Arrays.binarySearch(arr, 20));
        // Using custom
        System.out.println(binarySearch(arr, 34));
    }
}
