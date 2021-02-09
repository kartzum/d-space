// https://algoprog.ru/material/p4

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p4 {
    public static void main(String[] args) throws IOException {
        // tests();
        run();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        long[] arr = new long[n];
        long[] kk = new long[k];
        String[] t1 = reader.readLine().split(" ");
        String[] t2 = reader.readLine().split(" ");
        for (int i = 0; i < t1.length; i++) {
            arr[i] = Long.parseLong(t1[i]);
        }
        for (int i = 0; i < t2.length; i++) {
            kk[i] = Long.parseLong(t2[i]);
        }
        calc(arr, kk);
    }

    static void tests() {
        calc(new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new long[]{-2, 0, 4, 9, 12});
    }

    static void calc(long[] arr, long[] kk) {
        for (int i = 0; i < kk.length; i++) {
            long x = kk[i];
            int l = 0;
            int r = arr.length - 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (x > arr[m]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            if (arr[l] == x) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
