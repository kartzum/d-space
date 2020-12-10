// https://algoprog.ru/material/p426 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p426 {
    public static void main(String[] args) throws IOException {
        Charset charset = Charset.forName("cp866");
        Charset defaultCharset = Charset.forName("UTF-8");

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in, charset));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, charset));
        for (int i = 0; i < 1000; i++) {
            String t = r.readLine();
            String result = calc(t);
            if (result.length() > 0) {
                out.println(result);
                out.flush();
            }
        }
        // tests();
    }

    static void tests() {
        System.out.println(calc("Флатландия - наша родина. Ура!"));
    }

    static String calc(String t) {
        List<Character> del = new ArrayList<>();
        del.add('.');
        del.add('!');
        del.add('?');
        del.add(':');
        del.add('-');
        del.add(',');
        del.add(';');
        del.add('(');
        del.add(')');
        del.add(' ');
        if (t == null) {
            return "";
        }
        List<String> goodWords = new ArrayList<>();
        List<String> badWords = new ArrayList<>();
        int i = 0;
        while (i < t.length()) {
            char c = t.charAt(i);
            if (!del.contains(c)) {
                Set<Character> unique = new HashSet<>();
                int j = i;
                while (j < t.length()) {
                    char x = t.charAt(j);
                    if (del.contains(x)) {
                        break;
                    }
                    unique.add(x);
                    j++;
                }
                String w = t.substring(i, j);
                if (unique.size() > 3) {
                    goodWords.add(w);
                } else {
                    badWords.add(w);
                }
                i = j;
            }
            i++;
        }
        if (goodWords.size() > badWords.size()) {
            return t;
        } else {
            return "";
        }
    }
}
