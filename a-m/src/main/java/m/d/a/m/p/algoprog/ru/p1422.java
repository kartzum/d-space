// https://algoprog.ru/material/p1422 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1422 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = r.readLine().split(" ");
        long n = Long.parseLong(nk[0]);
        long k = Long.parseLong(nk[1]);
        System.out.println(calc(n, k));
    }

    static long calc(long n, long k) {
        long p = n * k;
        while (k != 0) {
            long t = k;
            k = n % k;
            n = t;
        }
        return p / n;
    }
}
