// https://algoprog.ru/material/p206

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p206 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        System.out.println(calc(n, m));
    }

    static int calc(int n, int m) {
        int[][] mt = new int[n][m];
        for (int i = 0; i < n; i++) {
            mt[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            mt[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                mt[i][j] = mt[i - 1][j] + mt[i][j - 1];
            }
        }
        return mt[n - 1][m - 1];
    }
}
