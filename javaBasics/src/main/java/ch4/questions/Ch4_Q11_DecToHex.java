package ch4.questions;

import java.util.Scanner;

public class Ch4_Q11_DecToHex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dec = sc.nextInt();
        System.out.println(Integer.toHexString(dec));
    }
}
