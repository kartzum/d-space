// https://algoprog.ru/material/p623 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p623 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(r.readLine());
        long d = 2;
        List<Long> result = new ArrayList<>();
        while (d * d <= n) {
            while (n % d == 0) {
                result.add(d);
                n /= d;
            }
            d += 1;
        }
        if (n != 1) {
            result.add(n);
        }
        System.out.print(result.get(0));
        for (int i = 1; i < result.size(); i += 1) {
            System.out.print("*" + result.get(i));
        }
    }
}
