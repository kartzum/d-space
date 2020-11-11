// https://algoprog.ru/material/p2771 - in progress.

// https://brestprog.by/topics/prefixsums/

package m.d.a.m.p.algoprog.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2771 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[] nums = new int[n];
        String[] numsAsArray = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numsAsArray[i]);
        }
        int[] pref = new int[n];
        pref[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + nums[i];
        }
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] temp = reader.readLine().split(" ");
            int l = Integer.parseInt(temp[0]) - 1;
            int r = Integer.parseInt(temp[1]) - 1;
            // System.out.println(query(pref, l, r));
            buffer.append(query(pref, l, r));
            buffer.append("\n");
        }
        System.out.println(buffer.toString());
    }

    static int query(int[] pref, int l, int r) {
        if (l > 0) {
            return pref[r] - pref[l - 1];
        } else {
            return pref[r];
        }
    }
}
