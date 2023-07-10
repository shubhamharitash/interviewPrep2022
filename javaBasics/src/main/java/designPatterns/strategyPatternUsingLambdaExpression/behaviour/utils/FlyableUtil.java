package designPatterns.strategyPatternUsingLambdaExpression.behaviour.utils;

import designPatterns.strategyPatternUsingLambdaExpression.behaviour.Flyable;

public class FlyableUtil {
    private static Flyable flyWithWings = () -> {
        System.out.println("I am flying with wings");
    };
    private static Flyable flyWithNoWings = () -> {
        System.out.println("I have no wings can't fly 😭");
    };
    private static Flyable flyWithRocketPower = () -> {
        System.out.println("Flying with 🚀 Power");
    };

    public static Flyable getFlyWithWings() {
        return flyWithWings;
    }

    public static Flyable getFlyWithNoWings() {
        return flyWithNoWings;
    }

    public static Flyable getFlyWithRocketPower() {
        return flyWithRocketPower;
    }
}
