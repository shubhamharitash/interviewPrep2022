package ch13.utilityClasses;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee1, Employee employee2) {
        return employee1.getSalary().compareTo(employee2.getSalary());
    }
}
