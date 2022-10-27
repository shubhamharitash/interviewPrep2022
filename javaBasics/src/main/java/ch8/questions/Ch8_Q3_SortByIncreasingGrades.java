package ch8.questions;

import java.util.Arrays;

public class Ch8_Q3_SortByIncreasingGrades {
    public static int numberOfCorrectAns(char[] input, char[] answers) {
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i] == answers[i] ? 1 : 0;
        }
        return sum;
    }

    public static void shiftElementsToRightFromIndex(int[] arr, int start, int end) {
        if (end - start >= 0)
            System.arraycopy(arr, start, arr, start + 1, end - start);
    }

    public static void insertToArr(int[] arr, int num) {
        int i, indexToInsert = 0;
        for (i = 0; arr[i] != -1; i++) {
            if (arr[i] < num)
                indexToInsert++;
        }
        shiftElementsToRightFromIndex(arr, indexToInsert, i);
        arr[indexToInsert] = num;
    }

    public static void main(String[] args) {
        char[][] answers = {
                {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
                {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
                {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
                {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};
        char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};
        int[] result = new int[answers.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < answers.length; i++) {
            insertToArr(result, numberOfCorrectAns(answers[i], keys));
        }
        for (int j : result) {
            System.out.print(j + " ");
        }
        System.out.println("");
    }
}
