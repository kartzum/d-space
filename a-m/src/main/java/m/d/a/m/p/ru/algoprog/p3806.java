// https://algoprog.ru/material/p3806

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3806 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(r.readLine());
        int n = Integer.parseInt(r.readLine());
        System.out.println(calc(a, n));
    }

    static double calc(double a, int n) {
        double count = 1;
        if (n == 0) return 1;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
                a *= a;
            } else {
                n--;
                count *= a;
            }
        }
        return count;
    }
}
