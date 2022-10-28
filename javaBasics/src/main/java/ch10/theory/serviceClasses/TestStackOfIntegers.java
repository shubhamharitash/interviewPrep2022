package ch10.theory.serviceClasses;

import ch10.theory.utilityClasses.StackOfIntegers;

import java.util.Scanner;

public class TestStackOfIntegers {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        StackOfIntegers stackOfIntegers = new StackOfIntegers();
        do {
            System.out.println("Enter one of the given choices");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. getSize");
            System.out.println("5. empty");
            System.out.println("6. Exit");
            choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        stackOfIntegers.push(sc.nextInt());
                        break;
                    case 2:
                        System.out.println("Popped element:" + stackOfIntegers.pop());
                        break;
                    case 3:
                        System.out.println("Current top ele at stack:" + stackOfIntegers.peek());
                        break;
                    case 4:
                        System.out.println("Size:" + stackOfIntegers.getSize());
                        break;
                    case 5:
                        System.out.println("IsEmpty:" + stackOfIntegers.empty());
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + choice);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (choice >= 1 && choice <= 5);
    }
}
