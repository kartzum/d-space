// https://algoprog.ru/material/p3050 - in progress.

// https://www.youtube.com/watch?v=6AW94BcSo4o
// https://www.youtube.com/watch?v=0Bc8zLURY-c
// https://sis.khashaev.ru/2013/august/c-prime/BIwzyPBgU6Y/

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p3050 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        move(n, 1, 3);
    }

    static void move(int n, int start, int finish) {
        if (n == 1) {
            System.out.printf("%d %d %d\n", n, start, finish);
        } else {
            int t = 6 - start - finish;
            move(n - 1, start, t);
            System.out.printf("%d %d %d\n", n, start, finish);
            move(n - 1, t, finish);
        }
    }
}
