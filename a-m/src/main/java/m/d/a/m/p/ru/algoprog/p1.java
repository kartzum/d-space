// https://algoprog.ru/material/p1

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1 {
    public static void main(String[] args) throws IOException {
        run();
        // tests();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        String[] t = reader.readLine().split(" ");
        int[] coords = new int[n];
        for (int i = 0; i < coords.length; i++) {
            coords[i] = Integer.parseInt(t[i]);
        }
        calc(n, k, coords);
    }

    static void tests() {
        calc(6, 3, new int[]{2, 5, 7, 11, 15, 20});
    }

    static void calc(int n, int k, int[] coords) {
        int left = 0;
        int right = coords[coords.length - 1] - coords[0] + 1;
        while (right - left != 1) {
            int middle = (left + right) / 2;
            if (isCorrect(n, k, coords, middle)) {
                left = middle;
            } else {
                right = middle;
            }
        }
        System.out.println(left);
    }

    static boolean isCorrect(int n, int k, int[] coords, int x) {
        int cows = 1;
        int lastCow = coords[0];
        for (int c : coords) {
            if ((c - lastCow) >= x) {
                cows += 1;
                lastCow = c;
            }
        }
        return cows >= k;
    }
}
