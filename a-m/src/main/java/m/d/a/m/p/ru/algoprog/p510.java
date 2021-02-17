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
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < v; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            String[] t = reader.readLine().split(" ");
            for (int j = 0; j < t.length - 1; j++) {
                int vv = Integer.parseInt(t[j + 1]) - 1;
                g[i][vv] = 1;
                g[vv][i] = 1;
                map.get(vv).add(i);
            }
        }
        String[] t = reader.readLine().split(" ");
        int start = Integer.parseInt(t[0]) - 1;
        int end = Integer.parseInt(t[1]) - 1;
        List<Integer> starts = new ArrayList<>(map.get(start));
        List<Integer> ends = new ArrayList<>(map.get(end));
        starts.sort(Comparator.naturalOrder());
        ends.sort(Comparator.naturalOrder());
        // printG(v, g);
        int r = bfs(v, g, starts, ends);
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
                {1, 1, 1, 0, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {0, 1, 0, 1, 1},
        };
        List<Integer> starts = new ArrayList<>();
        starts.add(1);
        starts.add(0);
        List<Integer> ends = new ArrayList<>();
        ends.add(4);
        int r = bfs(v, g, starts, ends);
        System.out.println(r);
    }

    static int bfs(int v, int[][] g, List<Integer> starts, List<Integer> ends) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];
        int dist[] = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i : starts) {
            queue.push(i);
            visited[i] = true;
            dist[i] = 0;
        }
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
        int min = Integer.MAX_VALUE;
        for (int i : ends) {
            if (dist[i] != Integer.MAX_VALUE && dist[i] < min) {
                min = dist[i];
            }
        }
        return min != Integer.MAX_VALUE ? min : -1;
    }
}