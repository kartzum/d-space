// https://algoprog.ru/material/p668

//  https://hsecodes.com/index.php/tasksdecision/index/393

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p668 {
    public static void main(String[] args) throws IOException {
        run();
        // tests();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            String[] t = reader.readLine().split(" ");
            x[i] = Integer.parseInt(t[0]);
            y[i] = Integer.parseInt(t[1]);
        }
        System.out.println(calc(n, x, y));
    }

    static void tests() {
        int n = 8;
        int[] x = new int[n];
        int[] y = new int[n];
        x[0] = 5;
        y[0] = 15;
        x[1] = 15;
        y[1] = 5;
        x[2] = 15;
        y[2] = -5;
        x[3] = 5;
        y[3] = -15;
        x[4] = -5;
        y[4] = -15;
        x[5] = -15;
        y[5] = -5;
        x[6] = -15;
        y[6] = 5;
        x[7] = -5;
        y[7] = 15;
        System.out.println(calc(n, x, y));
    }

    static long calc(int n, int[] x, int[] y) {
        long a = n;
        for (int i = 0; i < n; i++) {
            int dx = Math.abs(x[i] - x[(i + 1) % n]);
            int dy = Math.abs(y[i] - y[(i + 1) % n]);
            a += gcd(dx, dy) - 1;
        }
        return a;
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
