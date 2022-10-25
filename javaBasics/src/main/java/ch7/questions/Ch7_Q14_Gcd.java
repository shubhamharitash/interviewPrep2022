package ch7.questions;

public class Ch7_Q14_Gcd {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int gcd(int... numbers) {
        int gcd = gcd(numbers[0], numbers[1]);
        for (int i = 2; i < numbers.length; i++) {
            gcd = gcd(gcd, numbers[i]);
        }
        return gcd;
    }

    public static void main(String[] args) {
        System.out.println(gcd(21, 42, 84));
    }
}
