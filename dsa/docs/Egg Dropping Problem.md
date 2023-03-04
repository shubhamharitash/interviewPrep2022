## Problem Statement
https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/

## Approaches
#### Approach 1
Base Condition
1) if `n==1`, then we will have to perform `j-i+1` max attempts
2) if `i>j` this means we are trying to attempt for already known floor result. Thus 0 attempts required for such input.(Analogous to 0 floor condition)
3) if `i==j` this means we only have to check for one floor. Hence 1 attempt is only required.

Loop
i->1
j->k
k->i till j-1

###### Code
```java
class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    public static int[][] dp = new int[201][201];
    public static int solve(int n, int i, int j){
        if(i>j){
            return 0;
        }
        if(n==1){
            return j-i+1;
        }
        if(i==j){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int res = Integer.MAX_VALUE-1;
        for(int k=i; k<j; k++){
            int ans1 = solve(n-1, i, k-1) + 1;
            int ans2 = solve(n, k+1, j) + 1;
            res = Math.min(res, Math.max(ans1, ans2));
        }
        dp[i][j] = res;
        return res;
    }
    static int eggDrop(int n, int k) 
	{
	    for(int i=0; i<=200; i++){
	        Arrays.fill(dp[i], -1);
	    }
	    return solve(n, 1, k);
	}
}
```