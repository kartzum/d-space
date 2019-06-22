package m.d.a.m.p.lt.problems;

public class RotateImage {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        int[][] m = new int[][]{
                {}
        };
        new Solution().rotate(m);
        System.out.println(m);
    }

    static class Solution {
        public void rotate(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }
            int n = matrix.length;
            int numSquares = n / 2;

            for (int i = 0; i < numSquares; i++) {
                for (int j = i; j < n - i - 1; j++) {
                    rotatePositionAroundMatrix(matrix, i, j);
                }
            }
        }

        private void rotatePositionAroundMatrix(int[][] matrix, int rowIdx, int colIdx) {
            int n = matrix.length;
            int tmp = matrix[rowIdx][colIdx];

            for (int i = 0; i < 4; i++) {
                int value = tmp;
                int oldRowIdx = rowIdx;
                rowIdx = colIdx;
                colIdx = n - oldRowIdx - 1;
                tmp = matrix[rowIdx][colIdx];
                matrix[rowIdx][colIdx] = value;
            }
        }
    }
}
