package m.d.a.m.p.common;

import java.util.Arrays;

public class ArrayFreeSolution {
    public static void main(String[] args) {
        //swap();
        //System.out.println(pow(3, 3));
        System.out.println(Arrays.toString(mod(9, 3)));
    }

    private static void swap() {
        int a = 1;
        int b = 2;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + ", " + b);
    }

    private static int pow(int a, int n) {
        int k = n;
        int b = 1;
        while (k != 0) {
            k = k - 1;
            b = b * a;
        }
        return b;
    }

    private static int[] mod(int a, int d) {
        int r = a;
        int q = 0;
        while (!(r < d)) {
            r = r - d;
            q = q + 1;
        }
        return new int[]{r, q};
    }
}
