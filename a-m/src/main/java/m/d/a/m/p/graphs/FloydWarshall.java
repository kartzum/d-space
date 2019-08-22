package m.d.a.m.p.graphs;

/**
 * https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
 */
public class FloydWarshall {
    public static void main(String[] args) {
        test1();
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
}
