// https://algoprog.ru/material/p842 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p842 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        System.out.println(calc(n));
    }

    static int calc(int n) {
        int m = n + 1;
        int[] table = new int[m];
        table[0] = 1;
        table[1] = 1;
        for (int i = 2; i < m; i++) {
            table[i] = (table[i - 1] + table[i - 2]) % 10;
        }
        return table[m - 1];
    }
}
