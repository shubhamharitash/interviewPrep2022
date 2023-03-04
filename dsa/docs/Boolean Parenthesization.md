## Problem Statement

## Approaches
#### Approach 1
![[Boolean Parenthesization-1677867417027.jpeg]]

Here both count of true and false for subexpressions needs to be known. We just take care of that while computing the result.
###### Code
```java
class Solution{
    public static int[][][] dp = new int[201][201][2];
    public static boolean operand(char op){
        return op == 'T' ? true : false;
    }
    public static boolean evaluate(String s, int opIndex1, int oprIndex, int opIndex2){
        boolean op1 = operand(s.charAt(opIndex1));
        boolean op2 = operand(s.charAt(opIndex2));
        if(s.charAt(oprIndex) == '&'){
            return op1 & op2;
        } else if(s.charAt(oprIndex) == '|'){
            return op1 | op2;
        }
        return op1 ^ op2;
    }
    public static int solve(String s, int i, int j, boolean reqTruth){
        int reqIndex = reqTruth == false ? 0:1;
        if(dp[i][j][reqIndex] != -1)
            return dp[i][j][reqIndex];
        if(i==j){
            dp[i][j][reqIndex] = operand(s.charAt(i)) == reqTruth ? 1:0;
            return dp[i][j][reqIndex];
        }
        if(i+2 == j){
            dp[i][j][reqIndex] = evaluate(s, i, i+1, i+2) == reqTruth ? 1:0;
            return dp[i][j][reqIndex];
        }
        int res = 0; 
        for(int k=i; k<j-1; k+=2){
            solve(s, i, k, reqTruth);
            solve(s, i, k, !reqTruth);
            solve(s, k+2, j, reqTruth);
            solve(s, k+2, j, !reqTruth);
            int aFbF = (dp[i][k][0]*dp[k+2][j][0])%1003;
            int aFbT = (dp[i][k][0]*dp[k+2][j][1])%1003;
            int aTbF = (dp[i][k][1]*dp[k+2][j][0])%1003;
            int aTbT = (dp[i][k][1]*dp[k+2][j][1])%1003;
            if(reqTruth == true){
                if(s.charAt(k+1) == '&'){
                    res = (res + aTbT)%1003;
                } else if(s.charAt(k+1) == '|'){
                    res = ((res + aTbT)%1003 + (aFbT + aTbF)%1003)%1003;
                } else{
                    res = ((res + aFbT)%1003 + aTbF)%1003;
                }
            } else {
                if(s.charAt(k+1) == '&'){
                    res = ((res + aFbF)%1003 + (aFbT + aTbF)%1003)%1003;
                } else if(s.charAt(k+1) == '|'){
                    res = (res + aFbF)%1003;
                } else{
                    res = ((res + aFbF)%1003 + aTbT)%1003;
                }
            }
        }
        dp[i][j][reqIndex] = res;
        return dp[i][j][reqIndex];
    }
    static int countWays(int n, String s){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp.length; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(s, 0, n-1, true);
    }
}
```