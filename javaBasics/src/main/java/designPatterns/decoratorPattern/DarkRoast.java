package designPatterns.decoratorPattern;

public class DarkRoast extends Beverage {
    private final double cost;

    public DarkRoast() {
        description = "DarkRoast Beverage";
        cost = 0.99;
    }

    @Override
    public double cost() {
        return cost;
    }
}
