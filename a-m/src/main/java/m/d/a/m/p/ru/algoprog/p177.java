// https://algoprog.ru/material/p177

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p177 {
    public static void main(String[] args) throws IOException {
        run();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] t = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                m[i][j] = Integer.parseInt(t[j]);
            }
        }
        calc(n, m);
    }

    static void calc(int n, int[][] m) {
        int distMin = Integer.MAX_VALUE;
        int min1 = 0;
        int min2 = 0;
        int min3 = 0;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                for (int c = b + 1; c < n; c++) {
                    int dist = m[a][b] + m[b][c] + m[c][a];
                    if (dist < distMin) {
                        distMin = dist;
                        min1 = a;
                        min2 = b;
                        min3 = c;
                    }
                }
            }
        }
        System.out.println((min1 + 1) + " " + (min2 + 1) + " " + (min3 + 1));
    }
}
