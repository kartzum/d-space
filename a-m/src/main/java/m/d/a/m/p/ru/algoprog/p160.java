// https://algoprog.ru/material/p160

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p160 {
    public static void main(String[] args) throws IOException {
        // tests();
        run();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = 100;
        int v = Integer.parseInt(reader.readLine());
        int[][] g = new int[n][n];
        for (int i = 0; i < v; i++) {
            String[] t = reader.readLine().split(" ");
            for (int j = 0; j < v; j++) {
                g[i][j] = Integer.parseInt(t[j]);
            }
        }
        String[] t = reader.readLine().split(" ");
        int start = Integer.parseInt(t[0]);
        int end = Integer.parseInt(t[1]);
        int[] dist = new int[v];
        int[] from = new int[v];
        boolean[] visited = new boolean[v];
        Arrays.fill(from, -1);
        bfs(v, g, start, end, visited, dist, from);
        printResults(end, visited, dist, from);
    }

    static void tests() {
        int v = 5;
        int[][] g = new int[][]{
                {0, 1, 0, 0, 1},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
        };
        int[] dist = new int[v];
        int[] from = new int[v];
        boolean[] visited = new boolean[v];
        int start = 2;
        int end = 4;
        Arrays.fill(from, -1);
        bfs(v, g, start, end, visited, dist, from);
        printResults(end, visited, dist, from);
    }

    static void printResults(int end, boolean[] visited, int[] dist, int[] from) {
        if (visited[end]) {
            if (dist[end] == 0) {
                System.out.println(dist[end]);
            } else {
                System.out.println(dist[end]);
                List<Integer> p = new ArrayList<>();
                for (int i = end; i != -1; i = from[i]) {
                    p.add(i);
                }
                Collections.reverse(p);
                for (int i : p) {
                    System.out.print((i + 1) + " ");
                }
            }
        } else {
            System.out.println("-1");
        }
    }

    static void bfs(int v, int[][] g, int start, int end, boolean[] visited, int[] dist, int[] from) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(start);
        dist[start] = 0;
        visited[start] = true;
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < v; i++) {
                if (g[u][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    dist[i] = dist[u] + 1;
                    from[i] = u;
                    queue.push(i);
                }
            }
        }
    }
}
