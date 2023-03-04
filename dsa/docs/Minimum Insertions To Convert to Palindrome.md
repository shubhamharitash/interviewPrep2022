## Problem Statement
https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/

## Approaches
#### Approach 1
![[Minimum Insertions To Convert to Palindrome-1677603321960.jpeg]]

###### Code
```java
class Solution {
    public int minInsertions(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        String revStr = (new StringBuilder(s)).reverse().toString();
        for(int i=1; i<=s.length(); i++){
            for(int j=1; j<=s.length(); j++){
                if(s.charAt(i-1) == revStr.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int i = s.length();
        int j = s.length();
        List<Integer> stk = new ArrayList<>();
        while(i!=0 && j!=0){
            if(s.charAt(i-1) == revStr.charAt(j-1)){
                stk.add(j-1);
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            } else {
                j--;
            }
        }
        int res = 0;
        for(i=0;i<stk.size()-1; i++){
            res += stk.get(i) - stk.get(i+1) - 1;
        }
        if(stk.get(stk.size()-1)!=0)
            res += stk.get(stk.size()-1);
        if(stk.get(0) != (revStr.length() - 1)){
            res += (revStr.length() - 1) - stk.get(0);
        }
        return res;
    }
}
```