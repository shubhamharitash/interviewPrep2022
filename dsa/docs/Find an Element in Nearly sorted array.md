## Problem Statement
Element need to be found in nearly sorted array where $i^{th}$ element in its sorted version can be at $i^{th} - 1$ or $i^{th} + 1$.
Eg:
					I/P: 5 10 30 20 40
sorted version : 5 10 20 30 40
key: 30

## Approaches
#### Approach 1
1) Similar to a binary search, for mid we check $i^{th}$, $i^{th} -1$ and $i^{th} + 1$ element 
2) if not found then if arr[mid] < key then start = mid + 1 else end = mid -1

###### Code
```java
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
            start = mid + 1;  
        else  
            end = mid - 1;  
    }  
    return -1;  
}
```

