// https://algoprog.ru/material/p913

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p913 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        System.out.println(calc(n));
    }

    static int calc(int n) {
        int[][] table = new int[n + 1][2];
        table[n][0] = 1;
        table[n][1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            table[i][1] = table[i + 1][0];
            table[i][0] = table[i + 1][0] + table[i + 1][1];
        }
        return table[0][0];
    }
}
