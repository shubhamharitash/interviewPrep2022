package designPatterns.strategyPattern.quackBehaviour.impl;

import designPatterns.strategyPattern.quackBehaviour.Quackable;

public class MuteQuack implements Quackable {
    @Override
    public void quack() {
        System.out.println("🔇 quack");
    }
}
