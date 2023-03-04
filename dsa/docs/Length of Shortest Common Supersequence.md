## Problem Statement
https://www.geeksforgeeks.org/shortest-common-supersequence/

## Approaches
#### Approach 1
LCS elements would always be there. If we make worst supersequence, it will have 2x lcs elements. so we subtract that from m + n to get our ans.

###### Code
```java
public static int shortestCommonSupersequence(String s1,String s2,int m,int n)
{
	int[][] dp = new int[m+1][n+1];
	for(int i=1; i<=m; i++){
		for(int j=1; j<=n; j++){
			if(s1.charAt(i-1) == s2.charAt(j-1)){
				dp[i][j] = 1 + dp[i-1][j-1];
			} else {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
	}
	return m + n - dp[m][n];
}
```