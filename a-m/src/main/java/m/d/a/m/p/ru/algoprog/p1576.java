// https://algoprog.ru/material/p1576

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p1576 {
    public static void main(String[] args) throws IOException {
        run();
        // tests();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] sn = reader.readLine().split(" ");
        int s = Integer.parseInt(sn[0]);
        int n = Integer.parseInt(sn[1]);
        int[] nn = new int[n];
        for (int i = 0; i < n; i++) {
            nn[i] = Integer.parseInt(reader.readLine());
        }
        System.out.println(calc(s, nn));
    }

    static void tests() {
        System.out.println(calc(100, new int[]{200, 50}));
        System.out.println(calc(100, new int[]{50, 50, 50}));
    }

    static int calc(int s, int[] nn) {
        Arrays.sort(nn);
        int t = 0;
        int c = 0;
        for (int i = 0; i < nn.length; i++) {
            if (t + nn[i] <= s) {
                t += nn[i];
                c++;
            } else {
                break;
            }
        }
        return c;
    }
}
