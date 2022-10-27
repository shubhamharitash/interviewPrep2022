package ch8.questions;

import java.util.Scanner;

public class Ch8_Q2_SumOfMajorDiagonal {
    public static void inputMatrix(double[][] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextDouble();
            }
        }
    }

    public static double sumOfMajorDiagonal(double[][] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        double[][] arr = new double[4][4];
        inputMatrix(arr);
        System.out.println("Sum of major diagonal elements is:" + sumOfMajorDiagonal(arr));
    }
}
