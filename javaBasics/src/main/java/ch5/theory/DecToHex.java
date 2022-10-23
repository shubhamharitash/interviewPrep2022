package ch5.theory;

import java.util.Scanner;

/*
    256
    256%16 = 0
    16%16 = 0
    1%16 = 1
    100
 */

public class DecToHex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        StringBuilder result = new StringBuilder();
        while(num!=0){
            int digit = num % 16;
            char ch = digit < 10 ? (char) ('0' + digit) : (char) ('A' + digit - 10);
            result.append(ch);
            num /= 16;
        }
        result.reverse();
        System.out.println(result);
    }
}
