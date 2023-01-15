## Problem Statement
Find an element in unsorted array which is greater than both its neighbors. Here nums[-1] == nums[n] == $-\infty$. 
I/P: 10 20 15 2 23 90 67
O/P: either return 20 or 90

## Approaches
#### Approach 1
Condition to check mid
1) Check mid+1 and mid-1 element < mid element

Condition to move left or right
1) Validate with mid - 1 and mid+1 element, move to side which is greater

Validate for mid-1 and mid+1

###### Code
```java
public int findPeakElement(int[] arr) {
	int start = 0;
	int end = arr.length;
	while (start <= end) {
		int mid = start + (end - start) / 2;
		boolean midMinusOneInRange = !((mid - 1) < 0);
		boolean midPlusOneInRange = !((mid + 1) > (arr.length - 1));
		boolean validMidMinusOne = midMinusOneInRange && arr[mid - 1] < arr[mid];
		boolean validMidPlusOne = midPlusOneInRange && arr[mid + 1] < arr[mid];
		boolean bothMinusAndPlusInRange = midMinusOneInRange && midPlusOneInRange;
		boolean validBothMinusAndPlus = bothMinusAndPlusInRange && validMidMinusOne && validMidPlusOne;
		if (
				(validBothMinusAndPlus) ||
				(!midMinusOneInRange && !midPlusOneInRange) ||
				(!midPlusOneInRange && validMidMinusOne) ||
				(!midMinusOneInRange && validMidPlusOne)
		) {
			return mid;
		} else if (midMinusOneInRange && arr[mid - 1] > arr[mid]) {
			end = mid - 1;
		} else if (midPlusOneInRange && arr[mid + 1] > arr[mid]) {
			start = mid + 1;
		}
	}
	return -1;
}
```


#### Approach 2(OP Approach)
1) Check if mid > mid+1
	1) if yes 
		1) r = mid(mid is included since it is a possible answer)
	2) else
		1) l = mid + 1
2) Run loop `l<r` 

###### Code
```java
public int findPeakElement(int[] nums) {
	int l = 0, r = nums.length - 1;
	while (l < r) {
		int mid = (l + r) / 2;
		if (nums[mid] > nums[mid + 1])
			r = mid;
		else
			l = mid + 1;
	}
	return l;
}
```