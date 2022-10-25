package ch7.questions;

import java.util.Arrays;
import java.util.Scanner;

// Duplicates for elements 0 - 9
public class Ch7_Q15_EliminateDuplicates {
    public static void inputArr(int[] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void eliminateDuplicates(int[] arr) {
        boolean[] isPresent = new boolean[10];
        for (int i = 0; i < arr.length; i++) {
            if (isPresent[arr[i]]) {
                arr[i] = -1;
            } else {
                isPresent[arr[i]] = true;
            }
        }
        // Push logic
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                arr[cnt++] = arr[i];
            }
        }
        while (cnt < arr.length)
            arr[cnt++] = -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        inputArr(arr);
        eliminateDuplicates(arr);
        System.out.println(Arrays.toString(arr));
    }
}
