// https://algoprog.ru/material/p944

package m.d.a.m.p.algoprog.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p944 {
    public static void main(String[] args) throws IOException {
        run(args);
        // tests();
    }

    static void run(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] x = new int[n][m];
        for (int j = 0; j < n; j++) {
            String[] t = reader.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                x[j][i] = Integer.parseInt(t[i]);
            }
        }
        System.out.println(calc(n, m, x));
    }

    static void tests() {
        int n = 5;
        int m = 5;
        int[][] x = new int[][]{
                {1, 1, 1, 1, 1},
                {3, 100, 100, 100, 100},
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 1},
                {1, 1, 1, 1, 1}
        };
        System.out.println(calc(n, m, x));
    }

    static int calc(int n, int m, int[][] x) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = x[i][j];
                if (i > 0 && j > 0) {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j];
                    } else if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
