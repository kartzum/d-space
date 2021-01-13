// https://algoprog.ru/material/p108

package m.d.a.m.p.ru.algoprog;

import java.util.Scanner;

public class p108 {
    public static void main(String[] args) {
        // tests();
        run();
    }

    static void run() {
        Scanner input = new Scanner(System.in);
        String p = input.nextLine();
        if (isPalindrome(p)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    static void tests() {
        System.out.println(isPalindrome("abba"));
    }

    static boolean isPalindrome(String p) {
        int l = 0;
        int r = p.length() - 1;
        while (l < r) {
            char leftChar = p.charAt(l);
            char rightChar = p.charAt(r);
            if (leftChar != rightChar)
                return false;
            l++;
            r--;
        }
        return true;
    }
}
