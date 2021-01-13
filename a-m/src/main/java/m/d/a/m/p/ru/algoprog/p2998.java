// https://algoprog.ru/material/p2998

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2998 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        System.out.println(calc(n));
    }

    static int calc(int n) {
        int[][] table = new int[n][10];
        table[0][0] = 0;
        for (int i = 1; i < 10; i += 1) {
            table[0][i] = 1;
        }
        for (int i = 1; i < n; i += 1) {
            table[i][0] = table[i - 1][0] + table[i - 1][1];
            for (int j = 1; j <= 8; j += 1) {
                table[i][j] = table[i - 1][j] + table[i - 1][j - 1] + table[i - 1][j + 1];
            }
            table[i][9] = table[i - 1][9] + table[i - 1][8];
        }
        int result = 0;
        for (int i = 0; i < 10; i += 1) {
            result += table[n - 1][i];
        }
        return result;
    }
}
