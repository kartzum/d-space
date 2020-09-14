package m.d.a.m.p.ya.c1;

import java.util.Scanner;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine(); // "qiu";
        String b = input.nextLine(); // "iuq";
        System.out.println(run(a, b));
    }

    static int run(String a, String b) {
        if (a != null && b != null && a.length() == b.length()) {
            char[] aChars = a.toCharArray();
            char[] bChars = b.toCharArray();
            Arrays.sort(aChars);
            Arrays.sort(bChars);
            for (int i = 0; i < a.length(); i++) {
                if (aChars[i] != bChars[i]) {
                    return 0;
                }
            }
            return 1;
        }
        return 0;
    }
}
