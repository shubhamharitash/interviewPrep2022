#### Problem
Array is reverse sorted, perform binary search on it.

#### Solution
Every thing is same as normal binary search, only comparision logic is reversed.

###### Using own implementation
```java
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
```

###### Using inbuilt functionality
```java
System.out.println(Collections.binarySearch(nums, 30, (a, b) -> -a.compareTo(b)));

System.out.println(Collections.binarySearch(nums, 30, Comparator.reverseOrder());

System.out.println(Collections.binarySearch(nums, 30, Comparator.reverseOrder()));
```
