package designPatterns.decoratorPattern;

public abstract class Beverage {
    String description;

    Beverage() {
        description = "Unknown Beverage";
    }

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
