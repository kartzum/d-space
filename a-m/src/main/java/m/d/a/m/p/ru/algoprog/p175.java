// https://algoprog.ru/material/p175

// https://hsecodes.com/index.php/tasksdecision/index/1171

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p175 {
    public static void main(String[] args) throws IOException {
        run();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[] r = new int[n + 1];
        for (int i = 0; i < m; i++) {
            String[] t = reader.readLine().split(" ");
            int a = Integer.parseInt(t[0]);
            int b = Integer.parseInt(t[1]);
            r[a]++;
            r[b]++;
        }
        for (int i = 1; i <= n; ++i) {
            System.out.print(r[i] + " ");
        }
    }
}
