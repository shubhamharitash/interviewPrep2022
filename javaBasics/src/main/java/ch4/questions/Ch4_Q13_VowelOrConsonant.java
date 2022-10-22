package ch4.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ch4_Q13_VowelOrConsonant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        List<Character> listOfVowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        System.out.println(listOfVowels.contains(Character.toLowerCase(ch)) ? "vowel" : "consonant");
    }
}
