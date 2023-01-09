package sorting.questions;

import java.util.Arrays;

public class Q9_MissingElementsOfRange {
    public static int findLow(int[] arr, int key, int start, int end) {
        if (key < arr[0]) return 0;
        if (key > arr[arr.length - 1]) return arr.length;
        if (start > end)
            return start;

        int mid = start + (end - start) / 2;
        if (arr[mid] == key) return mid;
        if (arr[mid] < key) {
            if (mid + 1 < end && arr[mid + 1] >= key) return mid + 1;
            return findLow(arr, key, mid + 1, end);
        } else {
            if (mid - 1 >= start && arr[mid - 1] < key) return mid;
            return findLow(arr, key, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 14, 11, 51, 15};
        Arrays.sort(arr);
        int low = 50, high = 55;
        int index = findLow(arr, low, 0, arr.length - 1);
        int x = low;
        while (index < arr.length && x <= high) {
            if (arr[index] != x) {
                System.out.println(x + "");
            } else
                index++;
            x++;
        }
        while (x <= high) {
            System.out.println(x + " ");
            x++;
        }
    }
}
