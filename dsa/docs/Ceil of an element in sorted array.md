## Problem Statement
Compute floor(element > or == to given target) of target in sorted array

## Approaches
#### Approach 1
Here we just perform normal binary search where we keep the ans for every element > target
###### Code
```java
public static int findCeil(long arr[], int n, long x){
	int start = 0;
	int end = n - 1;
	int res = -1;
	while(start<=end){
		int mid = start + (end - start)/2;
		if(arr[mid] == x)
			return mid;
		else if(arr[mid] < x){	
			start = mid + 1;
		} else {
			res = mid;
			end = mid - 1;
		}
	}
	return res;
}