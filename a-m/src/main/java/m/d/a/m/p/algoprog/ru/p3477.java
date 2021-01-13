// https://algoprog.ru/material/p3477

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p3477 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int h = input.nextInt();
        int a = input.nextInt();
        int b = input.nextInt();
        int v = ((h - b - 1) / (a - b)) + 1;
        System.out.println(v);
    }
}
