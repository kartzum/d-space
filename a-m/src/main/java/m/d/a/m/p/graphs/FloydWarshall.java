package m.d.a.m.p.graphs;

/**
 * https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
 */
public class FloydWarshall {
    public static void main(String[] args) {
        // test1();
        test2();
    }

    private static void test1() {
        int INF = 99999;
        int V = 4;
        int[][] graph = new int[][]
                {
                        {0, 5, INF, 10},
                        {INF, 0, 3, INF},
                        {INF, INF, 0, 1},
                        {INF, INF, INF, 0}
                };
        int[][] dist = new Solution1().floydWarshall(graph, V);
        printSolution1(dist, V, INF);
    }

    static void printSolution1(int[][] dist, int V, int INF) {
        System.out.println("The following matrix shows the shortest " +
                "distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static class Solution1 {
        int[][] floydWarshall(int[][] graph, int V) {
            int[][] dist = new int[V][V];
            int i, j, k;

        /* Initialize the solution matrix same as input graph matrix.
           Or we can say the initial values of shortest distances
           are based on shortest paths considering no intermediate
           vertex. */
            for (i = 0; i < V; i++)
                for (j = 0; j < V; j++)
                    dist[i][j] = graph[i][j];

        /* Add all vertices one by one to the set of intermediate
           vertices.
          ---> Before start of an iteration, we have shortest
               distances between all pairs of vertices such that
               the shortest distances consider only the vertices in
               set {0, 1, 2, .. k-1} as intermediate vertices.
          ----> After the end of an iteration, vertex no. k is added
                to the set of intermediate vertices and the set
                becomes {0, 1, 2, .. k} */
            for (k = 0; k < V; k++) {
                // Pick all vertices as source one by one
                for (i = 0; i < V; i++) {
                    // Pick all vertices as destination for the
                    // above picked source
                    for (j = 0; j < V; j++) {
                        // If vertex k is on the shortest path from
                        // i to j, then update the value of dist[i][j]
                        if (dist[i][k] + dist[k][j] < dist[i][j])
                            dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }

            return dist;
        }

    }

    /**
     * 4 5
     * 1 2 5
     * 1 4 24
     * 2 4 6
     * 3 4 4
     * 3 2 7
     * 3
     * 1 2
     * 3 1
     * 1 4
     */
    private static void test2() {
        int roadNodes = 4;
        int roadEdges = 5;
        int[] roadFrom = new int[roadEdges];
        int[] roadTo = new int[roadEdges];
        int[] roadWeight = new int[roadEdges];

        roadFrom[0] = 1;
        roadTo[0] = 2;
        roadWeight[0] = 5;

        roadFrom[1] = 1;
        roadTo[1] = 4;
        roadWeight[1] = 24;

        roadFrom[2] = 2;
        roadTo[2] = 4;
        roadWeight[2] = 6;

        roadFrom[3] = 3;
        roadTo[3] = 4;
        roadWeight[3] = 4;

        roadFrom[4] = 3;
        roadTo[4] = 2;
        roadWeight[4] = 7;

        int q = 3;
        int[] x = new int[q + 1];
        int[] y = new int[q + 1];
        x[0] = 1;
        y[0] = 2;
        x[1] = 3;
        y[1] = 1;
        x[2] = 1;
        y[2] = 4;

        int inf = 99999;

        int[][] dist = calculate(roadFrom, roadTo, roadWeight, roadNodes + 1, roadEdges, inf);

        for (int i = 0; i < q; i++) {
            int x_ = x[i];
            int y_ = y[i];
            if (dist[x_][y_] != inf) {
                System.out.println(dist[x_][y_]);
            } else {
                System.out.println("-1");
            }
        }
    }

    static int[][] calculate(
            int[] roadFrom,
            int[] roadTo,
            int[] roadWeight,
            int n,
            int m,
            int inf
    ) {
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    graph[i][j] = inf;
                } else {
                    graph[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int x_ = roadFrom[i];
            int y_ = roadTo[i];
            int w = roadWeight[i];
            graph[x_][y_] = w;
        }

        return floydWarshall(graph, n);
    }

    static int[][] floydWarshall(int[][] graph, int v) {
        int[][] dist = new int[v][v];
        int i, j, k;

        for (i = 0; i < v; i++)
            for (j = 0; j < v; j++)
                dist[i][j] = graph[i][j];

        for (k = 0; k < v; k++) {
            for (i = 0; i < v; i++) {
                for (j = 0; j < v; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        return dist;
    }
}
