## Problem Statement
We need to compute the position of an element in infinite sorted array.

## Approaches
#### Approach 1
1) Compute start and end using doubling trick
	1) initially start =0 end = 1
		1) if arr[end] < target
			1) start = end + 1
			2) end = end*2
		2) else
			1) apply binary search

#### Approach 2(when ram is limited or insufficient)
1) Calculate start and end as in Approach 1
2) apply binary search in chunks of determined fixed size

