package ch6;

import java.util.Scanner;

public class Ch6_Q1_PentagonalNumbers {
    public static int getPentagonalNumbers(int n) {
        return n * (3 * n - 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 0) {
                System.out.printf("%-5d\n", getPentagonalNumbers(i));
            } else {
                System.out.printf("%-5d ", getPentagonalNumbers(i));
            }
        }
    }
}
