package ch6;

public class Ch6_Q13_SumSeries {
    public static double result(int num) {
        double sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += (double) i / (i + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.printf("%2d   %7.4f\n", i + 1, result(i + 1));
        }
    }
}
