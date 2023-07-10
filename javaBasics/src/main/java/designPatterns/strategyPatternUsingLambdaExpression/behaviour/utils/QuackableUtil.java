package designPatterns.strategyPatternUsingLambdaExpression.behaviour.utils;

import designPatterns.strategyPatternUsingLambdaExpression.behaviour.Quackable;

public class QuackableUtil {
    private static Quackable quack = () -> {
        System.out.println("I am quacking🔊");
    };
    private static Quackable squeak = () -> {
        System.out.println("I am squeaking🔊");
    };
    private static Quackable muteQuack = () -> {
        System.out.println("🔇 quack");
    };

    public static Quackable getQuack() {
        return quack;
    }

    public static Quackable getSqueak() {
        return squeak;
    }

    public static Quackable getMuteQuack() {
        return muteQuack;
    }
}
