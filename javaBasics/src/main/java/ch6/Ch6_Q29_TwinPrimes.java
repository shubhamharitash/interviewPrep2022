package ch6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ch6_Q29_TwinPrimes {
    private static final int DP_SIZE = (int) 1e6;
    private static final boolean[] dp = new boolean[DP_SIZE];
    private static final List<Integer> primes = new ArrayList<>();

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
    }

    public static void createListOfPrimes() {
        computePrimes();
        for (int i = 0; i < DP_SIZE; i++) {
            if (dp[i])
                primes.add(i);
        }
    }

    public static void printTwinPrimes() {
        for (int i = 0; primes.get(i) < 1000; i++) {
            if (primes.size() >= (i + 1) && (primes.get(i + 1) - primes.get(i)) == 2) {
                System.out.printf("%4d %4d\n", primes.get(i), primes.get(i + 1));
            }
        }
    }

    public static void main(String[] args) {
        createListOfPrimes();
        System.out.println(primes.stream().limit(25).collect(Collectors.toList()));
        printTwinPrimes();
    }
}
