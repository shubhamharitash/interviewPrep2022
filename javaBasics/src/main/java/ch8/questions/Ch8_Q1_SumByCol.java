package ch8.questions;

import java.util.Scanner;

public class Ch8_Q1_SumByCol {
    public static void inputMatrix(double[][] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextDouble();
            }
        }
    }

    public static double sumColumn(double[][] arr, int colIndex) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][colIndex];
        }
        return sum;
    }

    public static void main(String[] args) {
        double[][] arr = new double[3][4];
        inputMatrix(arr);
        for (int i = 0; i < arr[0].length; i++) {
            System.out.println("Sum of elements at col " + i + " is:" + sumColumn(arr, i));
        }
    }
}
