// https://algoprog.ru/material/p637

// http://it.kgsu.ru/TI_14/dpinfz6_5.html
// http://it.kgsu.ru/TI_14/dpinf011.html
// https://hsecodes.com/index.php/tasksdecision/index/362

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class p637 {
    public static void main(String[] args) throws IOException {
        run(args);
        // tests();
    }

    static void run(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = n;
        int k = Integer.parseInt(line[1]);
        int[][] x = new int[n][m];
        for (int j = 0; j < n; j++) {
            String[] t = reader.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                x[j][i] = Integer.parseInt(t[i]);
            }
        }
        System.out.println(calc(n, m, k, x));
    }

    static void tests() {
        int n = 5;
        int m = 5;
        int[][] x = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 100}
        };
        System.out.println(calc(n, m, 7, x));
    }

    static int calc(int n, int m, int k, int[][] x) {
        int[][] s = new int[n][m];
        s[0][0] = x[0][0];
        for (int p = 2; p <= k; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int max = 0;
                    if (odd(i + j) != odd(p)) {
                        if (i + 1 < n && s[i + 1][j] > max) {
                            max = s[i + 1][j];
                        }
                        if (i - 1 >= 0 && s[i - 1][j] > max) {
                            max = s[i - 1][j];
                        }
                        if (j - 1 >= 0 && s[i][j - 1] > max) {
                            max = s[i][j - 1];
                        }
                        if (j + 1 < m && s[i][j + 1] > max) {
                            max = s[i][j + 1];
                        }
                    }
                    if (max != 0) {
                        s[i][j] = max + x[i][j];
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s[i][j] > max) {
                    max = s[i][j];
                }
            }
        }
        return max;
    }

    static boolean odd(int v) {
        return v % 2 != 0;
    }
}
