## Problem Statement
Given a sorted array and a target, we need to compute the element whose absolute difference with target is minimum

## Approaches
#### Approach 1(Best Approach)
if key is present -> perform bs
if key is not present
1) perform bs
2) compute min(abs(arr[low], x), abs(arr[high], x))
> Why we can do 2?

cause after binary search is completed below will happen
| 1   | 3   | 8   | 10   | 15  |
| --- | --- | --- | ---- | --- |
|     |     |     | high | low    |

#### Approach 2
if key is present -> perform bs
if key is not present
1) compute floor
2) compute ceil
3) compute min(abs(floor, x), abs(ceil, x))

#### Approach 3
key = 5
| 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   | 10  |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 4   | 3   | 2   | 1   | 0   | 1   | 2   | 3   | 4   | 5   |

We can see this question as computing the pivot is smaller than both left hand element and right hand element
1) Where mid+1 and mid -1 are within start and end range
	1) arr[mid+1] > abs(arr[mid]) && arr[mid-1] > abs(arr[mid])
		1) return mid
	2) if arr[mid] > arr[mid + 1]
		1) start = mid + 1
	3) else if arr[mid] < arr[mid + 1]
		1) end = mid -1
2) When mid - 1 < start
	1) arr[mid+1] > abs(arr[mid])
		1) return mid
	2) else 
		1) start = mid + 1
3) When mid + 1 > end
	1) arr[mid-1] > abs(arr[mid])
		1) return mid
	2) end = mid -1
4) if end - start == 1
	1) return mid

