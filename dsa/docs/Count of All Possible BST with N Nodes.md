## Problem Statement
https://www.geeksforgeeks.org/number-of-unique-bst-with-a-given-key-dynamic-programming/

## Approaches
#### Approach 1(DP)
![[Count of All Possible BST with N Nodes-1678378486272.jpeg]]

###### Code
```java
class Solution
{
    //Function to return the total number of possible unique BST.
    static int numTrees(int N)
    {
        int mod = (int)(1e9+7);
        long[] dp = new long[N+1];
        dp[0] = dp[1] = 1;
        for(int i=2; i<=N; i++){
            for(int j=0; j<=i-1; j++){
                long ans = (long)((dp[j]%mod)*(dp[i-j-1]%mod));
                dp[i] = ((dp[i]%mod)+(ans%mod))%mod;
            }
        }
        return (int)dp[N];
    }
}
```