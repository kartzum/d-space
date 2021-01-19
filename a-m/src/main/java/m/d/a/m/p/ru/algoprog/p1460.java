// https://algoprog.ru/material/p1460

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1460 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nn = new int[n];
        String[] t = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nn[i] = Integer.parseInt(t[i]);
        }
        int k = Integer.parseInt(reader.readLine());
        calc(n, nn, k);
    }

    static void calc(int n, int[] nn, int k) {
        int kk = k;
        if (kk > 0) {
            kk %= n;
        } else {
            kk = n - ((-kk) % n);
        }
        StringBuilder buffer = new StringBuilder();
        for (int i = n - kk; i < n; i++) {
            buffer.append(nn[i]);
            buffer.append(" ");
        }
        for (int i = 0; i < n - k; i++) {
            buffer.append(nn[i]);
            buffer.append(" ");
        }
        System.out.println(buffer.toString());
    }
}
