// https://algoprog.ru/material/p3609

package m.d.a.m.p.ru.algoprog;

import java.util.Scanner;

public class p3609 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        double d = Double.parseDouble(a);
        System.out.print((int) (d * 10) % 10);
    }
}
