// https://algoprog.ru/material/p160

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class p160 {
    public static void main(String[] args) throws IOException {
        // tests();
        run();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(reader.readLine());
        int[][] g = new int[v][v];
        for (int i = 0; i < v; i++) {
            String[] t = reader.readLine().split(" ");
            for (int j = 0; j < v; j++) {
                g[i][j] = Integer.parseInt(t[j]);
            }
        }
        String[] t = reader.readLine().split(" ");
        int src = Integer.parseInt(t[0]);
        int dest = Integer.parseInt(t[1]);
        int[] pred = new int[v];
        if (bfs(v, g, src, dest, pred)) {
            printPath(pred, dest);
        } else {
            System.out.println("-1");
        }
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
        int[] pred = new int[v];
        int src = 2;
        int dest = 4;
        boolean r = bfs(v, g, src, dest, pred);
        if (r) {
            printPath(pred, dest);
        }
    }

    static void printPath(int[] pred, int dest) {
        LinkedList<Integer> path = new LinkedList<>();
        int crawl = dest;
        path.add(crawl);
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }
        System.out.println(path.size() - 1);
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print((path.get(i) + 1) + " ");
        }
    }

    static boolean bfs(int v, int[][] g, int src, int dest, int[] pred) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            visited[i] = false;
            pred[i] = -1;
        }
        visited[src] = true;
        queue.add(src);
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < v; i++) {
                if (g[u][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    pred[i] = u;
                    queue.add(i);
                    if (i == dest) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
