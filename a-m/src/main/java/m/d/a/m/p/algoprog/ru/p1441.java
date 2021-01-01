// https://algoprog.ru/material/p1441 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1441 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        String[] nnArray = r.readLine().split(" ");
        int[] nn = new int[n];
        for (int i = 0; i < n; i++) {
            nn[i] = Integer.parseInt(nnArray[i]);
        }
        System.out.println(calc(nn));
    }

    static int calc(int[] nn) {
        if (nn.length == 1) {
            return nn[0];
        }
        int k = nn[0];
        for (int i = 1; i < nn.length; i++) {
            k = nod(k, nn[i]);
        }
        return k;
    }

    static int nod(int a, int b) {
        while (a != b)
            if (a > b) a -= b;
            else b -= a;
        return a;
    }
}
