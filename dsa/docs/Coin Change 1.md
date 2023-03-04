## Problem Statement
All possible ways to perform a coin change for a given sum.

## Approaches
#### Approach 1
for 0 sum, possible way = 1
for rest, simple [[Unbounded Knapsack]] logic is applied.

###### Code
```java
public long count(int coins[], int N, int sum) {
	long[][] dp = new long[N+1][sum+1];
	dp[0][0] = 1;
	for(int i=1; i<=N; i++){
		for(int j=0; j<=sum; j++){
			if(j>=coins[i-1]){
				dp[i][j] = dp[i][j-coins[i-1]];
			}
			dp[i][j] = dp[i-1][j] + dp[i][j];
		}
	}
	return dp[N][sum];
}
```