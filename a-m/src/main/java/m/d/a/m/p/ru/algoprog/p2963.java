// https://algoprog.ru/material/p2963

// https://tproger.ru/articles/dynprog-starters/
// http://labs.tspu.edu.ru/doku.php?id=python:%D0%B7%D0%B0%D0%B4%D0%B0%D1%87%D0%B0_24

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2963 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(calc(n));
    }

    static int calc(int n) {
        int[] a = new int[n + 1];
        a[1] = 0;
        int min;
        for (int i = 2; i < n + 1; i++) {
            min = a[i - 1] + 1;
            if (i % 2 == 0) {
                min = Math.min(min, a[i / 2] + 1);
            }
            if (i % 3 == 0) {
                min = Math.min(min, a[i / 3] + 1);
            }
            a[i] = min;
        }
        return a[n];
    }
}
