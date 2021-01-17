// https://algoprog.ru/material/p2774

// https://www.geeksforgeeks.org/finding-the-maximum-square-sub-matrix-with-all-equal-elements/

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
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] c = reader.readLine().toCharArray();
            for (int j = 0; j < c.length; j++) {
                a[i][j] = c[j] == '#' ? 1 : 0;
            }
        }
        System.out.println(calc(a));
    }

    static void tests() {
        int[][] a1 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 1, 1}
        };
        System.out.println(calc(a1));
        int[][] a2 = new int[][]{
                {1}
        };
        System.out.println(calc(a2));
    }

    static int calc(int[][] a) {
        int n = a.length;
        int m = n;
        if (n == 1 && a[0][0] == 0) {
            return 0;
        }
        int[][] dp = new int[n][m];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    if (a[i][j] == a[i - 1][j] && a[i][j] == a[i][j - 1] && a[i][j] == a[i - 1][j - 1] && a[i][j] == 1) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
