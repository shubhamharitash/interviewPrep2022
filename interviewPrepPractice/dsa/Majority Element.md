## Problem Statement
https://leetcode.com/problems/majority-element/?envType=study-plan-v2&id=top-interview-150
#ImportantQuestionAdhoc

## Approaches
#### Approach 1(Voting method)
![[Majority Element-1683574333022.jpeg]]

###### Code
```java
class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int candidate = 0;
        for(int num:nums){
            if(cnt==0)
                candidate = num;
            // This line helps flip potential candidates
            cnt += candidate == num ? 1:-1;
        }
        return candidate;
    }
}
```