// https://algoprog.ru/material/p111541

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p111541 {
    public static void main(String[] args) throws IOException {
        // tests();
        run();
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
        calc(g, n);
    }

    static void tests() {
        int[][] g = new int[][]{
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0},
        };
        calc(g, 3);
    }

    static void calc(int[][] g, int n) {
        boolean[] visited = new boolean[n];
        dfs(g, n, visited, 0);
        if (!isConnected(n, visited)) {
            System.out.println("NO");
            return;
        }
        int answer = 0;
        for (int v1 = 0; v1 < n; ++v1) {
            for (int v2 = 0; v2 < n; ++v2) {
                if (g[v1][v2] == 1) {
                    ++answer;
                }
            }
        }
        if (answer / 2 == (n - 1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static void dfs(int[][] g, int n, boolean[] visited, int v) {
        visited[v] = true;
        for (int i = 0; i < n; i++) {
            if (g[v][i] == 1 && !visited[i]) {
                dfs(g, n, visited, i);
            }
        }
    }

    static boolean isConnected(int n, boolean[] visited) {
        for (int vertex = 0; vertex < n; ++vertex) {
            if (!visited[vertex]) {
                return false;
            }
        }
        return true;
    }
}
