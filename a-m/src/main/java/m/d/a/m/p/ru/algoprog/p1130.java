// https://algoprog.ru/material/p1130

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p1130 {
    public static void main(String[] args) throws IOException {
        // tests();
        run();
        // System.out.println(Arrays.toString(read("\t\t 123 213 \t 55 fsd 78rter7")));
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        long[] a = new long[21];
        long[] b = new long[21];
        /*String[] nn = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(nn[i]);
            b[i] = i;
        }*/
        long[] t = read(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = t[i];
            b[i] = i;
        }
        calc(n, a, b);
    }

    static void tests() {
        calc(1, new long[]{24, 0}, new long[]{0, 0});
        System.out.println();
        calc(2, new long[]{7, 8, 0}, new long[]{0, 1, 0});
    }

    static void calc(long n, long[] a, long b[]) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (a[j] < a[j + 1]) {
                    long k = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = k;
                    k = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = k;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print((b[i] + 1) + " ");
        }
    }

    static long[] read(String t) {
        List<Long> list = new ArrayList<>();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if (Character.isDigit(c)) {
                b.append(c);
            } else {
                if(b.length() > 0) {
                    list.add(Long.parseLong(b.toString()));
                    b.setLength(0);
                }
            }
        }
        if (b.length() > 0) {
            list.add(Long.parseLong(b.toString()));
        }
        long[] r = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            r[i] = list.get(i);
        }
        return r;
    }
}
