package m.d.a.m.p.arrays;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Arrays {
    public static void main(String[] args) {
        //init();
        //f();
        //m();
        mRnd();
    }

    private static void init() {
        final int[] a = new int[]{};
        System.out.println(a.length);
        System.out.println(a.getClass());
    }

    private static void f() {
        final int[] a = new int[]{1, 2, 3};
        for (int i : a) {
            System.out.println(i);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        final List<Integer> l = java.util.Arrays.asList(1, 2, 3);
        final IntStream aStream = java.util.Arrays.stream(a);
        System.out.println(aStream.sum());
    }

    private static void m() {
        final int[][] m = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        System.out.println(m.length);
        for (int[] i : m) {
            System.out.println(java.util.Arrays.toString(i));
        }
        for (int j = 0; j < m.length; j++) {
            for (int i = 0; i < m[j].length; i++) {
                System.out.println(m[j][i]);
            }
        }
    }

    private static void mRnd() {
        final Random random = new Random();
        final int[][] m = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        for (int j = m.length - 1; j >= 0; j--) {
            for (int i = m[j].length - 1; i >= 0; i--) {
                final int r = random.nextInt(j + 1);
                final int c = random.nextInt(i + 1);
                final int a = m[r][c];
                m[r][c] = m[j][i];
                m[j][i] = a;
            }
        }
        for (int[] k : m) {
            System.out.println(java.util.Arrays.toString(k));
        }
    }
}
