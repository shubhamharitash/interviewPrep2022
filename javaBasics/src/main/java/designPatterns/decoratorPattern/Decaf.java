package designPatterns.decoratorPattern;

public class Decaf extends Beverage {
    private final double cost;

    public Decaf() {
        description = "Decaf Beverage";
        cost = 1.05;
    }

    @Override
    public double cost() {
        return cost;
    }
}
