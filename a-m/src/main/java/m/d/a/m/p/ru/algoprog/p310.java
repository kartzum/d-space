// https://algoprog.ru/material/p310

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p310 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(r.readLine());
        boolean isPrime = true;
        for (long i = 2; i <= n / i; i += 1) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println("prime");
        } else {
            System.out.println("composite");
        }
    }
}
