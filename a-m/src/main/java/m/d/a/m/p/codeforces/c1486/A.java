package m.d.a.m.p.codeforces.c1486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(final String[] args) throws IOException {
        tests();
        //run();
    }

    static void run() throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(r.readLine());
            int[] nn = new int[n];
            String[] tt = r.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                nn[j] = Integer.parseInt(tt[j]);
            }
            System.out.println(calc(nn));
        }
    }

    static void tests() {
        //System.out.println(calc(new int[]{}));
        //System.out.println(calc(new int[]{1}));
        //System.out.println(calc(new int[]{1, 2}));
        //System.out.println(calc(new int[]{1, 0}));
        //System.out.println(calc(new int[]{4, 4, 4}));
        //System.out.println(calc(new int[]{0, 0}));
        //System.out.println(calc(new int[]{0, 1, 0}));
        //System.out.println(calc(new int[]{1000000000, 1000000000, 1000000000, 1000000000}));
        System.out.println(calc(new int[]{6, 5, 4, 3}));
    }

    static String calc(int[] a) {
        if (a.length <= 0) {
            return "NO";
        }
        if (a.length == 1) {
            return "YES";
        }
        int i = 0;
        while (i < a.length - 1) {
            if (a[i] >= a[i + 1]) {
                a[i] -= 1;
                a[i + 1] += 1;
                i++;
            }
        }
        return "YES";
    }
}
