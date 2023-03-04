## Problem Statement
https://practice.geeksforgeeks.org/problems/rod-cutting0840/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

## Approaches
#### Approach 1
Unbounded knapsack can be applied directly [[Unbounded Knapsack]]

###### Code
```java
public int cutRod(int price[], int N) {
	int[][] dp = new int[N+1][N+1];
	for(int i=1; i<=N; i++){
		for(int j=1; j<=N; j++){
			if(j>=i){
				dp[i][j] = price[i-1] + dp[i][j - i];
			}
			dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
		}
	}
	return dp[N][N];
}
```