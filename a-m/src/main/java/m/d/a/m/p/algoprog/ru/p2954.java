// https://algoprog.ru/material/p2954 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p2954 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        System.out.println((n + (-k % n)) % n);
    }
}