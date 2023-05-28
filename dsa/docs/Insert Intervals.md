## Problem Statement
https://leetcode.com/problems/insert-interval/description/

## Approaches
#### Approach 1
![[Insert Intervals-1684685202539.jpeg]]
[[Merge Intervals]] logic is used after inserting the interval.

###### Code
```java
class Solution {
    public static int[][] addNewIntervalMergeLogic(int[][] intervals, int[] newInterval){
        int[][] res = new int[intervals.length + 1][];
        boolean newIntervalInserted = false;
        int k = 0;
        for(int i=0; i<intervals.length; i++){
            if(newIntervalInserted || intervals[i][0] < newInterval[0]){
                res[k++] = intervals[i];
            } else {
                res[k++] = newInterval;
                res[k++] = intervals[i];
                newIntervalInserted = true;
            }
        }
        if(!newIntervalInserted)
            res[k++] = newInterval;
        return res;
    } 
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            int[][] res = new int[1][];
            res[0] = newInterval;
            return res;
        }
        intervals = addNewIntervalMergeLogic(intervals, newInterval);
        // Same code as merge intervals
        int[][] res = new int[intervals.length][];
        int[] temp = intervals[0];
        int k = 0;
        for(int i=1; i<intervals.length; i++){
            if(temp[1] >= intervals[i][0]){
                temp[1] = temp[1] > intervals[i][1] ? temp[1]:intervals[i][1];
                continue;
            }
            res[k++] = temp;
            temp = intervals[i];
        }
        res[k++] = temp;
        int[][] finalRes = new int[k][];
        for(int i=0; i<k; i++){
            finalRes[i] = res[i];
        }
        return finalRes;
    }
}
```