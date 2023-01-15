## Problem Statement
Element need to be search in a bitonic array

## Approaches
#### Approach 1
1) find bitonic element
2) perform 
	1) bs(arr, 0, index, key)
	2) bs(arr, index, end-1, key)
3) if key found return index else return -1
