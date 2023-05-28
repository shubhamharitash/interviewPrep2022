## Problem Statement
https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&id=top-interview-150

## Approaches
#### Approach 1
Using map, Two Pointer
Map keeps track of duplicates, pointers are used to decide where element needs to be placed according to logic

###### Code
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int[] map = new int[201];
        for(int i=0; i<nums.length; i++){
            map[100 + nums[i]]++;
        }
        int k=0;
        for(int i=0; i<nums.length; i++){
            if(map[100 +nums[i]]!=0){
                nums[k++] = nums[i];
                map[100 +nums[i]] = 0;
            }
        }
        return k;
    }
}
```