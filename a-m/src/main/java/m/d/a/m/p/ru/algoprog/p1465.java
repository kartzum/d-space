// https://algoprog.ru/material/p1465

// https://www.cyberforum.ru/python/thread2193882.html

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1465 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] ab = reader.readLine().split(" ");
        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);
        System.out.println(calc(a, b));
    }

    static int calc(int a, int b) {
        int res = 0;
        while (b != 0) {
            res += a / b;
            int t = a % b;
            a = b;
            b = t;
        }
        return res;
    }
}
