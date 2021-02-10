// https://algoprog.ru/material/p200

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p200 {
    public static void main(String[] args) throws IOException {
        run();
    }

    static int count = 0;

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        char[][] g = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] t = reader.readLine().toCharArray();
            for (int j = 0; j < t.length; j++) {
                g[i][j] = t[j];
            }
        }
        String[] t = reader.readLine().split(" ");
        int i = Integer.parseInt(t[0]);
        int j = Integer.parseInt(t[1]);
        count = 0;
        dfs(g, i - 1, j - 1);
        System.out.println(count);
    }

    static void dfs(char[][] g, int i, int j) {
        if (g[i][j] == '*') {
            return;
        }
        count++;
        g[i][j] = '*';
        dfs(g, i - 1, j);
        dfs(g, i + 1, j);
        dfs(g, i, j - 1);
        dfs(g, i, j + 1);
    }
}
