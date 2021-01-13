// https://algoprog.ru/material/pe2001p2

// https://www.youtube.com/watch?v=jnp-JaRed2A

package m.d.a.m.p.ru.algoprog;

import java.util.Scanner;

public class pe2001p2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(calc(n));
    }

    static String calc(int n) {
        if (n == 0) {
            return "";
        } else {
            return calc(n - 1) + (char) (65 + n - 1) + calc(n - 1);
        }
    }
}
