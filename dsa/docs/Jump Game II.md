## Problem Statement #ImpQuestionTwoPointer #mpQuestionGreedy
https://leetcode.com/problems/jump-game-ii/description/

## Approaches
#### Approach 1(DP)
Similar as [[Jump Game]]
Here we just make all comparisions and memoize to get intended result

###### Code
```java
class Solution {
    int[] dp;
    public int helper(int[] nums, int i){
        if(i == (nums.length-1))
            return 0;
        if(nums[i] + i >= (nums.length-1))
            return 1;
        if(dp[i]!=Integer.MAX_VALUE)
            return dp[i];
        for(int j=nums[i]; j>0; j--){
            dp[i+j] = helper(nums, i+j);
            if(dp[i+j]!=-1){
                dp[i] = Math.min(dp[i], 1+dp[i+j]);
            }
        }
        return dp[i]==Integer.MAX_VALUE?-1:dp[i];
    }
    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return helper(nums, 0);
    }
}
```

#### Approach 2(Two pointer approach)
![[Jump Game II-1679828657720.jpeg]]
Since we already know there exists a path to reach the end, here we use two pointer with greedy approach to keep track of maximum distance travelled and using that to make the jump. If we are already at the end according to our logic we would never make jump again.

###### Code
```java
class Solution {
    public int jump(int[] nums) {
        int curEnd = 0,curFar = 0;
        int res = 0;
        for(int i=0; i<nums.length-1; i++){
            curFar = Math.max(i + nums[i], curFar);
            if(i==curEnd){
                res++;
                curEnd = curFar;
            }
        }
        return res;
    }
}
```