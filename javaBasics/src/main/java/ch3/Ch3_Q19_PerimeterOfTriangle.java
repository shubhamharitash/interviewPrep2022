package ch3;

import java.util.Scanner;

public class Ch3_Q19_PerimeterOfTriangle {
    private static boolean isValidTriangle(int s1, int s2, int s3){
        return (s1 < (s2 + s3)) && (s2 < (s1 + s3)) && (s3 < (s2 + s3));
    }

    private static int perimeterOfTriangle(int s1, int s2, int s3){
        return s1 + s2+ s3;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s1, s2, s3;
        System.out.print("Enter side 1");
        s1 = sc.nextInt();
        System.out.print("Enter side 2");
        s2 = sc.nextInt();
        System.out.print("Enter side 3");
        s3 = sc.nextInt();

        boolean isValid = isValidTriangle(s1, s2, s3);
        if (isValid) {
            System.out.println("Perimeter of Traingle:" + perimeterOfTriangle(s1, s2, s3));
        }
    }
}
