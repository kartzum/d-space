package m.d.a.m.p.lt.problems;

public class SpiralMatrixII {
    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        int n = 5;

        int[][] m = new Solution().generateMatrix(n);

        int y = n;
        int x = n;
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                System.out.print(m[j][i] + ", ");
            }
            System.out.println();
        }
    }

    static class Solution {
        public int[][] generateMatrix(int n) {
            int INF = Integer.MAX_VALUE;
            int yn = n;
            int xn = n;
            int[][] m = new int[yn][xn];
            int k = 0;
            for (int j = 0; j < yn; j++) {
                for (int i = 0; i < xn; i++) {
                    m[j][i] = INF; // k; // INF;
                    k++;
                }
            }
            int[] xSteps = new int[]{1, 0, -1, 0};
            int[] ySteps = new int[]{0, 1, 0, -1};
            int x = 0;
            int y = 0;
            int i = 1;
            m[y][x] = i;
            int xi = 0;
            int yi = 0;
            int dx = xSteps[xi];
            int dy = ySteps[yi];
            while (i < yn * xn) {
                if (x + dx < xn && x + dx >= 0 && y + dy < yn && y + dy >= 0) {
                    int v = m[y + dy][x + dx];
                    if (v != INF) {
                        xi++;
                        yi++;
                        if (xi > xSteps.length - 1) {
                            xi = 0;
                        }
                        if (yi > ySteps.length - 1) {
                            yi = 0;
                        }
                        dx = xSteps[xi];
                        dy = ySteps[yi];
                    }
                    x += dx;
                    y += dy;
                    i++;
                    m[y][x] = i;
                } else {
                    xi++;
                    yi++;
                    if (xi > xSteps.length - 1) {
                        xi = 0;
                    }
                    if (yi > ySteps.length - 1) {
                        yi = 0;
                    }
                    dx = xSteps[xi];
                    dy = ySteps[yi];

                    x += dx;
                    y += dy;
                    i++;
                    m[y][x] = i;
                }
            }
            return m;
        }
    }
}
