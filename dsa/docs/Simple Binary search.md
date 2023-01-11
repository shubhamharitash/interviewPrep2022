#### Using for int[]
```java
System.out.println(Arrays.binarySearch(arr, 20));
```

#### Using for `List<Integer>`
```java
System.out.println(Collections.binarySearch(nums, 20));
```
Has support for both listing implementing comparable or for supplying custom comparator.

#### Using custom
```java
public static int binarySearch(int[] arr, int key) {  
    int start = 0;  
    int end = arr.length - 1;  
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
```
