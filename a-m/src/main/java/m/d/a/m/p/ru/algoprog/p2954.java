// https://algoprog.ru/material/p2954

package m.d.a.m.p.ru.algoprog;

import java.util.Scanner;

public class p2954 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        System.out.println((n + (-k % n)) % n);
    }
}
