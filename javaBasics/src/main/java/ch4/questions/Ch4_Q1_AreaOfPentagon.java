package ch4.questions;

import java.util.Scanner;

public class Ch4_Q1_AreaOfPentagon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radius = sc.nextDouble();
        double s = 2 * radius * Math.sin(Math.PI/5);
        double area = (5 * Math.pow(s, 2) )/ ( 4 * Math.tan(Math.PI/5) );
        System.out.printf("Area is :%.2f", area);
    }
}
