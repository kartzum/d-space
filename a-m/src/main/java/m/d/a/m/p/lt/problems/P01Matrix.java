package m.d.a.m.p.lt.problems;

public class P01Matrix {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        final int[][] m1 = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
        };
        final int[][] r1 = new Solution().updateMatrix(m1);
        print(r1);
    }

    private static void print(int[][] image) {
        for (int[] ints : image) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    static class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            int[][] mark = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        continue;
                    }
                    matrix[i][j] = getDistance(matrix, i, j, mark);
                }
            }
            return matrix;
        }

        private int getDistance(int[][] matrix, int i, int j, int[][] mark) {
            if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || mark[i][j] == 1) {
                return 100000;
            }

            if (i - 1 >= 0 && matrix[i - 1][j] == 0) {
                return 1;
            }
            if (j - 1 >= 0 && matrix[i][j - 1] == 0) {
                return 1;
            }
            if (i + 1 < matrix.length && matrix[i + 1][j] == 0) {
                return 1;
            }
            if (j + 1 < matrix[0].length && matrix[i][j + 1] == 0) {
                return 1;
            }
            mark[i][j] = 1;
            int searchUp = 1 + getDistance(matrix, i - 1, j, mark);
            int searchLeft = 1 + getDistance(matrix, i, j - 1, mark);
            int searchDown = 1 + getDistance(matrix, i + 1, j, mark);
            int searchRight = 1 + getDistance(matrix, i, j + 1, mark);
            mark[i][j] = 0;
            return Math.min(Math.min(searchDown, searchLeft), Math.min(searchRight, searchUp));
        }
    }
}
