// https://algoprog.ru/material/p1629

package m.d.a.m.p.algoprog.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String t = r.readLine();
        System.out.println(calc(t));
        //tests();
    }

    static void tests() {
        List<String> strings = new ArrayList<>();
        strings.add(";-[");
        // strings.add(":[");
        //strings.add(";-[:[");
        // strings.add(":)");
        /*strings.add(";---------[[[[[[[[");*/
        //strings.add(":-)]");
        //strings.add(";--");
        //strings.add("-)");
        //strings.add("::-(");
        //strings.add(":-()");
        // strings.add(":);------[[[[[]");
        for (String s : strings) {
            System.out.println(calc(s));
        }
    }

    static int calc(String t) {
        if (t == null || t.length() == 0) {
            return 0;
        }
        List<Character> starts = new ArrayList<>();
        starts.add(';');
        starts.add(':');
        List<Character> brackets = new ArrayList<>();
        brackets.add('(');
        brackets.add('[');
        brackets.add('{');
        brackets.add(')');
        brackets.add(']');
        brackets.add('}');
        int k = 0;
        int i = 0;
        while (i < t.length()) {
            char c = t.charAt(i);
            if (starts.contains(c)) {
                char prev = c;
                int j = i + 1;
                boolean y = false;
                while (j < t.length()) {
                    char x = t.charAt(j);
                    if (x == '-' || brackets.contains(x)) {
                        if (x == '-' && starts.contains(prev)) {
                            j++;
                            prev = x;
                        } else if (x == '-' && prev == '-') {
                            j++;
                            prev = x;
                        } else if (brackets.contains(x) && prev == '-') {
                            j++;
                            prev = x;
                            y = true;
                        } else if (starts.contains(prev) && brackets.contains(x)) {
                            j++;
                            prev = x;
                            y = true;
                        } else if (brackets.contains(x) && x == prev) {
                            j++;
                            prev = x;
                            y = true;
                        } else {
                            if (brackets.contains(x) && x == prev) {
                                y = true;
                            }
                            j++;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i = j;
                if (y) {
                    k++;
                }
            } else {
                i++;
            }
        }
        return k;
    }
}
