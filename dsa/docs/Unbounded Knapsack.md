## Problem Statement
https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/

## Approaches
#### Approach 1
![[Unbounded Knapsack-1677085693376.jpeg]]

###### Code
```java
static int knapSack(int N, int W, int val[], int wt[])
{
	int[][] dp = new int[N+1][W+1];
	for(int i=1; i<=N; i++){
		for(int j=1; j<=W; j++){
			if(j>=wt[i-1]){
				dp[i][j] = val[i-1] + dp[i][j - wt[i-1]];
			}
			dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
		}
	}
	return dp[N][W];
}
```