## Problem Statement
https://leetcode.com/problems/wiggle-subsequence/description/

## Approaches
#### Approach 1
![[Wiggle Subsequence-1680389185239.jpeg]]

###### Code
```java
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int size=nums.length, peak=1, valley=1;
        for(int i=1; i<size; ++i){
			if(nums[i]>nums[i-1]) 
				peak = valley + 1;
            else if(nums[i]<nums[i-1]) 
	            valley = peak + 1;
        }
        return Math.max(peak , valley );
    }
}
```