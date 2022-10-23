package ch6;

public class Ch6_Q27_Emirp {
    public static boolean isPrime(int n) {
        if ((n != 2 && n % 2 == 0) || n == 1)
            return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static int reverseInteger(int n) {
        int revN = 0;
        for (int i = n; i != 0; i /= 10) {
            revN = revN * 10 + i % 10;
        }
        return revN;
    }

    public static boolean isPalindrome(int n) {
        return reverseInteger(n) == n;
    }

    public static boolean isReversalPrime(int n) {
        return isPrime(reverseInteger(n));
    }

    public static void main(String[] args) {
        int cnt = 0, num = 2;
        while (cnt != 100) {
            if (isPrime(num) && !isPalindrome(num) && isReversalPrime(num)) {
                cnt++;
                if ((cnt) % 10 == 0) {
                    System.out.printf("%5d\n", num);
                } else {
                    System.out.printf("%5d ", num);
                }
            }
            num++;
        }
    }
}
