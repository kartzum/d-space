// https://algoprog.ru/material/p2774

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2774 {
    public static void main(String[] args) throws IOException {
        run(args);
        // tests();
    }

    static void run(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        char[][] x = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] c = reader.readLine().toCharArray();
            x[i] = c;
        }
        System.out.println(calc(x));
    }

    static void tests() {
        char[][] x = new char[][]{
                {'.', '.', '.', '.', '.'},
                {'.', '#', '#', '#', '.'},
                {'.', '#', '#', '#', '#'},
                {'.', '#', '#', '#', '#'},
                {'.', '.', '.', '#', '#'},
        };
        System.out.println(calc(x));
    }

    static int calc(char[][] x) {
        int n = x.length;
        int m = n;
        int[][] dp = new int[n][m];
        int r = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i * j == 0) {
                    continue;
                }
                if (x[i][j] == '#') {
                    int m1 = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    int m2 = Math.min(m1, dp[i - 1][j - 1]);
                    dp[i][j] += 1 + m2;
                    if (dp[i][j] > r) {
                        r = dp[i][j];
                    }
                }
            }
        }
        return r;
    }
}
