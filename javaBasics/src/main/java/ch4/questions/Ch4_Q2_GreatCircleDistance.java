package ch4.questions;

class Point {
    double x1,x2;

    public Point(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }
}

public class Ch4_Q2_GreatCircleDistance {
    public static void main(String[] args) {
        Point p1 = new Point(39.55, -116.25);
        Point p2 = new Point(41.5, 87.37);

        double radius = 6371.01;
        double d = radius * Math.acos(
                Math.sin(p1.x1) * Math.sin(p2.x1) +
                Math.cos(p1.x1) * Math.cos(p2.x1) * Math.cos(p1.x2 - p2.x2)
        );
        System.out.println(d);
    }
}
