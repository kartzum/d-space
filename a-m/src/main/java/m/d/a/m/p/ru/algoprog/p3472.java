// https://algoprog.ru/material/p3472

package m.d.a.m.p.ru.algoprog;

import java.util.Scanner;

public class p3472 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = 45 * n;
        int k = (n - 1) % 2;
        int t = 0;
        if (k == 0) {
            t = ((n - 1) / 2) * 5 + ((n - 1) / 2) * 15;
        } else {
            t = ((n - 1) / 2 + 1) * 5 + ((n - 1) / 2) * 15;
        }
        m = m + t;
        System.out.print(9 + (m / 60) + " " + m % 60);
    }
}
