package ch4.questions;

import com.sun.org.apache.xerces.internal.impl.dv.xs.YearMonthDV;

import java.time.YearMonth;
import java.util.Scanner;

public class Ch4_Q17_DaysOfMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        YearMonth yearMonth = YearMonth.of(year, month);
        System.out.println(yearMonth.lengthOfMonth());
    }
}
