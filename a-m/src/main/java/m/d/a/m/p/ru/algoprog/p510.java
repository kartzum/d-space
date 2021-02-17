// https://algoprog.ru/material/p510

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p510 {
    public static void main(String[] args) throws IOException {
        // tests();
        run();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(reader.readLine());
        int[][] g = new int[v][v];
        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            String[] t = reader.readLine().split(" ");
            int k = Integer.parseInt(t[0]);
            int[] ll = new int[k];
            for (int j = 0; j < t.length - 1; j++) {
                ll[j] = Integer.parseInt(t[j + 1]);
            }
            for (int j = 0; j < ll.length; j++) {
                int vv = ll[j] - 1;
                g[i][vv] = 1;
            }
        }
        String[] t = reader.readLine().split(" ");
        int start = Integer.parseInt(t[0]) - 1;
        int end = Integer.parseInt(t[1]) - 1;
        boolean[] visited = new boolean[v];
        int dist[] = new int[v];
        // printG(v, g);
        Arrays.fill(dist, Integer.MAX_VALUE);
        int r = bfs(v, g, start, end, visited, dist);
        System.out.println(r);
    }

    static void printG(int v, int[][] g) {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(g[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void tests() {
        int v = 5;
        int[][] g = new int[][]{
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
        };
        boolean[] visited = new boolean[v];
        int start = 0;
        int end = 4;
        int dist[] = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int r = bfs(v, g, start, end, visited, dist);
        System.out.println(r);
    }

    static int bfs(int v, int[][] g, int start, int end, boolean[] visited, int dist[]) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(start);
        visited[start] = true;
        dist[start] = 0;
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < v; i++) {
                if (g[u][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    dist[i] = dist[u] + 1;
                    queue.push(i);
                }
            }
        }
        if (dist[end] == Integer.MAX_VALUE) {
            return -1;
        }
        return dist[end] - 1;
    }
}