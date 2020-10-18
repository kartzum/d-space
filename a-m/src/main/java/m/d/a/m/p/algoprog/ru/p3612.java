// https://algoprog.ru/material/p3612 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p3612 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int h = input.nextInt();
        int m = input.nextInt();
        int s = input.nextInt();
        double v = (h + m / 60.0 + s / 3600.0) * 360 / 12;
        System.out.printf("%.2f", v);
    }
}
