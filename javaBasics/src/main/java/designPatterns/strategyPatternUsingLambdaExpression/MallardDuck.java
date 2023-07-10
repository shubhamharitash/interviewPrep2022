package designPatterns.strategyPatternUsingLambdaExpression;

import designPatterns.strategyPatternUsingLambdaExpression.behaviour.Flyable;
import designPatterns.strategyPatternUsingLambdaExpression.behaviour.Quackable;
import designPatterns.strategyPatternUsingLambdaExpression.behaviour.utils.FlyableUtil;
import designPatterns.strategyPatternUsingLambdaExpression.behaviour.utils.QuackableUtil;

public class MallardDuck extends Duck{
    public MallardDuck(){
        this.flyableBehaviour = FlyableUtil.getFlyWithRocketPower();
        this.quackableBehaviour = QuackableUtil.getMuteQuack();
    }

    public MallardDuck(Flyable flyable, Quackable quackable){
        this.flyableBehaviour = flyable;
        this.quackableBehaviour = quackable;
    }

    @Override
    public void display(){
        System.out.println("I am Mallard duck");
    }
}
