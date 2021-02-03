// https://algoprog.ru/material/p479

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p479 {
    public static void main(String[] args) throws IOException {
        run();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] g = new int[n][n];
        for (int i = 0; i < m; i++) {
            String[] t = reader.readLine().split(" ");
            int a = Integer.parseInt(t[0]) - 1;
            int b = Integer.parseInt(t[1]) - 1;
            g[a][b] = 1;
            g[b][a] = 1;
        }
        System.out.println(calc(n, g));
    }

    static String calc(int n, int[][] g) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (g[i][j] == 1) {
                        if (k != j && k != i && g[i][k] + g[j][k] == 1) {
                            return "NO";
                        }
                    }
                }
            }
        }
        return "YES";
    }
}
