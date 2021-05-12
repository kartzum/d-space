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
        StringBuilder s = new StringBuilder(temp[0]);
        StringBuilder t = new StringBuilder(temp[1]);
        System.out.println(calc(s, t));
    }

    static void tests() {
        System.out.println(calc(new StringBuilder("abc."), new StringBuilder("abd.")));
        System.out.println(calc(new StringBuilder("aaaa..."), new StringBuilder("bbbb...")));
    }

    static boolean calc(StringBuilder s, StringBuilder t) {
        int ps = applyBackspaces(s);
        int pt = applyBackspaces(t);

        if (pt != ps) {
            return false;
        } else if (ps == -1 && pt == -1) {
            return true;
        } else {
            for (int i = 0; i <= pt; i++) {
                if (s.charAt(i) != t.charAt(i))
                    return false;
            }
            return true;
        }
    }

    static int applyBackspaces(StringBuilder v) {
        int p = -1;
        for (int i = 0; i < v.length(); i++) {
            if (v.charAt(i) == '.' && p != -1) {
                p -= 1;
            } else if (v.charAt(i) != '.') {
                v.setCharAt(p + 1, v.charAt(i));
                p += 1;
            }
        }
        return p;
    }
}
