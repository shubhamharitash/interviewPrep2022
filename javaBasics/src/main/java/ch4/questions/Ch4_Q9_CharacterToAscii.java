package ch4.questions;

import java.util.Scanner;

public class Ch4_Q9_CharacterToAscii {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        System.out.println((int) ch);
    }
}
