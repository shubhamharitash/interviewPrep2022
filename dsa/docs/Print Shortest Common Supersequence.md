## Problem Statement
https://leetcode.com/problems/shortest-common-supersequence/description/

## Approaches
#### Approach 1
![[Shortest Common Supersequence-1677174519399.jpeg]]
Here, LCS serves as a guide for which element is to be included since if we included LCS string in our supersequence, we have already included what is common between those to strings.

###### Code
```java
public String shortestCommonSupersequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int i=s1.length();
        int j=s2.length();
        StringBuilder res = new StringBuilder();
        while(i!=0 && j!=0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                res.append(s1.charAt(i-1));
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]){
                res.append(s1.charAt(i-1));
                i--;
            } else {
                res.append(s2.charAt(j-1));
                j--;
            }
        }
        
        while(i!=0){
            res.append(s1.charAt(i-1));
            i--;
        }
        while(j!=0){
            res.append(s2.charAt(j-1));
            j--;
        }
        return res.reverse().toString();
    }
```