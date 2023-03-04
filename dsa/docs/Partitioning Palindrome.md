 ## Problem Statement
https://www.geeksforgeeks.org/palindrome-partitioning-dp-17/

## Approaches
#### Approach 1
Similar to [[Matrix Chain Multiplication]]

###### Code
```java
class Solution{
    static int[][] dp = new int[501][501];
    static boolean palindrome(String s, int i, int j){
        String str = s.substring(i, j+1);
        String revStr = (new StringBuilder(str)).reverse().toString();
        return str.equals(revStr);
    }
    static int solve(String s, int i, int j){
        if(i==j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(palindrome(s, i, j))
            return 0;
        int res = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int ans1 = solve(s, i, k);
            int ans2 = solve(s, k+1, j);
            res = Math.min(ans1 + ans2 + 1, res);
        }
        dp[i][j] = res;
        return dp[i][j];
    }
    static int palindromicPartition(String str)
    {
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(str, 0, str.length()-1);
    }
}
```