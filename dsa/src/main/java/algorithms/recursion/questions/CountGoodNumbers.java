package algorithms.recursion.questions;

import java.math.BigInteger;

public class CountGoodNumbers {
    public static long mod = (int) (1e9) + 7;

    public static long solve(long n) {
        if (n == 1)
            return 4;
        if (n == 2)
            return 20;
        if (n % 2 == 0) {
            BigInteger res = BigInteger.valueOf(solve(n / 2));
            res = res.mod(BigInteger.valueOf(mod));
            if (n == 18) {
                System.out.println(res);
                System.out.println(mod);
                System.out.println(res.multiply(res));
                System.out.println(Integer.parseInt(res.multiply(res).mod(BigInteger.valueOf(mod)).toString()));
            }
            return Long.parseLong(res.multiply(res).mod(BigInteger.valueOf(mod)).toString());
//            return (res%mod * res%mod)%mod ;
        }
        return (solve(n - 1) % mod * 5 % mod) % mod;
    }

    public static int countGoodNumbers(long n) {
        return (int) solve(n);
    }

    public static long power(long x, long y) {// this method computes pow(x,y) in O(logn) using divide & conquer
        long temp;
        if (y == 0) return 1;//base case (x power 0 = 1)
        temp = power(x, y / 2);//computing power for pow(x,y/2) -> divide & conquer step
        if (y % 2 == 0)
            return (temp * temp) % mod; //using that result of subproblem (2 power 2 = 2 power 1 * 2 power 1)
        else return (x * temp * temp) % mod;//using that result of subproblem (2 power 3 = 2 power 1 * 2 power 1 * 2)
        // if y is odd, x power y = x power y/2 * x power y/2 * x
        // if y is even, x power y = x power y/2 * x power y/2
    }

    public static void main(String[] args) {
//        System.out.println(countGoodNumbers(18));
        long temp = 800000;
        System.out.println((temp * temp) % ((long) (1e9 + 7)));
        System.out.println(power(800000, 2));
    }
}
