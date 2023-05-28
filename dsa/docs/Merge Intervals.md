## Problem Statement
https://leetcode.com/problems/merge-intervals/

## Approaches
#### Approach 1
![[Merge Intervals-1684680409553.jpeg]]

###### Code
```java
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
        int[][] res = new int[intervals.length][intervals[0].length];
        int[] temp = intervals[0];
        int k=0;
        for(int i=1; i<intervals.length; i++){
            if(temp[1] >= intervals[i][0]){
                temp[1] = temp[1] > intervals[i][1] ? temp[1]:intervals[i][1];
                continue;
            }
            res[k++] = temp;
            temp = intervals[i];
        }
        res[k++] = temp;
        int[][] finalRes = new int[k][2];
        while(--k>=0){
            finalRes[k] = res[k];
        }
        return finalRes;
    }
}
```