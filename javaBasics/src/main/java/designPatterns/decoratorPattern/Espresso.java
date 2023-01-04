package designPatterns.decoratorPattern;

public class Espresso extends Beverage {
    private final double cost;

    public Espresso() {
        description = "Espresso Beverage";
        cost = 1.99;
    }

    @Override
    public double cost() {
        return cost;
    }
}
