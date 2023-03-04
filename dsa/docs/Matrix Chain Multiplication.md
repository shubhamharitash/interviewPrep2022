## Problem Statement
https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/

## Approaches
#### Approach 1
![[Matrix Chain Multiplication-1677770742038.jpeg]]
This problem introduces a new class of problem where we need to choose a **k** between given **i** and **j**.

###### Code
```java
static int[][] dp = new int[501][501];
public static int solve(int[] arr, int i, int j){
	if(i>=j)
		return 0;
	int res = Integer.MAX_VALUE;
	if(dp[i][j]!=0){
		return dp[i][j];
	}
	for(int k=i; k<j; k++){
		int temp = solve(arr, i, k) + solve(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
		res = Math.min(res, temp);
	}
	dp[i][j] = res;
	return dp[i][j];
}
static int matrixMultiplication(int N, int arr[])
{
	for(int i=0; i<dp.length; i++){
		Arrays.fill(dp[i], 0);
	}
	return solve(arr,1,N-1);
}
```