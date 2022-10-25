package ch7.questions;

import java.util.Arrays;

public class Ch7_Q3_CountOccurrences {
    public static void generateRandomNumbers(int[] arr, int totalRandomNumbers) {
        for (int i = 0; i < totalRandomNumbers; i++) {
            arr[(int) (Math.random() * 100)] += 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        generateRandomNumbers(arr, 10000);
        System.out.println(Arrays.toString(arr));
    }
}
