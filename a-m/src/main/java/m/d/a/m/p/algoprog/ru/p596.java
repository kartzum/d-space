// https://algoprog.ru/material/p596

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p596 {
    public static void main(String[] args) {
        // tests();
        run();
    }

    static void run() {
        Scanner input = new Scanner(System.in);
        String[] xy = input.nextLine().split(" ");
        double x = Double.parseDouble(xy[0]);
        double y = Double.parseDouble(xy[1]);
        System.out.println(calc(x, y));
    }

    static void tests() {
        System.out.println(calc(10, 30));
        // System.out.println(calc(10, 50));
        // System.out.println(calc(1.9, 6));
    }

    static int calc(double x, double y) {
        double eps = Math.pow(10, -7);
        int k = 1;
        while (x < y - eps) {
            x *= 1.7;
            k++;
        }
        // System.out.println(x + ", " + eps);
        return k;
    }
}
