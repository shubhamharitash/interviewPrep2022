package designPatterns.strategyPattern;


import designPatterns.strategyPattern.flyBehaviour.Flyable;
import designPatterns.strategyPattern.quackBehaviour.Quackable;

public class Duck {
    Flyable flyableBehaviour;
    Quackable quackableBehaviour;

    public void swim(){
        System.out.println("I am swimming");
    }

    public void display(){
        System.out.println("I am a generic duck");
    }

    public void performQuack(){
        if(quackableBehaviour != null)
            quackableBehaviour.quack();
        else
            System.out.println("Can't quack");
    }

    public void performFly(){
        if(flyableBehaviour != null)
            flyableBehaviour.fly();
        else
            System.out.println("Can't fly");
    }

    public void setFlyableBehaviour(Flyable flyableBehaviour) {
        this.flyableBehaviour = flyableBehaviour;
    }

    public void setQuackableBehaviour(Quackable quackableBehaviour) {
        this.quackableBehaviour = quackableBehaviour;
    }
}
