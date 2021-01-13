// https://algoprog.ru/material/p848

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p848 {
    public static void main(String[] args) throws IOException {
        run();
        // tests();
    }

    static void run() throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String t = r.readLine();
        boolean result = calc(t);
        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static void tests() {
        System.out.println(calc(" 2x+3=5 "));
        System.out.println(calc("5"));
    }

    static boolean calc(String t) {
        int i = 0;
        while (i < t.length()) {
            char current = t.charAt(i);
            if (Character.isDigit(current)) {
                int j = i;
                String num = "";
                while (j < t.length() && Character.isDigit(t.charAt(j))) {
                    num += t.charAt(j);
                    j++;
                }

                if (num.length() > 1) {
                    return false;
                } else {
                    int v = Integer.parseInt(num);
                    if (v > 5) {
                        return false;
                    }
                }

                i = j;
            } else {
                i++;
            }
        }
        return true;
    }
}
