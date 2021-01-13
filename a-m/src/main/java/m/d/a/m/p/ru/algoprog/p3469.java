// https://algoprog.ru/material/p3469

package m.d.a.m.p.ru.algoprog;

import java.util.Scanner;

public class p3469 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int h = (n / 3600) % 24;
        int m = (n % 3600) / 60;
        int s = (n % 3600) % 60;
        String t = h + ":" + m + ":" + s;
        System.out.println(t);
    }
}
