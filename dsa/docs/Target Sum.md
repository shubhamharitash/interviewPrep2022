## Problem Statement
https://leetcode.com/problems/target-sum/description/

## Approaches
#### Approach 1
![[Target Sum-1677007542969.jpeg]]

###### Code
```java
public int findTargetSumWays(int[] nums, int target) {
	int sum = Arrays.stream(nums).sum();
	if(target > sum || target < -sum)
		return 0;
	int[][] dp = new int[nums.length+1][2*sum+1];
	dp[0][sum] = 1;
	for(int i=1; i<=nums.length; i++){
		for(int j=0; j<=2*sum; j++){
			if(j >= nums[i-1]){
				dp[i][j] = dp[i][j] + dp[i-1][j-nums[i-1]];
			}
			if(j + nums[i-1] <= 2*sum){
				dp[i][j] = dp[i][j] + dp[i-1][j+nums[i-1]];
			}
		}
	}
	return dp[nums.length][sum + target];
}
```

#### Approach 2
![[Target Sum-1677007805553.jpeg]]
This problem -> [[Count Subsets With given difference]] -> [[Subset Problem]]

###### Code
```java

```