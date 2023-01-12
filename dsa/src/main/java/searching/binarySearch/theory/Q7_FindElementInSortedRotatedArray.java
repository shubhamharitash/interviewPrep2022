package searching.binarySearch.theory;

public class Q7_FindElementInSortedRotatedArray {
    public static int binarySearch(int[] arr, int start, int end, int key) {
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

    public int search(int[] nums, int key) {
        int pivot = computePivot(nums);
        // System.out.println(pivot);
        if(pivot == 0)
            return binarySearch(nums, 0, nums.length - 1, key);
        if(nums[0] < key)
            return binarySearch(nums, 0, pivot - 1, key);
        else if(nums[0] == key)
            return 0;
        else
            return binarySearch(nums, pivot, nums.length - 1, key);
    }
    public static void main(String[] args) {

    }
}
