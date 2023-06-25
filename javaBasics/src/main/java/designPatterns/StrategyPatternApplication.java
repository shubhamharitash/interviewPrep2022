package designPatterns;

import designPatterns.strategyPattern.Duck;
import designPatterns.strategyPattern.MallardDuck;
import designPatterns.strategyPattern.flyBehaviour.impl.FlyWithNoWings;
import designPatterns.strategyPattern.flyBehaviour.impl.FlyWithWings;
import designPatterns.strategyPattern.quackBehaviour.impl.Squeak;

public class StrategyPatternApplication {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.performQuack();
        mallardDuck.performFly();
        mallardDuck.swim();

        // Changing behaviour via parameterized constructor
        mallardDuck = new MallardDuck(new FlyWithNoWings(), null);
        mallardDuck.display();
        mallardDuck.performQuack();
        mallardDuck.performFly();
        mallardDuck.swim();

        // Changing behaviour via setter
        mallardDuck.setFlyableBehaviour(new FlyWithWings());
        mallardDuck.setQuackableBehaviour(new Squeak());
        mallardDuck.display();
        mallardDuck.performQuack();
        mallardDuck.performFly();
        mallardDuck.swim();
    }
}
