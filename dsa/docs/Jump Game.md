## Problem Statement
https://leetcode.com/problems/jump-game/description/

## Approaches
#### Approach 1(DP)
At ith index, we check for route from all possible indexes through the jump value.
We optimize time complexity using memoization.

###### Code
```java
class Solution {
    int[] dp;
    public boolean helper(int[] nums, int i){
        if(nums[i] + i >= (nums.length-1))
            return true;
        if(dp[i]!=-1)
            return dp[i]==1;
        for(int j=1; j<=nums[i]; j++){
            dp[i+j] = helper(nums, i+j)==false? 0:1;
            if(dp[i+j]==1){
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = 0;
        return false;
    }
    public boolean canJump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0);
    }
}
```

#### Approach 2(Greedy)
Here we build our answer from last index.
Using while loop we keep on validating for curr and if valid reduce its value.
if curr become 0, it is indicative of the fact that we can reach the last index from 0th index 😄

###### Code
```java
class Solution {
    public boolean canJump(int[] nums) {
        int i=nums.length,curr=nums.length-1;
        while(i-- > 1 ){
            if((i-1)+nums[i-1]<curr) continue;
            curr=i-1;
        }
        return curr==0;
    }
}
```