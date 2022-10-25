package ch7.questions;

import java.util.Scanner;

public class Ch7_Q11_Deviation {
    public static double mean(double[] arr) {
        double average = 0;
        for (double value : arr) {
            average += value;
        }
        return average / arr.length;
    }

    public static double deviation(double[] arr) {
        double numerator = 0;
        double mean = mean(arr);
        for (double value : arr) {
            numerator += Math.pow((value - mean), 2);
        }
        return Math.sqrt(numerator / (arr.length - 1));
    }

    public static void inputArr(double[] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextDouble();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        inputArr(arr);
        System.out.println(mean(arr));
        System.out.println(deviation(arr));
    }
}
