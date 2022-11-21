package ch10.questions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ch10_Q20_ApproximateE {
    public static BigDecimal factorial(int n) {
        BigDecimal res = new BigDecimal(1);
        for (int i = 2; i <= n; i++) {
            res = res.multiply(BigDecimal.valueOf(i));
        }
        return res;
    }

    public static BigDecimal computeE(int n) {
        BigDecimal e = new BigDecimal(0);
        for (int i = n; i > 0; i--) {
            e = e.add(BigDecimal.valueOf(1).divide(factorial(i), 100, RoundingMode.UP));
        }
        return BigDecimal.valueOf(1).add(e);
    }

    public static void main(String[] args) {
        System.out.println(computeE(2000));
    }
}
