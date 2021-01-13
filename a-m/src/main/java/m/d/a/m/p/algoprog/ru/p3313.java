// https://algoprog.ru/material/p3313

package m.d.a.m.p.algoprog.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3313 {
    public static void main(String[] args) throws IOException {
        run();
        // tests();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nums = new int[n];
        String[] numsAsArray = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numsAsArray[i]);
        }
        int[] pref = calcPref(n, nums);
        int m = Integer.parseInt(reader.readLine());
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] temp = reader.readLine().split(" ");
            int l = Integer.parseInt(temp[0]) - 1;
            int r = Integer.parseInt(temp[1]) - 1;
            buffer.append(query(pref, l, r));
            buffer.append(" ");
        }
        System.out.println(buffer.toString());
    }

    static void tests() {
        int[] nums = {0, 0, 0, 0, 2};
        int n = nums.length;
        int[] pref = calcPref(n, nums);
        System.out.println(query(pref, 0, 2));
    }

    static int[] calcPref(int n, int[] nums) {
        int[] pref = new int[n];
        pref[0] = nums[0] == 0 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            int t = nums[i] == 0 ? 1 : 0;
            pref[i] = pref[i - 1] + t;
        }
        return pref;
    }

    static int query(int[] pref, int l, int r) {
        if (l > 0) {
            return pref[r] - pref[l - 1];
        } else {
            return pref[r];
        }
    }
}
