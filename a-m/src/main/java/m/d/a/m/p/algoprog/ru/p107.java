// https://algoprog.ru/material/p107

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p107 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        int l = 0;
        int r = 0;
        String maxValue = "";
        while (r < a.length()) {
            if (a.charAt(r) == ' ') {
                String temp = a.substring(l, r);
                if (temp.length() > maxValue.length()) {
                    maxValue = temp;
                }
                l = r + 1;
            }
            r++;
        }
        if (l < r) {
            String temp = a.substring(l, r);
            if (temp.length() > maxValue.length()) {
                maxValue = temp;
            }
        }
        System.out.println(maxValue);
        System.out.println(maxValue.length());
    }
}
