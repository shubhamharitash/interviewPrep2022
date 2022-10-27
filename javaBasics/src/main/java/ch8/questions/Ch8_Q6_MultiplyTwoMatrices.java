package ch8.questions;

import java.util.Arrays;
import java.util.Scanner;

public class Ch8_Q6_MultiplyTwoMatrices {
    public static void inputMatrix(double[][] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextDouble();
            }
        }
    }

    public static double[][] multiplyMatrix(double[][] mat1, double[][] mat2) {
        double[][] result = new double[mat1.length][mat2[0].length];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                for (int k = 0; k < mat2[0].length; k++) {
                    result[i][k] += mat1[i][j] * mat2[j][k];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        double[][] mat1 = new double[3][3];
        double[][] mat2 = new double[3][3];
        inputMatrix(mat1);
        inputMatrix(mat2);
        double[][] result = multiplyMatrix(mat1, mat2);
        for (double[] doubles : result) {
            System.out.println(Arrays.toString(doubles));
        }
    }
}
