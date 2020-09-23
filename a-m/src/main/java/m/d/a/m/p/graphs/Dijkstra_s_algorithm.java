package m.d.a.m.p.graphs;

// https://www.geeksforgeeks.org/java-program-for-dijkstras-shortest-path-algorithm-greedy-algo-7/
// https://www.youtube.com/watch?v=tyQSgTytc4s
// https://www.softwaretestinghelp.com/dijkstras-algorithm-in-java/

import java.util.Arrays;

public class Dijkstra_s_algorithm {
    public static void main(String[] args) {
        test2();
    }

    static void test1() {
        int graph[][] = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        int dist[] = dijkstra(graph, 0);
        printSolution(dist, 0);
    }

    static void test2() {
        int graph[][] = new int[][]{
                {0, 2, 1, 0, 0, 0},
                {2, 0, 7, 0, 8, 4},
                {1, 7, 0, 7, 0, 3},
                {0, 0, 7, 0, 8, 4},
                {0, 8, 0, 8, 0, 5},
                {0, 4, 3, 4, 5, 0}};
        int dist[] = dijkstra(graph, 0);
        printSolution(dist, 0);
    }

    static int[] dijkstra(int graph[][], int src) {
        boolean debug = true;
        int V = graph.length;
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            if (debug) {
                System.out.println(u + ", " + Arrays.toString(dist));
            }
            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
        }
        return dist;
    }

    static int minDistance(int dist[], Boolean sptSet[]) {
        int V = dist.length;
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }

    static void printSolution(int dist[], int n) {
        int V = dist.length;
        for (int i = 0; i < V; i++)
            System.out.println(i + " tt " + dist[i]);
    }
}
