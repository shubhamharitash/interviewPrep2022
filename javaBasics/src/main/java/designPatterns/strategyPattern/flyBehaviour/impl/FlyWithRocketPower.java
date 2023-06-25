package designPatterns.strategyPattern.flyBehaviour.impl;

import designPatterns.strategyPattern.flyBehaviour.Flyable;

public class FlyWithRocketPower implements Flyable {
    @Override
    public void fly() {
        System.out.println("Flying with 🚀 Power");
    }
}
