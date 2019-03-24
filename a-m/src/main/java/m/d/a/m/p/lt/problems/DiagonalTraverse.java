package m.d.a.m.p.lt.problems;

import java.util.Arrays;

public class DiagonalTraverse {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        System.out.println(Arrays.toString(new Solution().findDiagonalOrder(matrix)));
    }

    static class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) return new int[0];

            int m = matrix.length;
            int n = matrix[0].length;

            int[] result = new int[m * n];
            int row = 0;
            int col = 0;

            int rowD = -1;
            int colD = 1;

            for (int i = 0; i < m * n; i++) {
                result[i] = matrix[row][col];
                row += rowD;
                col += colD;

                if (row >= m) {
                    row = m - 1;
                    col += 2;
                    rowD = rowD * (-1);
                    colD = colD * (-1);
                }
                if (col >= n) {
                    col = n - 1;
                    row += 2;
                    rowD = rowD * (-1);
                    colD = colD * (-1);
                }
                if (row < 0) {
                    row = 0;
                    rowD = rowD * (-1);
                    colD = colD * (-1);
                }
                if (col < 0) {
                    col = 0;
                    rowD = rowD * (-1);
                    colD = colD * (-1);
                }
            }

            return result;
        }
    }
}
