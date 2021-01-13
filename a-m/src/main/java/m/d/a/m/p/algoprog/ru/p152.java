// https://algoprog.ru/material/p152

// https://www.geeksforgeeks.org/program-for-goldbachs-conjecture-two-primes-with-given-sum/
// https://www.programmersought.com/article/8291243372/

package m.d.a.m.p.algoprog.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class p152 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        calcPrimes();
        calc(n);
    }

    static Map<Integer, Integer> primes = new HashMap<>();

    static void calc(int n) {
        if (n <= 2 || n % 2 != 0) {
            return;
        }
        for (int i = 0; primes.get(i) <= n / 2; i++) {
            int diff = n - primes.get(i);
            if (primes.containsValue(diff)) {
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
        primes.put(0, 2);
        int j = 1;
        for (int i = 1; i <= MAX / 2; i++) {
            if (!marked[i]) {
                primes.put(j, 2 * i + 1);
                j++;
            }
        }
    }

}
