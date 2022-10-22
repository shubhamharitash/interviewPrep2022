package ch3;

import java.util.Scanner;

public class Ch3_Q26_Divisibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("Is num divisible by 5 and 6?:" + (num % 5 == 0 && num % 6 == 0));
        System.out.println("Is num divisible by 5 or 6?:" + (num % 5 == 0 || num % 6 == 0));
        System.out.println("Is num divisible by 5 or 6 but not both?:" + (num % 5 == 0 ^ num % 6 == 0));
    }
}
