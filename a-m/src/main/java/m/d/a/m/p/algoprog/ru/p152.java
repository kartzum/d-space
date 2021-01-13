// https://algoprog.ru/material/p152 - in progress.

// https://www.geeksforgeeks.org/program-for-goldbachs-conjecture-two-primes-with-given-sum/
// https://www.programmersought.com/article/8291243372/

package m.d.a.m.p.algoprog.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p152 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        calc(n);
    }

    static void calc(int n) {
        if (n <= 2 || n % 2 != 0) {
            return;
        }
        if (n == 4) {
            System.out.println("2 2");
            return;
        }
        for (int a = 3; a <= n / 2; a += 2) {
            int b = n - a;
            if (isPrime(a) && isPrime(b)) {
                System.out.println(a + " " + b);
                break;
            }
        }
    }

    static boolean isPrime(int m) {
        double d = Math.sqrt(m);
        for (int i = 3; i <= d; i += 2) {
            if (m % i == 0) return false;
        }
        return true;
    }

}
