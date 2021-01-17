// https://algoprog.ru/material/p111589

// http://algolist.ru/olimp/ar_sol.php#a6
// https://coderoad.ru/24228398/MemoryError-%D0%BD%D0%B0-%D0%BC%D0%BE%D0%B5%D0%BC-%D0%BA%D0%BE%D0%B4%D0%B5-Python-%D0%BA%D0%B0%D0%BA-%D0%BE%D0%BF%D1%82%D0%B8%D0%BC%D0%B8%D0%B7%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D1%82%D1%8C

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p111589 {
    public static void main(String[] args) throws IOException {
        run();
        // tests();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(reader.readLine());
        System.out.println(calc(k));
    }

    static void tests() {
        System.out.println(calc(5));
    }

    static int calc(long k) {
        return calc(k, 1 << 30);
    }

    static int calc(long k, long p) {
        return k == 1 ? 0 : p >= k ? calc(k, p / 2) : (calc(k - p, p / 2) + 1) % 3;
    }
}
