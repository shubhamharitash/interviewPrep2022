package ch13;

import ch13.utilityClasses.Employee;

import java.util.ArrayList;
import java.util.Arrays;

public class ComparableInterface {
    public static void main(String[] args) {
        Employee[] employeesArr = {
                new Employee("temp2", 200),
                new Employee("temp1", 100)
        };
        System.out.println(Arrays.toString(employeesArr));
        Arrays.sort(employeesArr);
        System.out.println(Arrays.toString(employeesArr));
    }
}
