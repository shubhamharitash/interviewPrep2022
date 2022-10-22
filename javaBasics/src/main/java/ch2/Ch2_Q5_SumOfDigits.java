package ch2;

import java.util.Scanner;

public class Ch2_Q5_SumOfDigits {
    public static void main(String[] args) {
        int num, sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number:");
        num = sc.nextInt();
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        System.out.printf("Sum of Digits is:%d", sum);
    }
}
