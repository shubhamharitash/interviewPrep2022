package ch4.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ch4_Q15_PhoneKeyPads {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> charToInteger = new HashMap<>();
        Map<Integer, String> integerToString = new HashMap<>();
        integerToString.put(2, "abc");
        integerToString.put(3, "def");
        integerToString.put(4, "ghi");
        integerToString.put(5, "jkl");
        integerToString.put(6, "mno");
        integerToString.put(7, "pqrs");
        integerToString.put(8, "tuv");
        integerToString.put(9, "wxyz");
        integerToString.forEach( (key, value) -> {
            char[] chArr = value.toCharArray();
            for (char c : chArr) {
                charToInteger.put(c, key);
            }
        });
        System.out.println(charToInteger.get(Character.toLowerCase(sc.next().charAt(0))));
    }
}
