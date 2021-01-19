// https://algoprog.ru/material/p1037

// https://wiki.lyc84.ru/index.php?title=%D0%A0%D0%B0%D0%B7%D0%B1%D0%BE%D1%80_%D0%BB%D0%B8%D1%86%D0%B5%D0%B9%D1%81%D0%BA%D0%BE%D0%B9_%D0%BE%D0%BB%D0%B8%D0%BC%D0%BF%D0%B8%D0%B0%D0%B4%D1%8B_2016

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        calc(n);
    }

    static void calc(long n) {
        long c = (long) Math.sqrt(n);
        long i = 2;
        while ((n % i != 0) & (i <= c)) {
            i++;
        }
        System.out.println((n / i) + " " + (n - n / i));
    }
}
