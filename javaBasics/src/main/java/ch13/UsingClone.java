package ch13;

import ch13.utilityClasses.CloneableHouse;

import java.util.ArrayList;
import java.util.Date;

public class UsingClone {
    public static void main(String[] args) {
        CloneableHouse house = new CloneableHouse("Hello World");
        CloneableHouse house2  = house.clone();
        System.out.println(house.getDate() == house2.getDate());
    }
}
