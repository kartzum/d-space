// https://algoprog.ru/material/p1406

package m.d.a.m.p.ru.algoprog;

import java.util.Scanner;

public class p1406 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String t = input.nextLine();
        boolean f = isAnagram(s, t);
        if (f) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] a = new int[256];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)]++;
            a[t.charAt(i)]--;
        }
        for (int v : a) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }
}
