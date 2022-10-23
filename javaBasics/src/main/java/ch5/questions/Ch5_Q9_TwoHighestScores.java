package ch5.questions;

import java.util.Scanner;

public class Ch5_Q9_TwoHighestScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch;
        String highestName = "", secondHighestName = "";
        int highestScore = Integer.MIN_VALUE, secondHighestScore = Integer.MIN_VALUE;
        do {
            System.out.println("Enter student name");
            String name = sc.next();
            System.out.println("Enter score");
            int score = sc.nextInt();
            if (score > highestScore) {
                secondHighestScore = highestScore;
                secondHighestName = highestName;
                highestScore = score;
                highestName = name;
            } else if (score > secondHighestScore){
                secondHighestScore = score;
                secondHighestName = name;
            }
            System.out.print("want to enter more?:");
            ch = sc.next().charAt(0);
        } while (Character.toLowerCase(ch) == 'y');
        System.out.printf("%s: %d\n", highestName, highestScore);
        System.out.printf("%s: %d\n", secondHighestName, secondHighestScore);
    }
}
