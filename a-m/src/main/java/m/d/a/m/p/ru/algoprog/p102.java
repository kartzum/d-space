// https://algoprog.ru/material/p102

package m.d.a.m.p.ru.algoprog;

import java.util.Scanner;

public class p102 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String value = input.nextLine();
        char c = value.charAt(0);
        if (c >= '0' && c <= '9') {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
