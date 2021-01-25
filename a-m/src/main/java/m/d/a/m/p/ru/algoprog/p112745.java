// https://algoprog.ru/material/p112745

// https://www.cyberforum.ru/free-pascal/thread1361433.html
// https://wiki.lyc84.ru/index.php?title=%D0%A0%D0%B0%D0%B7%D0%B1%D0%BE%D1%80_%D0%BB%D0%B8%D1%86%D0%B5%D0%B9%D1%81%D0%BA%D0%BE%D0%B9_%D0%BE%D0%BB%D0%B8%D0%BC%D0%BF%D0%B8%D0%B0%D0%B4%D1%8B_2017

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p112745 {
    public static void main(String[] args) throws IOException {
        int N = 100001;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        long[] a = new long[N];
        long[] s = new long[N];
        long[] pref = new long[N];
        long[] suff = new long[N];

        String[] numsAsArray = reader.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(numsAsArray[i - 1]);
            s[i] = s[i - 1] + a[i];
        }

        for (int i = k; i <= n; i++) {
            pref[i] = Math.max(pref[i - 1], s[i] - s[i - k]);
        }
        suff[n - k + 1] = s[n] - s[n - k];
        for (int i = n - k + 1; i >= 1; i--) {
            suff[i] = Math.max(suff[i + 1], s[i + k - 1] - s[i - 1]);
        }
        long best = Long.MAX_VALUE;
        for (int i = 1; i <= n - k + 1; i++) {
            best = Math.min(best, Math.max(pref[i - 1], suff[i + k]));
        }

        System.out.println(best);
    }
}
