## Problem Statement
https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/

## Approaches
#### Approach 1
Similar to [[Coin Change 1]]
Here, we just needed to count the minimum number of coins needed to form the required sum.
We also needed a way to check if a possible demonition is possible, for that we used Integer.MAX_VALUE

###### Code
```java
public int minCoins(int[] coins, int n, int sum) {
	int[][] dp = new int[n + 1][sum + 1];
	for (int i = 0; i <= n; i++) {
		Arrays.fill(dp[i], Integer.MAX_VALUE);
		dp[i][0] = 0;
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= sum; j++) {
			if (j >= coins[i - 1] && dp[i][j - coins[i - 1]] != Integer.MAX_VALUE) {
				dp[i][j] = dp[i][j - coins[i - 1]] + 1;
			}
			dp[i][j] = Math.min(dp[i - 1][j], dp[i][j]);
		}
	}
	return dp[n][sum] != Integer.MAX_VALUE ? dp[n][sum] : -1;
}
```