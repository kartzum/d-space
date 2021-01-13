// https://algoprog.ru/material/p511

package m.d.a.m.p.ru.algoprog;

import java.util.Scanner;

import static java.lang.Math.abs;

public class p511 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] t = input.nextLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int a = Integer.parseInt(t[1]);
        int b = Integer.parseInt(t[2]);
        int c = (n + (-abs(a - b) % n)) % n;
        int d = (n + (abs(a - b) % n)) % n;
        if (c < d) {
            System.out.print(c - 1);
        } else {
            System.out.print(d - 1);
        }
    }
}
