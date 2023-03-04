## Problem Statement
https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

## Note
01 knapsack represents a class of dp problems where and element will be included or not be included in the choice.

## Approaches
#### Approach 1(Simple recursion)
![[01 KnapSack-1676818155524.jpeg]]

###### Code
```java
public static int helper(int W, int wt[], int val[], int n){
	if(n==0 || W == 0)
		return 0;
	// if(dp[n][W]!=-1)
	//     return dp[n][W];
	int choice1 = 0;
	int choice2 = 0;
	if(W >= wt[n-1])
		choice1 = helper(W - wt[n-1], wt, val, n-1) + val[n-1];
	choice2 = helper(W, wt, val, n-1);
	return Math.max(choice1, choice2);
}
```

#### Approach 2(Memoization)
![[01 KnapSack-1676818222115.jpeg]]

###### Code
```java


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int[][] dp = new int[1001][1001];
    public static int helper(int W, int wt[], int val[], int n){
        if(n==0 || W == 0)
            return 0;
        if(dp[n][W]!=-1)
            return dp[n][W];
        int choice1 = 0;
        int choice2 = 0;
        if(W >= wt[n-1])
            choice1 = helper(W - wt[n-1], wt, val, n-1) + val[n-1];
        choice2 = helper(W, wt, val, n-1);
        dp[n][W] = Math.max(choice1, choice2);
        return dp[n][W];
    }
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(W,wt,val,n);
    } 
}
```

#### Approach 3(Top Down)
![[01 KnapSack-1676818262197.jpeg]]

###### Code
```java
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int[][] dp = new int[n+1][W+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=W; j++){
                if(j>=wt[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]] + val[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    } 
}
```