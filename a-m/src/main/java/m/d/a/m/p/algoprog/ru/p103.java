// https://algoprog.ru/material/p103 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p103 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String value = input.nextLine();
        char c = value.charAt(0);
        if (c >= 'a' && c <= 'z') {
            System.out.print((char) (c - 32));
        } else {
            System.out.println(c);
        }

    }
}
