[Link](https://www.geeksforgeeks.org/check-if-any-two-intervals-overlap-among-a-given-set-of-intervals/)

## Approaches
#### Approach 1($O(nlog(n))$)
**Input:**  arr[] = {{1, 3}, {5, 7}, {2, 4}, {6, 8}}
1) Insert set into list such that list always remains sorted with start time.
2) Check if arr[i - 1].end > arr[i].start

**Optimization**
How to color so that we have information for next insert
ans: array can be used. If element size is small it will be a hoge optimization over above  approach

						start...............end
**start...............end**    ==start...............end    start...............end==    **start...............end**

Lets think this set as that area is colored on the number line and you can't color the portion which already has color.

{1, 3} | {5, 7}, {2, 4}, {6, 8}
{1, 3} {5, 7} | {2, 4}, {6, 8}
{1, 3} {5, 7} | {6, 8}
{1, 3} {5, 7} | 

{1, 3} {5, 7} {7, 10}