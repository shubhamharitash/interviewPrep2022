package designPatterns.strategyPattern.quackBehaviour.impl;

import designPatterns.strategyPattern.quackBehaviour.Quackable;

public class Squeak implements Quackable {
    @Override
    public void quack() {
        System.out.println("I am squeaking🔊");
    }
}
