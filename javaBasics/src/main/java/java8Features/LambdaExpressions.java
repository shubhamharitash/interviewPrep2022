package java8Features;

import ch17.theory.TestingInterface;

import java.util.function.BinaryOperator;

public class LambdaExpressions {
    public static void main(String[] args) {
        // various ways to call a lambda expression
        Runnable noArguments = () -> System.out.println("no Arguments");
        noArguments.run();

        // Custom interface
        TestingInterface<Integer, Float> convertTypeInterface = Integer::floatValue;
        System.out.println(convertTypeInterface.convertType(10));

        Runnable multiStatement = () -> {
            System.out.println("Statement 1");
            System.out.println("Statement 2");
        };
        multiStatement.run();

        BinaryOperator<Long> multiplyExplicit = (Long x, Long y) -> x * y;
        System.out.println(multiplyExplicit.apply(10L, 20L));
    }
}
