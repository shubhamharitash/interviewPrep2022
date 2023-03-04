## Problem Statement
https://leetcode.com/problems/partition-equal-subset-sum/

## Approaches
#### Approach 1
![[Equal Sum Parition-1676826765282.jpeg]]

###### Code
```java
class Solution {
    public boolean subsetSumProblem(int[] nums, int sum){
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        for(int i=0; i<nums.length; i++){
            dp[i][0] = true;
        }
        for(int i=1; i<=nums.length; i++){
            for(int j=1; j<=sum; j++){
                if(j>=nums[i-1]){
                    dp[i][j] = dp[i-1][j-nums[i-1]];
                }
                dp[i][j] = dp[i-1][j] || dp[i][j];
            }
        }
        return dp[nums.length][sum];
    }
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        return sum%2!=0 ? false : subsetSumProblem(nums, sum/2);
    }
}
```