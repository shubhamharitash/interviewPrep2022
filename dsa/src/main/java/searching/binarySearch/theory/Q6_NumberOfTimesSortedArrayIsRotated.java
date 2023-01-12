package searching.binarySearch.theory;

import java.util.stream.IntStream;

public class Q6_NumberOfTimesSortedArrayIsRotated {
    public static int computePivot(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int prev = (mid + arr.length - 1) % arr.length;
            if (arr[prev] > arr[mid])
                return mid;
            else if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] nums = IntStream.range(0, 10).toArray();
        System.out.println(computePivot(nums));
    }
}
