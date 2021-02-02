// https://algoprog.ru/material/p176

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p176 {
    public static void main(String[] args) throws IOException {
        //tests();
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
        reader.readLine();
        int[] colors = new int[n];
        String[] t = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            colors[i] = Integer.parseInt(t[i]);
        }
        System.out.println(calc(n, m, colors));
    }

    static void tests() {
        int n = 7;
        int[][] m = new int[][]{
                {0, 1, 0, 0, 0, 1, 1},
                {1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0}
        };
        int[] colors = new int[]{1, 1, 1, 1, 1, 3, 3};
        System.out.println(calc(n, m, colors));
    }

    static int calc(int n, int[][] m, int[] colors) {
        int bad = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int b = m[i][j];
                if (b == 1) {
                    if (colors[i] != colors[j]) {
                        bad++;
                    }
                }
            }
        }
        return bad / 2;
    }
}
