package searching.binarySearch.theory;

public class Q8_FindElementInNearlySortedArray {
    public static int binarySearchNearlySorted(int[] arr, int start, int end, int key) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key)
                return mid;
            else if (mid - 1 > 0 && arr[mid - 1] == key)
                return mid - 1;
            else if (mid + 1 < arr.length && arr[mid + 1] == key)
                return mid + 1;
            else if (arr[mid] < key)
                start = mid + 2;
            else
                end = mid - 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 10, 30, 20, 40};
        System.out.println(binarySearchNearlySorted(arr, 0, arr.length - 1, 20));
    }
}
