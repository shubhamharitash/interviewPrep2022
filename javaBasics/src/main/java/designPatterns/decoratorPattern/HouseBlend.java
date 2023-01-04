package designPatterns.decoratorPattern;

public class HouseBlend extends Beverage {
    private final double cost;

    public HouseBlend() {
        description = "HouseBlend Beverage";
        cost = 0.89;
    }

    @Override
    public double cost() {
        return cost;
    }
}
