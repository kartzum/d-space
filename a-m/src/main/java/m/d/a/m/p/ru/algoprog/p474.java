// https://algoprog.ru/material/p474

// https://site.ada.edu.az/~medv/acm/Docs%20e-olimp/Volume%2040/3986.htm

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p474 {
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
        int[] out = new int[n];
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] == 1) {
                    out[i]++;
                    in[j]++;
                }
            }
        }
        int sources = 0;
        int sinks = 0;
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                sources++;
            }
            if (out[i] == 0) {
                sinks++;
            }
        }
        System.out.println(sources);
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                System.out.println((i + 1));
            }
        }
        System.out.println(sinks);
        for (int i = 0; i < n; i++) {
            if (out[i] == 0) {
                System.out.println((i + 1));
            }
        }
    }
}
