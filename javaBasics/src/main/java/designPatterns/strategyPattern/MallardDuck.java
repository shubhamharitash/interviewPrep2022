package designPatterns.strategyPattern;

import designPatterns.strategyPattern.flyBehaviour.Flyable;
import designPatterns.strategyPattern.flyBehaviour.impl.FlyWithRocketPower;
import designPatterns.strategyPattern.quackBehaviour.Quackable;
import designPatterns.strategyPattern.quackBehaviour.impl.MuteQuack;

public class MallardDuck extends Duck{
    public MallardDuck() {
        this.flyableBehaviour = new FlyWithRocketPower();
        this.quackableBehaviour = new MuteQuack();
    }

    public MallardDuck(Flyable flyable, Quackable quackable) {
        this.flyableBehaviour = flyable;
        this.quackableBehaviour = quackable;
    }
    
    @Override
    public void display(){
        System.out.println("I am Mallard duck");
    }
}
