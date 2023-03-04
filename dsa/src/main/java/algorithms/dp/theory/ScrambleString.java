package algorithms.dp.theory;

import java.util.ArrayList;
import java.util.List;

public class ScrambleString {
    public static int[][][][] dp = new int[31][31][31][31];
    public static boolean solve(String s1, String s2, int i, int j, int i2, int j2){
        if(dp[i][j][i2][j2]!=-1){
            return dp[i][j][i2][j2] == 1;
        }
        if(i==j){
            System.out.printf("chars -> %c %c\n", s1.charAt(i), s2.charAt(i2));
            dp[i][j][i2][j2] = s1.charAt(i) == s2.charAt(i2) ? 1:0;
            return dp[i][j][i2][j2] == 1;
        }
        if(s1.substring(i,j+1).equals(s2.substring(i2,j2+1))){
            return true;
        }
        for(int k=i; k<j; k++){
            boolean noSwapPart1 = solve(s1, s2, i, k, i2, i2 + (k-i));
            boolean noSwapPart2 = solve(s1, s2, k+1, j, i2 + (k-i) + 1, j2);
            boolean swapPart1 = solve(s1, s2, k+1, j, i2, i2 + (j-k-1));
            boolean swapPart2 = solve(s1, s2, i, k, i2 + (j-k-1) + 1, j2);
            System.out.printf("%s %s %b\n", s1.substring(i, k+1), s2.substring(i, k+1), noSwapPart1);
            System.out.printf("%s %s %b\n", s1.substring(k+1, j+1), s2.substring(k+1, j+1), noSwapPart2);
            System.out.printf("%s %s %b\n", s1.substring(k+1, j+1), s2.substring(i, i + (j-k-1)+1), swapPart1);
            System.out.printf("%s %s %b\n", s1.substring(i, k+1), s2.substring(i + (j-k-1) + 1, j+1), swapPart2);
            if((noSwapPart1 && noSwapPart2) || (swapPart1 && swapPart2)){
                dp[i][j][i2][j2] = 1;
                return true;
            }
        }
        return false;
    }
    public static boolean isScramble(String s1, String s2) {
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp.length; j++){
                for(int k=0; k<dp.length; k++){
                    for(int l=0; l<dp.length; l++){
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        return solve(s1, s2, 0, s1.length()-1, 0, s2.length() -1);
    }

    public static void main(String[] args) {
        System.out.println(isScramble("abc", "cba"));
    }
}
