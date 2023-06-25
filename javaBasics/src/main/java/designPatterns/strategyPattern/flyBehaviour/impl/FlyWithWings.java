package designPatterns.strategyPattern.flyBehaviour.impl;

import designPatterns.strategyPattern.flyBehaviour.Flyable;

public class FlyWithWings implements Flyable {
    @Override
    public void fly() {
        System.out.println("I am flying with wings");
    }
}
