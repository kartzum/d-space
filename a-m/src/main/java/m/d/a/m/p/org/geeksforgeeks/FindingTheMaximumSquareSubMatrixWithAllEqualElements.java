// https://www.geeksforgeeks.org/finding-the-maximum-square-sub-matrix-with-all-equal-elements/

package m.d.a.m.p.org.geeksforgeeks;

public class FindingTheMaximumSquareSubMatrixWithAllEqualElements {
    public static void main(String[] args) {
        tests();
    }

    static void tests() {
        test1();
    }

    static void test1() {
        int[][] a = {
                {2, 2, 3, 3, 4, 4},
                {5, 5, 7, 7, 7, 4},
                {1, 2, 7, 7, 7, 4},
                {4, 4, 7, 7, 7, 4},
                {5, 5, 5, 1, 2, 7},
                {8, 7, 9, 4, 4, 4}
        };
        System.out.println(largestKSubmatrix(a));
    }

    static int largestKSubmatrix(int[][] a) {
        int n = a.length;
        int m = n;
        int[][] dp = new int[n][m];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    if (a[i][j] == a[i - 1][j] && a[i][j] == a[i][j - 1] && a[i][j] == a[i - 1][j - 1]) {
                        dp[i][j] = (dp[i - 1][j] > dp[i][j - 1] &&
                                dp[i - 1][j] > dp[i - 1][j - 1] + 1) ?
                                dp[i - 1][j] :
                                (dp[i][j - 1] > dp[i - 1][j] &&
                                        dp[i][j - 1] > dp[i - 1][j - 1] + 1) ?
                                        dp[i][j - 1] :
                                        dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
