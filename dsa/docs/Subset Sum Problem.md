## Problem Statement
https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

## Approaches
#### Approach 1
![[Subset Sum Problem-1676822215032.jpeg]]

###### Code
```java
static Boolean isSubsetSum(int n, int arr[], int sum){
	// code here
	boolean[][] dp = new boolean[n+1][sum+1];
	for(int i=0;i<=n;i++){
		dp[i][0] = true;
	}
	for(int i=1; i<=n; i++){
		for(int j=1; j<=sum; j++){
			if(j>=arr[i-1])
				dp[i][j] = dp[i-1][j-arr[i-1]];
			dp[i][j] = dp[i][j] || dp[i-1][j];
		}
	}
	return dp[n][sum];
}
```