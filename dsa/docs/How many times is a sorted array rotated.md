## Problem Statement
How many times a sorted array is rotated
eg
sorted array: 2 5 6 8 11 12 15 18
I/P -> rotated array: 11 12 15 18 2 5 6 8
O/P -> 4
> Here 4 rotations are done in clockwise direction

## Approaches
#### Approach 1
| 2   | 5   | 6   | 8   | 11  | 12  | 15  | 18  |
|:--- | --- | --- | --- | --- | --- | --- | --- |
| 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7    |

| 11  | 12  | 15  | 18  | 2  | 5   | 6   | 8  |
|:--- | --- | --- | --- | --- | --- | --- | --- |
| 0   | 1   | 2   | 3   | ==4==   | 5   | 6   | 7   |

Number of rotations == index of smallest element
Thus, We find index of smallest element(**Our PIVOT**)

Things we need to figure out
1) At once we get to know that **element** at **mid** is **minimum** or not.
	1) if(arr[mid-1] > arr[mid])
		1) return mid;
	2) instead of mid -1 we can do mid + N - 1 so thaqt we do not need to add a check for mid - 1. It is also more logically correct according to circular sorted array. 
2) some factor which decides where to go (left or right)
	1) if arr[mid] > arr[end]
		1) start = mid+1
	2) else 
		1) end = mid -1
###### Code
Using mid - 1
```java
public static int computePivot(int[] arr) {  
    int low = 0;  
    int high = arr.length - 1;  
    while (low <= high) {  
        int mid = low + (high - low) / 2;  
        if (mid - 1 >= 0 && arr[mid - 1] > arr[mid])  
            return mid;  
        else if (arr[mid] > arr[high]) {  
            low = mid + 1;  
        } else  
            high = mid - 1;  
    }  
    return 0;  
}
```

Using modulo logic
```java
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
```