## Problem Statement
https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/

## Approaches
#### Approach 1
n - longestPalindromeSubseq will give us req deletions 

###### Code
```java
public int lcs(String s1, String s2){
	int m = s1.length();
	int n = s2.length();
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
	return dp[m][n];
}
public int longestPalindromeSubseq(String s) {
	String s1 = s;
	String s2 = (new StringBuilder(s)).reverse().toString();
	return lcs(s1, s2);
}
int minDeletions(String str, int n)
{
	return n - longestPalindromeSubseq(str);
}
```