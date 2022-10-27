package ch8.questions;

public class Ch8_Q7_NearestPoints {
    public static double distance(double[] point1, double[] point2) {
        double result = 0;
        for (int i = 0; i < point1.length; i++) {
            result += Math.pow((point1[i] - point2[i]), 2);
        }
        return Math.sqrt(result);
    }

    public static void main(String[] args) {
        double[][] points = {{-1, 0, 3}, {-1, -1, -1}, {4, 1, 1},
                {2, 0.5, 9}, {3.5, 2, -1}, {3, 1.5, 3}, {-1.5, 4, 2},
                {5.5, 4, -0.5}};
        double minDistance = Double.MAX_VALUE;
        int[] indices = new int[2];
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = distance(points[i], points[j]);
                if (distance < minDistance) {
                    indices[0] = i;
                    indices[1] = j;
                    minDistance = distance;
                }
            }
        }
        System.out.printf("%d, %d, %2f", indices[0], indices[1], minDistance);
    }
}
