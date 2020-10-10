// https://algoprog.ru/material/p106 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.util.ArrayList;
import java.util.Scanner;

public class p106 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        ArrayList<String> strings = new ArrayList<>();
        int l = 0;
        int r = 0;
        while (r < a.length()) {
            if (a.charAt(r) == ' ') {
                strings.add(a.substring(l, r));
                l = r + 1;
            }
            r++;
        }
        if (l < r) {
            strings.add(a.substring(l, r));
        }
        System.out.println(strings.size());
    }
}
