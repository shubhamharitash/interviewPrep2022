package ch5.questions;

import java.util.Scanner;

public class Ch5_Q17_Pyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            String temp = "1";
            for (int j = 2; j <= i; j++) {
                temp = String.format("%d %s %d", j, temp, j);
            }
            for (int j = i; j <= num; j++) {
                temp = String.format("  %s  ", temp);
            }
            System.out.println(temp);
        }
    }
}
