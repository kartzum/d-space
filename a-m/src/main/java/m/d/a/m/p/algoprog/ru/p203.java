// https://algoprog.ru/material/p203 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p203 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(calc(n));
    }

    static int calc(int n) {
        if(n <= 1) {
            return 1;
        }
        int n_ = n + 1;
        int[] table = new int[n_];
        table[0] = 1;
        table[1] = 1;
        table[2] = 2;
        for (int i = 3; i < n_; i++) {
            table[i] = table[i - 3] + table[i - 2] + table[i - 1];
        }
        return table[table.length - 1];
    }
}
