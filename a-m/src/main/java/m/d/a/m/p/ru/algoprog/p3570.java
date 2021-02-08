// https://algoprog.ru/material/p3570

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3570 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(reader.readLine());
        int n = Integer.parseInt(reader.readLine());

        double l = 0;
        double r = 0;
        if (a < 1) {
            r = 1;
        } else {
            r = a;
        }
        double m = r / 2;

        for (int i = 0; i < 200; i++) {
            if (Math.pow(m, n) >= a) {
                r = m;
            } else {
                l = m;
            }
            m = (l + r) / 2;
        }

        System.out.println(r);
    }
}
