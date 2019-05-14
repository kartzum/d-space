package m.d.a.m.p.ya.points;

import java.util.Arrays;

public class Points {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        double[][] a = new double[][]{
                {(1 / 20.9) * 21.7, (1 / 20.9) * (-1.2), (1 / 20.9) * (-2.1), (1 / 20.9) * (-0.9)},
                {(1 / 21.2) * 27.46, (1 / 21.2) * (-1.2), (1 / 21.2) * (-1.5), (1 / 21.2) * (-2.5)},
                {(1 / 19.8) * 28.76, (1 / 19.8) * (-2.1), (1 / 19.8) * (-1.5), (1 / 19.8) * (-1.3)},
                {(1 / 32.1) * 49.72, (1 / 32.1) * (-0.9), (1 / 32.1) * (2.5), (1 / 32.1) * (1.3)}
        };
        double[] x0 = new double[]{1.04, 1.3, 1.45, 1.55};
        double[] r = solve1(a, x0);
        System.out.println(Arrays.toString(r));
    }

    private static double[] solve1(
            double[][] a,
            double[] x0
    ) {
        int n = a.length;
        int k = a[0].length;

        int l = 0;
        for (int i = 0; i < n; i++) {
            double t = a[i][0];
            int p = 1;
            for (int j = 0; j < k; j++) {
                if (j == l) {
                    continue;
                }
                t += a[i][p] * x0[j];
                p++;
            }
            l++;
            System.out.println("");
            System.out.println(t);
        }

        return new double[]{0, 0, 0};
    }
}
