// https://algoprog.ru/material/p597

package m.d.a.m.p.ru.algoprog;

import java.util.Scanner;

public class p597 {
    public static void main(String[] args) {
        run();
    }

    static void run() {
        Scanner input = new Scanner(System.in);
        Double x = null;
        Double y = null;
        String firstLine = input.nextLine();
        String[] firstLineValues = firstLine.split(" ");
        if (firstLineValues.length == 2) {
            x = Double.parseDouble(firstLineValues[0]);
            y = Double.parseDouble(firstLineValues[1]);
        } else {
            String secondLine = input.nextLine();
            x = Double.parseDouble(firstLine);
            y = Double.parseDouble(secondLine);
        }
        System.out.println(calc(x, y));
    }

    static int calc(double x, double y) {
        double eps = Math.pow(10, -7);
        int k = 1;
        double v = x;
        while (v < y - eps) {
            x *= 1.7;
            v += x;
            k++;
        }
        // System.out.println(x + ", " + eps);
        return k;
    }
}
