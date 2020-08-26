package m.d.a.m.p.cses.fi;

import java.util.Scanner;

public class RepetitionsRun {
    public static void main(String[] args) {
        run();
    }

    static void run() {
        Scanner input = new Scanner(System.in);
        String v = input.nextLine(); // "ATTCGGGAAA";
        System.out.println(calc(v));
    }

    static int calc(String v) {
        if (v == null || v.length() == 0) {
            return 0;
        }
        if (v.length() == 1) {
            return 1;
        }
        int max = 0;
        int i = 0;
        while (i < v.length()) {
            char current = v.charAt(i);
            int j = i + 1;
            while (j < v.length() && v.charAt(j) == current) {
                j++;
            }
            int s = j - i;
            if (s > max) {
                max = s;
            }
            i = j;
        }
        return max;
    }
}
