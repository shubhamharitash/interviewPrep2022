package ch13;

import ch13.utilityClasses.Employee;
import ch13.utilityClasses.EmployeeComparator;

import java.util.ArrayList;

public class UsingComparatorForSorting {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("temp2", 200));
        employees.add(new Employee("temp1", 100));
        employees.sort(new EmployeeComparator());
        System.out.println(employees);
    }
}
