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
###### Code
```java
```

