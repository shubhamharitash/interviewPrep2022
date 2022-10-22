package ch2;

import java.util.Scanner;

public class Ch2_Q21_CompoundInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        float interestRate = sc.nextFloat() / 12;
        int years = sc.nextInt();

        float result =  amount * (float)Math.pow(1 + interestRate/100, 12 * years);
        System.out.printf("Accumulated value is:%.2f", result);
    }
}
