// https://algoprog.ru/material/p2771 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p2771 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] nm = input.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[] nums = new int[n];
        String[] numsAsArray = input.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numsAsArray[i]);
        }
        int[] pref = new int[n];
        pref[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + nums[i];
        }
        for (int i = 0; i < m; i++) {
            String[] temp = input.nextLine().split(" ");
            int l = Integer.parseInt(temp[0]) - 1;
            int r = Integer.parseInt(temp[1]) - 1;
            System.out.println(query(pref, l, r));
        }
    }

    static int query(int[] pref, int l, int r) {
        if (l > 0) {
            return pref[r] - pref[l - 1];
        } else {
            return pref[r];
        }
    }
}
