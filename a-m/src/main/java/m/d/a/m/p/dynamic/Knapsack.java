package m.d.a.m.p.dynamic;

// https://www.geeksforgeeks.org/java-program-for-dynamic-programming-set-10-0-1-knapsack-problem/
// https://www.youtube.com/watch?v=Y9J1odinMS0
// https://www.guru99.com/knapsack-problem-dynamic-programming.html
// https://www.baeldung.com/java-knapsack

public class Knapsack {
    public static void main(String[] args) {
        // int val[] = new int[]{60, 100, 120};
        // int wt[] = new int[]{10, 20, 30};
        int val[] = new int[]{10, 4, 2, 6, 7};
        int wt[] = new int[]{7, 3, 1, 5, 4};
        int W = 12;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }

    private static int knapSack(int M, int W[], int V[], int n) {
        int B[][] = new int[n + 1][M + 1];
        boolean debug = true;
        if (debug) {
            print(B);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= M; j++) {
                B[i][j] = B[i - 1][j];
                if ((j >= W[i - 1]) && (B[i][j] < B[i - 1][j - W[i - 1]] + V[i - 1])) {
                    B[i][j] = B[i - 1][j - W[i - 1]] + V[i - 1];
                }
                if (debug) {
                    System.out.print(B[i][j] + " ");
                }
            }
            if (debug) {
                System.out.print("\n");
            }
        }
        if (debug) {
            System.out.println("Max Value:\t" + B[n][M]);
            System.out.println("Selected Packs: ");
        }
        while (n != 0) {
            if (B[n][M] != B[n - 1][M]) {
                if (debug) {
                    System.out.println("\tPackage " + n + " with W = " + W[n - 1] + " and Value = " + V[n - 1]);
                }
                M = M - W[n - 1];
            }
            n--;
        }
        return B[n][M];
    }

    private static void print(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

}
