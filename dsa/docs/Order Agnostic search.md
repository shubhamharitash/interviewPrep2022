#### Problem Statement
We need to find an element in sorted array but we don't know if its sorted in ascending or descending order.

## Approaches
#### Approach 1
We find which sorting is there then apply the relevant binarySearch
1) pick mid and compare it with start and end element
	1) if `arr[start] < arr[mid]` or `arr[mid] < arr[end]` 
		1) its ascending else
		2) its descending
2)  apply the relevant binarySearch

```java
if(nums.get(0) < nums.get(1))  
    System.out.println(Collections.binarySearch(nums, 30));  
else  
    System.out.println(Collections.binarySearch(nums, 30, Comparator.reverseOrder()));
```