package ch5.questions;

import java.util.Scanner;

public class Ch5_Q44_BitLevelOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        short num = sc.nextShort();
        char[] bits = new char[16];
        for (int i = 0,index = 15; i < 16; i++,index--) {
            bits[index] = (char) ('0' + (num & 1));
            num >>= 1;
        }
        System.out.println(new String(bits));
    }
}
