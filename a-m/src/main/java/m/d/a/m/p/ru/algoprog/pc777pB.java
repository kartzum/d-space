// https://algoprog.ru/material/pc777pB

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pc777pB {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String t1 = reader.readLine();
        String t2 = reader.readLine();
        int[] s = new int[n];
        int[] m = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(t1.charAt(i) + "");
            m[i] = Integer.parseInt(t2.charAt(i) + "");
        }

        java.util.Arrays.sort(s);
        java.util.Arrays.sort(m);

        int k = 0;
        for (int j = 0; j < n; j++) {
            if (m[j] >= s[k]) {
                k++;
            }
        }
        System.out.println((n - k));

        k = 0;
        for (int j = 0; j < n; j++) {
            if (m[j] > s[k]) {
                k++;
            }
        }
        System.out.println(k);
    }
}
