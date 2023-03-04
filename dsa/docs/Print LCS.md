## Problem Statement
https://www.geeksforgeeks.org/printing-longest-common-subsequence/

## Approaches
#### Approach 1
![[Print LCS-1677170378861.jpeg]]

###### Code
```java
public static void printLCS(String S1, String S2, int m, int n){  
    int[][] dp = new int[m+1][n+1];  
    for(int i=1; i<=m; i++){  
        for(int j=1; j<=n; j++){  
            if(S1.charAt(i-1) == S2.charAt(j-1)){  
                dp[i][j] = 1 + dp[i-1][j-1];  
            } else {  
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);  
            }  
        }  
    }  
    m = m+1;  
    n = n+1;  
    while(m != 0 || n!=0){  
        if(S1.charAt(m-1) == S2.charAt(n-1)){  
            System.out.println(S1.charAt(m-1));  
        } else if(dp[m-1][n] > dp[m][n-1]){  
            m--;  
        }  
        n--;  
    }  
}
```