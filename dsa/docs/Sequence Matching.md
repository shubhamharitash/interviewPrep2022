## Problem Statement
https://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/

## Approaches
#### Approach 1
lcs == reqAnsSubstringLength
Takes O(n^2) time can be optimized

###### Code
```java
int lcs(String str1, String str2){
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for(int i=1; i<=str1.length(); i++){
            for(int j=1; j<=str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
    boolean isSubSequence(String A, String B){
        int reqLength = Math.min(A.length(), B.length());
        return lcs(A, B) == reqLength;
    }
```

#### Approach 2
Two pointer approach
Simply match the character and move ahaed if it doesn't match

###### Code
```java
class Solution{
    boolean isSubSequence(String str1, String str2){
        int i = 0;
        int j = 0;
        while(i<str1.length() && j<str2.length()){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i==str1.length();
    }
}
```