package ch6;

public class Ch6_Q26_PalindromicPrime {
    public static boolean isPrime(int n) {
        if ((n != 2 && n % 2 == 0) || n == 1)
            return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isPalindrome(int n) {
        int revN = 0;
        for (int i = n; i != 0; i /= 10) {
            revN = revN * 10 + i % 10;
        }
        return revN == n;
    }

    public static void main(String[] args) {
        int cnt = 0, num = 2;
        while (cnt != 100) {
            if (isPrime(num) && isPalindrome(num)) {
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
