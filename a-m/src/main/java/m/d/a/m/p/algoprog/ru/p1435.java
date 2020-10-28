// https://algoprog.ru/material/p1435 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p1435 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(calc(s));
        // System.out.println(calc("127.0.0.1"));
        // System.out.println(calc("12...34"));
        // System.out.println(calc("0.256.21.123"));
    }

    static String calc(String s) {
        if (s == null || s.length() == 0) {
            return "0";
        }
        List<String> parts = new ArrayList<>();
        int i = 0;
        StringBuilder buffer = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '.') {
                parts.add(buffer.toString());
                buffer.delete(0, buffer.length());
            }
            if (c != '.') {
                buffer.append(c);
            }
            i++;
        }
        if (buffer.length() > 0) {
            parts.add(buffer.toString());
            buffer.delete(0, buffer.length());
        }
        if (parts.size() != 4) {
            return "0";
        }
        for (String p : parts) {
            if (p.length() == 0) {
                return "0";
            }
            for (int j = 0; j < p.length(); j++) {
                if (!Character.isDigit(p.charAt(j))) {
                    return "0";
                }
            }
            int v = Integer.parseInt(p);
            if (v > 255 || v < 0) {
                return "0";
            }
        }
        return "1";
    }
}
