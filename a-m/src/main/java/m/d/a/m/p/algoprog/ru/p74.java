// https://algoprog.ru/material/p74 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.math.BigDecimal;
import java.util.Scanner;

public class p74 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BigDecimal a = input.nextBigDecimal();
        BigDecimal b = input.nextBigDecimal();
        BigDecimal c = input.nextBigDecimal();
        BigDecimal sum = a.add(b);
        double v = Math.abs(sum.doubleValue() - c.doubleValue());
        if (v <= Math.pow(10, -7)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
