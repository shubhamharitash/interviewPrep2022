## Problem Statement
We need to find an element in sorted rotated array.
I/P: 11 12 15 18 2 5 6 8
target 6
ans: 6

## Approaches
#### Approach 1
1) Find pivot
2) if pivot at 0th element, simple binary sort
3) else if arr[0] < target
	1) apply binarySearch(arr, 0, pivot-1, target)
4) else if arr[0] == target
	1) return 0
5) else
	1) apply binarySearch(arr, pivot, arr.length - 1, target)

###### Code
```java
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
```

