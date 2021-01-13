// https://algoprog.ru/material/p113656

package m.d.a.m.p.ru.algoprog;

import java.util.Scanner;

public class p113656 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String w = input.nextLine();
        System.out.println(calc(w, 0, w.length() - 1));
        // tests();
    }

    static String calc(String w, int i, int j) {
        if (j - i <= 1) {
            if (j == i) {
                return Character.toString(w.charAt(i));
            } else {
                return w.substring(i, j + 1);
            }
        } else {
            return w.charAt(i) + "(" + calc(w, i + 1, j - 1) + ")" + w.charAt(j);
        }
    }

    static void tests() {
        String w1 = "abcd";
        System.out.println(calc(w1, 0, w1.length() - 1));
        String w2 = "example";
        System.out.println(calc(w2, 0, w2.length() - 1));
    }
}
