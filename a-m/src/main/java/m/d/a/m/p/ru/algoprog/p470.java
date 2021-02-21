// https://algoprog.ru/material/p470

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p470 {
    public static void main(String[] args) throws IOException {
        run();
        // tests();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] t = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                g[i][j] = Integer.parseInt(t[j]);
            }
        }
        calc(n, g);
    }

    static void tests() {
    }

    static void calc(int n, int[][] g) {
        for (int row = 0; row < n; ++row) {
            int degree = 0;
            for (int column = 0; column < n; ++column) {
                degree += g[row][column];
            }
            System.out.println(degree);
        }
    }
}
