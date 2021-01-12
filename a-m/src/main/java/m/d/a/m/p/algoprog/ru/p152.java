// https://algoprog.ru/material/p152 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p152 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        calcPrimes();
        calc(n);
    }

    static ArrayList<Integer> primes = new ArrayList<>();

    static void calc(int n) {
        if (n <= 2 || n % 2 != 0) {
            return;
        }
        for (int i = 0; primes.get(i) <= n / 2; i++) {
            int diff = n - primes.get(i);
            if (primes.contains(diff)) {
                System.out.println(primes.get(i) + " " + diff);
                return;
            }
        }
    }

    static void calcPrimes() {
        int MAX = 100000;
        boolean[] marked = new boolean[MAX / 2 + 100];
        for (int i = 1; i <= (Math.sqrt(MAX) - 1) / 2; i++) {
            for (int j = (i * (i + 1)) << 1; j <= MAX / 2; j = j + 2 * i + 1) {
                marked[j] = true;
            }
        }
        primes.add(2);
        for (int i = 1; i <= MAX / 2; i++) {
            if (!marked[i]) {
                primes.add(2 * i + 1);
            }
        }
    }

}
