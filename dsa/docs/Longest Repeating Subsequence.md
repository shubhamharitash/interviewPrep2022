## Problem Statement
https://www.geeksforgeeks.org/longest-repeating-subsequence/

## Approaches
#### Approach 1
![[Longest Repeating Subsequence-1677190103341.jpeg]]

###### Code
```java
public int LongestRepeatingSubsequence(String str1)
{
	int m = str1.length();
	int[][] dp = new int[m + 1][m + 1];
	for(int i=1; i<=m; i++){
		for(int j=1; j<=m; j++){
			if(i != j && str1.charAt(i-1) == str1.charAt(j-1)){
				dp[i][j] = 1 + dp[i-1][j-1];
			} else {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
	}
	return dp[m][m];
}
```