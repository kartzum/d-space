// https://algoprog.ru/material/p154 - in progress.
// https://code-live.ru/post/greatest-common-denominator-algorithms/
// https://codelab.ru/s/cpp/common_divisor:recursive_euclid/

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p154 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] t = input.nextLine().split(" ");
        int a = Integer.parseInt(t[0]);
        int b = Integer.parseInt(t[1]);
        int c = gcd(a, b);
        System.out.println(c);
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
