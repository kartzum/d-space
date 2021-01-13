// https://algoprog.ru/material/p973

package m.d.a.m.p.algoprog.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;


public class p973 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(r.readLine());
        System.out.print(calc(k));
    }

    static int calc(int k) {
        int lim = 15485863; // 1000000th prime number
        BitSet isPrime = new BitSet(lim + 1);
        isPrime.set(0, false);
        isPrime.set(1, false);
        for (int i = 2; i <= lim; i += 1) {
            isPrime.set(i);
        }
        int c = 0;
        int nth = 0;
        for (int i = 2; i <= lim && c < k; i += 1) {
            if (isPrime.get(i)) {
                c += 1;
                nth = i;
                int j = i * i;
                while (j <= lim) {
                    isPrime.set(j, false);
                    j += i;
                }
            }
        }
        return nth;
    }
}
