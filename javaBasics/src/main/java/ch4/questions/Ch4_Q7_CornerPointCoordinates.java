package ch4.questions;

import java.util.*;

class CirclePoint {
    double radius;
    double degrees;

    public CirclePoint(double radius, double degrees) {
        this.radius = radius;
        this.degrees = degrees;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getDegrees() {
        return degrees;
    }

    public void setDegrees(double degrees) {
        this.degrees = degrees;
    }

    public Map<String, Double> getPoint() {
        Map<String, Double> point = new HashMap<>();
        point.put("x1", radius * Math.cos(degrees));
        point.put("x2", radius * Math.sin(degrees));
        return point;
    }
}

public class Ch4_Q7_CornerPointCoordinates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius:");
        double radius = sc.nextDouble();
        double angle = Math.PI/2;
        for (int i=0; i < 5; i++, angle += (2 * Math.PI) / 5){
            CirclePoint circlePoint = new CirclePoint(radius, angle);
            System.out.println(circlePoint.getPoint());
        }
    }
}
