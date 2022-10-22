package ch4.questions;

import java.util.Scanner;

public class Ch4_Q22_IsSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(s1.contains(s2));
    }
}
