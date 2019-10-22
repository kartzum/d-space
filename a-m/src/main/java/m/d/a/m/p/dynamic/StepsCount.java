package m.d.a.m.p.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://foxford.ru/wiki/informatika/dvumernoe-dinamicheskoe-programmirovanie-tablitsy
 */
public class StepsCount {
    public static void main(String[] args) {
        // test1();
        test2();
    }

    private static void test1() {
        System.out.println(new Solution1().calc(6, 6));
    }

    private static void test2() {
        Iterable<int[]> r = new Solution2().calc(6, 6);
        for (int[] i : r) {
            System.out.println(Arrays.toString(i));
        }
    }

    private static class Solution1 {
        int calc(int x, int y) {
            int[][] mt = new int[y][x];
            for (int i = 1; i < x; i++) {
                mt[1][i] = 1;
            }
            for (int j = 1; j < y; j++) {
                mt[j][1] = 1;
            }
            mt[0][0] = 1;
            // printMt(mt);
            for (int j = 1; j < y; j++) {
                for (int i = 1; i < x; i++) {
                    mt[j][i] = mt[j - 1][i] + mt[j][i - 1] + mt[j - 1][i - 1];
                }
            }
            // printMt(mt);
            return mt[y - 1][x - 1];
        }
    }

    private static class Solution2 {
        Iterable<int[]> calc(int x, int y) {
            int[][] mt = new int[y][x];
            for (int i = 1; i < x; i++) {
                mt[1][i] = 1;
            }
            for (int j = 1; j < y; j++) {
                mt[j][1] = 1;
            }
            mt[0][0] = 1;
            for (int j = 1; j < y; j++) {
                for (int i = 1; i < x; i++) {
                    mt[j][i] = mt[j - 1][i] + mt[j][i - 1] + mt[j - 1][i - 1];
                }
            }

            List<int[]> r = new ArrayList<>();

            int i = x - 1;
            int j = y - 1;
            while (i != 0 && j != 0) {
                r.add(new int[]{i, j});
                int min1 = Math.min(mt[j - 1][i], mt[j][i - 1]);
                int min = Math.min(min1, mt[j - 1][i - 1]);
                if (min == mt[j - 1][i]) {
                    j = j - 1;
                } else if (min == mt[j][i - 1]) {
                    i = i - 1;
                } else {
                    j = j - 1;
                    i = i - 1;
                }
            }

            // printMt(mt);

            return r;
        }
    }

    private static void printMt(int[][] mt) {
        int y = mt.length;
        int x = mt[0].length;
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                System.out.print(mt[j][i] + " ");
            }
            System.out.println();
        }
    }
}
