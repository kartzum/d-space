// https://algoprog.ru/material/p112735

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p112735 {
    public static void main(String[] args) throws IOException {
        int N = 100000;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] nums = new int[N];
        String[] numsAsArray = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numsAsArray[i]);
        }
        int j = 0;
        int[] p = new int[N];
        int[] s = new int[N];
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[j]) {
                p[i] = i;
                j = i;
            } else {
                p[i] = p[j];
            }
        }
        j = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] >= nums[j]) {
                s[i] = i;
                j = i;
            } else {
                s[i] = s[j];
            }
        }
        int m = 0;
        int l = 0;
        int r = k + 1;
        int i = 0;
        for (j = r; j < n; j++) {
            int t = nums[p[i]] + nums[s[j]];
            if (t > m) {
                l = p[i];
                r = s[j];
                m = t;
            }
            i += 1;
        }
        System.out.println((l + 1) + " " + (r + 1));
    }
}
