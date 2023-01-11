package leetcodeBasicQuestions;

import java.util.Scanner;

enum RomanValues {
    I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
    final int value;

    RomanValues(int value) {
        this.value = value;
    }
}

enum AheadValue {
    I("VX"), X("LC"), C("DM");
    final String value;

    AheadValue(String value) {
        this.value = value;
    }
}

public class RomanToInt {
    public static int computeAnomaly(int a, int b) {
        return a - b;
    }

    public static int romanToInt(String s) {
        if (s.length() == 0)
            return 0;
        String s0 = String.valueOf(s.charAt(0));
        if (s.length() >= 2 && "IXC".contains(s0)) {
            String s1 = String.valueOf(s.charAt(1));
            if (AheadValue.valueOf(s0).value.contains(s1)) {
                int s0Value = RomanValues.valueOf(s0).value;
                int s1Value = RomanValues.valueOf(s1).value;
                return computeAnomaly(s1Value, s0Value) + romanToInt(s.substring(2));
            }
        }
        return RomanValues.valueOf(s0).value + romanToInt(s.substring(1));
    }

    public static int romanToIntSimple(String s){
        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(romanToIntSimple(sc.nextLine()));
    }
}
