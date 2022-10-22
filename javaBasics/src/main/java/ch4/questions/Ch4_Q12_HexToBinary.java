package ch4.questions;

import java.util.Scanner;

public class Ch4_Q12_HexToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Integer.toBinaryString(Integer.parseInt(sc.next(), 16)));
    }
}
