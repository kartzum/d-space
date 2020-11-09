// https://algoprog.ru/material/p153 - in progress.

// https://www.youtube.com/watch?v=jnp-JaRed2A

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class pe2001p2 {
    static char[] letters = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(calc(n));
    }

    static String calc(int n) {
        if (n == 0) {
            return "";
        } else {
            return calc(n - 1) + letters[n - 1] + calc(n - 1);
        }
    }
}
