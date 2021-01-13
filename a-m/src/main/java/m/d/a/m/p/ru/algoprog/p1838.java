// https://algoprog.ru/material/p1838

package m.d.a.m.p.ru.algoprog;

import java.util.Scanner;

public class p1838 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] temp = input.nextLine().split(" ");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);
        int c = Integer.parseInt(temp[2]);
        int d = Integer.parseInt(temp[3]);

        int x = Math.abs(a - c);
        int y = Math.abs(b - d);
        int m = x;
        int n = y;
        while (y != 0) {
            int t = x % y;
            x = y;
            y = t;
        }
        System.out.println(m + n - x);
    }
}
