// https://algoprog.ru/material/pc777pD

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pc777pD {
    public static void main(String[] args) throws IOException {
        run();
        // tests();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = reader.readLine();
        }
        calc(n, a);
    }

    static void tests() {
        // System.out.println(calc("1 2 +"));
        //System.out.println(calc("8 9 + 1 7 - *"));
        calc(3, new String[]{"#book", "#bigtown", "#big"});
    }

    static void calc(int n, String[] a) {
        String prev = a[n - 1];
        for (int p = n - 2; p >= 0; p--) {
            int index = 0;
            while (index < a[p].length()) {
                if (index >= prev.length()) {
                    break;
                }
                if (a[p].charAt(index) < prev.charAt(index)) {
                    index = a[p].length();
                    break;
                }
                if (a[p].charAt(index) > prev.charAt(index)) {
                    break;
                }
                ++index;
            }
            a[p] = a[p].substring(0, index);
            prev = a[p];
        }
        for (int p = 0; p < n; p++) {
            System.out.println(a[p]);
        }
    }
}
