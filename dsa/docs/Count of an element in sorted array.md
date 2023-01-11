## Problem Statement
Calculate count of an element in sorted array

## Approaches
#### Approach 1
1) Find first and last occurence
2) last - first + 1

###### Code
```java
public class Q5_CountOfAnElement {  
    public static int firstOccurence(int[] arr, int key) {  
        int start = 0;  
        int end = arr.length - 1;  
        int res = -1;  
        while (start <= end) {  
            int mid = start + (end - start) / 2;  
            if (arr[mid] < key)  
                start = mid + 1;  
            else if (arr[mid] == key) {  
                res = mid;  
                end = mid - 1;  
            } else  
                end = mid - 1;  
        }  
        return res;  
    }  
  
    public static int lastOccurence(int[] arr, int key) {  
        int start = 0;  
        int end = arr.length - 1;  
        int res = -1;  
        while (start <= end) {  
            int mid = start + (end - start) / 2;  
            if (arr[mid] < key)  
                start = mid + 1;  
            else if (arr[mid] == key) {  
                res = mid;  
                start = mid + 1;  
            } else  
                end = mid - 1;  
        }  
        return res;  
    }  
  
    public static void main(String[] args) {  
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};  
        System.out.println(lastOccurence(arr, 8) - firstOccurence(arr, 8) + 1);  
    }  
}
```

