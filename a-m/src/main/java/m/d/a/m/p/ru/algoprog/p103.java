// https://algoprog.ru/material/p103

package m.d.a.m.p.ru.algoprog;

import java.util.Scanner;

public class p103 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String value = input.nextLine();
        int shift = 'a' - 'A';
        char c = value.charAt(0);
        if (c >= 'a' && c <= 'z') {
            System.out.print((char) (c - shift));
        } else {
            System.out.println(c);
        }

    }
}
