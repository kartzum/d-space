package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p112 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        int l = 0;
        int r = a.length() - 1;
        boolean f = true;
        while (l < r) {
            while (a.charAt(l) == ' ') {
                l++;
            }
            while (a.charAt(r) == ' ') {
                r--;
            }
            if (a.charAt(l) != a.charAt(r)) {
                f = false;
                break;
            }
            l++;
            r--;
        }
        if (f) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
