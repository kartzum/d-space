package m.d.a.m.p.dynamic;

/**
 * https://foxford.ru/wiki/informatika/dvumernoe-dinamicheskoe-programmirovanie-tablitsy
 */
public class StepsCount {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(new Solution1().calc(6, 6));
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
