package m.d.a.m.p.ya.points;

import java.util.Arrays;

public class Points {
    public static void main(String[] args) {
        // https://en.wikipedia.org/wiki/Jacobi_method
        // https://ru.wikipedia.org/wiki/%D0%9C%D0%B5%D1%82%D0%BE%D0%B4_%D0%AF%D0%BA%D0%BE%D0%B1%D0%B8
        // http://dspace.kpfu.ru/xmlui/bitstream/handle/net/110750/0Main.pdf?sequence=1&isAllowed=y
        // http://td.chem.msu.ru/uploads/files/courses/general/statexp/lsq_descr.pdf

        test1();
    }

    private static void test1() {
        double[][] a = new double[][]{
                {10.0, -1.0, 2.0, 0.0},
                {-1.0, 11.0, -1.0, 3.0},
                {2.0, -1.0, 10.0, -1.0},
                {0.0, 3.0, -1.0, 8.0}
        };
        double[] b = new double[]{6.0, 25.0, -11.0, 15.0};
        double[] x0 = new double[]{0, 0, 0, 0};
        double[] r = solve1(a, b, x0, 0.001);
        System.out.println(Arrays.toString(r));
    }

    private static double[] solve1(
            double[][] a,
            double[] b,
            double[] x0,
            double eps
    ) {
        int n = a.length;
        int k = a[0].length;

        double[] t = new double[k];
        double[] r = new double[k];

        System.arraycopy(x0, 0, r, 0, r.length);

        double norm;

        do {

            for (int i = 0; i < n; i++) {
                t[i] = b[i];
                for (int g = 0; g < k; g++) {
                    if (i != g) {
                        t[i] -= a[i][g] * r[g];
                    }
                }
                t[i] /= a[i][i];
            }

            norm = Math.abs(r[0] - t[0]);
            for (int h = 0; h < k; h++) {
                if (Math.abs(r[h] - t[h]) > norm) {
                    norm = Math.abs(r[h] - t[h]);
                }
                r[h] = t[h];
            }
            // System.out.println(norm + ", " + Arrays.toString(t));
        } while (norm > eps);

        return r;
    }
}
