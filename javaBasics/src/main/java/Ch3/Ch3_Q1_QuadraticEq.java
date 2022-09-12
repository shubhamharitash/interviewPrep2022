package Ch3;

import java.util.Scanner;

public class Ch3_Q1_QuadraticEq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float a, b, c;
        a = sc.nextFloat();
        b = sc.nextFloat();
        c = sc.nextFloat();

        float discriminant = (float) Math.pow(b, 2) - 4 * a * c;
        if (discriminant < 0) {
            System.out.println("Real roots not their");
        } else if (discriminant == 0) {
            float result = -b / (2 * a);
            System.out.println("roots are:" + result + " " + result);
        } else {
            float root1 = (-b - (float) Math.sqrt(discriminant))/(2*a);
            float root2 = (-b + (float) Math.sqrt(discriminant))/(2*a);
            System.out.printf("Roots are %.2f and %.2f", root1, root2);
        }
    }
}
