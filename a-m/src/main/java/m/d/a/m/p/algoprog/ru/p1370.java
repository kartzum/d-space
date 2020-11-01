// https://algoprog.ru/material/p1370 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p1370 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String[] ab = input.nextLine().split(" ");
        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);
        int c = 0;
        for (int i = n - 1; i > 0; i -= 1) {
            c = b - a;
            b = a;
            a = c;
        }
        System.out.print(a + " " + b);
    }
}
