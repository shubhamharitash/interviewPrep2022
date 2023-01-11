![[Libraries-1673319374505.jpeg]]
## Using specialized streams for primitive types(long, integer, double)
![[Libraries-1673355808359.jpeg]]

## Choices in overloading
![[Libraries-1673356200049.jpeg]]Here, IntegerBinaryOperator is printed

## @FunctionalInterface
This annotation enforces an interface to satisfy the criteria of being a functional interface which is 
> having only one abstract method

## Default Methods
So you’ve got your new stream method on Collection; how do you allow MyCustom List to compile without ever having to know about its existence? The Java 8 approach to solving the problem is to allow Collection to say, “If any of my children don’t have a stream method, they can use this one.” These methods on an interface are called default methods. They can be used on any interface, functional or not


