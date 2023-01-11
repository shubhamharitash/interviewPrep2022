#### Problem statement
Find first and last occurence of an element in array

## Approaches
#### Approach 1
For mid logic is changed
1) We store the result if its equal and keep searching for first or last occurence
```java
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
```

```java
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
```