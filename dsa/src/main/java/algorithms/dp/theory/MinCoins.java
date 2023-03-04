package algorithms.dp.theory;

import java.util.Arrays;

public class MinCoins {
    public int minCoins(int[] coins, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= coins[i - 1] && dp[i][j - coins[i - 1]] != Integer.MAX_VALUE) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + 1;
                }
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j]);
            }
        }
        return dp[n][sum];
    }
}
