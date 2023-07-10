package designPatterns;


import designPatterns.strategyPatternUsingLambdaExpression.Duck;
import designPatterns.strategyPatternUsingLambdaExpression.MallardDuck;
import designPatterns.strategyPatternUsingLambdaExpression.behaviour.utils.FlyableUtil;
import designPatterns.strategyPatternUsingLambdaExpression.behaviour.utils.QuackableUtil;

public class StrategyPatternUsingLambdaApplication {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.performQuack();
        mallardDuck.performFly();
        mallardDuck.swim();

        // Changing behaviour via parameterized constructor
        mallardDuck = new MallardDuck(FlyableUtil.getFlyWithNoWings(), null);
        mallardDuck.display();
        mallardDuck.performQuack();
        mallardDuck.performFly();
        mallardDuck.swim();

        // Changing behaviour via setter
        mallardDuck.setFlyableBehaviour(FlyableUtil.getFlyWithWings());
        mallardDuck.setQuackableBehaviour(QuackableUtil.getSqueak());
        mallardDuck.display();
        mallardDuck.performQuack();
        mallardDuck.performFly();
        mallardDuck.swim();
    }
}
