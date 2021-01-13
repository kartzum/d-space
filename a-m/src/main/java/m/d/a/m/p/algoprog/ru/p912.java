// https://algoprog.ru/material/p912

package m.d.a.m.p.algoprog.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p912 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        System.out.println(calc(n));
    }

    static int calc(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        int m = n + 1;
        int[] table = new int[m];
        table[0] = 1;
        table[1] = 2;
        table[2] = 4;
        for (int i = 3; i < m; i++) {
            table[i] = table[i - 1] + table[i - 2] + table[i - 3];
        }
        return table[m - 1];
    }
}
