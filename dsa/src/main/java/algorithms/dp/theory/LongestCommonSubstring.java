package algorithms.dp.theory;

import java.util.Arrays;

public class LongestCommonSubstring {
    int longestCommonSubstr(String S1, String S2, int m, int n){
        // code here
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(S1.charAt(i-1) == S2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int res = 0;
        for(int i=1; i<=m; i++){
            if(Arrays.stream(dp[i]).max().isPresent())
                res = Math.max(res, Arrays.stream(dp[i]).max().getAsInt());
        }
        return res;
    }
}
