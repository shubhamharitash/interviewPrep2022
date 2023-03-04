## Problem Statement
https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/

## Approaches
#### Approach 1
![[Min number of operations-1677185732841.jpeg]]
(m - LCS) + (n - LCS)

###### Code
```java
public int minOperations(String str1, String str2) 
{ 
	int m = str1.length();
	int n = str2.length();
	int[][] dp = new int[m+1][n+1];
	for(int i=1;i<=m;i++){
		for(int j=1;j<=n;j++){
			if(str1.charAt(i-1) == str2.charAt(j-1)){
				dp[i][j] = 1 + dp[i-1][j-1];
			} else {
				dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
	}
	return (m - dp[m][n]) + (n - dp[m][n]);
} 
```