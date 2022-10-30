package ch10.questions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ch10_Q19_MersennePrime {
    final static int DP_SIZE = (int) 1e6;
    final static boolean[] dp = new boolean[DP_SIZE];
    static List<Integer> primes = new ArrayList<>();

    public static void computePrimes() {
        Arrays.fill(dp, true);
        dp[2] = true;
        dp[0] = dp[1] = false;
        for (int i = 2 * 2; i < DP_SIZE; i += 2) {
            dp[i] = false;
        }
        for (int i = 3; i * i < DP_SIZE; i += 2) {
            if (dp[i]) {
                for (int j = i * i; j < DP_SIZE; j += i) {
                    dp[j] = false;
                }
            }
        }
        for (int i = 0; i < DP_SIZE; i++) {
            if (dp[i])
                primes.add(i);
        }
    }

    public static void output(int n) {
        BigInteger num = new BigInteger("2");
        for (int i = 0; i < n; i++) {
            System.out.println(num.pow(primes.get(i)).subtract(new BigInteger("1")));
        }
    }

    public static void main(String[] args) {
        computePrimes();
        output(100);
    }
}
