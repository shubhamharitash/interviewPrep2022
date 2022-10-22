package ch2;

import java.util.Scanner;

public class Ch2_Q5_CalculateTips {
    public static void main(String[] args) {
        float amount, gratuityRate;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount and gratuity rate:");
        amount = sc.nextFloat();
        gratuityRate = sc.nextFloat();
        float gratuity, gratuityAmount;
        gratuity = (amount * gratuityRate) / 100;
        gratuityAmount = gratuity + amount;
        System.out.printf("Gratuity %.2f and total amount %.2f", gratuity, gratuityAmount);
    }
}
