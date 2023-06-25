package designPatterns.strategyPattern.flyBehaviour.impl;

import designPatterns.strategyPattern.flyBehaviour.Flyable;

public class FlyWithNoWings implements Flyable {

    @Override
    public void fly() {
        System.out.println("I have no wings can't fly 😭");
    }
}
