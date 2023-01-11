package searching.binarySearch.theory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q2_DescendingSortedBinarySearch {
    public static int reverseSortedBinarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] > key)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = IntStream.iterate(100, i -> i - 1).limit(100).toArray();
        System.out.println(reverseSortedBinarySearch(arr, 30));

        List<Integer> nums = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(Collections.binarySearch(nums, 30, (a, b) -> -a.compareTo(b)));
        System.out.println(Collections.binarySearch(nums, 30, Comparator.reverseOrder()));
    }
}
