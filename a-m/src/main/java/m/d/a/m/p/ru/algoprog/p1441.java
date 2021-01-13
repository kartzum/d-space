// https://algoprog.ru/material/p1441

package m.d.a.m.p.ru.algoprog;

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
        int k = nn[0];
        for (int i = 1; i < nn.length; i++) {
            k = nod(k, nn[i]);
        }
        return k;
    }

    static int nod(int a, int b) {
        while (b > 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
