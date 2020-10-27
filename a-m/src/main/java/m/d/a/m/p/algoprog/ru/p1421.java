// https://algoprog.ru/material/p1421 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p1421 {
    public static void main(String[] args) {
        // tests();
        run();
    }

    static void run() {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(calc(s));
    }

    static String calc(String s) {
        StringBuilder buffer = new StringBuilder();
        int i = 0;
        Character prev = null;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c != ' ') {
                buffer.append(c);
                i++;
            } else if (prev != null && prev == ' ') {
                i++;
            } else {
                buffer.append(c);
                i++;
            }
            prev = c;
        }
        return buffer.toString();
    }


    static void tests() {
        System.out.println("'" + calc("   dd  f  " + "'"));
        System.out.println("'" + calc("   d  iz  czl l l h udq t  " + "'"));
    }
}
