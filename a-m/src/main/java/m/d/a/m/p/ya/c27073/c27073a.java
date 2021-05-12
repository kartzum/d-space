package m.d.a.m.p.ya.c27073;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class c27073a {
    public static void main(String[] args) throws IOException {
        run();
        //tests();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = reader.readLine().split(" ");
        System.out.println(calc(temp[0], temp[1]));
    }

    static void tests() {
        System.out.println(calc("abc.", "abd."));
        System.out.println(calc("aaaa...", "bbbb..."));
    }

    static boolean calc(String s, String t) {
        int si = s.length() - 1;
        int ti = t.length() - 1;
        int sc = 0;
        int tc = 0;
        while (si >= 0 || ti >= 0) {
            while (si >= 0 && (sc > 0 || s.charAt(si) == '.')) {
                if (s.charAt(si) == '.') {
                    sc++;
                } else {
                    sc--;
                }
                si--;
            }
            while (ti >= 0 && (tc > 0 || t.charAt(ti) == '.')) {
                if (t.charAt(ti) == '.') {
                    tc++;
                } else {
                    tc--;
                }
                ti--;
            }
            if (si >= 0 && ti >= 0) {
                if (s.charAt(si) != t.charAt(ti)) {
                    return false;
                }
                si--;
                ti--;
            } else if (si < 0 && ti >= 0) {
                return false;
            } else {
                return si < 0;
            }
        }
        return true;
    }
}
