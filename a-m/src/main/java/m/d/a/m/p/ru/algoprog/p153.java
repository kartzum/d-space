// https://algoprog.ru/material/p153

package m.d.a.m.p.ru.algoprog;

import java.util.Scanner;

public class p153 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(fib(n));
    }

    static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
